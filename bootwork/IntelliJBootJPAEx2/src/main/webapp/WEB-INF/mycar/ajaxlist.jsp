<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <style>
        body, body * {
            font-family: 'Jua'
        }
        div.menu{
            margin-left: 30px;
            margin-right: 30px;
        }
        div.menu b{
            cursor: pointer;
        }
        div.carlist{
            margin-left: 30px;
            margin-top: 30px;
            width: 700px;
        }
        div.carlist .car{
            float:left;
            width: 150px;
            height: 220px;
            border: 3px solid pink;
            border-radius:30px;
            margin-right: 10px;
            margin-bottom: 10px;
            text-align: center;
        }
        div.carlist .car img{
            border-radius:30px;
            width: 100%;
            height: 140px;
        }

    </style>
    <script>
        $(function() {
            list(1);
            $("b.list").click(function () {
                let idx = $(this).attr("idx");
                list(idx);
            });
        });
        function list(idx){
                $.ajax({
                    type:"get",
                    url:"/list",
                    data:{"idx":idx},
                    dataType:"json",
                    success:function(res){
                        let s="";
                        $.each(res,function(idx,ele){
                           s+=`
                            <div class='car'>
<img src="../save/\${ele.carphoto}" width="100px">
<br>
\${ele.carname}<br>
\${ele.carprice}원
</div>
                            `;
                           if((idx+1)%3==0){
                               s+=`<br style="clear:both">`
                           }

                        });
                        $(".carlist").html(s);
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
<button type="button" class="btn btn-outline-danger btn-sm" style="margin-left: 100px;width: 200px;"
        onclick="location.href='./'">메인메뉴</button>
<div class="menu">
    <b class="list" idx="1">고가순</b>
    &nbsp;&nbsp;
    <b class="list" idx="2">저가순</b>
    &nbsp;&nbsp;
    <b class="list" idx="3">등록순</b>
</div>
<div class="carlist">

</div>
</body>
</html>
