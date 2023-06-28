<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
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

<c:forEach var="a" begin="1" end="10">
	${a }&nbsp;
</c:forEach>
<hr>
<c:forEach var="a" begin="1" end="10" step="2">
	${a }&nbsp;
</c:forEach>

<%
	List<String> list = Arrays.asList("red","green","blue","orange","pink");
	request.setAttribute("list", list);//request에 저장
%>
					<%--requestScope는 생략가능 --%>
<c:forEach var="s" items="${list }" varStatus="i">
	<h5 style="color:${s}">${i.count}(${i.index}): ${s }</h5><%--count 는 일련번호, index는 인덱스번지? --%>

</c:forEach>
<hr>
<c:forEach var="s" items="${list }" begin="1" end="3" varStatus="i">
	<h5 style="color:${s}">${i.count}(${i.index}): ${s }</h5><%--count 는 일련번호, index는 인덱스번지? --%>

</c:forEach>

<c:forEach var="a" begin="1" end="8">
	<c:set var="photo"	 value="../image/animal/C${a}.png"/>
	<img src="${photo }" width="60">
</c:forEach>

<h5>shop의 이미지 중 1.jpg~12.jpg까지 출력하는데 한줄에 3개씩만 출력(w:60, h:80)</h5>
<c:forEach var="a" begin="1" end='12' varStatus="i">
	<img src="../image/shop/${a}.jpg" width="60" height="80">
	<c:if test="${i.count%3==0}"><br></c:if>


</c:forEach>

</body>
</html>











