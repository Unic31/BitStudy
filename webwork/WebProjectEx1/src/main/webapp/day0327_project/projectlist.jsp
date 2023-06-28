<%@page import="study.dto.ProjectDto"%>
<%@page import="java.util.List"%>
<%@page import="study.dao.ProjectDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap"
	rel="stylesheet">
	
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	
<style type="text/css">
body, body * {
	font-family: 'Jua'
}
table tr th{
text-align: center;
text-decoration: none;
color:black;


}
table{
table-layout:fixed;
position: absolute;
top: 40px;
}
td{
overflow: hidden;
white-space: nowrap;
text-overflow: ellipsis;
}
.title{
text-decoration: none;
color: black;
}
.g{
height : 25px;
width: 30px;
}

/* .btn1{
position: absolute;
left: 100px;
}
.btn2{
position: absolute;
left: 230px;
} */
</style>

</head>
<%
String a = request.getParameter("a");
ProjectDao dao = new ProjectDao();
//
List<ProjectDto> list = null;
if(a==null){
list = dao.getAllDatas();
}else{
list = dao.getAllDatasA(a);
}


%>
<body>
<div style="margin: 30px 50px">
		

		<table class="table table-bordered"
			style="width: 700px; margin: 20px 50px;">
			
			<br><br>
			<caption align="top">
			
				<b><%=list.size() == 0 ? "밥心 에" : "밥心 에 총 " + list.size() + "개의 글이 있습니다"%></b>
				<br>
				<button type="button" class="btn1 btn btn-secondary btn-sm"
			style="width: 120px" onclick="location.href='projectform.jsp'">
			<i class="bi bi-pencil-fill"></i>&nbsp;글쓰기
		</button>
		<button type="button" class="btn2 btn btn-secondary btn-sm" style="width:120px" onclick="">
		<i class="bi bi-search"></i>&nbsp;검색
		</button>
		<%
	boolean b = false;//pass쿠키가 존재하면 true로 변경
	//브라우저에 저장된 모든 쿠키값들을 얻는다
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			String cname = cookies[i].getName();
			String cvalues = cookies[i].getValue();
			if (cname.equals("pass") && cvalues.equals("bit701")) {
		//amho쿠기가 존재하므로b를 true로 바꾼다
		b = true;
			}
		}
	}

	if (b) {
	%>
	<!-- amho쿠기가 있는경우-로그인을 이미 한경우 -->
	<button type="button" class="btn3 btn btn-danger btn-sm" style="width:120px;float: right;" onclick="">
		<i class="bi bi-dash-circle"></i>&nbsp;로그아웃
		</button>

	<%
	} else {
	%>
	<button type="button" class="btn4 btn btn-success btn-sm" style="width:120px;float: right;" onclick="location.href='projectlogin.jsp'">
		<i class="bi bi-plus-circle"></i>&nbsp;로그인
		</button>
	<%
	}
	%>
		
			</caption>
			<tr bgcolor="lightgray">
				<th width="70">번호</th>
				<th width="250">제목</th>
				<th width="100">작성자</th>
				<th width="70">음식</th>
				<th width="140">가격</th>
				<th width="90">평점</th>
				<th width="80">추천수</th>
			</tr>
			<%
			if (list.size() == 0) {
			%>
			<tr height="60">
				<td colspan="7" align="center" valign="middle"><b>게시글이 없습니다</b>
				</td>
			</tr>

			<%
			} else {
			int i = 0;
			for (ProjectDto dto : list) {
			%>
			<tr>
				<td align="center"><%=list.size() - i++%></td>
				
				<td><%
						if (dto.getPhoto() != null) {
						%> <?xml version="1.0" standalone="no"?>
<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 20010904//EN"
 "http://www.w3.org/TR/2001/REC-SVG-20010904/DTD/svg10.dtd">
<svg class="g" version="1.0" xmlns="http://www.w3.org/2000/svg"
 width="512.000000pt" height="512.000000pt" viewBox="0 0 512.000000 512.000000"
 preserveAspectRatio="xMidYMid meet">

<g class="g" transform="translate(0.000000,512.000000) scale(0.100000,-0.100000)"
fill="#000000" stroke="none">
<path d="M2470 4904 c-130 -22 -175 -38 -218 -78 -60 -54 -70 -144 -28 -248
16 -40 20 -60 13 -63 -7 -1 -61 -13 -122 -25 -544 -107 -1062 -461 -1369 -935
-189 -292 -312 -639 -341 -967 l-7 -78 -89 0 c-135 0 -183 -14 -239 -69 -57
-55 -70 -93 -70 -207 0 -107 32 -174 105 -219 l48 -30 434 -5 434 -5 -51 -39
c-29 -22 -132 -137 -231 -257 -99 -120 -183 -220 -187 -223 -4 -2 -29 2 -56
11 -40 13 -56 14 -102 4 -30 -7 -68 -24 -84 -37 -34 -29 -175 -230 -201 -289
-43 -93 -8 -195 89 -262 250 -175 953 -647 980 -659 72 -30 170 -7 226 52 14
16 62 83 106 149 87 132 101 176 80 253 -6 24 -28 61 -48 84 l-37 41 40 34
c59 52 115 82 197 106 105 32 375 31 613 -2 272 -37 420 -24 744 65 295 82
437 142 588 251 127 91 578 498 599 540 13 27 19 60 18 111 l0 72 322 0 322 0
53 28 c81 42 113 100 117 212 5 119 -9 164 -68 221 -57 55 -104 69 -239 69
l-89 0 -7 78 c-10 110 -41 270 -76 392 -38 130 -105 299 -130 324 -23 24 -73
25 -99 1 -30 -27 -25 -71 19 -176 67 -163 120 -374 137 -546 l7 -73 -1733 -2
-1732 -3 -19 -24 c-26 -32 -24 -73 4 -99 l23 -22 1908 -2 1908 -3 19 -24 c14
-18 19 -39 19 -90 0 -58 -3 -71 -23 -89 l-23 -22 -2365 0 -2366 0 -21 23 c-30
32 -32 143 -3 178 l19 24 321 3 320 3 21 26 c23 30 24 42 9 77 -17 36 -57 46
-192 46 l-119 0 6 68 c46 460 250 887 586 1222 663 663 1689 778 2491 280 194
-120 397 -306 538 -493 47 -61 83 -100 98 -103 52 -14 102 37 89 89 -17 71
-265 346 -431 480 -269 217 -596 373 -920 437 -60 12 -115 24 -122 25 -7 3 -3
23 13 63 64 159 13 265 -151 308 -51 14 -231 26 -275 18z m255 -167 c34 -12
40 -19 43 -45 4 -35 -19 -84 -56 -124 -25 -28 -27 -28 -152 -28 -125 0 -127 0
-152 28 -35 37 -58 85 -58 122 0 33 16 43 95 60 56 13 232 4 280 -13z m-877
-2848 c161 -43 309 -79 327 -79 19 0 175 29 347 65 171 36 324 65 340 65 73 0
122 -65 99 -132 -14 -39 -22 -45 -169 -124 -67 -36 -127 -74 -132 -84 -17 -31
-11 -60 16 -87 l25 -25 192 5 192 5 231 69 232 69 253 166 c140 92 266 170
281 173 36 9 78 -31 78 -74 0 -39 -3 -42 -271 -278 -254 -224 -319 -274 -444
-338 -118 -60 -394 -146 -630 -196 -94 -20 -359 -17 -495 6 -170 28 -494 27
-602 -3 -121 -33 -204 -80 -303 -173 l-40 -37 -352 240 -352 239 166 202 c91
111 179 215 197 230 131 119 317 193 456 181 36 -3 197 -41 358 -85z m392 81
c-33 -11 -90 -11 -115 0 -13 6 7 8 60 8 55 0 72 -3 55 -8z m1549 5 c-3 -2 -73
-49 -155 -103 l-151 -99 -211 -62 c-117 -33 -216 -61 -222 -61 -6 0 3 18 19
41 42 57 58 134 42 204 -7 30 -17 57 -22 60 -33 21 20 25 348 25 196 0 354 -2
352 -5z m-3212 -731 c770 -522 863 -587 869 -611 5 -19 -8 -46 -61 -126 -82
-125 -102 -147 -130 -147 -20 0 -938 613 -992 663 -13 11 -23 30 -23 41 0 22
129 219 162 249 11 9 26 17 34 17 8 0 71 -39 141 -86z"/>
</g>
</svg> <%
 					}
 					%><a href="projectdetail.jsp?num=<%=dto.getNum()%>" class="title"><%=dto.getTitle()%>
						
				</a></td>
				<td align="center"><%=dto.getWriter()%><i class="bi bi-cup-hot-fill"></i></td>
				<td align="center">
				<%=dto.getFood() %>
				
				</td>
				<td align="center"><%=dto.getPrice() %></td>
				<td align="center"><%=dto.getStar() %></td>
				<td align="center"><%=dto.getCount() %></td>



			</tr>
			<%
			}
			%>

			<%
			}
			%>

		</table>
	</div>
	<script type="text/javascript">
	$(".btn2").click(function(){
		let a = prompt("검색할 키워드를 입력하세요");
		if(a!=null){
			location.href="projectlist.jsp?a="+a;
		}
	})
	$(".btn3").click(function(){
		let b = confirm("로그아웃 하시겠습니까?");
		if(b==true){
			location.href="projectlogoutaction.jsp";
		}
	})

	</script>

</body>
</html>