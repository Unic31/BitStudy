<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="study.dao.PersonDao"%>
<%@page import="study.dto.PersonDto"%>
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
PersonDao dao = new PersonDao();
List<PersonDto> list = dao.getAllPersons();
Date date = new Date();
int Y = date.getYear()+1900;//현재년도
%>
<body>
	<table class="table table-borderde">
		<thead>
			<tr>
				<th>사진</th>
				<th>설명</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (PersonDto dto : list) {
				int age=Y-dto.getYear();//나이
				int m=dto.getYear()%12;
				String ddi=m==0?"원숭이":m==1?"닭":m==2?"개":m==3?"돼지":m==4?"쥐":m==5?"소":m==6?"호랑이":m==7?"토끼":m==8?"용":m==9?"뱀":m==10?"말":"양";
			%>
			<tr>
				<td><img width="50px"
					src="../image/moviestar/<%=dto.getPhoto()%>"></td>
				<td>
					이름:<%=dto.getName()%><br>
					<%=dto.getYear()%>년생(<%=Y %>세, <%=ddi %>띠)<br>
					주소:<%=dto.getJob()%><br>
					직업:<%=dto.getAdd()%>
				</td>
			</tr>


			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>