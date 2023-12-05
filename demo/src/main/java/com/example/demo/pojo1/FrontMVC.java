package com.example.demo.pojo1;

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
@WebServlet("*.gd")
public class FrontMVC extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(FrontMVC.class);
	private static final long serialVersionUID = 1L;

	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// http://localhost:8000/lecture/lectureDelete.gd
		// 1. notice/noticeInsert.gd로 끊음.
		String uri = req.getRequestURI();
		logger.info(uri);
		String context = req.getContextPath();
		// 2. 두번째 문자열부터 짤라오기 notice/noticeInsert.gd가 남음
		String command = uri.substring(context.length() + 1);
		// 3. 의미없는 gd 잘라내기
		// 3-1. 점이 있는 위치를 가져와서 end 변수에 대입
		int end = command.lastIndexOf(".");
		// 3-2. end 전까지의 문자열로 잘라내기
		command = command.substring(0, end);
		String upmu[] = null;
		// 4.토크나이저로 나누기
		upmu = command.split("/");

		// 5.나눠진 URL 확인하기
		for (String name : upmu) {
			logger.info(name);
		}

		// ActionForward 받아오기 -> 변수(path, isRedirect)
		ActionForward af = null;
		// Controller 생성 -> res, req 받을 수 있게 됨.
		NoticeController nc = new NoticeController();
//		LectureController lc = new LectureController();
//		MemberController  mc = new MemberController();
		/* 어떤 컨트롤러 태울 것인가? */
		// 이 지점은 내려가는 방향이다. (컨트롤러 요청 지점)
		if ("notice".equals(upmu[0])) {
			req.setAttribute("upmu", upmu); // 원본이 넘어감(배열 주소번지 넘김, 들어간 값 사용 가능)
			// NpticeController로 넘어가게 됨 - upmu[1] 메소드 이름이니까?!
			af = nc.execute(req, res);
		}
		// 이 지점은 java와 오라클서버를 경유한 뒤 시점이다.
		if (af != null) {
			// 너 수정했니?삭제했니?입력했니?조회햇니? => redirect
			if (af.isRedirect()) {
				res.sendRedirect(af.getPath());
			}
			// 너 안햇니? => forward
			else {
				RequestDispatcher view = req.getRequestDispatcher(af.getPath());
				view.forward(req, res);
			}
		} else if ("Lecture".equals(upmu[1])) {
		}
	}
	/* 컨트롤을 타고 난 뒤 내가 할 일은? */
	// 해당 업무에 대응하는 컨트롤러 결정 페이지 이름 받아온다.
	// 위에 결정된 true, false 값에 따라 sendRedirect와 forward를 통해 응답페이지 호출한다.


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req, res);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req, res);
	}

}
