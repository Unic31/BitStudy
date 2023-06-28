<%@page import="study.dto.ProjectDto"%>
<%@page import="study.dao.ProjectDao"%>
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

table tr th {
	text-align: center;
}

table {
	position: absolute;
}
</style>

</head>
<%
int num=Integer.parseInt(request.getParameter("num"));

ProjectDao dao = new ProjectDao();

ProjectDto dto = dao.getData(num);
%>
<body>
	<div style="margin: 30px 50px">

		<form action="projectupdateaction.jsp" method="post"
			enctype="multipart/form-data">
	<input type="hidden" name="num" value="<%=dto.getNum() %>">
 			<table>
				<caption align="top">
					<b>게시글 쓰기</b>
				</caption>
				<tr>
					<th bgcolor="lightgray" width="100">작성자</th>
					<td><input type="text" name="writer" class="form-control"
						autofocus="autofocus" required="required"
						value="<%=dto.getWriter()%>"></td>
				</tr>
				<tr>
					<th bgcolor="lightgray" width="100">제목</th>
					<td><input type="text" name="title" class="form-control"
						required="required"
						value="<%=dto.getTitle()%>"></td>
				</tr>
				<tr>
					<th bgcolor="lightgray" width="100">음식 사진(1장)</th>
					<td><input type="file" name="upload" id="myfile"
						class="form-control"
						value="<%=dto.getPhoto()%>"></td>
				</tr>
				<tr>
					<th bgcolor="lightgray" width="100">음식</th>
					<td><select name="food">
							<option value="한식">한식</option>
							<option value="일식">일식</option>
							<option value="중식">중식</option>
							<option value="양식">양식</option>
					</select></td>
				</tr>
				<tr>
					<th bgcolor="lightgray" width="100">가격</th>
					<td><select name="price">
							<option value="5000원 이하">5000원 이하</option>
							<option value="5000~10000원">5000~10000원</option>
							<option value="10000원 이상">10000원 이상</option>
					</select></td>
				</tr>
				<tr>
					<th bgcolor="lightgray" width="100">평점</th>
					<td><select name="star">
							<option value="★☆☆☆☆">★☆☆☆☆</option>
							<option value="★★☆☆☆">★★☆☆☆</option>
							<option value="★★★☆☆">★★★☆☆</option>
							<option value="★★★★☆">★★★★☆</option>
							<option value="★★★★★">★★★★★</option>
					</select></td>
				<tr>
					<td colspan="2"><img id="fphoto" src="../image/black.jpg"
						style="width: 400px; height: 300px;object-fit:contain" name="photo"></td>
				</tr>
				<tr>
					<td colspan="2"><textarea style="width: 100%; height: 150px"
							name="content" required="required"><%=dto.getContent() %></textarea></td>
				</tr>

				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-secondary btn-sm">
							&nbsp;저장&nbsp;</button>
						<button type="button" class="btn btn-secondary btn-sm"
							onclick="history.back()">&nbsp;이전&nbsp;</button>
					</td>
				</tr>

			</table>
		</form>
	</div>
	<script type="text/javascript">
		$("#myfile").change(function() {
			console.log("1:" + $(this)[0].files.length);
			console.log("2:" + $(this)[0].files[0]);
			//정규표현식
			var reg = /(.*?)\/(jpg|jpeg|png|bmp)$/;
			var f = $(this)[0].files[0];//현재 선택한 파일
			if (!f.type.match(reg)) {
				alert("확장자가 이미지파일이 아닙니다");
				return;
			}
			if ($(this)[0].files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$("#fphoto").attr("src", e.target.result);
				}
				reader.readAsDataURL($(this)[0].files[0]);
			}
		});
	</script>
</body>
</html>