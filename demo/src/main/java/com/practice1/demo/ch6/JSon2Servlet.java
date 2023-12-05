package com.practice1.demo.ch6;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mime1/json2.do")
public class JSon2Servlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(JSon2Servlet.class);
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doGet");
		res.sendRedirect("./json2Test.jsp");
	}
}
