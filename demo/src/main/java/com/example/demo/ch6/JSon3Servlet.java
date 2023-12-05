package com.example.demo.ch6;

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


//확인해보고 싶다?
/*
1. URL 패턴이 필요 어떤 방법으로?? - > exactly, *.do , * , default (/-root directory)
2. 테스트 URL 패턴 적어보기! 
-get 방식 : http://localhost:8000/mime/json.do
-post 방식 : 
*/
@WebServlet("/mime/json3.do")
public class JSon3Servlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(JSon3Servlet.class);
	private static final long serialVersionUID = 1L;
	
	//서블릿 경유했지만 ㄱ실제로 한 건 없음
	//유지문제 포함되지 않음. 유지하고 싶다면 forward 사용
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
		
		//여기가 포인트 - 주요 낱말카드 : socpe - 유효범위 - request
		//디스패치방식 사
		req.setAttribute("list", list);
		RequestDispatcher view = req.getRequestDispatcher("./json2Test.jsp");
		//파라미터값으로 req, res 원본을 넘김 그래야 서블릿에서 쥐고 있는 데이터 셋 화면으로 출력 가능 
		view.forward(req, res);
	}
}
