package com.practice1.demo.pojo1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/*서블릿이나 컨트롤러에서 구현해야 하는 메서드로서, 클라이언트의 요청을 처리하고, 결과에 따라 ActionForward 객체를 반환*/
public interface Action {
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException;
}
