package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/*")
public class TestController {
	Logger logger = LoggerFactory.getLogger(TestController.class);
	@GetMapping("testList")
	public String testList(Model model) {
		logger.info("testList");
		return "test/testList"; //새로고침
//		return "redirect:/test.jsp"; //새로고침
//		return "forward:/test.jsp";  //새로고침 x 
	}
}
