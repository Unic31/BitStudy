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
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
body, body * {
	font-family: 'Jua'
}
.shopadd{
	cursor: pointer;
	color: red;
	font-size: 30px;
}
.box{
	width: 40px;
	height: 30px;
	border:1px solid black;
	margin-left: 50px;
}
.iupdate,.idelete{
	cursor: pointer;
	font-size: 20px;
}
.iupdate{
	color: green;
}
.idelete{
	color:red;
	margin-left: 30px;
}
</style>
<script type="text/javascript">
$(function(){
	//처음 시작시 목록 출력
	list();
	
	//검색 후 엔터 또는 검색버튼 클릭시 list다시 호출
	$("#btnsearch").click(function(){
		list();
	});
	$("#search").keyup(function(e){
		if(e.keyCode==13)
		list();
	});
	
	
	//상품추가 모달창
	//1.사진 변경시 해당 사진 나오게 하기
	$("#nphoto").change(function(){
		//선택한 사진명을 얻는다
		let imgSrc=$(this).val();
		//#photoview의 src변경
		$("#photoview").attr("src","../../image/shop/"+imgSrc);
	});
	//단가 입력후 포커스가 벗어날때 숫자인지 아닌지 체크
	$("#ndan").blur(function(){
		if(isNaN($(this).val())){ //isNaN:숫자가 아닌게 있으면 true나옴
			alert("단가는 숫자로만 입력하세요")
			$(this).val("");
			$(this).focus();
		}
	});
	
	//상품등록버튼
	$("#btnadd").click(function(){
		//모달폼에서 입력한 값들을 읽어온다
		let sang=$("#nsangpum").val();
		let color=$("#ncolor").val();
		let su=$("#nsu").val();
		let dan=$("#ndan").val();
		let ipgoday=$("#nipgoday").val();
		let photo=$("#nphoto").val();
		
		$.ajax({
			type:"get",
			url:"../shopback/insertshop.jsp",
			dataType:"html",
			data:{"sangpum":sang,"color":color,"su":su,"dan":dan,"ipgoday":ipgoday,"photo":photo},
				//{"insertshop에서읽은이름":let에서지정한이름}
			success:function(res){
				//성공했으면 현재 페이지 새로고침
				location.reload();
			},
			statusCode:{
				404:function(){
					alert("파일이 없어요");
				},
				500:function(){
					alert("서버 오류")
				}
			}
		});
	});
	
	//수정 아이콘 클릭시 모달창에 데이터 넣기
	$(document).on("click",".iupdate",function(){
		let num=$(this).attr("num");
		//alert(num);
		$.ajax({
			type:"get",
			url:"../shopback/selectdata.jsp",
			dataType:"json",
			data:{"num":num},
			success:function(res){
				$("#unum").val(res.num);
				$("#usangpum").val(res.sangpum);
				$("#uphoto").val(res.photo);
				$("#usu").val(res.su);
				$("#udan").val(res.dan);
				$("#uipgoday").val(res.ipgoday);
				$("#ucolor").val(res.color);
				
				//사진
				$("#uphotoview").attr("src","../../image/shop/"+res.photo);
			},
			statusCode:{
				404:function(){
					alert("파일이 없어요");
				},
				500:function(){
					alert("서버 오류")
				}
			}
		});
	});
	//수정창에서 사진 변경 이벤트
	$("#uphoto").change(function(){
		//선택한 사진명을 얻는다
		let imgSrc=$(this).val();
		//#photoview의 src변경
		$("#uphotoview").attr("src","../../image/shop/"+imgSrc);
	});
	
	//수정버튼 클릭시
	$("#btnupdate").click(function(){
		//form의 입력 데이터를 한꺼번에 가져온다
		//단 form안에서 줘야하고 태그 안에서는 name을 줘야한다
		let data=$("#frmupdate").serialize();
		//alert(data);
		$.ajax({
			type:"get",
			url:"../shopback/updateshop.jsp",
			dataType:"html",//보내기만 하고 받을거 없으면html
			data:data,//위에서 serialize로 변수선언해둔거
			success:function(res){
				//화면 새로고침
				//location.reload();//새로고침
				
				//목록부분만 출력
				list();//새로고침 되면 안되는 부분이 있을수도 있으니까 리스트 재호출
			},
			statusCode:{
				404:function(){
					alert("파일이 없어요");
				},
				500:function(){
					alert("서버 오류")
				}
			}
		});
	});
	
	
	
	//삭제 아이콘 클릭시 이벤트
	$(document).on("click",".idelete",function(){
		//태그에 넣어둔 num을 읽기
		let num=$(this).attr("num");
		//alert(num);
		
		let b=confirm("삭제 하려면 확인을 눌려주세요")
		if(b){
			$.ajax({
				type:"get",
				url:"../shopback/deleteshop.jsp",
				data:"num="+num,//방식이 두가지
				dataType:"html",
				success:function(res){
					list();
				},
				statusCode:{
					404:function(){
						alert("파일이 없어요");
					},
					500:function(){
						alert("서버 오류")
					}
				}
			});
		}
	});
	
	
});//function end

