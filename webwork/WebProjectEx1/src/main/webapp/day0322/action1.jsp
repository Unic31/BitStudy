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
	//form태그의 입력값을 읽어온다
	String irum=request.getParameter("irum"); //폼태그 인풋에 속성 name의 값
	String nai=request.getParameter("nai");//폼태그 인풋에 속성 nai의 값
	%>
<body>
	<h3>
		이름:<%=irum %><br>
		나이:<%=nai %><br>
	</h3>
	<!-- <a href="form1.jsp">다시 입력</a> --> <!-- form1.jsp로 이동(다시불러오는거라 데이터 남아있지않음) -->
	<!-- <a href="javascript:history.back()">다시입력</a> --><!-- back는 데이터 남아있음 -->
	<a href="javascript:history.go(-1)">다시 입력</a> <!-- -1:이전페이지로 이동, -2:전전페이지,
															 -3:전전전페이지 인듯. 이것도 back라 데이터 남아있음 -->
</body>
</html>