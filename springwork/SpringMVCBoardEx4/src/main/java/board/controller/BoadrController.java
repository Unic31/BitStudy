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
			@RequestParam ArrayList<MultipartFile> upload, //����������
			HttpServletRequest request, //������
			HttpSession session
			) {
		//���ǿ� ����� �̸���
		String email=(String)session.getAttribute("loginemail");
		//�� �̸��Ͽ� �ش��ϴ� member ���̺��� num��
		int num=memberDao.selectOneOfEmail(email).getNum();
		//dto�� num����
		dto.setNum(num);
		
		//���ε��� ���
		String realPath=request.getSession().getServletContext().getRealPath("/resources/photo");
		System.out.println(realPath);
		String images="";
		//������ ���ε� ��������� db�� no��� ����
		//���ε� ������� ���ϸ��� ��¥�� �����غ���
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fname=sdf.format(new Date());
		
		if(upload.get(0).getOriginalFilename().equals("")) { //���� ���ε� ����
			images="no"; //���� �ȳ־����� no�� ����
		}else {
			int i = 0;
			for(MultipartFile mfile:upload) {
				String originalName=mfile.getOriginalFilename();
				// .�� �������� ��������(��, ���ϸ� ���̿� . �� �� ���� �ȵ�)
				StringTokenizer st = new StringTokenizer(originalName,".");
				String fileName=st.nextToken(); // . �� �������� �������� ù��°��(���ϸ�)
				String extName=st.nextToken(); // . �� �������� �������� �� ������(Ȯ���ڸ�)
				
				//���ϸ��� ��¥�� �����ϱ�
				fileName=fname+"_"+i++ +"."+extName; // fname(������ ���ص� �����Ͻú���)�ڿ� _ �ְ� i(0���� 1�� ������Ű�� �ֱ�(�ߺ������ʰ�)) 
													// �� �ڿ� . ���̰� Ȯ���� ���̱�
				System.out.println(fileName); //���ε�� ���� ���ϸ�
				
				images+=fileName+",";
				
				//���� ���ε�
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
			//������ �ĸ� ����
			images=images.substring(0,images.length()-1);
			
		}
		//dto�� images�� ����
		dto.setImages(images);
		//db�� ����
		boardDao.insertOfBoard(dto);
		return "redirect:list";
	}
	
	@GetMapping("/board/list")
	public String list(
			HttpSession session,
			Model model,
			@RequestParam(defaultValue="1") int currentPage //������ ��ȣ�� �ȳѾ�ð�� ������ 1�������� �����ش�
			) {
		String email=(String)session.getAttribute("loginemail");
		MemberDto dto = memberDao.selectOneOfEmail(email);
		
		model.addAttribute("dto",dto);
		
		
		int totalCount=boardDao.getTotalCount();//�Խ����� �� �� ����
		int totalPage;//�� ��������
		int perPage=3;//�� �������� ������ �� ����
		int perBlock=3;//�� ���� ������ �������� ����
		int startNum;//�� ���������� ������ ���� ���۹�ȣ
		int startPage;//�� ������ ������ ���� ������ ��ȣ
		int endPage;//�� ������ ������ �� ������ ��ȣ
		int no;//�� ��½� ����� ���۹�ȣ
		
		//�� ��������
		totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);//�� �������� 0�� ���ϰ� �������� ������ 1(������)�� �����ش�
		//���� ������
		startPage=(currentPage-1)/perBlock*perBlock+1;//(2-1)/3*3+1=1, (5-1)/3*3+1=4
		//��������
		endPage=startPage+perBlock-1;
		//�̶� ������ ... endPage�� totalPage���� ũ�� �ȵȴ�
		if(endPage>totalPage)
			endPage=totalPage;
		
		//�� �������� ���۹�ȣ(1������:0, 2������:3, 3������:6...)
		startNum=(currentPage-1)*perPage;
		//�� �۸��� ����� �� ��ȣ(��:10���ϰ�� 1������:10, 2������:7...)
		no=totalCount-startNum;
		
		//�� �������� �ʿ��� �Խñ� db���� ��������
		List<BoardDto> list = boardDao.getPagingList(startNum, perPage);
		//�� �Խñۿ� �۾������ name�� dto�� ����
		for(BoardDto bdto:list) {
			//�۾������ num
			int num=bdto.getNum();
			//num�� �ش��ϴ� ����� �̸� 
			String name="";
			try {
				//num�� �ش��ϴ� �����Ͱ� ������� ������Ʈ�̼��� �߻�
				name=memberDao.selectOneOfNum(num).getName();
			}catch (NullPointerException e) {
				name="Ż����ȸ��";
			}
			//bdto�� ����
			bdto.setName(name);
			
			//��� ���� acount�� ����
			int acount=answerDao.getAllAnswers(bdto.getIdx()).size();
			bdto.setAcount(acount);
		}
		
		//��½� �ʿ��� �������� model�� ��� ����
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
		//��ȸ�� ����
		boardDao.updateReadCountOfBoard(idx);
		//board���̺��� dto�����͸� ��´�
		BoardDto dto = boardDao.selectOneBoardOfIdx(idx);
		//num�� �ش��ϴ� name, photo�� �� dto�� �־��ش�
		
		try {
		String name=memberDao.selectOneOfNum(dto.getNum()).getName();
		String photo=memberDao.selectOneOfNum(dto.getNum()).getPhoto();
		
		dto.setName(name);
		dto.setPhoto(photo);
		}catch (NullPointerException e){
			dto.setName("Ż����ȸ��");
			dto.setPhoto("noimage.png");
		}
		//model�� dto, currentPage�� ����
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
			@RequestParam ArrayList<MultipartFile> upload, //����������
			HttpServletRequest request, //������
			@RequestParam int currentPage
			) {
		//���ε��� ���
		String realPath=request.getSession().getServletContext().getRealPath("/resources/photo");
		System.out.println(realPath);
		String images="";
		//������ ���ε� ��������� db�� no��� ����
		//���ε� ������� ���ϸ��� ��¥�� �����غ���
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fname=sdf.format(new Date());
		
		if(upload.get(0).getOriginalFilename().equals("")) { //���� ���ε� ����
			images=null; //null�ϰ�� ���� ������ �����ǰ� sql�� ¥����
		}else {
			int i = 0;
			for(MultipartFile mfile:upload) {
				String originalName=mfile.getOriginalFilename();
				// .�� �������� ��������(��, ���ϸ� ���̿� . �� �� ���� �ȵ�)
				StringTokenizer st = new StringTokenizer(originalName,".");
				String fileName=st.nextToken(); // . �� �������� �������� ù��°��(���ϸ�)
				String extName=st.nextToken(); // . �� �������� �������� �� ������(Ȯ���ڸ�)
				
				//���ϸ��� ��¥�� �����ϱ�
				fileName=fname+"_"+i++ +"."+extName; // fname(������ ���ص� �����Ͻú���)�ڿ� _ �ְ� i(0���� 1�� ������Ű�� �ֱ�(�ߺ������ʰ�)) 
													// �� �ڿ� . ���̰� Ȯ���� ���̱�
				System.out.println(fileName); //���ε�� ���� ���ϸ�
				
				images+=fileName+",";
				
				//���� ���ε�
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
			//������ �ĸ� ����
			images=images.substring(0,images.length()-1);
			
		}
		//dto�� images�� ����
		dto.setImages(images);
		//db�� �����Ѱ� ����
		boardDao.updateBoard(dto);
		return "redirect:content?idx="+dto.getIdx()+"&currentPage="+currentPage;
	}
	@GetMapping("/board/delete")
	public String delete(
			@RequestParam int idx,
			@RequestParam int currentPage
			) {
		
		boardDao.deleteBoard(idx);
		//������ ���� ������ ������� �̵�
		return "redirect:./list?currentpage="+currentPage;
		
	}
}
