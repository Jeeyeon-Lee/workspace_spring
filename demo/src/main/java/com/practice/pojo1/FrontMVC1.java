package com.practice.pojo1;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.RequestDispatcher;
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
//확장자가 gd로 끝나면 내가 관여할게! 
@WebServlet("*.me")
public class FrontMVC1 extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(FrontMVC1.class);
	private static final long serialVersionUID = 1L;

	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doService");
		//gd로 끝나는 url 관여할건데 url 나눠서 배열에 넣어볼게 -> 각 값별 처리를 위해
		String uri = req.getRequestURI();
		logger.info(uri);
		String context = req.getContextPath();
		logger.info(context);
		String command = uri.substring(context.length()+1);
		logger.info(command);
		int end = command.lastIndexOf(".");
		logger.info(""+end);
		String upmu[] = null;
		upmu = command.split("/");
		for(String name : upmu) {
			logger.info(name);
		}
		
		//url 업무이름/메소드에 따른 실행할 수 있도록 Action 인터페이스 구현 필요
		//경로, 리다이렉트여부에 대한 변수와 메소드가 정의되어있는 ActionForward(추상클래스)가 있음. 사용하기 위해 생성  
		//&메소드리읆별 처리를 위해 Logic도 생성해야 함. 
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doPost-가져올 때");
		doService(req, res);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doGet-가져올 때");
		doService(req, res);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doDelete-삭제할 때");
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doPut-수정할 때");
	}
}

