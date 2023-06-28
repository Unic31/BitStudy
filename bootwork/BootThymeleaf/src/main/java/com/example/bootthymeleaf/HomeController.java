package com.example.bootthymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Vector;

@Controller
public class HomeController {
    List<ShopDto> list = new Vector<>();
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("message","Happy Day!!!");

        ShopDto dto = ShopDto.builder().sang("복숭아").su(5).dan(1200).build();
        model.addAttribute("dto",dto);
        model.addAttribute("today", new Date());
        return "home";
    }

    @GetMapping("/list")
    public String list(Model model){

        list.clear();
        list.add(new ShopDto("고양이1","cat1.jpg", 1, 999999));
        list.add(new ShopDto("고양이2","cat2.jpg", 2, 999999));
        list.add(new ShopDto("고양이3","cat3.jpg", 3, 999999));
        list.add(new ShopDto("고양이4","cat4.jpg", 4, 999999));

        model.addAttribute("list",list);
        return "list";
    }

    @GetMapping("/detail")
    public String detail(int index, Model model, HttpSession session){
        session.setAttribute("loginid","admin");
        model.addAttribute("dto",list.get(index));
        return "detail";
    }

}
