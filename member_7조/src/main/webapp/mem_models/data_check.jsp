<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<% request.setCharacterEncoding("utf-8"); %>
    
<%@ page import="java.sql.*" %>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>


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
    String checkType = request.getParameter("checkType");


	String mem_name;
	String mem_id;
	String mem_passwd;
	String mem_email="";
	String mem_phone="";
	String mem_RRN;
	String check_id="";
	String check_passwd="";

	String sql;
	int result;
	String msg="실행결과:";
	ResultSet rs;
	int loginState;

	switch(checkType){
		case "idChk" :
			JSONObject obj = new JSONObject();
			mem_id = request.getParameter("userid");
			sql = "select * from member where mem_id = '" + mem_id + "'";
			
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				check_id = rs.getString("mem_id");
				}
			
			if(mem_id.equals(check_id)) {
				//out.print('1');
				obj.put("checkResult",1);
				out.print(obj);
				
			} else {
				//out.print('0');
				obj.put("checkResult",0);
				out.print(obj);

			}

			break;

		default:
			break;
	}

%>