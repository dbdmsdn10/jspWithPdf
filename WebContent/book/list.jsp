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
	<h2>[도서목록]</h2>
	<div id="search">
		<form name="frm">
			<select name="key">
				<option value="code" <c:out value="${key=='code'?'selected':''}"/>>코드</option>
				<option value="title" <c:out value="${key=='title'?'selected':''}"/>>책제목</option>
				<option value="writer"
					<c:out value="${key=='writer'?'selected':''}"/>>책저자</option>
			</select> <input type="text" name="word" value="${word}"> <input
				type="submit" value="검색" id="btnSearch"> 검색수:
			<%
 	out.println(request.getAttribute("count"));
 %>
			<input type="hidden" name="page" value="${page}">
		</form>
	</div>
	<table border=1 width=700>
		<tr>
			<td width=100>코드</td>
			<td width=400>제목</td>
			<td width=100>저자</td>
			<td width=100>가격</td>
		</tr>
		<c:forEach var="vo" items="${list}">
			<tr class="row">
				<td><a href="book.read?code=${vo.code}">${vo.code}</a></td>
				<td>${vo.title}</td>
				<td>${vo.writer}</td>
				<td><fmt:formatNumber value="${vo.price}" pattern="#,###" /></td>
			</tr>

		</c:forEach>
	</table>
	<script>
		var totPage = "${totPage}";
		var page = "${page}";
		var count = "${count}";
		if (count == 0) {
			$("#pagination").hide();
		}
		if (page == 1) {
			$("#btnPre").attr("disabled", true);
		}
		if (page == totPage) {
			$("#btnNext").attr('disabled', true);
		}
		$("#btnPre").on("click", function() {
			page--;
			$(frm.page).val(page);
			$(frm).submit();
		});
		$("#btnNext").on("click", function() {
			page++;
			$(frm.page).val(page);
			$(frm).submit();
		});
		$("#btnSearch").on("click", function() {
			$(frm.page).val(1);
			$(frm).submit();
		})
	</script>
</body>
</html>