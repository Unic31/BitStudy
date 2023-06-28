<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%


/* String chksave = request.getParameter("chksave");
String id = request.getParameter("id"); */
String pass=request.getParameter("pass");
	if(pass.equals("bit701")){
		Cookie cookie=new Cookie("pass",pass);
		cookie.setPath("/");
		cookie.setMaxAge(60*60);//한시간
		response.addCookie(cookie);
		response.sendRedirect("projectlist.jsp");
	}else{%>
		<script>
			alert("비밀번호가 맞지 않습니다");
			history.back();
		</script>
	<%}

	
%>