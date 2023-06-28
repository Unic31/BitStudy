package board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import board.dao.AnswerDao;
import board.dao.MemberDao;
import board.dto.AnswerDto;

@RestController
public class AnswerController {
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	AnswerDao answerDao;
	
	//댓글 insert
	@GetMapping("/board/ainsert")
	public void insertAnswer(
			@RequestParam String content,
			@RequestParam int idx,
			@RequestParam int num
			) {
		
		
		//dto에 담는다
		AnswerDto dto = new AnswerDto();
		dto.setContent(content);
		dto.setIdx(idx);
		dto.setNum(num);
		
		answerDao.insertAnswer(dto);
	}
	//댓글 전체 list
	@GetMapping("/board/alist")
	public List<AnswerDto> getAllAnswers(
			@RequestParam int idx
			){
		List<AnswerDto> list= answerDao.getAllAnswers(idx);//list가 json형태로 반환(컨트롤러가 rest컨트롤러라서)
		for(AnswerDto dto:list) {							//일반 컨트롤러 였으면 리퀘스트바디 해줘야함
			try {
			//member 테이블로부터 name, photo를 얻어서 dto에 넣는다
			String name=memberDao.selectOneOfNum(dto.getNum()).getName();
			String photo=memberDao.selectOneOfNum(dto.getNum()).getPhoto();
			dto.setName(name);
			dto.setPhoto(photo);
			}catch(NullPointerException e) {//해당 num이 없을경우 널포인트 이셉션 발생
				dto.setName("탈퇴한 회원");
				dto.setPhoto("noimage2.png");
				
			}
			
			
		}
		return list;
	}
	@GetMapping("/board/adelete")
	public void deleteAnswer(
			@RequestParam int seq
			) {
		answerDao.deleteAnswer(seq);
		
		
	}
	
}
