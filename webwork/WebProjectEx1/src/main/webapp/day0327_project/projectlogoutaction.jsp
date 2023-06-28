<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
//브라우저에 저장된 모든 쿠키값들을 얻는다
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (int i = 0; i < cookies.length; i++) {
		String cname = cookies[i].getName();
		String cvalues = cookies[i].getValue();
		if (cname.equals("pass") && cvalues.equals("bit701")) {
			cookies[i].setMaxAge(0);//유지시간을 0으로 변경
			cookies[i].setPath("/");	//path 지정
			response.addCookie(cookies[i]);//브라우저에 추가
		}
	}
}
response.sendRedirect("projectlist.jsp");
%>