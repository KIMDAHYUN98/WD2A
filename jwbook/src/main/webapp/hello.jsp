<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Hello World</h2>
<hr>
현재 날짜와 시간은
<%=LocalDateTime.now()%>
입니다.
<hr>
<h1>나는 몽이 입니다.</h1>
<img src="./img/몽이.jpg" width="200" height="200">
<br>
<a href="./hello2.jsp">두번째 페이지로 이동</a>
</body>
</html>