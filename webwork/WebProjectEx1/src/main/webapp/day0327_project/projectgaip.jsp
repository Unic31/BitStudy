<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
</head>
<body>
<form name="Join" action="Joinreal.jsp" method="post">
<center>
<table border=1>
<tr>
 <td colspan="2" align=center>
 <b><font size=5>회원가입</font></b>
 </td>
</tr>
 
 <tr><td>아이디  </td><td><input type="text" name="id"></td></tr>
 <tr><td>비밀번호  </td><td><input type="password" name="password"></td></tr>

 
 
 
 <tr>
  <td colspan="2" align=center>
   <a href="javascript:Join.submit()">회원가입</a>
   <a href="javascript:Join.reset()">다시작성</a>
  </td>
 </tr>
 
</table>
</center>
</form>
</body>
</html>

