<%@page import="study.dao.ProjectDao"%>
<%@page import="study.dto.ProjectDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
MultipartRequest mulRequest = null;

ServletContext context = getServletContext();
String realPath = context.getRealPath("/save");

int uplodeSize = 1024 * 1024 * 5;

try {
	mulRequest = new MultipartRequest(request, realPath, uplodeSize, "utf-8",
			new DefaultFileRenamePolicy());
	
	int num=Integer.parseInt(mulRequest.getParameter("num"));
	String writer = mulRequest.getParameter("writer");
	String title = mulRequest.getParameter("title");
	String content = mulRequest.getParameter("content");
	String photo = mulRequest.getFilesystemName("upload");//실제업로드된 파일명
	String food = mulRequest.getParameter("food");
	String price = mulRequest.getParameter("price");
	String star = mulRequest.getParameter("star");
	
	ProjectDto dto = new ProjectDto(writer, title, content, photo, food, price, star);
	dto.setNum(num);
	
	ProjectDao dao = new ProjectDao();
	
	dao.updateProject(dto);
	
	response.sendRedirect("projectdetail.jsp?num="+num);
	
	

} catch (Exception e) {
	out.print("업데이트액션오류"+e.getMessage());
}
%>