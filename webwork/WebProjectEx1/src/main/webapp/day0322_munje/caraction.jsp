<%@page import="study.dao.CarDao"%>
<%@page import="study.dto.CarDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
request.setCharacterEncoding("utf-8");
CarDto dto = new CarDto();
CarDao dao = new CarDao();

//폼태그에서 받은 입력값을 읽음(메소드="포스트"인 겨우)
String carname=request.getParameter("carname");
int carprice=Integer.parseInt(request.getParameter("carprice"));
String carphoto=request.getParameter("carphoto");
String Guipday=request.getParameter("guipday");


//읽은값 dto에 넣어서 변환
dto.setCarname(carname);
dto.setCarprice(carprice);
dto.setCarphoto(carphoto);
dto.setGuipday(Guipday);

//dao의 insert메소드를 dto에 있는 생성자로 실행
dao.insertCar(dto);

response.sendRedirect("carlist.jsp");

%>