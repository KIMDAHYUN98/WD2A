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
    String checkType2 = request.getParameter("checkType2");


	String mem_name;
	String mem_id;
	String mem_passwd;
	String mem_email="";
	String mem_phone="";
	String mem_RRN;
	String check_rrn="";
	String check_passwd="";

	String sql;
	int result;
	String msg="실행결과:";
	ResultSet rs;

	switch(checkType2){
		case "rrnCheck" :
			//JSONArray arr = new JSONArray();
			JSONObject obj = new JSONObject();
			mem_RRN = request.getParameter("userRRN");
			sql = "select * from member where mem_RRN = '" + mem_RRN + "'";
			
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				check_rrn = rs.getString("mem_RRN");
				}
			
			if(mem_RRN.equals(check_rrn)) {
				//out.print('1');
				obj.put("checkResult2",1);
				out.print(obj);
				
			} else {
				//out.print('0');
				obj.put("checkResult2",0);
				out.print(obj);


			}

			break;

		default:
			break;
	}

%>