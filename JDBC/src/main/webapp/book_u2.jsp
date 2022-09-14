<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="post" action="./book_dao.jsp">
	<br>서적번호(수정불가) : <input type="text" name="book_id" size="30">
	<br>서적명 : <input type="text" name="title" size="30">
	<br>출판사 : <input type="text" name="publisher" size="30">
	<br>출판년도 : <input type="text" name="year" size="30">
	<br>가격 : <input type="text" name="price" size="30">
	
	<br><input type="hidden" name="Update" value="C">
	<br><input type="submit" value="수정">
	
<br><a href="./index.jsp">홈으로 돌아가기</a>
</form>
</body>
</html>