function list(){
	//search값 읽기
	let search=$("#search").val();
	$.ajax({
		type:"get",
		url:"../shopback/listshop.jsp",
		dataType:"json",
		data:{"search":search},//반환값에다 입력값 보내는것
		success:function(res){
			let s="총 "+res.length+" 개의 상품이 검색되었습니다<br><br>"
			
			s+="<table class='table table-bordered>'";
			$.each(res,function(idx,ele){
				s+=`
				<tr>
					<td>
					<img src="../../image/shop/\${ele.photo}" width="200" height="240" border="2"
					</td>
					<td valign="midle">
					<i class="bi bi-pencil-square iupdate" data-bs-toggle="modal" data-bs-target="#myShopUpdateModal" num="\${ele.num}"></i>
					<i class="bi bi-trash3 idelete" data-bs-toggle="modal" data-bs-target="#myShopDeleteModal"num="\${ele.num}"></i>
					<br><br>
					상품명 : \${ele.sangpum}<br>
					색	상
						<div class='box' style="background-color:\${ele.color}"></div>
					수	량 : \${ele.su}개<br>	
					수	량 : \${ele.dan}원<br>	
					입고일 : \${ele.ipgoday}<br>	
					</td>
				</tr>
				
				`;
				
			});
			
			$(".list").html(s);
		},
		statusCode:{
			404:function(){
				alert("파일이 없어요");
			},
			500:function(){
				alert("서버 오류")
			}
		}
	});
}

</script>
</head>
<body>
<!-- 상품 수정 모달창 -->
<div class="modal" id="myShopUpdateModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">상품 수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
      <form id="frmupdate">
      <input type="hidden" name="num" id="unum" value="">
        <table class="table table-bordered">
        <tr>
        	<th style="background-color:#ccc" width=80>상품명</th>
        	<td><input type="text" name="sangpum" id="usangpum" class="form-control"></td>
        </tr>
        <tr>
        	<th style="background-color:#ccc" width=80>사진</th>
        	<td class="input-group">
        		<select name="photo" id="uphoto" class="form-select">
        		<%
        		for(int i=1;i<=34;i++){
        			String fname=i+"."+(i==24?"gif":"jpg");
        			%>
        			<option value="<%=fname%>"><%=fname%></option>
        		<%}
        		%>
        		
        		</select>
        		<img src="../../image/shop/1.jpg" width="50" height="50" border="1" hspace="3" id="uphotoview">
        	</td>
        </tr>
        <tr>
        	<th style="background-color:#ccc" width=80>수량</th>
        	<td><input type="number" name="su" id="usu" class="form-control" min="1" max="5" value="1"></td>
        </tr>
        <tr>
        	<th style="background-color:#ccc" width=80>단가</th>
        	<td><input type="text" name="dan" id="udan" class="form-control"></td>
        </tr>
        <tr>
        	<th style="background-color:#ccc" width=80>색상</th>
        	<td><input type="color" name="color" id="ucolor" class="form-control" value="#ccfdab"></td>
        </tr>
        <tr>
        	<th style="background-color:#ccc" width=80>입고일</th>
        	<td><input type="date" name="ipgoday" id="uipgoday" class="form-control"></td>
        </tr>
        </table>
        </form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal"
        id="btnupdate">상품수정</button>
      </div>

    </div>
  </div>
</div>


<!-- 상품 등록 모달창 -->
<div class="modal" id="myShopModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">상품 등록</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <table class="table table-bordered">
        <tr>
        	<th style="background-color:#ccc" width=80>상품명</th>
        	<td><input type="text" id="nsangpum" class="form-control"></td>
        </tr>
        <tr>
        	<th style="background-color:#ccc" width=80>사진</th>
        	<td class="input-group">
        		<select id="nphoto" class="form-select">
        		<%
        		for(int i=1;i<=34;i++){
        			String fname=i+"."+(i==24?"gif":"jpg");
        			%>
        			<option value="<%=fname%>"><%=fname%></option>
        		<%}
        		%>
        		
        		</select>
        		<img src="../../image/shop/1.jpg" width="50" height="50" border="1" hspace="3" id="photoview">
        	</td>
        </tr>
        <tr>
        	<th style="background-color:#ccc" width=80>수량</th>
        	<td><input type="number" id="nsu" class="form-control" min="1" max="5" value="1"></td>
        </tr>
        <tr>
        	<th style="background-color:#ccc" width=80>단가</th>
        	<td><input type="text" id="ndan" class="form-control"></td>
        </tr>
        <tr>
        	<th style="background-color:#ccc" width=80>색상</th>
        	<td><input type="color" id="ncolor" class="form-control" value="#ccfdab"></td>
        </tr>
        <tr>
        	<th style="background-color:#ccc" width=80>입고일</th>
        	<td><input type="date" id="nipgoday" class="form-control"></td>
        </tr>
        </table>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal"
        id="btnadd">상품등록</button>
      </div>

    </div>
  </div>
</div>
<div class="search input-group" style="margin:30px 50px">
	<input type="text" id="search" placeholder="검색할 상품을 입력하세요"
	style="width:200px">
	<button class="btn btn-danger btn-sm" id="btnsearch">검색</button>
	&nbsp;&nbsp;
	<i class="bi bi-plus-circle shopadd" data-bs-toggle="modal" data-bs-target="#myShopModal"></i>
</div>
<div class="list" style="margin:20px 50px;width:450px"></div>
</body>
</html>