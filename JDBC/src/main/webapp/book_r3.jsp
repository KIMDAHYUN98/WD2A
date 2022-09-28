<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>서적관리시스템 - 조회(R3)</h1>
	<hr>
	<h2>전체보기(부분조회 미포함, 페이징 기능 개선, 출력 레코드 갯수 선택, 세션객체 사용안함)</h2>
	<hr>
	<%
	int range = Integer.parseInt(request.getParameter("range"));
	%>
	<h2>현재 DISPLAY RECORDS NUMBER : <%=range%> </h2>
	<hr>

<%
	String driverName = "org.mariadb.jdbc.Driver";
	String url = "jdbc:mariadb://localhost/book_db";
	String user = "root";
	String passwd = "root";
	
	Class.forName(driverName);
	Connection con = DriverManager.getConnection(url, user, passwd);
	Statement stmt = con.createStatement();
	request.setCharacterEncoding("utf-8");
%>
<%
	int book_id;
	String title;
	String publisher;
	String year;
	int price;
	
	String sql;
	ResultSet rs;
%>

<%
	int startRecord = 0;
	int limitCnt = 10;
	int currentPageNo = 0;
	
	
	
	currentPageNo = Integer.parseInt(request.getParameter("currentPageNo"));
	System.out.println(currentPageNo);
	startRecord = currentPageNo * range;
	
	if(range == 0) 
	{
		sql = "SELECT * FROM books ORDER BY book_id limit ";
		sql	+= startRecord + ", " + limitCnt;
	} 
	else
	{
		sql = "SELECT * FROM books ORDER BY book_id limit ";
		sql	+= startRecord + ", " + range;
	}
	
	System.out.println(sql);
	rs = stmt.executeQuery(sql);
	
%>

<%
	String sql2 = "SELECT count(*) FROM books ";
	ResultSet rs2 = stmt.executeQuery(sql2);

	int recordCnt = 0;
	int pageCnt;

	while (rs2.next()) {
		// 레코드 총 갯수
		recordCnt = rs2.getInt(1);
	}k

	// 페이지 번호 갯수
	pageCnt = recordCnt / range;

	if (recordCnt % 10 != 0)
		pageCnt++;
%>

<form action="./book_r3.jsp?range=<%=range%>" method="get">
	<div>
	디스플레이 레코드수 변경 :
	<select name="range">
		<option value="10">10</option>
		<option value="20">20</option>
		<option value="50">50</option>
		<option value="100">100</option>
	</select>
	<input type="hidden" value="<%=currentPageNo%>" name="currentPageNo">
	<input type="submit" value="확인">
	</div>
</form>
<%
	
%>
<br>
<table border="1">
	<thead>
		<tr>
			<th>순번</th>
			<th>제목</th>
			<th>출판사</th>
			<th>출판년도</th>
			<th>가격</th>
		</tr>
		
	</thead>
<%

		while(rs.next()) {
			book_id = rs.getInt("book_id");
			title = rs.getString("title");
			publisher = rs.getString("publisher");
			year = rs.getString("year");
			price = rs.getInt("price"); 
%>

		<tr>
			<td><%=book_id%></td>
			<td><%=title%></td>
			<td><%=publisher%></td>
			<td><%=year%></td>
			<td><%=price%></td>
		</tr>

<%
	}
%>
	</tbody>
	</table>

<a href="./book_r3.jsp?currentPageNo=0&range=<%=range%>">[FIRST]</a>
<%
	// [PRE] 버튼
	if(currentPageNo > 0) {
%>
	<a href="./book_r3.jsp?currentPageNo=<%=(currentPageNo -1)%>&range=<%=range%>">[PRE]</a>
<%
	} else {
%>
	[PRE]
<%
	}
	// [1] [2] [3] ... [9] [10] 페이지 번호 버튼
	for(int i = (currentPageNo / 10) * 10; i < ((currentPageNo / 10) * 10)+ 10; i++){
		if( i == currentPageNo ) {
%>
			[<%=(i+1)%>]
<%
		} else {
%>
			<a href="./book_r3.jsp?currentPageNo=<%=i%>&range=<%=range%>">[<%=(i+1)%>]</a>
<%
		}
		
		if((i+1) == pageCnt)
			break;
	}
%>

<%
	// [NEXT] 버튼
	if( currentPageNo < pageCnt - 1 ) {
%>
	<a href="./book_r3.jsp?currentPageNo=<%=(currentPageNo+1)%>&range=<%=range%>">[NXT]</a>
<%
	} else {
%>
	[NXT]
<%
	}    
%>

<a href="./book_r3.jsp?currentPageNo=<%=(pageCnt-1)%>&range=<%=range%>">[END]</a>

<br><br><a href="./index.jsp">홈으로 돌아가기</a>
</body>
</html>