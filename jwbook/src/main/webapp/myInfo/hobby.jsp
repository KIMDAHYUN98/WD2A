<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성격</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>WD2A Introduce MySelf</h1>
</div>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="./myInfo.jsp">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="./personality.jsp">성격</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./hobby.jsp">취미</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./goal.jsp">목표</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./likeThing.jsp">좋아하는 것</a>
      </li>       
    </ul>
  </div>  
</nav>
<div style="margin:30px">
      <h2>What is my hobby?</h2>
	  <p>저의 취미생활을 소개합니다!</p> 
</div>
<div style="text-align:center">
	<div style="display:inline-block">
		<img src="../img/listening.JPG" alt="음악감상" width="304" height="236"> 
		<img src="../img/reading.JPG" alt="독서" width="304" height="236"> 	
	 </div>
	 <div>
		<img src="../img/cajon.JPG" alt="악기연주" width="304" height="236">
		<img src="../img/game.JPG" alt="악기연주" width="304" height="236">
	 </div>
</div>
<div class="col-sm-4" >
	<a type="button" class="btn btn-light" href="./myInfo.jsp">홈으로</a>
</div>
<br>
<div class="jumbotron text-center" style="margin-bottom:0">
  <p>👩‍💻YoungGin University 웹데이터베이스 전공</p>
</div>
</body>
</html>