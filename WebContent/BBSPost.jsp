<%@ page import="java.io.*, java.util.Date" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setCharacterEncoding("UTF-8");// 이것과 아래것은 이 java에 있는것 출력할때
	response.setContentType("text/html; charset=UTF-8");
	request.setCharacterEncoding("UTF-8");// 이건 서버에 있는값을 가져올때 사용
	String name = request.getParameter("name");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	Date date=new Date();
	long time=date.getTime();
	String fileName=time+".txt";
	PrintWriter writer=null;
	try{
		String filePath=application.getRealPath("/WEB-INF/"+fileName);
		writer=new PrintWriter(filePath);
		writer.println("제목 "+title+"%n");
		writer.println("글쓴이 "+name+"%n");
		writer.println(content);
		out.println(filePath+"저장되었습니다.");
		writer.close();
		response.sendRedirect("BBSPostResult.jsp?result=success");
	}catch(Exception e){
		out.println("오류"+e.getMessage());
		response.sendRedirect("BBSPostResult.jsp?result=fail");
	}
	
	%>
</body>
</html>