<%@page import="study.dto.MyCarDto"%>
<%@page import="java.util.List"%>
<%@page import="study.dao.MyCarDao"%>
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
MyCarDao dao = new MyCarDao();
List<MyCarDto> list = dao.getAllCars();
%>
<body>
	<button type="button" id="move">차량 추가 페이지로 이동</button>
	<hr>
	<h2 class="alert alert-danger">차량리스트</h2>
	<table class="table table-border">
		<tr>
			<th>차량번호</th>
			<th>이 름</th>
			<th>차량가격</th>
			<th>사 진</th>
			<th>구 입 일</th>
		</tr>

		<%
		int n = 1;
		for (MyCarDto dto : list) {
		%><tr>
			<td><%=n++%></td>
			<td><%=dto.getCarname()%></td>
			<td><%=dto.getCarprice()%></td>
			<td><img width="100"
				src="../image/mycarimage/car<%=dto.getCarphoto()%>"></td>
			<td><%=dto.getGuipday()%></td>
			<td><button onclick="del(<%=dto.getNum()%>)" type="button"
					id="delete">삭제</button></td>
		</tr>
		<%
		}
		%>




	</table>





	<script type="text/javascript">
		$("#move").click(function() {
			location.href = "mycarform.jsp"
		});

		function del(num){
			let b=confirm("삭제 확인")
			if(b){
				location.href="deletecar.jsp?num="+num
			}
		}
		
	</script>
</body>
</html>