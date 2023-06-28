package boot.study.controller;

import boot.study.dto.BoardDto;
import boot.study.service.BoardService;
import naver.cloud.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private NcpObjectStorageService storageService;
    private String bucketName="bit701-bucket-113";
    //private String bucketName="bit701-bucket-56";//쌤꺼

    @GetMapping("/list")
    public String list(
            @RequestParam(defaultValue = "1") int currentPage,
            Model model
        ){
        int totalCount=boardService.getTotalCount();//게시판의 총 글 갯수
        int totalPage;//총 페이지수
        int perPage=3;//한 페이지당 보여질 글 갯수
        int perBlock=2;//한 블럭당 보여질 페이지의 갯수
        int startNum;//각 페이지에서 보여질 글의 시작번호
        int startPage;//각 블럭에서 보여질 시작 페이지 번호
        int endPage;//각 블럭에서 보여질 끝 페이지 번호
        int no;//글 출력시 출력할 시작번호

        //총 페이지수
        totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);//딱 떨어지면 0을 더하고 나머지가 있으면 1(페이지)을 더해준다
        //시작 페이지
        startPage=(currentPage-1)/perBlock*perBlock+1;
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
        List<BoardDto> list = boardService.getPagingList(startNum, perPage);
        //출력시 필요한 변수들을 model에 모두 저장
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("list", list);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("no", no);

        return "/main/board/boardlist";
    }

    @GetMapping("/writeform") //폼이 원글일수도 있고 답글폼일수도 있다
    public String form(
            @RequestParam(defaultValue = "1") int currentPage,
            @RequestParam(defaultValue = "0") int num,
            @RequestParam(defaultValue = "0") int ref,
            @RequestParam(defaultValue = "0") int step,
            @RequestParam(defaultValue = "0") int depth,
            Model model
    ){
        //답글일경우 제목은 나오게 하기 위해서 제목을 구해보자
        String subject="";
        if(num>0){//답글인경우
            subject=boardService.getData(num).getSubject();

        }
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("num",num);
        model.addAttribute("ref",ref);
        model.addAttribute("step",step);
        model.addAttribute("depth",depth);
        model.addAttribute("subject",subject);
        return "/main/board/boardform";
    }
    @PostMapping("/insert")
    public String insert(BoardDto dto, MultipartFile upload){
        String filename="";
        //업로드를 한 경우에만 버킷에 미지지 저장
        if(!upload.getOriginalFilename().equals("")){//오리지날 파일네임이 빈문자열이 "아니면" == 파일을 올렸으면
            filename=storageService.uploadFile(bucketName, "board", upload);
        }
        //dto에 파일명 저장
        dto.setFilename(filename);

        boardService.insertBoard(dto);
        return "redirect:list";
    }

    @GetMapping("/content")
    public String content(int num,int currentPage,Model model){
        //조회수 증가
        boardService.updateReadcount(num);
        //dto
        BoardDto dto = boardService.getData(num);

        model.addAttribute("dto",dto);
        model.addAttribute("currentPage",currentPage);


        return "/main/board/content";
    }
    @GetMapping("/delete")
    @ResponseBody public Map<String, String> delete(int num, String pass){
        System.out.println(num);
        System.out.println(pass);
        Map<String, String> map = new HashMap<>();
        //비번이 맞을경우 map에 result->success를 넣고 버켓의 사진 지우고 db글 지우고
        //틀릴경우 map에 result->에 fail
        boolean b = boardService.isEqualPass(num,pass);

        if(b){
            map.put("result","success");
            //db삭제 전에 저장된 이미지를 버켓에서 지운다
            String filename=boardService.getData(num).getFilename();
            storageService.deleteFile(bucketName, "board", filename);
            //db삭제
            boardService.deleteBoard(num);
        }else{
            map.put("result","fail");
        }

        return map;
    }
    /*@GetMapping("/update")
    public String update(int num, Model model){
        System.out.println(num);
        BoardDto dto = boardService.getData(num);
        model.addAttribute("dto",dto);

        return "/main/board/updateform";
    }*/
    @GetMapping("/updatepass")
    @ResponseBody public Map<String, String> updatepass(int num, String pass){
        Map<String, String> map = new HashMap<>();
        //비번이 맞을경우 map에 result->success를 넣고 버켓의 사진 지우고 db글 지우고
        //틀릴경우 map에 result->에 fail
        boolean b = boardService.isEqualPass(num,pass);
        if(b){
            map.put("result","success");
        }else{
            map.put("result","fail");
        }
        return map;
    }

    @GetMapping("/updateform")
    public String updateform(int num, int currentPage, Model model){

        BoardDto dto = boardService.getData(num);
        model.addAttribute("dto",dto);
        model.addAttribute("currentPage",currentPage);
        return "/main/board/updateform";
    }
    @PostMapping("/update")
    public String update(BoardDto dto, MultipartFile upload, int currentPage){
        //사진선택을 한 경우에는 기존사진을 버켓에서 지우고 다시 업로드
        String filename="";
        if(!upload.getOriginalFilename().equals("")){
            //기존파일명 알아내기
            filename = boardService.getData(dto.getNum()).getFilename();
            //버킷에서 삭제
            storageService.deleteFile(bucketName, "board", filename);
            //다시 업로드후 업ㄹ드한 파일명 얻기
            filename=storageService.uploadFile(bucketName, "board", upload);
        }
        dto.setFilename(filename);

        //수정
        boardService.updateBoard(dto);

        return "redirect:./content?num="+dto.getNum()+"&currentPage="+currentPage;
    }
}
