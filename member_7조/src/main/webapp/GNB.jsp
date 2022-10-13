<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
	.nav-item{
		margin : 0 1rem;
		  width: 25%;
		  background-color: #fff;
		  display: flex;
		  align-items: center;
		  border-radius: 9px;
		  padding: 0.5rem 1rem;
		  margin: 0 1rem;
		  /* box-shadow: 블럭에 그림자를 적용하는 CSS 기능
		     https://developer.mozilla.org/ko/docs/Web/CSS/box-shadow 
		     offset-x | offset-y | blur-radius | spread-radius | color */
		  box-shadow: 10px 10px 10px -5px rgba(25, 42, 70, 0.2);
		  transition: 0.4s;
	}
	.nav-item:hover {
  		transform: translate(0, -5px);
  		color : bule;
	}
</style>
</head>
<body>
<hr>
<%
if(session.getAttribute("loginState").equals("login")&&session.getAttribute("grade").equals("user")){
%>
<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
  			<div style="padding-left : 5rem">
				<a href="/member_7조/index.jsp"><img src="/member_7조/images/yju_logo_01.png"/></a>
			</div>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
    	</button>
		<div class="collapse navbar-collapse justify-content-end" id="navbarNav" style="padding-right : 5rem">
			<ul class="navbar-nav">
			
              <!-- <div class="skill-name">업무 자동화</div> -->
		        <li class="nav-item">
		          <a class="nav-link" href="/member_7조/mem_views/member01.jsp">GNB01</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="/member_7조/mem_views/member02.jsp">GNB02</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="/member_7조/mem_views/member03.jsp">GNB03</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="/member_7조/mem_views/member04.jsp">GNB04</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="/member_7조/mem_views/member05.jsp">GNB05</a>
		        </li>
      		</ul>
    	</div>
	</div>
</nav>
<%
	}
else if(session.getAttribute("loginState").equals("login")&&session.getAttribute("grade").equals("manager")){
%>
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
  	<div style="padding-left : 5rem">
  	<a href="/member_7조/index.jsp"><img src="/member_7조/images/yju_logo_01.png"/></a>
  </div>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNav" style="padding-right : 5rem">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="/member_7조/mem_views/member01.jsp">GNB01</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/member_7조/mem_views/member02.jsp">GNB02</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/member_7조/mem_views/member03.jsp">GNB03</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/member_7조/mem_views/member04.jsp">GNB04</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/member_7조/mem_views/member05.jsp">GNB05</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/member_7조/manager_page.jsp?currentPageNo=0">관리자</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<%
}%>
</body>
</html>