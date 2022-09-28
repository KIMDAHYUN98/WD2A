<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 주민번호 UK, NN -->
	<h1>회원 가입</h1>
	<hr>
	<br>
	<form action="./member_dao.jsp" method="post">
		이름 <input type="text">
		아이디 <input type="text" name="mId">
		비밀번호 <input type="password" name="mName">
		이메일 <input type="text" name="mEmail">
		전화번호 <input type="text" name="mPhone">
		주민번호 <input type="text" name="mReg_num">
		<input type="hidden" name="memberType" value="C" >
		<input type="submit" value="가입">
</form>
</body>
</html>