<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
.head-container{
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.inner{
	margin: 2rem 4rem;
}
</style>
</head>
<script type="text/javascript">
	// 삭제 버튼 기능
	// 삭제 버튼을 누를 경우 onclick을 통해 check() 함수가 실행
	function checkConfirm(){
		// 수정 버튼 형식과 같음
		if(confirm("정말 탈퇴 하시겠습니까?") == true) {
			 document.actionType.submit();
		} else {
			return false;
		}
	}
</script>

<body>

<%
	if( session.isNew()){
		session.setAttribute("loginState", "logout");
		session.setAttribute("userid", null);
		session.setAttribute("userpw", null);
		session.setAttribute("grade", null);
	}

%>

<div class="head-container">
 	<div class="inner">
 	<%
 		if(session.getAttribute("loginState").equals("logout") || session.getAttribute("loginState").equals("errorID") || session.getAttribute("loginState").equals("errorPW")|| session.getAttribute("loginState").equals("login")){
 	%>
 			<a href="/member_7조/index.jsp"><img src="/member_7조/images/yju_logo_01.png"></a>
 	<%
 		}
 	%>
 	</div>
 	
 	<div class="inner">
<%
		if(session.getAttribute("loginState").equals("login")&&session.getAttribute("grade").equals("manager")){
%>
		<%=session.getAttribute("userid")%> 관리자님 로그인중
		
		
		<form name="logout" method="post" action="/member_7조/mem_models/member_dao.jsp">
		  <input type="hidden" name="actionType" value="LOGOUT">
		  <input type="hidden" name="currentPageNo" value="0">
		  <input type="submit" class="btn btn-primary btn-sm w-100" value="로그아웃">
		</form> 
<%
		}
		else if(session.getAttribute("loginState").equals("login")&&session.getAttribute("grade").equals("user")){
			%>
		<%=session.getAttribute("userid")%>님 로그인중
		<div style="display: flex;">
			<form name="logout" method="post" action="/member_7조/mem_models/member_dao.jsp">
		  <input type="hidden" name="actionType" value="LOGOUT">
		  <input type="hidden" name="currentPageNo" value="0">
		  <input type="submit" class="btn btn-primary btn-sm" value="로그아웃">
		</form>
			<!-- 수정 버튼-->
			 <button type="button" class="btn btn-success btn-sm" onclick="location.href='/member_7조/updateForm.jsp'">수정</button>
			 <form method="post" action="/member_7조/mem_models/member_dao.jsp" name="actionType">
			<!-- 삭제 버튼 -->
			  <input type="hidden" name="actionType" value="QUIT">
			  <input type="hidden" name="currentPageNo" value="0">
			  <input type="hidden" name="userid" value=<%=session.getAttribute("userid")%>>
			  <input type="button" class="btn btn-danger btn-sm" onclick="checkConfirm()" value="탈퇴">
			 </form>
		</div>

		<% 
		}
	else if(session.getAttribute("loginState").equals("join")){
			
		}
//else if state = signup으로 로그인창안뜨는 헤더띄우고 이거는 signup페이지에서 호출함
//이후에 dao에서 회원가입 처리하고나면 state logout으로 초기화필요
//절대경로 ./signup.jsp                 ../mem_models/member_dao.jsp
		else{
%>		 
		 <form class="row g-4" name="login" method="post" action="/member_7조/mem_models/member_dao.jsp">

		 	<div class="col-auto">
		 		<input type="text" class="form-control" name="userid" size="10" placeholder="ID">
		 	</div>

		 	<div class="col-auto">
		 		<input type="password" class="form-control" name="passwd" size="10" placeholder="Password">
		 	</div>
		 	<div class="col-auto">	
		 		<input type="hidden" name="actionType" value="LOGIN">
		    	<input type="hidden" name="currentPageNo" value="0">	    	
		    	<input type="submit" class="btn btn-primary" value="로그인">
		    </div>	
			<div class="col-auto">	    			    	
		    	<input type="button" class="btn btn-secondary" name="join" value="회원가입" onclick="location.href='/member_7조/join.jsp'">
		    </div>		    	    
		 </form>
<%
			if(session.getAttribute("loginState").equals("errorID")){
				out.print("사용자 ID 오류");
			}
			
			if(session.getAttribute("loginState").equals("errorPW")){
				out.print("사용자 PW 오류");
			}
		}
%>		
	</div>
</div>
<%
		if(session.getAttribute("loginState").equals("login")){
%>
			<%@ include file= "/GNB.jsp" %>
<%
		}
%>
<hr> 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>