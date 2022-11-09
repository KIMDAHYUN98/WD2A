<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>db_dbcp_conn_test.jsp</title>
</head>
<body>
	<h1>DBCP 연결 테스트 - With MariaDB</h1>
<hr>
<%
	Connection con = null;

	try {
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc_mariadb");
		con = ds.getConnection();
		
		out.println("<h3>DB연결 성공!!</h3>");
	} catch(Exception e) {
		out.println("<h3>DB연결 실패!!</h3>");
		e.printStackTrace();
	} finally {
		if( con != null)
			con.close();
	}
%>
</body>
</html>