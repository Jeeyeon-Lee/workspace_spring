<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%  // 서블릿(FrontMVC)을 경유하고 [NoticeController -> NoticeLogic]
 	// select한 결과를 돌려(List<Map>)받아서 request객체에 담아 두었다
    // 									 req.setAttribute("nList",nList)
 	List<Map<String,Object>> nList = (List)request.getAttribute("nList");
	out.print(nList);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>공지사항{webapp}</title>
</head>
<body>
    <!-- 공지사항 목록 처리할 코드 작성해 보기 -->
    <input type="button" value="조회"/>
</body>
</html>