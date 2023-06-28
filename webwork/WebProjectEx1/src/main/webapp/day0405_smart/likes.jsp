<%@page import="org.json.simple.JSONObject"%>
<%@page import="study.dao.SmartDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	int num=Integer.parseInt(request.getParameter("num"));
	//추천 증가
	SmartDao dao = new SmartDao();
	dao.updateLikes(num);
	
	//증가된 likes얻기
	int likes=dao.getData(num).getLikes();
	
	//json으로 반환
	JSONObject ob = new JSONObject();
	ob.put("likes",likes);
%>
<%=ob.toString() %>