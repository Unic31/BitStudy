<%@ page language="java" contentType="text/html; ;charset=utf-8"
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
request.setCharacterEncoding("utf-8");
String sname=request.getParameter("sname");
String gender=request.getParameter("gender");
String []hobby=request.getParameterValues("hobby");
String email1=request.getParameter("email1");
String email2=request.getParameter("email2");
%>
<body>
<h4>
이름:<%=sname %><br>
성별:<%=gender %><br>
취미<%
if(hobby==null){ %>
가 없습니다
<%}else{%>는<%
for(String h : hobby)
{%> <%=h %>
<%} %>입니다<%}
%>
<br>
이메일:<%=email1 %>@<%=email2 %>





</h4>
</body>
</html>