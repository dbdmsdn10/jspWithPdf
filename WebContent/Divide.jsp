<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
 String str1 = request.getParameter("num1");
 String str2 = request.getParameter("num2");
 int num1 = Integer.parseInt(str1);
 int num2 = Integer.parseInt(str2);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:catch var="e">
 <% int result = num1 / num2; %>
 나눗셈의 결과는? <%= result%>
 </c:catch>
 <c:if test="${e != null}">에러 메시지: ${e.message}</c:if>
</body>
</html>