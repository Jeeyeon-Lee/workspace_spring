package com.example.demo.ch5;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.dao.TestDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//200 : 오케이
//302 : 한 번 요청한 url get 방식으로 또 요청했을 때 - 서버까지 전달 x 
//404 에러 : url 오타, 경로 오류 
//405 에러 : Restful API 메소드 이름 오타 
//500 : Exception, 런타임에러, 반드시 트러블 슈팅 해야함. 

//url로 호출할 수 있는 메소드는 doGet() 뿐이다. - get 방식 뿐
//그럼 doPost()는?? postman, 자바스크릡트로 처리하면 사용 가능 
@WebServlet("/test/testList")
public class TestServlet extends HttpServlet {
	Logger	logger = LoggerFactory.getLogger(TestServlet.class);
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doGet");  
		TestDao tDao = new TestDao();
		Map<String,Object> pMap = new HashMap<>();
		tDao.procEmpcursor(pMap);
		logger.info(pMap.toString());
		req.setAttribute("pMap", pMap);
		
		//View 계층과 연결되는 지점!! front - back 만나는 지점!! 
		RequestDispatcher view = req.getRequestDispatcher("./testList.jsp");
		view.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doPost");
	}

}
