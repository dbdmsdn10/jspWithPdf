<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.num==0}">
		처음뵙겠습니다.<br>
		</c:when>
		<c:when test="${param.num==1}">
		반갑습니다<br>
		</c:when>
		<c:otherwise>
		안녕하세요<br>
		</c:otherwise>
	</c:choose>

	<c:forEach var="cnt" begin="1" end="5">
		<font size=${cnt}>야호<br></font>
	</c:forEach>
	<br>
	<br>

	<h3>오늘 점심메뉴입니다</h3>
	<ul>
		<c:forEach var="dish" items="${menu}">
		<li>${dish}</li>
</c:forEach>
	</ul>

</body>
</html>