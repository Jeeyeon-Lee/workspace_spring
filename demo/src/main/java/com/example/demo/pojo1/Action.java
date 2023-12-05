package com.example.demo.pojo1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// interface - 추상메소드만 가질수 있다. - 클래스의 명세서 역할을 담당 = 구현은 할 수 없다.
//-> 디바이스가 결정되지 않았으니까
/*서블릿이나 컨트롤러에서 구현해야 하는 메서드로서, 클라이언트의 요청을 처리하고, 결과에 따라 ActionForward 객체를 반환 => 일관된 방식으로 요청처리하도록 도움*/
public interface Action {
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException; // http..을 사용한다는건 의존적인거임
	
}