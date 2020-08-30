<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>[도서수정]</h2>
	<form action="book.update" method="post">
		<table border=1 width=500>
			<tr>
				<td width=100>코드:</td>
				<td><input type="text" name="code" value="${vo.code}"></td>
			</tr>
			<tr>
				<td width=100>제목:</td>
				<td><input type="text" name="title" value="${vo.title}" size=50></td>
			</tr>
			<tr>
				<td width=100>저자:</td>
				<td><input type="text" name="writer" value="${vo.writer}"></td>
			</tr>
			<tr>
				<td width=100>가격:</td>
				<td><input type="text" name="price" value="${vo.price}"></td>
			</tr>
		</table>
		<div id="btnMenu">
			<input type="submit" value="저장"> <input type="button"
				value="삭제" onClick="location.href='book.delete?code=${vo.code}'">
			<input type="button" value="목록" onClick="location.href='book.list'">
			<input type="reset" value="취소">
		</div>
	</form>
</body>
</html>