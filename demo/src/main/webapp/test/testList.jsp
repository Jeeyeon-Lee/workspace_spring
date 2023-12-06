<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Map, com.google.gson.Gson"%>
<%!
//디클러레이션 - 자바코드 사용 가능
//전변, 메소드 선언 자리
//인스턴스화 못 함 - 플랫폼 독립적이어서 서버마다 자바 클래스 이름의 명명규칙 다름 
//공통코드, DB 연동하는 코드, 재사용성 고려한 메소드라면 XXX.java 


//</select>
//<select id="proc_empcursor" parameterType="java.util.Map" statementType="CALLABLE">

//아래 코드 설명 resultset : 커서 / VO : 레코드, 가로형 데이터 / 모드 : in, out, in-out / 
//	{  call proc_empcursor(#{key, jdbcType=CURSOR, mode=OUT, javaType=java.sql.ResultSet, resultMap=empVO})}
//</select>
%>

<%
//스크립틀릿 - 자바코드 입력하는 공간
//지역변수 : service()코드가 생성되니까 메소드 안에서 선언한 변수이니까 
//조회된 결과를 Map으로 가져올 예정임!

//java, xml 파일을 확인해가며 타입, 이름 등 확인해가며 작성 필요!! 
//request는 저장소의 역할도 한다는 것 잊지 말기!! 
//캐스팅 연산자로 타입 맞춰주기, 중간 확인하기 
  Map<String,Object> rmap = (Map)request.getAttribute("pMap");
  out.print(rmap); //out은 내장객체 인스턴스화 없이 즉시 사용 가능!! 
  Gson g = new Gson();
  String temp = g.toJson(rmap);
  out.print(temp);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원목록 - 프로시저{webapp}</title>
</head>
<body>

</body>
</html>