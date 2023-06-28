package bit.study.spring;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//자동으로 xml에 been등록
@Controller
public class HomeController {
	
	//@RequestMapping(value = "/",method = RequestMethod.GET)
	//@RequestMapping("/")
	
	@GetMapping("/") //5.0부터 가능
	public String home(Model model,HttpSession session) {
		//session에 저장
		session.setAttribute("myid", "angel");
		
		//request에 저장
		model.addAttribute("message","Have a Good Day!!");
		model.addAttribute("today",new Date());
		return "home";//포워드(url안바뀌면서 페이지 이동)할 파일명 /WEB-INF/views/home.jsp(servlet-context에 적혀있음)
	}
	
	//@GetMapping("/myshop")
	@GetMapping({"/myshop","/yourshop"})//매핑 여러가지
	public ModelAndView goShp() {
		ModelAndView model = new ModelAndView();
		//request에 저장
		model.addObject("sangpum","자동차");
		model.addObject("price","100000원");
		model.addObject("color","yellow");
		model.addObject("carname","car5.png");
		//포워드
		model.setViewName("myshop");
		return model;
	}
}
