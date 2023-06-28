<%@page import="java.util.Date"%>
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
div.box{
float:left;
width:50px;
height:50px;
margin-right:5px;
border:1px solid black;
}
</style>

</head>
<body>
<c:set var="colors" value="red,green,blue,gray,pink,orange,magenta,tomato"/>
<h4>${colors }</h4>
<c:forTokens var="a" items="${colors }" delims=","><%-- ","로 분리한 변수를 a가 받는다 --%>
	<div class="box" style="background-color:${a}">${a}</div>
</c:forTokens>
<hr>
<h5 style="clear:both">숫자, 날짜 포멧 양식</h5>
<c:set var="today" value="<%=new Date() %>"/>
<c:set var="money" value="7896730"/>
<c:set var="num1" value="23.456789"/>
<c:set var="num2" value="0.8"/>

${today }
<hr>
<fmt:formatDate value="${today }" pattern="yyy-MM-dd"/><br>
<fmt:formatDate value="${today }" pattern="yyy-MM-dd HH:mm"/><br><%--14시--%>
<fmt:formatDate value="${today }" pattern="yyy-MM-dd a hh:mm"/><br><%--오후 02시--%>
<fmt:formatDate value="${today }" pattern="yyy-MM-dd EEEE"/><br><%--화요일--%>
<fmt:formatDate value="${today }" pattern="yyy-MM-dd EEE"/><br><%--화--%>
<hr>
${money }<br>
${num1 }<br>
type : number <fmt:formatNumber value="${money }" type="number"/><br><%-- , 추가 --%>
type : currency <fmt:formatNumber value="${money }" type="currency" currencySymbol="￦"/><br><%-- , 추가 --%>
type : currency <fmt:formatNumber value="${money }" type="currency" currencySymbol="$"/><br><%-- , 추가 --%>

<fmt:formatNumber value="${num1 }" pattern="0.00"/><br>
<fmt:formatNumber value="${num2 }" pattern="0.00"/><br><!-- 빈자리를 0으로 채움 -->
<fmt:formatNumber value="${money }" pattern="#,##0"/><!-- 3자리마다 , 하겠다는것 -->


</body>
</html>