package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/*")
public class TestController {
	@GetMapping("testList")
	//왜 리턴타입이 String??
	//upmuu[0] = redirect or forward
	//ActionForward로 클래스를 설계하여 String 대신 사용해보기 
	//Pojo(순수자바) 실습 
	public String testList(Model model) {
		return "redirect:/test.jsp"; //새로고침
//		return "forward:/test.jsp";  //새로고침 x 
	}
	
}
