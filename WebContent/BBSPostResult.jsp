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
		request.setCharacterEncoding("UTF-8");
		String str = request.getParameter("result");
		if (str.equals("success")) {
			out.println("str="+str+"저장성공");
		}
		else{
			out.println("str="+str+"저장실패");
		}
	%>
</body>
</html>