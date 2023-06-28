<%@page import="study.dao.ProjectDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
int num = Integer.parseInt(request.getParameter("num"));

//dao선언
ProjectDao dao = new ProjectDao();

dao.upProject(num);

response.sendRedirect("projectdetail.jsp?num="+num);
%>