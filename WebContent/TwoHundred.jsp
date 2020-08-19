<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int total = 0;
	for (int i = 0; i < 100; i++) {
		total += i;
	}
	%>
	1부터 100까지의 합=<%=total%><br> result의 값=<%=result()%><br> <br>
	
	날짜와시각<br>
	<%
		GregorianCalendar now = new GregorianCalendar();
	%>
	오늘의 날짜: <%=String.format("%TF", now)%><br>현재시각: <%=String.format("%TT", now)%><br>
</body>
</html>

<%!public int result() {
		int a = 0;
		for (int i = 0; i <= 10; i++) {
			a += i;
		}
		return a;
	}%>