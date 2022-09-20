<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>서적관리시스템 - 조회(R3)</h1>
	<hr>
	<h2>전체보기(부분조회 미포함, 페이징 기능 개선, 출력 레코드 갯수 선택, 세션객체 사용안함)</h2>
	<hr>
	<h2>현재 DISPLAY RECORDS NUMBER : 10</h2>
	<hr>

<%
	String driverName = "org.mariadb.jdbc.Driver";
	String url = "jdbc:mariadb://localhost/book_db";
	String user = "root";
	String passwd = "root";
	
	Class.forName(driverName);
	Connection con = DriverManager.getConnection(url, user, passwd);
	Statement stmt = con.createStatement();
	request.setCharacterEncoding("utf-8");
%>
<%
	String range;
%>
<form action="./book_r3.jsp?range=<%=%>" method="get">
<div>
디스플레이 레코드수 변경 :
<select name="range">
	<option value="10">10</option>
	<option value="20">20</option>
	<option value="50">50</option>
	<option value="100">100</option>
</select>
<input type="submit" value="확인">
</div>
</form>

<%
	System.out.println("range ===> " + Integer.parseInt(request.getParameter("range")));
%>

<br><br><a href="./index.jsp">홈으로 돌아가기</a>
</body>
</html>