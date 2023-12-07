<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/notice/noticeList.jsp");
view.forward(request, response);  
%>