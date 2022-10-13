<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
	//페이징을 처리하기 위해 전체페이지를 가져오기 위한 쿼리문 = sql3, rs3
	String sql3 = "select count(*) from member";
	ResultSet rs3 = stmt.executeQuery(sql3);
	int recordCnt=0;	//전체 레코드의 개수
	int pageCnt;		//페이지를 표시할 변수
	int limitCnt=10;	//한페이지 안에 보여줄 레코드의 수
	
	while(rs3.next()) {
		recordCnt=rs3.getInt(1);
	}
	
	pageCnt = recordCnt/limitCnt;
	if(recordCnt%limitCnt!=0) {
		pageCnt++;
	}

%>
<%
	int mem_num;		//회원번호
	String mem_id;		//회원ID
	String mem_passwd;		//회원PW
	String mem_name;	//회원이름
	String mem_email;	//회원이메일
	String mem_phone;		//회원전화번호
	String mem_RRN;		//회원주민번호
	String mem_date;	//회원가입날짜
	String mem_class;	//회원권한
	
	String search = request.getParameter("search");
	int result;
	
	int currentPageNo;		//현재페이지를 담을 변수
	int startRecord = 0; 	//limit을 사용하는 쿼리에 몇번레코드부터 보여줄건지 담을 변수
	currentPageNo = Integer.parseInt(request.getParameter("currentPageNo"));
	startRecord = currentPageNo * limitCnt;
	
	//페이징을 처리할 쿼리문 = sql, rs
	String sql = "select * from member order by mem_num limit ";
	sql+=startRecord+","+limitCnt;
	
	//검색한 부분만 조회하는 쿼리문 = sql2, rs2
	String sql2 = "select * from member where mem_name like \"%"+search+"%\" order by mem_num limit ";
	

	ResultSet rs = stmt.executeQuery(sql);
	
	int start = (currentPageNo/10) * 10;
	int end = start+10;
	if(end > pageCnt) {
		end = pageCnt;
	}
	
	//만약 search로부터 받아온 값이 있다면(null이 아닐경우) 그 값을 검색, null이 온다면 검색안한것
	//근데 검색했을때의 페이징 처리는 되지만 first와 end를 눌렀을때는 검색조건이 없을때로 돌아감 -> 이부분은 건들게 너무 많음....
	if(search != null) {
		//sql4에 들어가는 쿼리문은 검색했을때의 페이징 처리 코드 = sql4, rs4
		String sql4 = "select count(*) from member where mem_name like \"%"+search+"%\"";
		ResultSet rs4 = stmt.executeQuery(sql4);
		recordCnt=0;	//전체 레코드의 개수
		limitCnt=10;	//한페이지 안에 보여줄 레코드의 수
		
		//이 밑의 코드는 검색을 했을때
		//나오는 페이지의 수가 전체를 조회했을때 보다는 적으니 그에 맞게 조건을 줘서
		//검색했을때 총 페이지 수를 결정하는 조건문
		while(rs4.next()) {
			recordCnt=rs4.getInt(1);
		}
		
		pageCnt = recordCnt/limitCnt;
		
		if(recordCnt%limitCnt!=0) {
			pageCnt++;
		}
		sql2+=startRecord+","+limitCnt;
		
		System.out.println(sql2);
		
		rs=stmt.executeQuery(sql2);
		if(end > pageCnt) {
			end = pageCnt;
		}
	}
	else {
%>

<script>
	function searchCheck() {
		if(<%=search%> == null)){
			alert('검색어를 입력해주세요');
		}	
	}
</script>
<% 
	}
	
%>
<%@include file="./header.jsp" %>

		<!--이 부분은 검색을 위한 폼 여기서 이미지로 된 돋보기 아이콘을 누르면 폼의 데이터가 manager_page.jsp페이지로 전송이 되면서 위의 sql4가 실행이 됨  -->
<form method="post" action="/member_7조/manager_page.jsp">
	<div class="row row-cols-auto"> <!-- 열 자동 맞춤 -->
		<label for="search" class="col col-form-label">검색</label>
		<div class="col-lg-2">
			<input type="text" class="form-control" id="search" placeholder="이름을 입력하세요" name="search">
			<input type="hidden" name="currentPageNo"value="<%=currentPageNo%>">
		</div>
		<input type="image" src="/member_7조/images/검색.png" width="30px" height="30px" value="검색" onClick="return searchCheck()">
	</div>
			
</form>
<br>
    <div>
        <table class="table table-info table-striped" border="1"> <!-- info 계열의 색상을 테이블 행마다 줄무늬를 추가-->
            <thead class="table-dark"> <!-- 테이블 상단 색깔 검정 -->
                <tr>
                    <th>회원 번호</th>
                    <th>회원 이름</th>
                    <th>회원 아이디</th>
                    <th>회원 비밀번호</th>
                    <th>회원 이메일</th>
                    <th>회원 전화번호</th>
                    <th>회원 주민번호</th>
                    <th>회원 가입날짜</th>
                    <th>회원 권한</th>
                    <th>회원 삭제</th>
                </tr>
            </thead>
            <tbody>
