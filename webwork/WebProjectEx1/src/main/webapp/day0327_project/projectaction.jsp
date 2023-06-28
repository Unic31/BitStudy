<%@page import="study.dao.ProjectDao"%>
<%@page import="study.dto.ProjectDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
MultipartRequest mulRequest = null;

//저장할 경로
ServletContext context = getServletContext();
String realPath = context.getRealPath("/save");
System.out.println(realPath);

int uploadSize = 1024 * 1024 * 5;

try {
	mulRequest = new MultipartRequest(request, realPath, uploadSize, "utf-8", new DefaultFileRenamePolicy());
	//데이터 읽기
	String writer = mulRequest.getParameter("writer");
	String title = mulRequest.getParameter("title");
	String content = mulRequest.getParameter("content");
	String photo = mulRequest.getFilesystemName("upload");//실제업로드된 파일명
	String food = mulRequest.getParameter("food");
	String price = mulRequest.getParameter("price");
	String star = mulRequest.getParameter("star");

	//dto에 담기
	ProjectDto dto = new ProjectDto(writer, title, content, photo, food, price, star);

	//dao선언
	ProjectDao dao = new ProjectDao();

	//insert
	dao.insertPj(dto);

	//목록으로 이동
	response.sendRedirect("projectlist.jsp");

} catch (Exception e) {
	out.print("업로드 오류" + e.getMessage());
}




%>