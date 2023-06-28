<%@page import="java.io.File"%>
<%@page import="study.dao.ProjectDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%

int num=Integer.parseInt(request.getParameter("num"));

ProjectDao dao = new ProjectDao();

//업로드했던 파일명 얻기
String photo = dao.getData(num).getPhoto();
//업로드된 경로 구하기
String realPath = getServletContext().getRealPath("/save");
//파일객체생성
File file = new File(realPath + "/" + photo);
file.delete();

dao.deleteProject(num);

response.sendRedirect("projectlist.jsp");
%>