<!-- 
	일반 회원 정보 수정 화면 
-->
<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	body {
      min-height: 100vh;

      background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);
    }

    .input-form {
      max-width: 900px;

      margin-top: 50px;
      padding: 60px;

      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
    }
    th, td {
		padding-top: 10px;
    	padding-bottom: 20px;
    	padding-left: 30px;
    	padding-right: 40ox;
    }

  </style>
<script type="text/javascript">

// 수정 버튼 누를 시 check() 함수가 실행되어 cofirm 창이 뜬다.
	function check() {
		// 확인 버튼 누를 경우
		if(confirm("정말 수정하시겠습니까?") == true)
			document.actionType.submit();
		// 취소 버튼 누를 경우
		else 
			return false;
	}
</script>
<body>
<%
String driverName = "org.mariadb.jdbc.Driver";
String url = "jdbc:mariadb://localhost/member_db";
String user = "root";
String password = "root";

Class.forName(driverName);
Connection con = DriverManager.getConnection(url,user,password);
Statement stmt = con.createStatement();
request.setCharacterEncoding("utf-8");
%>

<%
	String userId;
	String sql;
	
	Object id = session.getAttribute("userid");
	
	userId = id.toString();
	
	sql = "SELECT * FROM member WHERE mem_id = '" + userId + "'";
	ResultSet rs = stmt.executeQuery(sql);
%>


<%
	String mem_id;
	String mem_name;
	String mem_passwd;
	String mem_email;
	String mem_phone;
	String mem_RRN;
	
	while(rs.next()) {
		mem_id = rs.getString("mem_id");
		mem_name = rs.getString("mem_name");
		mem_passwd = rs.getString("mem_passwd");
		mem_email = rs.getString("mem_email");
		mem_phone = rs.getString("mem_phone");
		mem_RRN = rs.getString("mem_RRN");
%>

<%@ include file="./header.jsp" %>
<div class = "container">

		<div class = "input-form col-md-12 mx-auto">  <!-- 너비 꽉차게, 오른쪽,왼쪽 여백 자동 --> 
			<div class = "row justify-content-center"> <!-- 중앙 정렬 -->			
				<div class = "col-lg-9">				
					<form action="/member_7조/mem_models/member_dao.jsp" method="post" name="actionType">
						<table>
							<tr>
								<div class=" mb-3"> 
									<td>이름</td>
									<td><input type="text" class="form-control" name="mem_name" value="<%=mem_name%>" style="width:210%;"></td>	
								</div>
							</tr>	
							<tr>
								<div class=" mb-3">
								<td>아이디</td>
								<td><input type="text" class="form-control" name="mem_id" value="<%=mem_id%>" readonly="readonly" style="width:210%;"></td>
								</div>
							</tr>
							<tr>
								<div class=" mb-3">
								<td>비밀번호</td>
								<td><input type="password" class="form-control" name="mem_passwd" value="<%=mem_passwd%>" style="width:210%;"></td>
								</div>
							</tr>
							<tr>
								<div class=" mb-3">
								<td>이메일</td>
								<td><input type="text" class="form-control" name="mem_email" value="<%=mem_email%>" style="width:210%;"></td>
								</div>
							</tr>
							<tr>
								<div class=" mb-3">
								<td>핸드폰 번호</td>
								<td><input type="text" class="form-control" name="mem_phone" value="<%=mem_phone%>" style="width:210%;"></td>
								</div>
							</tr>
							<tr>
								<div class=" mb-3">
								<td>주민번호</td>
								<td><input type="text" class="form-control" name="mem_RRN" value="<%=mem_RRN%>" readonly="readonly" style="width:210%;"></td>
								</div>
							</tr>
						</table>
						<br>
						<input type="hidden" name="currentPageNo" value="0">
						<input type="hidden" name="actionType" value="UPDATE">
						<input type="submit" class="btn btn-success w-100" value="수정" onclick="check()">
					</form>
				</div>
			</div>
		</div>

</div>	
<%
	}
%>

</body>
</html>