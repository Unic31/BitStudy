<%@page import="study.dayd021.ShopDto"%>
<%@page import="java.util.List"%>
<%@page import="study.dayd021.ShopList"%>
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
<body>
	<h3 class="alert alert-danger">AnimalDto 데이터 출력하기</h3>
	<%
	ShopList shoplist = new ShopList();
	List<ShopDto> list = shoplist.getSangpumList();
	%>
	<table class="table table-bordered" style="width: 400px">
		<tr bgcolor="lightgray">
			<th>이름</th>
			<th>가격</th>
			<th>색</th>
			<th>사진</th>
		</tr>

		<%
		for (int i = 0; i < list.size(); i++) {
			ShopDto dto = list.get(i);
		%>
		<tr> 
			<td><%=dto.getSangpumName()%></td>
			<td><%=dto.getSangpumPrice()%></td>
			<td><%=dto.getSangpumColor()%></td>
			<td><img width="60" height="100" src="../image/shop/<%=dto.getSangpumPhoto()%>.jpg"></td>
		</tr>
		<%
		}
		%>















	</table>
</body>
</html>