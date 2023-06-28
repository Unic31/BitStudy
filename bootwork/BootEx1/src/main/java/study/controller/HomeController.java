package study.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(
			Model model
			) {
		model.addAttribute("today", new Date());
		model.addAttribute("message", "Spring Boot Setting 성공기원");
		return "views/home";
	}
}
