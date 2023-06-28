<%@page import="study.dto.ProjectDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedHashSet"%>
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
</style>

</head>
<%

String a = request.getParameter("a");
ProjectDao dao = new ProjectDao();
List<ProjectDto>list = dao.getAllDatasA(a);

%>
<body>
<div style="margin: 30px 50px">
		<button type="button" class="btn1 btn btn-secondary btn-sm"
			style="width: 120px" onclick="location.href='projectform.jsp'">
			<i class="bi bi-pencil-fill"></i>&nbsp;글쓰기
		</button>
		<button type="button" class="btn2 btn btn-secondary btn-sm" style="width:120px" onclick="">
		<i class="bi bi-search"></i>&nbsp;검색
		</button>

		<table class="table table-bordered"
			style="width: 700px; margin: 20px 50px;">
			<b></b>
			<caption align="top">
			
				<b><%=list.size() == 0 ? "밥心 에 게시글이 없습니다" : "밥心 에 총 " + list.size() + "개의 글이 있습니다"%></b>
			</caption>
			<tr bgcolor="lightgray">
				<th width="70">번호</th>
				<th width="300">제목</th>
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
						%> <i class="bi bi-cup-hot-fill"></i> <%
 					}
 					%><a href="projectdetail.jsp?num=<%=dto.getNum()%>" class="title"><%=dto.getTitle()%>
						
				</a></td>
				<td align="center"><%=dto.getWriter()%></td>
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
			location.href="projectsearchaction.jsp?a="+a;
		}
	})

	</script>

</body>
</html>