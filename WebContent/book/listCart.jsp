<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h2>[장바구니]</h2>
<table id="tbl" border=1 width=700>
	<tr>
		<td>코드</td>
		<td>제목</td>
		<td>단가</td>
		<td>수량</td>
		<td>금액</td>
	</tr>
	<c:forEach items="${listCart}" var="vo">
		<tr class="row">
			<td><a href="read?code=${vo.code}">${vo.code}</a></td>
			<td>${vo.title}</td>
			<td><fmt:formatNumber value="${vo.price}" pattern="#,###" /></td>
			<td><fmt:formatNumber value="${vo.number}" pattern="#,###" /></td>
			<td><fmt:formatNumber value="${vo.price * vo.number}"
					pattern="#,###" /></td>
		</tr>
	</c:forEach>
</table>