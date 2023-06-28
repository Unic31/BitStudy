<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
.hello {
	color: orange;
	font-size: 15px;
}
</style>
</head>
<body>
	<h3 style="color: green;">Hello JSP!</h3>
	<script type="text/javascript">
		for (let i = 1; i <= 10; i++) {
			document.write("<b class='hello'>" + i + "</b>&nbsp;");

			//jps에서는 es6 literal사용시 변수값이 가져오는 $앞에 \ 붙인다
			//jsp에서는 $의 다른 기능이 있어서 \붙여야됨
			document.write(`<b class='hello'>\${i}</b>&nbsp;`);
		}
	</script>
	<%
	//이곳은 자바영역..scriptlet이라고 부른다;
	//이곳에서 선언하는 변수는 지역변수가 된다
	//선언 후 그 아래쪽에서만 사용 가능하다
	String name = "홍길동";
	int year = 2010;

	//브라우저로 출력시 out라는 내장 객체를 사용해도 된다(JspWriter)
	out.print("<h2>내 이름은 " + name + " 이고 " + year + " 년생 입니다1</h2>");
	%>
	<!-- 선언문의 변수나 메서드 호출은 위치가 상관없다 -->
	<%=getAssress()%><br>
	<%=address%><br>
	<%=MESSAGE%><br>
	<!-- 표현식을 이용해서 자바 영역의 변수 출력이 가능하다 -->
	<h2>
		내 이름은
		<%=name%>
		이고
		<%=year%>
		년생 입니다2
	</h2>

	<!-- 클래스 멤버변수나 메서드를 만들려면 선언문을 사용하여야 한다 -->
	<%!//이곳에서 선언한 변수나 메서드는 멤버로 구현한 것이므로
	//위치 상관없이 어드서든 호출이 가능하다
	final static String MESSAGE = "Bitcamp 701";
	String address = "강남구 역삼동";

	public String getAssress() {
		return "우리집은 " + address;
	}%>
</body>
</html>