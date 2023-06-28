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
.box{
border:3px solid gray;
width : 30px;
height : 30px;
float:left;
margin-right:10px;
}
</style>

</head>
<%
	//post방식인 경우 데이터를 읽기전에 엔코딩 코드를 넣어준다
	request.setCharacterEncoding("utf-8");
	//form2의 데이터를 post방식으로 읽는 경우
	String sang=request.getParameter("sang");
	String pass=request.getParameter("pass");
	//체크박스는 여러개 선택이 가능-배열로 받는다//선택을 안했을경우 null값
	String []colors=request.getParameterValues("color");
	String photo=request.getParameter("photo");
	//hidden 데이터 읽기
	String message=request.getParameter("message");
%>
<body>
	<h4>
	상품명:<%=sang %><br>
	비밀번호:<%=pass %><br>
	선택색상<br>
	<%
	if(colors==null){%>
	<b>원하는 색상 없음</b>
		<%}else{
		for(String s:colors)
		{%>
		s
		
		<%}
	}
	%>
	<br style="clear : both;">
	선택한 사진<br>
	<img src="../image/shop/<%=photo %>" width="200" border="1">
	<br>
	Hidden 메세지<br>
	<%=message %>
	
	</h4>
</body>
</html>