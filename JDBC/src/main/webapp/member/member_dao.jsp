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
<h1>회원관리 시스템 - 데이터베이스 처리 부분</h1>
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
	String memberType = request.getParameter("memberType");

	int mNum;
	String mName;
	String mId;
	String mPw;
	String mEmail;
	String mPhone;
	String mReg_num;
	
	String sql;
	int result;
	String msg = "실행결과 : ";

	switch(memberType) {
		case "C" :
			mName = request.getParameter("mName");
			mId = request.getParameter("mId");
			mPw = request.getParameter("mPw");
			mEmail = request.getParameter("mEmail");
			mPhone = request.getParameter("mPhone");
			mReg_num = request.getParameter("mReg_num");
			
		sql = "INSERT INTO members (mName, mId, mPw, mEmail, mPhone, mReg_num) VALUES ";
		sql += "('"+ mName + "', '" + mId + "', '" + mPw + "', '" + mEmail; 
		sql +=	"', '" + mPhone + "', '" + mReg_num + "')";
			
		System.out.println(sql);
		result = stmt.executeUpdate(sql);
		
		if(result == 1) {
			System.out.println("레코드 추가 성공");
			msg += "레코드 추가 성공";
		}
		else {
			System.out.println("레코드 추가 실패");
			msg += "레코드 추가 실패";
		
			break;
		}
	}
%>

<h2><%=msg%></h2>

	<br><a href="../index.jsp">홈으로 돌아가기</a>
</body>
</html>