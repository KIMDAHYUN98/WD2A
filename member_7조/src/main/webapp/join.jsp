<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
<script
  src="http://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
<style>
.rrn_ok{
color:#008000;
display: none;
}

.rrn_already{
color:#6A82FB; 
display: none;
}

.id_ok{
color:#008000;
display: none;
}
.id_already{
color:#6A82FB; 
display: none;
}
</style>
<style>
    body {
      min-height: 100vh;

      background-image: linear-gradient(120deg, #a6c0fe 0%, #f68084 100%);
      
    }

    .input-form {
      max-width: 680px;

      margin-top: 50px;
      padding: 32px;

      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
    }
  </style>


<!-- 위는  아이디 주민번호 중복체크를 위한 css 아래는 비밀번호 숨기기 해제 토글, 현재는 삭제-->

<script>
var idCheck = 0;
var RRNCheck = 0;
$(document).on('click', '#idConfirm', function(){
	if(idCheck==1){
		$('#id').attr('readonly', true);
	}
})
function checkID(){
	console.log($('input[name=id]').val());
	var userId = $('input[name=id]').val();
		$.ajax({
			type : 'get',
			url : '/member_7조/mem_models/data_check.jsp',
			data : {userid : ﻿$("input[name=id]").val(), checkType : $("input[name=checkType]").val() },
			dataType:'json',
			success: function(result) {
				console.log('통신성공');
				console.log(result);
				console.log(result.checkResult);
				if(userId=="" && result.checkResult==1) {
					$('#id_already').css("display","inline-block");
	                $('#id_ok').css("display", "none");
	                idCheck=0;
				} else if(result.checkResult==1) {
					$('#id_already').css("display","inline-block");
	                $('#id_ok').css("display", "none");
					idCheck=0;
				} else if(result.checkResult==0){
					$('#id_ok').css("display","inline-block"); 
					$('#id_already').css("display", "none");
					idCheck=1;
					signupCheck();
				}
			},
			error:function(request,status,error){
				 console.log("code: " + request.status);
			     console.log("message: " + request.responseText);
			     console.log("error: " + error);}

		});
	}
	
function checkRRN(){
	console.log($('input[name=rrn]').val());
	var userRRN = $('input[name=rrn]').val();
		$.ajax({
			type : 'get',
			url : '/member_7조/mem_models/rrn_check.jsp',
			data : {userRRN : ﻿$("input[name=rrn]").val(), checkType2 : $("input[name=checkType2]").val() },
			dataType:'json',
			success: function(result) {
				console.log('통신성공');
				console.log(result);
				console.log(result.checkResult2);
				if(result.checkResult2==1) {
					$('#rrn_invalid').css("display","inline-block");
	                $('#rrn_ok').css("display", "none");
	                RRNCheck=0;
	                checkRule();
				}else if(result.checkResult2==0){
					$('#rrn_ok').css("display","inline-block"); 
					$('#rrn_invalid').css("display", "none");
					RRNCheck=1;
					signupCheck();					
				}
			},
			error:function(request,status,error){
				 console.log("code: " + request.status);
			     console.log("message: " + request.responseText);
			     console.log("error: " + error);}

		});
	}

</script>
<script>
		function checkForm() {
			
			var num = document.joinForm.rrn.value;
			
			if(num.length>6 && num.charAt(6) != '-'){
				$('.rrn_already').css("display","inline-block");
                $('.rrn_ok').css("display", "none");
                checkRule();
			}
			
			var num2 = num.replace(/-/g,"");
			var arrNum1 = new Array(); // 주민번호 앞자리숫자 6개를 담을 배열
	        var arrNum2 = new Array();
			
			
			for(var i=0; i<num2.length; i++){
				arrNum1[i] = num2.charAt(i);
			}
			var tempSum=0;
			var cnt=2;
			for(var j=0; j<num2.length-1; j++){
				if(0<=j&&j<=7){
					tempSum += arrNum1[j]*(j+2);
				}
				else{
					tempSum += arrNum1[j]*cnt;
					cnt++;
				}
			}
			
			if((11-(tempSum%11))%10==arrNum1[12]){
				$('#rrn_ok').css("display","none"); 
                $('#rrn_already').css("display", "none");
                $('#rrn_invalid').css("display", "none");
                if(num2.length>12){
                	checkRRN();
                }
			}
			else{
				$('#rrn_already').css("display","inline-block");
                $('#rrn_ok').css("display", "none");
                $('#rrn_invalid').css("display", "none");
                RRNCheck=0;
                if(num2.length>12){
                	RRNCheck=0;
                	checkRule();
                }
			}
			
			};
		function checkRule(){
			document.getElementById("rrn").value ='';
			
		}
</script>
<script type="text/javascript">
function signupCheck() {
    var name = $("#name").val();
    var pw = $("#password").val();
    var rrn = $("#rrn").val();
    var id = $("#id").val();
    console.log(name,pw,rrn);
    if(name=="" || pw=="" || rrn=="" || id=="" ||idCheck==0 ||RRNCheck==0) {
    	$("#signupbtn").prop("disabled", true);

    } else {
    	$("#signupbtn").prop("disabled", false);
    }
}
</script>
</head>
<body>

<%@ include file="./header.jsp" %>

	<div class = "container">
		<div class = "input-form col-md-12 mx-auto">  <!-- 너비 꽉차게, 오른쪽,왼쪽 여백 자동 --> 
			<div class = "row justify-content-center"> <!-- 중앙 정렬 -->
				<div class = "col-md-8">
					<form method="post" name="joinForm"action="/member_7조/mem_models/member_dao.jsp" class="was-validated">
						<div class="mb-3"> 
							<label for="name">이름</label>
							<input type="text" class="form-control is-valid" id="name" name="name" size="30" oninput="signupCheck()" placeholder="홍길동" required>
							<div class="invalid-feedback">이름을 입력하세요.</div> <!-- 입력이 안되었을경우 경고 표시와 메시지 출력 -->
						</div>
						<div class=" mb-3">
							<label for="id">아이디</label>
							<div class="row g-2">
								<div class="col-md-9">
									<input type="text" class="form-control" id="id" name="id" size="30" placeholder="ID" oninput="checkID()" required>
									<input type="hidden" name="checkType" value="idChk">
								</div>
								<div class="col-md">
									<input class="btn btn-primary" type="button" id="idConfirm" value="사용하기">							
								</div>
								<span class="invalid-feedback" id="id_already">중복된 ID</span> <!-- 아이디가 중복 될 경우 메시지 출력 -->				
								<span class="valid-feedback" id="id_ok">사용가능한 ID</span> <!-- 아이디가 사용 가능할 경우 메시지 출력 -->
							</div>
						</div>
						<div class="mb-3">
							<label>비밀번호</label>
							<input type="password" class="form-control" id="password" name="password" placeholder="PW" size="30" oninput="signupCheck()" required> <i class="fa fa-eye fa-lg"></i>
							<div class="invalid-feedback">비밀번호를 입력하세요.</div>
						</div>
						<div class="mb-3">
							<label>휴대전화</label>
							<input type="text" class="form-control" name="phone" placeholder="000-0000-0000" size="30">
						</div>
						<div class="mb-3">
							<label>이메일</label>
							<input type="text"  class="form-control" name="email" placeholder="email@addrress.com" size="30">
						</div>
						<div class="mb-3">
							<label>주민번호</label>
							<input type="text" class="form-control" id="rrn" name="rrn" placeholder="YYMMDD-0000000" size="30" pattern=".{14,14}" oninvalid="this.setCustomValidity('주민등록번호를 다시 확인하고 입력해주세요')" oninput="checkForm()" required>
							<input type="hidden" name="checkType2" value="rrnCheck">
							<span class="valid-feedback" id="rrn_ok">사용 가능한 주민번호입니다.</span> <!-- 양식에 맞을 경우 메시지 출력 -->
							<span class="invalid-feedback" id="rrn_already">주민번호 양식틀림.</span> <!-- 양식에 틀리거나 입력이 안된 경우 메시지 출력 -->	
							<span class="invalid-feedback" id="rrn_invalid">중복된 주민번호입니다.</span> <!-- 양식에 틀리거나 입력이 안된 경우 메시지 출력 -->						
						</div>
						<input type="hidden" name="actionType" value="JOIN">
						<br><input type="hidden" name="currentPageNo" value="0">			
						<button type="submit" class="btn btn-primary btn-lg w-100" id="signupbtn" value="회원가입" disabled="disabled">회원가입</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>