<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="date" value="<%=new Date()%>"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="greeting" value="How Are You?"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
[오늘날짜] <fmt:formatDate value="${date}"/><br>
[지금 시각] <fmt:formatDate value="${date}" type="time"/>

<br><br><br>
[S]<fmt:formatDate value="${date}" type="both" dateStyle="short" timeStyle="short"/><br>
 [M]<fmt:formatDate value="${date}" type="both" dateStyle="medium" timeStyle="medium"/><br>
 [L]<fmt:formatDate value="${date}" type="both" dateStyle="long" timeStyle="long"/><br>
 [F]<fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full"/>
<br><br><br>
[오늘의 날짜]<fmt:formatDate value="${date}" type="date" pattern="yyyy/MM/dd (E)"/><br>
 [현재의 시각]<fmt:formatDate value="${date}" type="time" pattern="(a) hh:mm:ss"/>


<br><br>
첫 번째 수:<fmt:formatNumber value="1234500" groupingUsed="true"/><br>
 두 번째 수:<fmt:formatNumber value="3.14158" pattern="#.##"/><br>
 세 번째 수:<fmt:formatNumber value="10.5" pattern="#.00"/><br>
 네 번째 수:<fmt:formatNumber value="1234500" pattern="#,###"/>
 
 <br><br><br>
 금액: <fmt:formatNumber value="1000000" type="currency" currencySymbol="￦"/><br>
 퍼센트: <fmt:formatNumber value="0.99" type="percent"/>
 
 <br><br><br>
 본래의문자열: ${greeting} <br>
 모두대문자로: ${fn:toUpperCase(greeting)} <br>
 모두소문자로: ${fn:toLowerCase(greeting)} <br>
 Are의 위치는? ${fn:indexOf(greeting, "Are")} <br>
 Are를 Were로 바꾸면? ${fn:replace(greeting, "Are ", "Were")} <br>
 문자열의 길이는? ${fn:length(greeting)} <br>
 
</body>
</html>