<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="kdh57_mvc_beer3.model.beer.*"%>
<%@ page import="java.util.*"%>
<%@ include file="/globalData.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이쇼핑몰(KDH57) - 맥주자료조회(R4, R41)</title>

</head>
<body>

<h1>마이쇼핑몰(KDH57) - 맥주자료조회(R4, R41)</h1>
	<hr>
	<%
		BeerDTO beer;
		ArrayList<BeerDTO> beerList;
		BeerPageInfoVO bpiVO;
	
		bpiVO = (BeerPageInfoVO) session.getAttribute("beerPageInfoVO");
		beerList = (ArrayList<BeerDTO>) request.getAttribute("beerList");
		int currentPageNo = bpiVO.getCurrentPageNo();
	%>
	<h2>
		현재 DISPLAY RECORDS NUMBER :
	<%=bpiVO.getLimitCnt()%></h2>
	<hr>
	<br>
<%
	String select_search = request.getParameter("select_search");
	String input_search = request.getParameter("input_search");
	
	System.out.println(input_search + " => jsp의 input 값");
	System.out.println(select_search + " => jsp의 input 값");
%>
<p>
<form method="post" action="./BeerController.be">
<select name="select_search">
	<option value="0">입력</option>
	<option value="b_code">코드</option>
	<option value="b_category">종류</option>
	<option value="b_name">이름</option>
	<option value="b_country">원산지</option>
</select>
<input type="text" name="input_search">
<input type="hidden" name="actionType" value="SEARCH">
<input type="hidden" name="currentPageNo" value="0">
<input type="submit" value="검색">
</form>

	<table border="1">
		<thead>
			<tr>
				<th>순번</th>
				<th>코드</th>
				<th>종류</th>
				<th>이름</th>
				<th>원산지</th>
				<th>가격</th>
				<th>알코올</th>
				<th>설명</th>
				<th>좋아요</th>
				<th>싫어요</th>
				<th>사진</th>
			</tr>
		</thead>
		<tbody>

			<%
			for (int i = 0; i < beerList.size(); i++) {
				beer = beerList.get(i);
			%>

			<tr>
				<td><%=beer.getB_id()%></td>
				<td><%=beer.getB_code()%></td>
				<td><%=beer.getB_category()%></td>
				<td><%=beer.getB_name()%></td>
				<td><%=beer.getB_country()%></td>
				<td><%=beer.getB_price()%></td>
				<td><%=beer.getB_alcohol()%></td>
				<td><%=beer.getB_content()%></td>
				<td><%=beer.getB_like()%></td>
				<td><%=beer.getB_dislike()%></td>
				<td><%=beer.getB_image()%></td>
			</tr>
	<%
	}
	%>
		</tbody>
	</table>

<a href="./BeerController.be?actionType=R5&currentPageNo=0&select_search=<%=select_search%>&input_search=<%=input_search%>">[FIRST]</a>

<%
	if(currentPageNo > 0) {
%>
<a href="./BeerController.be?actionType=R5&currentPageNo=<%=(currentPageNo-1)%>&select_search=<%=select_search%>&input_search=<%=input_search%>">[PRE]</a>

<%
	} else {
%>
	[PRE]
<%
	}

	for(int i = bpiVO.getStartPageNo(); i < bpiVO.getEndPageNo(); i++) {
		if(i == currentPageNo) {
%>
		[<%=(i+1)%>]
<%
		} else {
%>
<a href="./BeerController.be?actionType=R5&currentPageNo=<%=i%>&select_search=<%=select_search%>&input_search=<%=input_search%>">[<%=(i+1)%>]</a>
<%
		}
	}
%>
<%
	if(currentPageNo < bpiVO.getPageCnt() - 1) {
%>
<a href="./BeerController.be?actionType=R5&currentPageNo=<%=(currentPageNo+1)%>&select_search=<%=select_search%>&input_search=<%=input_search%>">[NXT]</a>

<%
	} else {
%>

	[NXT]
<%
	}
%>

<a href="./BeerController.be?actionType=R5&currentPageNo=<%=(bpiVO.getPageCnt()-1)%>&select_search=<%=select_search%>&input_search=<%=input_search%>">[END]</a>

<br><a href="<%=rootDir%>/index.jsp">홈으로 돌아가기</a>

</body>
</html>