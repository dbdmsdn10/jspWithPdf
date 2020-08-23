<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean class="mall.PersonalInfo" id="pinfo" scope="request"/>
이름: <jsp:getProperty name="pinfo" property="name"/><br>
성별: <jsp:getProperty name="pinfo" property="gender"/><br>
나이: <jsp:getProperty name="pinfo" property="age"/><br>
</body>
</html>