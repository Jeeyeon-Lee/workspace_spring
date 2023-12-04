package com.example.demo.separator;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/auth/login1.do")
public class Login1Controller extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(Login1Controller.class);
	private static final long serialVersionUID = 1L;
	//게으른 인스턴스화 : 우선 null로 해두고, 필요할 때 생성하자 
	Login1Logic lgLogic = null;
	
	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doService");
		logger.info(req.toString());
		logger.info(res.toString());
		lgLogic = new Login1Logic(); //여기서 생성(실습용이지 딱히 의미있는 인스턴스화 x)
		//getParameter("mem_id")의 파라미터와 리턴타입은 String 타입이다. 
		String mem_id = req.getParameter("mem_id"); //where절
		String mem_pw = req.getParameter("mem_pw"); //and절
		String mem_name = lgLogic.login(mem_id, mem_pw);
		req.setAttribute("mem_name", mem_name);
		
//		세션으로 해보기 
		
//		HttpSession session = req.getSession();
//		session.setAttribute("smem_name", mem_name);
//		res.sendRedirect("./index.jsp");
		
//		forward로 해보기
		RequestDispatcher view = req.getRequestDispatcher("index.jsp");
		view.forward(req,res);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
}
