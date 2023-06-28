package bit.study.spring;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//�ڵ����� xml�� been���
@Controller
public class HomeController {
	
	//@RequestMapping(value = "/",method = RequestMethod.GET)
	//@RequestMapping("/")
	
	@GetMapping("/") //5.0���� ����
	public String home(Model model,HttpSession session) {
		//session�� ����
		session.setAttribute("myid", "angel");
		
		//request�� ����
		model.addAttribute("message","Have a Good Day!!");
		model.addAttribute("today",new Date());
		return "home";//������(url�ȹٲ�鼭 ������ �̵�)�� ���ϸ� /WEB-INF/views/home.jsp(servlet-context�� ��������)
	}
	
	//@GetMapping("/myshop")
	@GetMapping({"/myshop","/yourshop"})//���� ��������
	public ModelAndView goShp() {
		ModelAndView model = new ModelAndView();
		//request�� ����
		model.addObject("sangpum","�ڵ���");
		model.addObject("price","100000��");
		model.addObject("color","yellow");
		model.addObject("carname","car5.png");
		//������
		model.setViewName("myshop");
		return model;
	}
}
