<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>[게시판 글읽기]</h2>
	<div>[제목] ${vo.title}</div>
	<div>[작성일시] ${vo.wdate}</div>
	-----------------------------------------------------------
	<div>${vo.content}</div>
</body>
</html>