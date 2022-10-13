<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="./header.jsp" %>
<%
	if(session.getAttribute("loginState").equals("login")&&session.getAttribute("grade").equals("회원")){
%>
		 <jsp:include page="./login_page.jsp"/>
<%
	}else if(session.getAttribute("loginState").equals("login")&&session.getAttribute("grade").equals("관리자")){
		%>
		<jsp:include page="./manager_page.jsp"/>
		<%
	}
	else{
%>
		 <jsp:include page="./logout_page.jsp"/>
<%
	}
%>		 
<%@ include file="./footer.jsp" %>
</body>
</html>