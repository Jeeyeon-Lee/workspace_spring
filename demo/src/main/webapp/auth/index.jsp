<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
//스크립틀릿 - 자바코드 - 예외)전변, 메소드선언, 생성자 선언, 인스턴스화 불가 
	int global = 0;
	void methodA(){ //이 메소드는 호출 불가 왜? 인스턴스화 안되는 부분이니까

	}
%>
<%
	//테스트 시나리오 구분 필요!! 
	
	//디클러레이션 사용x - 전변, 메소드선언, 생성자 선언
	//서블릿 경유하지 않고 이 페이지를 요청하면 무조건 null로 출력
	//왜?? 
	//auth/index.jsp에서 아이디 비번 입력 후 로그인 누르면 auth/login.do를 요청
	//->이 서블릿을 경유한 뒤 
	//Login1Controller에서 sendRedirrect로 index.jsp 요청이 됨 
	
	String mem_name = (String)request.getAttribute("mem_name");
	String smem_name = (String)session.getAttribute("smem_name");
	out.print(mem_name); // sendRedirect로 요청하면 무조건 null 출력됨, forward로 요청하면 출력됨
	out.print("<br>");
	out.print("세션 : "+ smem_name);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index page - 로그인</title>
</head>
<body>
<!-- 요청을 나타내는 문자열이 서블릿 매핑 이름 뒤에 붙어서.. get방식, 노출된다
내 비번이 다 보인다. 보안이 취약하다.  
URL - req.getRequestUR:() : 도메인 제외 나머지 값만 -> /auth/login.do
전체 URL - req.getRequestURL() : full네임 출력 
=> URL을 통해 사용자의 요청사항 구분 가능 
/auth/login.do
upmu[0] = auth(컨트롤 클래스 이름)
upmu[1] = login(컨트롤클래스 메소드이름)
-->
<!-- http://localhost:8000/auth/index.jsp -->
	<form id="f_login" method="get" action="./login.do">
<!-- id 는 js에서 주로 사용, 
name은 서블릿에서 사용, 화면에서 입력한 값 들을 때 name 속성으로만 읽을 수 있음. -->	
		<input type="text" id="mem_id" name="mem_id"/><br>
		<input type="text" name="mem_pw"/><br>
		<input type="button" value="로그인" onclick="login()"/>
	</form>
	<script>
		login = () => {
			console.log('login');
			document.querySelector("#f_login").submit();
		}
	</script>
</body>
</html>