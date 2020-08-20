<%@ page import="java.io.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
	BufferedReader reader=null;
	try{
		String filePath=application.getRealPath("/mettable.txt");
		reader=new BufferedReader(new FileReader(filePath));
		
		while(true){
			String str=reader.readLine();
			if(str==null){
				break;
			}
			out.println(str+"<br>");
		}
		reader.close();
	}catch(Exception e){
		out.println("오류"+e.getMessage());
	}
	%>
	
</body>
</html>