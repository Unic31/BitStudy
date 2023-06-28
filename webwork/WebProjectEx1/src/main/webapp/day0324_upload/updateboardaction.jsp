<%@page import="study.dao.SimpleBoardDao"%>
<%@page import="study.dto.SimpleBoardDto"%>
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
int uplodeSize = 1024 * 1024 * 3;

try {
	mulRequest = new MultipartRequest(request, realPath, uplodeSize, "utf-8",
			new DefaultFileRenamePolicy());

	//데이터 읽기
	int num = Integer.parseInt(mulRequest.getParameter("num"));
	String writer = mulRequest.getParameter("writer");
	String subject = mulRequest.getParameter("subject");
	String content = mulRequest.getParameter("content");
	String photo = mulRequest.getFilesystemName("upload");//실제 업로드된 파일명
	System.out.println(photo);
	//dto에 담기
	SimpleBoardDto dto = new SimpleBoardDto(writer, subject, content, photo); //dto에 넘까지 같이 담는게 없어서
	dto.setNum(num); //여기서 넘 따로 담아줌

	//dao 선언
	SimpleBoardDao dao = new SimpleBoardDao();

	//update
	dao.updateBoard(dto);

	//목록으로 이동
	response.sendRedirect("detailboard.jsp?num=" + num);

} catch (Exception e) {
	out.print("업로드 수정 오류"+e.getMessage());
}
%>