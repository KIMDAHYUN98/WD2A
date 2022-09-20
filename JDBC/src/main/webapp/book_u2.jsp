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
<h1>서적관리시스템 - 자료수정(U)</h1>
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
	int book_id;
	String title;
	String publisher;
	String year;
	int price;
	int id;
	
	String sql;
	ResultSet rs;
%>

<%
		id = Integer.parseInt(request.getParameter("book_id"));
		
		sql = "SELECT * FROM books WHERE book_id =" + id;
		rs = stmt.executeQuery(sql);
		
		while(rs.next())
		{
			book_id = rs.getInt("book_id");
			title = rs.getString("title");
			publisher = rs.getString("publisher");
			year = rs.getString("year");
			price = rs.getInt("price");
%>

<form method="post" action="./book_dao.jsp">
	<br>서적번호(수정불가) : <input type="text" name="book_id" size="30" value="<%=book_id%>">
	<br>서적명 : <input type="text" name="title" size="30" value="<%=title%>">
	<br>출판사 : <input type="text" name="publisher" size="30" value="<%=publisher%>">
	<br>출판년도 : <input type="text" name="year" size="30" value="<%=year%>">
	<br>가격 : <input type="text" name="price" size="30" value="<%=price%>">
	
	<br><input type="hidden" name="actionType" value="U">
	<br><input type="submit" value="수정">

<%
		}
%>
	
<br><a href="./index.jsp">홈으로 돌아가기</a>
</form>
</body>
</html>