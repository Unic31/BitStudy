<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<body>
<h3 class="alert alert-success">MyCar List</h3>
<br>
<h3>총 ${count }개의 차가 있습니다</h3>

<table class="table table-bordered" style="width:600px">
	<tr style="background-color:#ccc">
		<th>번호</th>
		<th>차 이름</th>
		<th>차 가격</th>
		<th>구입날짜</th>
	</tr>
	<c:forEach var="dto" items="${list }" varStatus="i">
	<tr>
		<td>${i.count }</td>
		<td>
			<img src="../image/mycarimage/car${dto.carphoto }" width="60">
			<b>${dto.carname }</b>
		</td>
		<td>
			${dto.carprice }
		</td>
		<td>${dto.guipday}</td>
	</tr>
		
	</c:forEach>

</table>
</body>
</html>