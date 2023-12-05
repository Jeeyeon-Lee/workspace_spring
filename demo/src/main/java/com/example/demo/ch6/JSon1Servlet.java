package com.example.demo.ch6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

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
@WebServlet("/mime/json.do")
public class JSon1Servlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(JSon1Servlet.class);
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		//내보낼 정보 담기
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
		//키 = 값  -> 추후 다른 곳에서 비벼지기 어려움. 
//		out.print(list); //[{loc=경기, dname=운영부, deptno=30}]

		//temp까지 찍어서 값을 비교해봐야 함. 
		//json으로 변경하여 내보낼 준비하기
		//why?? JSON 포맷(마임타입)을 이야기하지만 결국 이 서블릿이 데이터셋 역할을 한다는 걸 봐야 함. 
		//그 역할을 한다는 걸 이해해야 리액트, UI 솔루션, 라이브러리에 비벼질 수 있음.
		//리액트의 어떤 언어가 이 URL을 가져가나?(javascript-전송-(get,post)-fetch&ajax&axios)
		//"키" : "값" -> JSON 형식이기 때문에 활용 가능. 
		//
		Gson g = new Gson();
		String temp = g.toJson(list);
		out.print(temp); //[{"loc":"경기","dname":"운영부","deptno":30}]
	}
}
