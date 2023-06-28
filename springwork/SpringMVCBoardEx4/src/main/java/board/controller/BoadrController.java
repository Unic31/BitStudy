package board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.Session;

import board.dao.AnswerDao;
import board.dao.BoardDao;
import board.dao.MemberDao;
import board.dto.BoardDto;
import board.dto.MemberDto;

@Controller
public class BoadrController {
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	AnswerDao answerDao;
	
	@GetMapping("/board/form")
	public String form() {
		return "board/form";
	}
	
	@PostMapping("/board/addboard")
	public String insertBoard(
			@ModelAttribute BoardDto dto,
			@RequestParam ArrayList<MultipartFile> upload, //사진여러개
			HttpServletRequest request, //저장경로
			HttpSession session
			) {
		//세션에 저장된 이메일
		String email=(String)session.getAttribute("loginemail");
		//그 이메일에 해당하는 member 테이블의 num값
		int num=memberDao.selectOneOfEmail(email).getNum();
		//dto에 num저장
		dto.setNum(num);
		
		//업로드할 경로
		String realPath=request.getSession().getServletContext().getRealPath("/resources/photo");
		System.out.println(realPath);
		String images="";
		//사진을 업로드 안했을경우 db에 no라고 저장
		//업로드 했을경우 파일명을 날짜로 변경해보자
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fname=sdf.format(new Date());
		
		if(upload.get(0).getOriginalFilename().equals("")) { //사진 업로드 안함
			images="no"; //사진 안넣었을때 no로 저장
		}else {
			int i = 0;
			for(MultipartFile mfile:upload) {
				String originalName=mfile.getOriginalFilename();
				// .을 기준으로 나눠보자(단, 파일명 사이에 . 이 들어간 경우는 안됨)
				StringTokenizer st = new StringTokenizer(originalName,".");
				String fileName=st.nextToken(); // . 을 기준으로 나눴을때 첫번째꺼(파일명)
				String extName=st.nextToken(); // . 을 기준으로 나눴을때 그 다음거(확장자명)
				
				//파일명을 날짜로 변경하기
				fileName=fname+"_"+i++ +"."+extName; // fname(위에서 구해둔 연월일시분초)뒤에 _ 넣고 i(0부터 1씩 증가시키며 넣기(중복되지않게)) 
													// 그 뒤에 . 붙이고 확장자 붙이기
				System.out.println(fileName); //업로드될 최종 파일명
				
				images+=fileName+",";
				
				//사진 업로드
				try {
					mfile.transferTo(new File(realPath+"/"+fileName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//마지막 컴마 제거
			images=images.substring(0,images.length()-1);
			
		}
		//dto에 images값 저장
		dto.setImages(images);
		//db에 저장
		boardDao.insertOfBoard(dto);
		return "redirect:list";
	}
	
	@GetMapping("/board/list")
	public String list(
			HttpSession session,
			Model model,
			@RequestParam(defaultValue="1") int currentPage //페이지 번호가 안넘어올경우 무조건 1페이지를 보여준다
			) {
		String email=(String)session.getAttribute("loginemail");
		MemberDto dto = memberDao.selectOneOfEmail(email);
		
		model.addAttribute("dto",dto);
		
		
		int totalCount=boardDao.getTotalCount();//게시판의 총 글 갯수
		int totalPage;//총 페이지수
		int perPage=3;//한 페이지당 보여질 글 갯수
		int perBlock=3;//한 블럭당 보여질 페이지의 갯수
		int startNum;//각 페이지에서 보여질 글의 시작번호
		int startPage;//각 블럭에서 보여질 시작 페이지 번호
		int endPage;//각 블럭에서 보여질 끝 페이지 번호
		int no;//글 출력시 출력할 시작번호
		
		//총 페이지수
		totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);//딱 떨어지면 0을 더하고 나머지가 있으면 1(페이지)을 더해준다
		//시작 페이지
		startPage=(currentPage-1)/perBlock*perBlock+1;//(2-1)/3*3+1=1, (5-1)/3*3+1=4
		//끝페이지
		endPage=startPage+perBlock-1;
		//이때 문제점 ... endPage가 totalPage보다 크면 안된다
		if(endPage>totalPage)
			endPage=totalPage;
		
		//각 페이지의 시작번호(1페이지:0, 2페이지:3, 3페이지:6...)
		startNum=(currentPage-1)*perPage;
		//각 글마다 출력할 글 번호(예:10개일경우 1페이지:10, 2페이지:7...)
		no=totalCount-startNum;
		
		//각 페이지에 필요한 게시글 db에서 가져오기
		List<BoardDto> list = boardDao.getPagingList(startNum, perPage);
		//각 게시글에 글쓴사람의 name을 dto에 저장
		for(BoardDto bdto:list) {
			//글쓴사람의 num
			int num=bdto.getNum();
			//num에 해당하는 사람의 이름 
			String name="";
			try {
				//num에 해당하는 데이터가 없을경우 널포인트이셉션 발생
				name=memberDao.selectOneOfNum(num).getName();
			}catch (NullPointerException e) {
				name="탈퇴한회원";
			}
			//bdto에 저장
			bdto.setName(name);
			
			//댓글 갯수 acount에 저장
			int acount=answerDao.getAllAnswers(bdto.getIdx()).size();
			bdto.setAcount(acount);
		}
		
		//출력시 필요한 변수들을 model에 모두 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("no", no);
		
		
		
		
		
		
		
		model.addAttribute("totalCount", totalCount);
		
		return "board/list";
	}

	@GetMapping("/board/content")
	public String content(
			Model model,
			@RequestParam int idx,
			@RequestParam int currentPage
			) {
		//조회수 증가
		boardDao.updateReadCountOfBoard(idx);
		//board테이블의 dto데이터를 얻는다
		BoardDto dto = boardDao.selectOneBoardOfIdx(idx);
		//num에 해당하는 name, photo를 얻어서 dto에 넣어준다
		
		try {
		String name=memberDao.selectOneOfNum(dto.getNum()).getName();
		String photo=memberDao.selectOneOfNum(dto.getNum()).getPhoto();
		
		dto.setName(name);
		dto.setPhoto(photo);
		}catch (NullPointerException e){
			dto.setName("탈퇴한회원");
			dto.setPhoto("noimage.png");
		}
		//model에 dto, currentPage를 저장
		model.addAttribute("dto", dto);
		model.addAttribute("currentPage", currentPage);
		
		
		
		return "board/content";
	}
	@GetMapping("/board/update")
	public String update(
			@RequestParam int idx,
			@RequestParam int currentPage,
			Model model
			) {
		System.out.println(idx);
		BoardDto dto = boardDao.selectOneBoardOfIdx(idx);
		model.addAttribute("dto",dto);
		model.addAttribute("currentPage",currentPage);
				
		return "board/updateform";
	}
	
	@PostMapping("/board/updateform")
	public String updateform(
			@ModelAttribute BoardDto dto,
			@RequestParam ArrayList<MultipartFile> upload, //사진여러개
			HttpServletRequest request, //저장경로
			@RequestParam int currentPage
			) {
		//업로드할 경로
		String realPath=request.getSession().getServletContext().getRealPath("/resources/photo");
		System.out.println(realPath);
		String images="";
		//사진을 업로드 안했을경우 db에 no라고 저장
		//업로드 했을경우 파일명을 날짜로 변경해보자
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fname=sdf.format(new Date());
		
		if(upload.get(0).getOriginalFilename().equals("")) { //사진 업로드 안함
			images=null; //null일경우 기존 사진이 유지되게 sql문 짜놨음
		}else {
			int i = 0;
			for(MultipartFile mfile:upload) {
				String originalName=mfile.getOriginalFilename();
				// .을 기준으로 나눠보자(단, 파일명 사이에 . 이 들어간 경우는 안됨)
				StringTokenizer st = new StringTokenizer(originalName,".");
				String fileName=st.nextToken(); // . 을 기준으로 나눴을때 첫번째꺼(파일명)
				String extName=st.nextToken(); // . 을 기준으로 나눴을때 그 다음거(확장자명)
				
				//파일명을 날짜로 변경하기
				fileName=fname+"_"+i++ +"."+extName; // fname(위에서 구해둔 연월일시분초)뒤에 _ 넣고 i(0부터 1씩 증가시키며 넣기(중복되지않게)) 
													// 그 뒤에 . 붙이고 확장자 붙이기
				System.out.println(fileName); //업로드될 최종 파일명
				
				images+=fileName+",";
				
				//사진 업로드
				try {
					mfile.transferTo(new File(realPath+"/"+fileName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//마지막 컴마 제거
			images=images.substring(0,images.length()-1);
			
		}
		//dto에 images값 저장
		dto.setImages(images);
		//db에 수정한거 저장
		boardDao.updateBoard(dto);
		return "redirect:content?idx="+dto.getIdx()+"&currentPage="+currentPage;
	}
	@GetMapping("/board/delete")
	public String delete(
			@RequestParam int idx,
			@RequestParam int currentPage
			) {
		
		boardDao.deleteBoard(idx);
		//삭제후 보던 페이지 목록으로 이동
		return "redirect:./list?currentpage="+currentPage;
		
	}
}
