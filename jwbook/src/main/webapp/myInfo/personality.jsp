<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성격</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Song+Myung&display=swap');

#div1{
  font-family: 'Song Myung', serif;
}
</style>
</head>
<body>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1>WD2A Introduce MySelf</h1>
	</div>
	<div>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<a class="navbar-brand" href="./myInfo.jsp">Home</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="./personality.jsp">성격</a></li>
					<li class="nav-item"><a class="nav-link" href="./hobby.jsp">취미</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="./goal.jsp">목표</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="./likeThing.jsp">좋아하는 것</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<br>
	<div style="margin-left:30px">
	<h2>What is my personality?</h2>
	<p>나의 성격을 소개합니다!
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md">
				<div class="fakeimg"></div>
				<br> <img src="../img/ISFJ.JPG">
			</div>
			<div class="col-md" style="margin-top:50px">
				<div style="float: left">
					<div style="margin-bottom: 80px; font-size: 30px" id="div1">
						<span style="margin-right: 80px">내향적(I)</span> 
						<span>독립적 </span>
					</div>
					<div style="margin-bottom: 80px; font-size: 30px" id="div1">
						<span style="margin-right: 80px">현실적(S)</span> <span>상상력이
							부족함</span>
					</div>
					<div style="margin-bottom: 80px; font-size: 30px" id="div1">
						<span style="margin-right: 80px">감정적(F)</span> <span>공감능력이
							좋음</span>
					</div>
					<div style="margin-bottom: 80px; font-size: 30px" id="div1">
						<span style="margin-right: 80px">계획적(J)</span> <span>계획적인듯
							즉흥적인 나</span>
					</div>
				</div>
				<div style="float: right">
				</div>
			</div>
		</div>
	</div>
	<br>

	<div class="col-sm-4">
		<a type="button" class="btn btn-light" href="./myInfo.jsp">홈으로</a>
	</div>
<br>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>👩‍💻YoungGin University 웹데이터베이스 전공</p>
	</div>
</body>
</html>