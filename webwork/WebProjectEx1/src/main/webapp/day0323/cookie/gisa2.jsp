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
	① 아동 수당을 18세까지 매달 100만 원씩, 1인당 2억 천여 만 원을 지급한다 ② 30세 전에 자녀를 셋 이상 둔 남성의 병역을 면제한다는 방안 등입니다.
포털 이용자 반응은 사뭇 달랐습니다.
'아동 수당 지급' 건에 대해선 일단 우호적이었습니다.
경제협력개발기구( OECD) 국가 중 꼴찌를 벗어나지 못하고 있는 출생률을 고려할 때 "할 수 있는 건 다 해봐야 된다"는 위기감이 주를 이뤘습니다.
이정도는 되어야 꼴찌는 탈출하지 (rlaq****)
그래 뭐라도 해라 진짜 나라 사라지는 거 체감돼서 겁난다 (qjae****)
뭐든 빨리해봐라. 말만 하지 말고 (ms16****)
반면 '병역 면제' 혜택에 대해선 "황당하다"는 비난 목소리가 상당했습니다.
' 초혼 연령은 알고 말하느냐'는 비판부터 '부잣집 병역 면제 루트'라는 지적에, 일각에선 '병역 문제'를 '출산'과 연계시키는 부분을 두고 성별 혐오 댓글로까지 번졌습니다.
'자녀 셋이면 원래 부양가족 면제 혜택이 있다'는 의견도 나왔는데, 병역법상 아이를 셋 이상 낳아도 보유 재산과 소득이 일정 기준에 부합해야 군 면제가 가능합니다.
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