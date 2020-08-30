<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>[게시판 글쓰기]</h2>
	<form action="../servletAndroid/bbs.insert" method="post">
		<c:if test="${id==null}">
			<input type="hidden" name="writer" value="guest">
		</c:if>
		<c:if test="${id!=null}">
			<input type="hidden" name="writer" value="${id}">
		</c:if>
		
		
		<table border=1 width=500>
			<tr>
				<td width=100>제목</td>
				<td><input type="text" name="title" size=54></td>
			</tr>
			<tr>
				<td colspan=2><textarea rows="10" cols="70" name="content"></textarea></td><
			</tr>
		</table>
		<div id="btnMenu">
			<input type="submit" value="저장"> <input type="reset"
				value="취소">
		</div>
	</form>

</body>
</html>