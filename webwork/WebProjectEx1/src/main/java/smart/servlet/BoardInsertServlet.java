package smart.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.dao.SmartDao;
import study.dto.SmartDto;


@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//한글 엔코딩
		request.setCharacterEncoding("utf-8");
		String writer=request.getParameter("writer");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		//dto
		SmartDto dto = new SmartDto();
		dto.setWriter(writer);
		dto.setSubject(subject);
		dto.setContent(content);
		//dao
		SmartDao dao = new SmartDao();
		//insert
		dao.insertSmart(dto);
		
		response.sendRedirect("list");//데이터db에 추가 후 목록으로 이동
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);//post로 받은걸 doGet으로 이동
	}

}
