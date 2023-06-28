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
	<h4 class="alert alert-info" style="width: 400px">Mysql mycar
		데이터추가</h4>
		<form action="mycaraction.jsp">
		<table class="table table-bordered" style="width: 400px">
		<tr>
		<th>이름</th>
		<td><input class="form-conntrol" type="text" name="carname"></td>
		</tr>
		<tr>
		<th>가격</th>
		<td><input class="form-conntrol" type="text" name="carprice"></td>
		</tr>
		<tr>
		<th>사진</th>
		<td>
		<select class="form-select" name="carphoto" id="photo">
		<%
		for(int i=1;i<=15;i++){%>
			<option value="<%=i%>.png">
			<%=i %>번
			</option>
		<%}
		%>
		</select>
		</td>
		</tr>
		<tr>
		<th>구입일</th>
		<td><input class="form-conntrol" type="text" name="guipday"></td>
		</tr>
		<tr>
		<td colspan="2" align="center">
		<button type="submit" class="btn btn-success" >차량 추가</button>
		</td>
		</tr>
		
		
		
		</table>
		</form>
		<img src="../image/mycarimage/car1.png" id="photoview" border="3px" width="200">
		<script type="text/javascript">
		$("#photo").change(function(){
			let src=$(this).val();
			$("#photoview").attr("src",`../image/mycarimage/car\${src}`)
	/* 	$("#photoview").attr("src","$(this).val()" */
		
		});
		
		</script>
		
		
		
</body>
</html>