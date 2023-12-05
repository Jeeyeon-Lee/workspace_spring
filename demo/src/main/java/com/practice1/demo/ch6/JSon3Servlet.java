package com.practice1.demo.ch6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mime1/json3.do")
public class JSon3Servlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(JSon3Servlet.class);
	private static final long serialVersionUID = 1L; 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doGet");
		//데이터셋을 쥐고 있어야 넘길 수 있음. 
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> rmap = new HashMap<>();
		rmap.put("deptno",10);
		rmap.put("dname","총무부");
		rmap.put("loc","서울");
		list.add(rmap);
		rmap.put("deptno",20);
		rmap.put("dname","개발부");
		rmap.put("loc","인천");
		list.add(rmap);
		rmap.put("deptno",30);
		rmap.put("dname","운영부");
		rmap.put("loc","경기");
		list.add(rmap);		
		//forward 써보자
		req.setAttribute("list",list);
		RequestDispatcher view = req.getRequestDispatcher("./json2Test.jsp");
		view.forward(req, res);
	}
}
