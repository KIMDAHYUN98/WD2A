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
<h2>회원정보 조회</h2>

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
	int mNum;
	String mName;
	String mId;
	String mPw;
	String mEmail;
	String mPhone;
	String mReg_num;
	
	String sql = "SELECT * FROM members ORDER BY mNum";
	ResultSet rs = stmt.executeQuery(sql);
%>

<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>이메일</th>
			<th>핸드폰번호</th>
			<th>주민번호</th>
		</tr>
		
	</thead>

<%
	while(rs.next()) {
		mNum = rs.getInt("mNum");
		mName = rs.getString("mName");
		mId = rs.getString("mId");
		mEmail = rs.getString("mEmail");
		mPhone = rs.getString("mPhone");
		mReg_num = rs.getString("mReg_num");

%>

	<tr>
		<td><%=mNum%></td>
		<td><%=mName%></td>
		<td><%=mId%></td>
		<td><%=mEmail%></td>
		<td><%=mPhone%></td>
		<td><%=mReg_num%></td>
	</tr>
<%
	}
%>
	</tbody>
	</table>
</body>
</html>