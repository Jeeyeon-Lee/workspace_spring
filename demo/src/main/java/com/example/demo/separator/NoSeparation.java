package com.example.demo.separator;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//표준으로 사용하는 이유는 다른 외부 라이브러리와 의존관계와 있을 때 에러없이 처리됨! 
@WebServlet("/auth/login.do")
public class NoSeparation extends HttpServlet {
	//객체로부터 class 객체 얻어오는 함수 getClass()
	Logger logger = LoggerFactory.getLogger(NoSeparation.class);
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//이 코드는 부모메소드로 사용하고 싶을 때 넣어서 사용(통상 생략하고 사용)
		//super.doGet(req, resp);
		//1.입력
		logger.info("doGet");
		String mem_Id = req.getParameter("mem_id"); //where절
		String mem_pw = req.getParameter("mem_pw"); //and절
		//2.처리(인증) 
		//서버 응답으로 받아올 이름 담기
		String mem_name = null;
		String db_id = "kiwi";
		String db_pw = "123";
		String db_name = "키위";
		if(mem_Id.equals(db_id)) {
			if(mem_pw.equals(db_pw)) {
				mem_name = db_name;
			}else{
				mem_name = "비밀번호가 맞지 않습니다.";
			}
		}else {
			System.out.println("아이디가 존재하지 않습니다.");
		}
		//3. 결과출력 
		/* response = pageContext, 
		request,
		session. 
		application.
		*/
		res.setContentType("text/html:charset=utf-8");
		PrintWriter out = res.getWriter();
		/*현업에서는 정규식의 방식으로 작성가능*/
		boolean isID = mem_name.contains("아이디가");
		boolean isPW = mem_name.contains("비밀번호가");
		if(isID||isPW) { //or로 작성! 
			out.print(mem_name);
		}else {
			out.print(mem_name+"님 환영합니다.");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//이 코드는 부모메소드로 사용하고 싶을 때 넣어서 사용(통상 생략하고 사용)
		//super.doPost(req, resp); 
	}
}
