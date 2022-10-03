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
		이름 <input type="text" name="mName" size="30"><br>
		아이디 <input type="text" name="mId" size="30"><br>
		비밀번호 <input type="password" name="mPw" size="30"><br>
		이메일 <input type="text" name="mEmail" size="30"><br>
		전화번호 <input type="text" name="mPhone" size="30"><br>
		주민번호 <input type="text" name="mReg_num" size="30"><br>
		<input type="hidden" name="memberType" value="C" >
		<input type="submit" value="가입">
</form>
</body>
</html>