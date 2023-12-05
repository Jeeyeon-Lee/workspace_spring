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
@WebServlet("/mime/json2.do")
public class JSon2Servlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(JSon2Servlet.class);
	private static final long serialVersionUID = 1L;
	
	//서블릿 경유했지만 ㄱ실제로 한 건 없음
	//유지문제 포함되지 않음. 유지하고 싶다면 forward 사용
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doGet");
		res.sendRedirect("./json2Test.jsp"); 
	}
}
