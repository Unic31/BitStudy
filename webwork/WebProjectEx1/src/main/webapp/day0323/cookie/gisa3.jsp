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
	if (b) {
	%>
	<pre>
	푸근하고 귀여운 캐릭터로 잘 알려진 곰돌이 푸가 살인마로 등장하는 이 영화!
당초 홍콩에서 23일 오늘 개봉 예정이었던 영국 공포 영화 '곰돌이 푸: 피와 꿀'입니다.
그런데 개봉을 하루 앞둔 어제 돌연 기술적인 이유로 홍콩은 물론 마카오에서도 상영이 취소됐는데요.
이를 두고 외신에선 중국이 또다시 곰돌이 푸와 관련한 콘텐츠 사용을 제한했다고 지적했습니다.
앞서 지난 2013년 시진핑 주석과 버락 오바마 전 미국 대통령이 걸어가는 모습이 공개된 뒤 시 주석을 곰돌이 푸에 빗대는 글들이 소셜미디어에 돌기 시작했는데요.
이때부터 중국 당국은 곰돌이 푸 캐릭터를 검열 대상으로 삼았는데, 이번 상영 취소도 그와 관련된 조치라는 분석이 나오고 있습니다.
소식을 접한 누리꾼들은 '곰돌이 푸는 무슨 죄인가요', '이러면 진짜 닮았다고 스스로 소문내는 거나 다름없다' 등의 반응을 보였습니다.
</pre>
	<%
	} else {
	%>
	<script type="text/javascript">
		alert("먼저 로그인 후 기사를 확인하세요");
		history.back();
	</script>

	<%
	}
	%>
</body>
</html>