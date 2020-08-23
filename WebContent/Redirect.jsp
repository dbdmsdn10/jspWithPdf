<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<--
<c:url var="next" value="Divide.jsp">
	<c:param name="num1" value="100" />
	<c:param name="num2" value="25" />
</c:url>
<c:redirect url="${next}" />
-->
<h3>FONT 태그에 대하여</h3>
<c:out value="<font size=7>커다란 글씨</font>는 다음과 같은 출력을 합니다." />
<br>
<br>
<c:out value="<font size=7>커다란 글씨</font>" escapeXml="false" />

<br>
<br>
안녕하세요,
<c:out value="${param.ID}" default="guest" />
님
