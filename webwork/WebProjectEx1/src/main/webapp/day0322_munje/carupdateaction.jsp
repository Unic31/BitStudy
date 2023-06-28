<%@page import="study.dao.CarDao"%>
<%@page import="study.dto.CarDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
MultipartRequest mulRequest = null;

//저장할 경로
ServletContext context = getServletContext();
String realPath = context.getRealPath("/save");




int uplodeSize = 1023*1024*3;


try{
mulRequest = new MultipartRequest(request, realPath, uplodeSize, "utf-8",
		new DefaultFileRenamePolicy());

int num = Integer.parseInt(mulRequest.getParameter("num"));
String carname = mulRequest.getParameter("carname");
int carprice = Integer.parseInt(mulRequest.getParameter("carprice"));
String carphoto = mulRequest.getParameter("carphoto");
String guipday = mulRequest.getParameter("guipday");

//dto에 담기
CarDto dto = new CarDto(num, carname, carprice, carphoto, guipday);

//dao선언
CarDao dao = new CarDao();

//update
dao.updateCar(dto);

response.sendRedirect("carlist.jsp?num="+num);

} catch (Exception e){
	out.print("업로드 수정 오류"+e.getMessage());
	
}










%>
