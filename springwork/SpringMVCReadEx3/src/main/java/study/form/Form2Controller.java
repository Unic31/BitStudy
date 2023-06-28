package study.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import study.dto.ShopDto;

@Controller
public class Form2Controller {
	
	@GetMapping("/form2")
	public String form2() {
		return "myform/form2";
	}
	
	@PostMapping("/read2")
	//@ModelAttribute : 같은 이름은 자동으로 읽어오고 model에 저장 //form의 name이랑 dto의 변수가 같을때 자동
	//model에 저장되는 이름은 shopDto 이름으로 모델에 저장됨(첫글자 소문자)
	//다른이름으로 저장하고 싶을 경우 @ModelAttribute("이름"). 이름 변경 안할거면 그냥 ModelAttribute 생략 가능
	/*public String read2(@ModelAttribute ShopDto dto,
			@RequestParam int pagenum,Model model)
	{
		model.addAttribute("pagenum",pagenum);
		return "result/readdata2";
	}*/
	public String read2(ShopDto dto,
			int pagenum,Model model)
	{
		model.addAttribute("pagenum",pagenum);
		return "result/readdata2";
	}
}
