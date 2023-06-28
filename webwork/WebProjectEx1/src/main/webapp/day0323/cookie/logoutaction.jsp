<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
//브라우저에 저장된 모든 쿠키값들을 얻는다
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (int i = 0; i < cookies.length; i++) {
		String cname = cookies[i].getName();
		String cvalues = cookies[i].getValue();
		if (cname.equals("amho") && cvalues.equals("1234")) {
			//해당 쿠키를 제거
			//유지시간을 0으로 변경
			cookies[i].setMaxAge(0);
			//path 지정
			cookies[i].setPath("/");
			//브라우저에 추가
			response.addCookie(cookies[i]);
		}
	}
}

//메인 페이지로 이동
response.sendRedirect("cookiemain.jsp");
%>