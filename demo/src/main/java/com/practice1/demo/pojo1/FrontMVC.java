package com.practice1.demo.pojo1;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * URL 패턴 14가지 구성 예정
http://localhost:8000/member/memberInsert.gd -> (입력)insert : int
http://localhost:8000/lecture/lectureInsert.gd
http://localhost:8000/notice/noticeInsert.gd
http://localhost:8000/member/memberUpdate.gd -> (수정)update : int
http://localhost:8000/lecture/lectureUpdate.gd
http://localhost:8000/notice/noticeUpdate.gd
http://localhost:8000/member/memberDelete.gd -> (삭제)delete : int
http://localhost:8000/lecture/lectureDelete.gd
http://localhost:8000/notice/noticeDelete.gd
http://localhost:8000/member/memberList.gd   -> (조회)select - dispatcher(forward) -false
http://localhost:8000/lecture/lectureList.gd -> (조회)select - dispatcher(forward) -false
http://localhost:8000/notice/noticeList.gd   -> (조회)select - dispatcher(forward) -false
*/

@WebServlet("*.fd")
public class FrontMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(FrontMVC.class);

	//개발자가 설계를 잘 해야 하는 메소드
	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		logger.info(uri);
		String context = req.getContextPath();
		String command = uri.substring(context.length()+1);
		int end = command.lastIndexOf(".");
		command = command.substring(0,end);
		String upmu[] = null;
		upmu = command.split("/"); //업무이름, 메소드 2개의 값로 나눠서 배열에 저장됨.
		for(String name : upmu) {
			logger.info(name);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req, res);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req, res);
	}
}
