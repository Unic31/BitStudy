<%@page import="study.dto.CarDto"%>
<%@page import="java.util.List"%>
<%@page import="study.dao.CarDao"%>
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
CarDao dao = new CarDao();
List<CarDto> list = dao.getAllCars();
%>
<body>
	<table class="table table-border">
		<tr>
			<th>번 호</th>
			<th>이 름</th>
			<th>가 격</th>
			<th>사 진</th>
			<th>구 입 일</th>
		</tr>
		<%
		int n = 1;
		for (CarDto dto : list) {
		%>
		<tr>
			<td><%=dto.getNum()%></td>
			<td><%=dto.getCarname()%></td>
			<td><%=dto.getCarprice()%></td>
			<td><img width="100"
				src="../image/mycarimage/car<%=dto.getCarphoto()%>"></td>
			<td><%=dto.getGuipday()%></td>
			<td>
				<button type="button" id="delete" onclick="del(<%=dto.getNum() %>)">삭제</button>
				<button type="button" id="update" onclick="location.href='carupdate.jsp?num=<%=dto.getNum()%>'">수정</button>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	<script type="text/javascript">
	 function del(num){
		 let b=confirm("삭제")
		 if(b){
			 location.href="cardelete.jsp?num="+num
		 }
		 
	 }
	 
	
	</script>
	
</body>





</html>