<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>자기소개서 첫번째 과제</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <style>
  .fakeimg {
    height: 200px;
    border : 4px inset;
  }
  .btn btn-primary {font-size:10px; margin:100px 100px}
  </style>
</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>WD2A Introduce MySelf</h1>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="#">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  
</nav>

<div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-4">
      <h2>About Me</h2>
      <h5>Photo of me:</h5>
      <div>
      <img src="../img/나.jpg" height="400" width="350">
      </div>
      <br>
      <h3>Some Links</h3>
      <p>더 알아보고 싶다면? 여기로 클릭!</p>
      <ul class="nav nav-pills flex-column">
        <li class="nav-item">
          <a class="nav-link active" href="./personality.jsp">성격</a>
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
        <li class="nav-item">
          <a class="nav-link disabled" href="#">Disabled</a>
        </li>
      </ul>
    
      <hr class="d-sm-none">
    </div>
    <div class="col-sm-8">
      <h2>🤔 Who am I?</h2>
      <h6>나에 대해 소개합니다!</h6>
      <div class="container">
 <table class="table table-hover">
    <tbody>
	    <tr>
	    <td><b>이름</b></td>
	    <td>김다현</td>
	    </tr>
      <tr>
        <td><b>거주지</b></td>
        <td>대구광역시 서구</td>
      </tr>
      <tr>
        <td><b>나이</b></td>
        <td>25세</td>
      </tr>
      <tr>
        <td><b>생년월일</b></td>
        <td>1998년 6월 29일</td>
      </tr>
      <tr>
        <td><b>전화번호</b></td>
        <td>010-3390-9817</td>
      </tr>
      <tr>
        <td><b>깃허브 주소</b></td>
        <td><a href="https://github.com/KIMDAHYUN98">김다현의 깃허브 바로가기!</a></td>
      </tr>
    </tbody>
  </table>
</div>

<hr>

 <h2>👨‍👩‍👧‍👦 My Family</h2>
 <h6>우리 가족을 소개합니다!</h6>
  <div class="container">
  <div id="accordion">
  <div class="card" style="width:400px">
  <div  style="margin:30px">
	  <h4 class="card-title"><b>마미 ♥ 대디</b></h4>
	  <p class="card-text">아버지 : 57세, 직장인</p>
	  <p class="card-text">어머니 : 53세, 전업주부</p>
  </div>
      <a class="btn btn-primary" data-toggle="collapse" href="#collapseOne">Show Photo</a>
      <div id="collapseOne" class="collapse show" data-parent="#accordion">
    	<div class="card-body">
    	  <img class="card-img-top" src="../img/엄마아빠.jpg" alt="Card image" style="width:100%">
      </div>
    </div>
  </div>
  <br>
  <div class="card" style="width:400px">
  <div  style="margin:30px">
	  <h4 class="card-title"><b>브라더</b></h4>
	  <p class="card-text">27세, 보안관련 직무</p>
  </div>
      <a class="btn btn-primary" data-toggle="collapse" href="#collapseTwo">Show Photo</a>
      <div id="collapseTwo" class="collapse" data-parent="#accordion">
    	<div class="card-body">
    	  <img class="card-img-top" src="../img/오빠.jpg" alt="Card image" style="width:100%">
      </div>
    </div>
  </div>
  <br>
  <div class="card" style="width:400px">
  <div  style="margin:30px">
	  <h4 class="card-title"><b>몽이</b></h4>
	  <p class="card-text">4세, 우리집 담당 마스코트</p>
  </div>
      <a class="btn btn-primary" data-toggle="collapse" href="#collapseThree">Show Photo</a>
      <div id="collapseThree" class="collapse" data-parent="#accordion">
    	<div class="card-body">
    	  <img class="card-img-top" src="../img/몽이.jpg" alt="Card image" style="width:100%">
      </div>
    </div>
  </div>
</div>
</div>
  </div>
</div>
</div>
<br>
<div class="jumbotron text-center" style="margin-bottom:0">
  <p>👩‍💻YoungGin University 웹데이터베이스 전공</p>
</div>

</body>
</html>
