<%@page import="study.dto.CarDto"%>
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
int num = Integer.parseInt(request.getParameter("num"));
CarDao dao = new CarDao();
CarDto dto = dao.getCar(num);

%>
<body>
<form action="carupdateaction.jsp" enctype="multipart/form-data" method="post">
<input type="hidden" name="num" value="<%=num%>">
<table>
<tr>
<th>차 이름</th>
<td><input type="text" name="carname" value="<%=dto.getCarname()%>"></td> 
</tr>
<tr>
<th>차 가격</th>
<td><input type="text" name="carprice" value="<%=dto.getCarprice() %>"></td>
</tr>
<tr>
<th>차 사진</th>
<td>
<select name="carphoto" id="photo">
<%
for(int i=0;i<15;i++){%>
	<option value="<%=i+1%>.png"><%=i+1 %>번차</option>
<%}
%>
</select>
</td>
</tr>
<tr>
<th>차 구입일</th>
<td><input type="text" name="guipday" value="<%=dto.getGuipday()%>"></td>
</tr>
<tr>
<td colspan="2"><button type="submit">차량등록</button></td>
</tr>


</table>
</form>
<img style="width:300px; height:200px;" src="../image/mycarimage/car<%=dto.getCarphoto() %>" id="view">
<script type="text/javascript">
$("#photo").change(function(){
	let src = $(this).val();
	$("#view").attr("src",`../image/mycarimage/car\${src}`)
});
</script>
</body>
</html>