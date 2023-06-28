<%@page import="study.dto.SimpleBoardDto"%>
<%@page import="study.dao.SimpleBoardDao"%>
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

//업로드할 사진 사이즈
int uploadSize = 1024 * 1024 * 3;//3mb

try {
	mulRequest = new MultipartRequest(request, realPath, uploadSize, "utf-8", new DefaultFileRenamePolicy());
	//데이터 읽기
	String writer = mulRequest.getParameter("writer");
	String subject = mulRequest.getParameter("subject");
	String content = mulRequest.getParameter("content");
	String photo = mulRequest.getFilesystemName("upload");//실제업로드된 파일명

	//dto에 담기
	SimpleBoardDto dto = new SimpleBoardDto(writer, subject, content, photo);

	//dao선언
	SimpleBoardDao dao = new SimpleBoardDao();

	//insert
	dao.insertBoard(dto);

	//목록으로 이동
	response.sendRedirect("boardlist.jsp");

} catch (Exception e) {
	out.print("업로드 오류" + e.getMessage());
}
%>