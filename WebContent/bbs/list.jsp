<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>[게시판목록]</h2>
	<div>페이지:${page}/${totalPage}</div>
	<table border=1 width=700>
		<tr>
			<td>순번</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>작성시간</td>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr class="row">
				<td>${vo.seqno}</td>
				<td><a href="bbs.read?seqno=${vo.seqno}">${vo.title}</a></td>
				<td>${vo.writer}</td>
				<td><fmt:formatDate value="${vo.wdate}" pattern="yyyy-MM-dd" /></td>
				<td><fmt:formatDate value="${vo.wdate}" pattern="hh:mm:ss" /></td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${page==totalPage}">
		<a href="bbs.list?page=${page-1}">[이전]</a>
	</c:if>
	<c:if test="${page==1}">
		<a href="bbs.list?page=${page+1}">[다음]</a>
	</c:if>
	<c:if test="${page>1 && page<totalPage}">
		<a href="bbs.list?page=${page-1}">[이전]</a>
		<a href="bbs.list?page=${page+1}">[다음]</a>
	</c:if>
</body>
</html>