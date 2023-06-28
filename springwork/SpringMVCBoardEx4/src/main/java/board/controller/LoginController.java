package board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.dao.MemberDao;

@Controller
public class LoginController {

	@Autowired
	MemberDao memberDao;
	@GetMapping("/login/form")
	public String form(HttpSession session) {
		
		//로그인 여부를 판단-세션 없을경우 null
		String loginok=(String)session.getAttribute("loginok");
		
		if(loginok==null)
			return "login/login";
		else
			return "login/logout";
			
	}
	@PostMapping("/login/loginaction")
	public String loginAction(
			@RequestParam String email,
			@RequestParam String pass,
			@RequestParam(required=false) String saveemail,//null일때 null로 받는다. 안하면 null값일때 에러뜸
			//@RequestParam(defaultValue="no") String saveemail,//체크 안했을경우 no값으로 변환되서 넘어온다
			HttpSession session
			) {
		//이메일과 비밀번호가 맞는지 체크
		int count=memberDao.isEqualPassEmail(email, pass);
		if(count==1) {//이메일과 비번이 맞으면 1
			
			//세션 시간
			session.setMaxInactiveInterval(60*60);
			//로그인 성공시 세션에 저장하기
			session.setAttribute("loginok", "yes");
			session.setAttribute("loginemail", email);
			session.setAttribute("saveemail", saveemail==null?"no":"yes");
			//로그인한 사람의 num값 얻어서 세션에 저장
			int num=memberDao.selectOneOfEmail(email).getNum();
			session.setAttribute("loginnum", num);//로그인한 사람의 num을 loginnum이란 이름으로 저장
			
			return "redirect:../board/list";
		}else {
			return "login/loginfail";
		}
		
	}
	@GetMapping("/login/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginok");
		return "redirect:form";
	}
	
}