<%
			while(rs.next()) {
				mem_num=rs.getInt("mem_num");
				mem_name=rs.getString("mem_name");
				mem_id=rs.getString("mem_id");
				mem_passwd=rs.getString("mem_passwd");
				mem_email=rs.getString("mem_email");
				mem_phone=rs.getString("mem_phone");
				mem_RRN=rs.getString("mem_RRN");
				mem_date = rs.getString("mem_date");
				mem_date = mem_date.substring(0, mem_date.length()-2); //timestamp는 초까지 다 보여줘서 그부분은 substring을 통해 제거해서 일, 시, 분까지만 보이게 하기
				mem_class=rs.getString("mem_class");
%>
				<tr>
                    <td><%=mem_num%></td>
                    <td><%=mem_name%></td>
                    <td><%=mem_id %></td>
                    <td><%=mem_passwd%></td>
                    <td><%=mem_email%></td>
                    <td><%=mem_phone%></td>
                    <td><%=mem_RRN%></td>
                    <td><%=mem_date%></td>
                    <td>
                   	<!-- 회원 권한 수정하는 코드 -->
                   	<!-- select박스에다 name을 주어 dao에서 입력된 값을 확인 하도록 해줌 -->
                   	<!-- 그후 밑에는 회원삭제와 마찬가지로 confirm을 주고, 밑에 actionType으로는 dao에서 update처리 할수 있게 해주고 -->
                   	<!-- 그 밑에 currentPageNo와 mem_class는 페이지 이동할때 필요한 데이터를 주기위해 hidden을 사용 -->
                   	<div class="dropdown">
                    <form method="post" action="./mem_models/member_dao.jsp"> <!-- 선택 버튼 -->
                    	<select class="form-select form-select-sm" name="updateMem">
                    		<option disabled value=""><%=mem_class %></option>
                    		<option value="회원">회원</option>
                    		<option value="관리자">관리자</option>
                    	</select>
                    	<input type="submit" class="btn btn-success btn-sm w-100" value="수정" onclick="return confirm('정말 수정하시겠습니까?')">
                    	<input type="hidden" name="actionType" value="memUPDATE">
                    	<input type="hidden" name="currentPageNo" value=<%=currentPageNo%>>
                    	<input type="hidden" name="mem_class" value=<%=mem_id%>>
                    </form>
                    </div>
                    </td>
                    <td>
                    	<!-- 정말 삭제하시겠습니까 라는 confirm이 뜨고 네를 누르면 dao로 앞의 데이터가 넘어가고 취소를 누르면 안넘어감 -->
                    	<a href="./mem_models/member_dao.jsp?mem_num=<%=mem_num%>&actionType=DELETE&currentPageNo=<%=currentPageNo%>" onclick="return confirm('정말 삭제하시겠습니까?')">
                    	<button type="button" class="btn btn-danger">회원삭제</button>
                    	</a>
                    </td>
                </tr>
<%
			}
%>
            </tbody>
        </table>
       </div>
<br>

<ul class="pagination justify-content-center"> <!-- 페이지 번호 중앙정렬 -->
	<li class="page-item"> <!-- 페이지 활성화 -->
		<a class="page-link" href="./manager_page.jsp?currentPageNo=0">«</a>
	</li>
<%
	if(currentPageNo >= 1) {
%>
	<li class="page-item">
	<a class="page-link" href="./manager_page.jsp?currentPageNo=<%=currentPageNo-1%>">‹</a>	
	</li>	
<%
	} else {
%>
	<li class="page-item disabled"> <!-- 페이지 비활성화 -->
	<a class="page-link" href="#" aria-disabled="true">‹</a>
	</li>
<%		
	}
%>
<%
	System.out.println(pageCnt);
	for(int i=start; i<end; i++) {
		if(i==currentPageNo) {
%>
		<li class="page-item active" aria-current="page"> <!-- 현재 페이지 번호 활성화 -->
			<a class="page-link" href="./manager_page.jsp?currentPageNo=<%=i%>"><%=(i+1)%></a>
		</li>
<%			
		} else {
%>
			<li class="page-item">
				<a class="page-link" href="./manager_page.jsp?currentPageNo=<%=i%>"><%=(i+1)%></a>
			</li>
<%			
		}
	}
%>
<%
	if(currentPageNo < pageCnt -1) {
%>
	<li class="page-item">
		<a class="page-link" href="./manager_page.jsp?currentPageNo=<%=(currentPageNo+=1)%>&start=<%=start+=1%>">›</a>
	</li>
<%
	} else {
		
%>
	<li class="page-item disabled">
		<a class="page-link" href="#" aria-disabled="true">›</a>
	</li>
<%		
	}
%>
	<li class="page-item">
		<a class="page-link" href="./manager_page.jsp?currentPageNo=<%=(pageCnt-1) %>">»</a>
	</li>
</ul>

<br>
<%@ include file="./footer.jsp" %>
</body>
</html>