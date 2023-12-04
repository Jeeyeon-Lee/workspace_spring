<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index page - 로그인</title>
</head>
<body>
<!-- 요청을 나타내는 문자열이 서블릿 매핑 이름 뒤에 붙어서.. get방식, 노출된다
내 비번이 다 보인다. 보안이 취약하다.  -->
<!-- http://localhost:8000/auth/index.jsp -->
	<form id = "f_login" method = "get"action = "./login.do">
		<input type = "text" name = "mem_id"/><br>
		<input type = "text" name = "mem_pw"/><br>
		<input type = "button" value = "로그인" onclick = "login()"/><br>
	</form>
	<script>
		login = () =>{
			console.log('login');
			document.querySelector("#f_login").submit();
		}
	</script>
</body>
</html>