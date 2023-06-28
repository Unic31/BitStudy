<%@page import="java.io.Console"%>
<%@page import="study.dto.ProjectDto"%>
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

.day {
	color: gray;
	font-size: 15px;
}
.writer{
font-size : 25px;
}
.content{
font-size : 21px;
}
</style>

</head>
<%
int num = Integer.parseInt(request.getParameter("num"));

ProjectDao dao = new ProjectDao();

ProjectDto dto = dao.getData(num);
%>
<body>

	<div style="margin: 30px 50px">
		<table class="table" style="width: 600px">
			<tr>
				<td>
					<h3>
						<div><%=dto.getTitle()%></div>
					</h3>
				</td>
			</tr>
			<tr>
				<td><b class="writer"><%=dto.getWriter()%></b></td>
			</tr>
			<tr>
				<td valgin="top"> 
				<%
 				if (dto.getPhoto() != null) {
 				%>
				<!--  사진을 가져오다가 오류 발생시 사진을 안보이게 해준다 --> <%-- <img
				src="../save/<%=dto.getPhoto()%>" style="max-width: 300px"
				onerror="this.style.display='none'"> --%> <!-- 사진을 가져오다가 오류 발생시 대체이미지 -->
				<img src="../save/<%=dto.getPhoto()%>" style="max-width: 300px"
				onerror="this.src='../image/noimage.png'"> <%}%>
				<br>
				 <div class="content"><%=dto.getContent().replace("\n", "<br>")%></div>
					
					</td>
			</tr>
			<tr>
			<td>
				평점 <%=dto.getStar() %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;가격 <%= dto.getPrice()%>
			</td>
			
			</tr>
			<tr>
			<td>
			<span class="day"> 추천수&nbsp;<%=dto.getCount()%> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<button type="button" onclick="up(<%=dto.getNum()%>)" class="btn btn-sm btn-outline-secondary" 
						style="width: 80px"><i class="bi bi-hand-thumbs-up"></i>&nbsp;
			추천
			</button>
			
			<br>
			</td>
			</tr>
			<tr>
				<td>
					<button type="button" class="btn btn-sm btn-outline-secondary"
						style="width: 80px" onclick="location.href='projectform.jsp'">
						<i class="bi bi-pencil-fill"></i> &nbsp;글쓰기
					</button>

					<button type="button" class="btn btn-sm btn-outline-secondary"
						style="width: 80px"
						onclick="update(<%=dto.getNum()%>)">
						<i class="bi bi-pencil-square"></i> &nbsp;수정
					</button>

					<button type="button" class="btn btn-sm btn-outline-secondary"
						style="width: 80px" onclick="del(<%=dto.getNum()%>)">
						<i class="bi bi-file-earmark-x-fill"></i> &nbsp;삭제
					</button>

					<button type="button" class="btn btn-sm btn-outline-secondary"
						style="width: 80px" onclick="location.href='projectlist.jsp'">
						<i class="bi bi-card-list"></i> &nbsp;목록
					</button>
				</td>
			</tr>
		</table>
	</div>
	<script type="text/javascript">
	<%
	boolean b = false;//쿠키가 존재하면 true로 변경
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
	
	%>
		function up(num){
			if(<%=b%>){
				let u=confirm("추천하시겠습니까?")
				if(u){
				location.href="projectup.jsp?num="+num;
				}	
			}else{
				alert("비회원은 추천할수 없습니다");
			}
		}
		function del(num) {
			if(<%=b%>){
			/* alert(num); */
			let c=confirm("삭제를 하려면 확인을 눌러주세요")
			if(c){
				location.href="projectdelete.jsp?num="+num;
			}
		}else{
			alert("비회원은 삭제할수 없습니다");
		}
		}
		function update(num){
			if(<%=b%>){
			location.href="projectupdate.jsp?num="+num;
			}else{
				alert("비회원은 수정할수 없습니다");
			}
		}
	</script>

</body>
</html>
</html>