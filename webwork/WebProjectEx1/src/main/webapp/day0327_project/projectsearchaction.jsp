<%@page import="java.util.List"%>
<%@page import="study.dto.ProjectDto"%>
<%@page import="study.dao.ProjectDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<%
request.setCharacterEncoding("utf-8");


String a = request.getParameter("a");

ProjectDao dao = new ProjectDao();

List<ProjectDto> list = dao.getAllDatasA(a);

response.sendRedirect("projectsearchlist.jsp");





%>