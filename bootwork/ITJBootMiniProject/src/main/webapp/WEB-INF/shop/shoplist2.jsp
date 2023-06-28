<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../commonvar.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Refresh" content="10;url=./list">
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
    </style>
</head>
<body>
<button class="btn btn-sm btn-outline-success" onclick="location.href='shopform'" style="margin-bottom: 10px">상품등록</button>
<h5 class="alert alert-danger">
    총 ${totalCount} 개의 상품이 등록되었습니다
    <span style="float:right;">
        <button class="btn btn-sm btn-outline-success" onclick="location.href='list'">작은사진으로 확인</button>
    </span>
</h5>
<table <%--style="width: 540px"--%> class="table table-bordered">

    <c:forEach var="dto" items="${list}" varStatus="i">

        <tr style="float: left">
            <td style="cursor:pointer;" onclick="location.href='detail?num=${dto.num}'">
                <figure>
                    <%--<img src="http://ovfjnvwkvfwf16981861.cdn.ntruss.com/shop/${dto.photo}?type=f&w=160&h=160&faceopt=true&ttype=jpg">--%>
                    <img src="http://${imageUrl_small}/shop/${dto.photo}?type=f&w=160&h=160&faceopt=true&ttype=jpg">
                    <figcaption>
                        ${dto.sangpum}
                    </figcaption>
                </figure>
            </td>
        </tr>
     <%--   <c:if test="${i.count%3==0}">
            <tr>

            </tr>
        </c:if>--%>


    </c:forEach>
</table>
</body>
</html>
