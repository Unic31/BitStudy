<%@page import="study.dao.MyCarDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
MyCarDao dao = new MyCarDao();

int num=Integer.parseInt(request.getParameter("num"));

dao.deledtCar(num);

response.sendRedirect("carlist.jsp");
%>