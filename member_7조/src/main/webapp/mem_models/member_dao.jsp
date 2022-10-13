<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
    String actionType = request.getParameter("actionType");


	
	int mem_num;
	String mem_name;
	String mem_id;
	String mem_passwd;
	String mem_email="";
	String mem_phone="";
	String mem_RRN;
	String mem_class="";
	String check_id="";
	String check_passwd="";
	int currentPageNo =Integer.parseInt(request.getParameter("currentPageNo"));


	String sql;
	int result;
	String msg="실행결과:";
	ResultSet rs;
	int loginState;


	switch(actionType){
		case "LOGIN":
			
			mem_id = request.getParameter("userid");
			mem_passwd = request.getParameter("passwd");
			
			sql = "SELECT mem_id,mem_passwd,mem_class from member where mem_id ='" + mem_id+"';";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				check_id = rs.getString("mem_id");
				check_passwd = rs.getString("mem_passwd");
				mem_class = rs.getString("mem_class");
			}
			if(mem_class.equals("관리자")){
				if(mem_id.equals(check_id)){
			    	if(mem_passwd.equals(check_passwd)){
			    		session.setAttribute("loginState", "login");
			    		session.setAttribute("grade", "manager");
			    		session.setAttribute("userid", mem_id);
			    		session.setAttribute("userpw", mem_passwd);
			    	}else{
			    		session.setAttribute("loginState", "errorPW");
			    	}
			}else{
		    	session.setAttribute("loginState", "errorID");
		    }
				}
			else if(mem_class.equals("회원")){
		    	if( mem_id.equals(check_id)){
			    	if( mem_passwd.equals(check_passwd)){
			    		session.setAttribute("loginState", "login");
			    		session.setAttribute("grade", "user");
			    		session.setAttribute("userid", mem_id);
			    		session.setAttribute("userpw", mem_passwd);
			    	}else{
			    		session.setAttribute("loginState", "errorPW");
			    	}
			    }else{
			    	session.setAttribute("loginState", "errorID");
			    }	
		    }
			else{
				session.setAttribute("loginState", "errorID");
				session.setAttribute("grade", null);
			}
			break;
			
		    
		case "LOGOUT":
			session.setAttribute("userid", null);
			session.setAttribute("userpw", null);
			session.setAttribute("loginState", "logout");
			break;
			
		case "UPDATE" :
			
			mem_id = request.getParameter("mem_id");
			mem_name = request.getParameter("mem_name");
			mem_passwd = request.getParameter("mem_passwd");
			mem_email = request.getParameter("mem_email");
			mem_phone = request.getParameter("mem_phone");
			
			sql = "UPDATE member SET mem_name='" + mem_name + "'";
			sql += ", mem_passwd='" + mem_passwd + "'";
			sql += ", mem_email='" + mem_email + "'";
			sql += ", mem_phone='" + mem_phone + "'";
			sql += " WHERE mem_id='" + mem_id + "'";
			
			System.out.println(sql);
			result = stmt.executeUpdate(sql);
			
			break;
			
		case "QUIT" :
			mem_id = request.getParameter("userid");
			
			sql = "DELETE FROM member WHERE mem_id = '" + mem_id + "'";
			
			System.out.println(sql);
			result = stmt.executeUpdate(sql);
			
			session.setAttribute("userid", null);
			session.setAttribute("userpw", null);
			session.setAttribute("loginState", "logout");
			
			break;
			
		case "JOIN":
			
			mem_name = request.getParameter("name");
			mem_id = request.getParameter("id");
			mem_passwd = request.getParameter("password");
			mem_phone = request.getParameter("phone");
			mem_email = request.getParameter("email");
			mem_RRN = request.getParameter("rrn");
			
			sql = "INSERT INTO member (mem_name,mem_id,mem_passwd,mem_email,mem_phone,mem_RRN) VALUES";
			sql += "('" + mem_name + "','" + mem_id + "','" + mem_passwd + "','" + mem_email + "','" + mem_phone + "','" + mem_RRN +"');";
		    
			result = stmt.executeUpdate(sql);
			session.setAttribute("userid", null);
			session.setAttribute("userpw", null);
			session.setAttribute("loginState", "logout");
			break;
		case "DELETE":
			mem_num = Integer.parseInt(request.getParameter("mem_num"));
			String del = request.getParameter("del");
			
			
			sql="delete from member where mem_num = "+ mem_num;
			
			System.out.println(sql);
			System.out.println(del);
			
			result=stmt.executeUpdate(sql);
			break;
		
		case "memUPDATE":
			String updateMem = request.getParameter("updateMem");
			mem_id = request.getParameter("mem_class");
			
			sql="update member set mem_class ="+"\""+updateMem+"\"";
			sql+=" where mem_id = "+"\""+mem_id+"\"";
			System.out.println(sql);
			result = stmt.executeUpdate(sql);
			
			
			if(result==1) {
%>
				<script>
					alert('권한 수정완료!');
					history.back();
				</script>
<%
				return;
			} else {
%>
				<script>
					alert('권한 수정 실패!');
					location.href="../manager.jsp?currentPageNo=<%=currentPageNo%>";
				</script>
<%				
				return;
			}
		default:
			break;
	}
%>
<!-- 이하 딜리트문은 삭제요청후에는 관리자 회원 조회페이지로 가게하는것
없으면 index로 이동해버림
 -->
<%if(actionType.equals("DELETE")) {
%>
<script>
location.href="../manager_page.jsp?currentPageNo=<%=currentPageNo%>";
</script>
<%
} else {
	%>
<jsp:forward page="../index.jsp"/>
<%} %>

</body>
</html>