<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>[도서등록]</h2>
	<form action="insert" method="post">
		<table border=1 width=500>
			<tr>
				<td width=100>코드:</td>
				<td><input type="text" name="code"></td>
			</tr>
			<tr>
				<td width=100>제목:</td>
				<td><input type="text" name="title" size=50></td>
			</tr>
			<tr>
				<td width=100>저자:</td>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<td width=100>가격:</td>
				<td><input type="text" name="price"></td>
			</tr>
		</table>
		<div id="btnMenu">
			<input type="submit" value="저장"><input type="reset"
				value="취소">
		</div>
	</form>
</body>
</html>