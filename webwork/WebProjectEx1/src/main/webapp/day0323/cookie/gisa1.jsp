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
boolean b = false;//amho쿠키가 존재하면 true로 변경
//브라우저에 저장된 모든 쿠키값들을 얻는다
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (int i = 0; i < cookies.length; i++) {
		String cname = cookies[i].getName();
		String cvalues = cookies[i].getValue();
		if (cname.equals("amho") && cvalues.equals("1234")) {
	//amho쿠기가 존재하므로b를 true로 바꾼다
	b = true;
		}
	}
}
%>
<body>
<%
if(b){
%>
	<pre>
	■ 가격 내리면 해결? 그게 답이 아니라는 극장계
우선 가격 이야기부터 해볼까요. 많은 분이 댓글에서 티켓값이 너무 비싸졌다고 지적했습니다. 
'타짜'와 '암살' 등을 만든 최동훈 감독이 공개적으로 티켓값 조정 필요성을 말할 정돕니다.
하지만 극장 업계는 가격 인하를 검토하기보단, 기술 특별관 등에 투자를 늘려 관객을 유인하겠단 입장입니다. 
수십만 원을 오가는 클래식이나 뮤지컬 공연 등도 성황을 이루는 것처럼, 진짜 가치가 있다고 판단하면 지갑이 열린다는 논리입니다.
일례로 누적 관객 수천만을 넘긴 '아바타 : 물의 길'의 경우 관객의 53%가 일반관보다 더 비싼 특수 상영관을 선택했습니다. 
가수 임영웅의 공연 실황 등을 담은 '아임 히어로 더 파이널'의 경우에도 더 비싼 스크린X 관을 택한 관객의 비율이 일반관의 2배가 넘습니다.
중요한 건 '15,000원이 아깝지 않은 경험을 극장이 제공해 줄 수 있느냐'는 문젭니다. 극장도 이를 알고 있습니다. 최근 응원 상영회 등 이벤트 기획에 열심인 이유입니다. 
OTT(온라인 동영상 서비스)를 이용해 휴대 전화 화면으로 볼 땐 느낄 수 없는 즐거움, 
즉 상영관 안에서 다 함께 환호하고 감동하는 경험은 극장만의 장점이라는 거죠.
하지만 한계가 있습니다. 모든 영화가 응원 상영회에 어울리는 것도 아닐뿐더러, 영화 자체가 재미있지 않으면 극장의 강점은 무의미합니다.
'재밌으면 본다, 재미없으면 공짜로 보여줘도 안 본다'는 댓글은 핵심을 찌릅니다.
</pre>
<%} else{%>
	<script type="text/javascript">
	alert("먼저 로그인 후 기사를 확인하세요");
	history.back();
	</script>
	
<%}%>
</body>
</html>