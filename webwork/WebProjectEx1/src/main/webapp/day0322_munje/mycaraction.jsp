<%@page import="study.dao.MyCarDao"%>
<%@page import="study.dto.MyCarDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
request.setCharacterEncoding("utf-8");
MyCarDto dto = new MyCarDto();
MyCarDao dao = new MyCarDao();


String carname = request.getParameter("carname");
int carprice = Integer.parseInt(request.getParameter("carprice"));
String carphoto = request.getParameter("carphoto");
String guipday = request.getParameter("guipday");


dto.setCarname(carname);
dto.setCarprice(carprice);
dto.setCarphoto(carphoto);
dto.setGuipday(guipday);

dao.insertCar(dto);//dao에 insertCar 메소드를 dto에있는 생성자 로 실행시킨다

response.sendRedirect("mycarlist.jsp");
%>