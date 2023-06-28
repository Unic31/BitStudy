<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
	body, body *{

		font-family: 'Jua'

	}
</style>
</head>
<body>
<div style="margin:30px;width:600px;">
	<h4 class="alert alert-danger">
		${dto.name} 님의 데이터를 수정중입니다.
		
		<i class="bi bi-house" style="float:right;font-size:30px;cursor:pointer;color:red;" onclick="location.href='../'"></i>
	</h4>
	<br>
	<form action="update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${dto.num }">
		<table class="table table-bordered">
		
			<caption align="top"><b>회원수정</b></caption>
			<tr>
				<th style="width:100px;background-color:orange;" >회원명</th>
				<td>
				<input type="text" name="name"	value="${dto.name }" required="required" autofocus="autofocus"
				class="form-control" style="width:120px">
				</td>
				<td rowspan="4">
					<input type="file" name="upload" class="form-control" onchange="readUrl(this)"
					style="width: 190px;">
					<br>
					<img src="../photo/${dto.photo }"  id="showimg" width="120" height="150"
					style="margin-left: 40px;"
					onerror="this.src='../photo/noimage.png'">
					
					<script type="text/javascript">
						function readUrl(input)
						{
							if(input.files[0]){
								let reader=new FileReader();
								reader.onload=function(e){
									$("#showimg").attr("src",e.target.result);
								}
								reader.readAsDataURL(input.files[0]);
							}
						}
					
					</script>
					
				</td>	
			</tr>
<%-- 				
			<tr>
				<th style="width:100px;background-color:orange;">이메일</th>
				<td>
					<input type="email" name="email" value="${dto.email }"id="email"	 required="required"
					class="form-control" style="width:120px">
					
					<button type="button" class="btn btn-danger btn-sm" id="btnjungbok">중복체크</button>
					<script type="text/javascript">
						$("#btnjungbok").click(function(){
							$.ajax({
								type:"get",
								url:"./isemail",
								dataType:"json",
								data:{"email":$("#email").val()},
								success:function(res){
									if(res.result=='success'){
										alert("사용 가능한 아이디 입니다");
									}else{
										alert("이미 가입된 이메일 입니다. \n다른 이메일로 가입하세요");
										$("#email").val("");
									}
								}
							});
						});
					</script>
				</td>
			</tr> --%>	
			<tr>
				<th style="width:100px;background-color:orange;">핸드폰</th>
				<td>
					<input type="text" name="hp" value="${dto.hp }" required="required"
					class="form-control" style="width:120px">
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<button type="submit" class="btn btn-outline-secondary" 
					style="width:100px">저장</button>
					
					<button type="button" class="btn btn-outline-secondary" 
					style="width:100px" onclick="location.href='list'">목록</button>
				</td>
			</tr>	
		</table>
	</form>
</div>
</body>
</html>
