<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%

	session.removeAttribute("loginstate");
	//메인페이지로 이동
	response.sendRedirect("sessionmain.jsp");	

%>