<%@page import="study.dao.ShopDao"%>
<%@page import="study.dto.ShopDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	//데이터 읽기
	String sangpum=request.getParameter("sangpum");
	String color=request.getParameter("color");
	String ipgoday=request.getParameter("ipgoday");
	String photo=request.getParameter("photo");
	int su=Integer.parseInt(request.getParameter("su"));
	int dan=Integer.parseInt(request.getParameter("dan"));
			

	//dto에 넣기
	ShopDto dto=new ShopDto();
	dto.setSangpum(sangpum);
	dto.setColor(color);
	dto.setIpgoday(ipgoday);
	dto.setPhoto(photo);
	dto.setSu(su);
	dto.setDan(dan);
	
	//dao선언 후 insert메소드 호출
	ShopDao dao=new ShopDao();
	dao.insertShop(dto);


%>