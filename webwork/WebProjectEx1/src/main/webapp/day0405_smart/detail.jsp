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
.day{
	float:right;
	margin-right: 10px;
	color: #888;
	font-size: 12px;
}
</style>

</head>
<body>
<div style="margin:30px 50px;width:600px;">
	<h2><b>${dto.subject }</b></h2>
	<div>
		<b>${dto.writer }</b>
		<span class="day">
			<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
		</span>
	</div>
	<div style="color:#888;margin-top:10px;">
		조회 ${dto.readcount }
		&nbsp;&nbsp;
		<span class="likes" style="cursor:pointer">추천 ${dto.likes }</span>
	</div>
	<pre>
		${dto.content }
	</pre>
	<div>
		<button type="button" class="btn btn-outline-secondary" 
		onclick="location.href='writeform'">글쓰기</button>
		
		<button type="button" class="btn btn-outline-secondary" 
		onclick="location.href='updateform?num=${dto.num}'">수정</button>
		
		<button type="button" class="btn btn-outline-secondary" 
		onclick="del(${dto.num})">삭제</button>
		
		<button type="button" class="btn btn-outline-secondary" 
		onclick="location.href='list'">글목록</button>
	</div>
</div>
<script type="text/javascript">
	$(".likes").click(function(){
		let num=${dto.num};
		console.log(num);
		$.ajax({
			type:"get",
			url:"../day0405_smart/likes.jsp",
			dataType:"json",
			data:{"num":num},
			success:function(res){
				$(".likes").text("추천 "+res.likes);	
			}
		});
	});
	function del(num){
		//alert(num);
		let b=confirm("삭제 하려면 확인");
		if(b){
			location.href="delete?num="+num;
		}
		
	}
</script>
</body>
</html>



















