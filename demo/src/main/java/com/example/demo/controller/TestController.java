package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/*")
public class TestController {
	@GetMapping("testList")
	public String testList() {
		return "redirect:/test.jsp"; //새로고침
//		return "forward:/test.jsp";  //새로고침 x 
	}
	
}
