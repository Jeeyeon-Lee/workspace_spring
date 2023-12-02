package com.example.demo.ch5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class HelloServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

//	매개변수가 없는 init -> 서블릿 초기화하는 기본 초기화 메소드 
	@Override
	public void init() throws ServletException {
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> rmap = new HashMap<>();
		rmap.put("mem_id", "kiwi");
		rmap.put("mem_pw", 123);
		list.add(rmap);

		req.setAttribute("list", list);// 저장하기 - index.jsp에서 꺼낼땐 list 이름을 사용함
		res.sendRedirect("./index.jsp");
	}

	@Override
	public void destroy() {
	}

	
}
