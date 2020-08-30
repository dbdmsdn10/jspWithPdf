<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>한빛미디어</title>
<link rel="stylesheet" href="home.css" />
</head>
<body>
	<div id="page">
		<div id="header">
			<h1>한빛 미디어</h1>
		</div>
		<div id="center">
			<div id="menu">
				<div class="item">
					<a href="/servletAndroid/index.jsp">회사소개</a>
				</div>
				<div class="item">
					<a href="../servletAndroid/book.list">책 정보</a>
				</div>
				<div class="item">
					<a href="../servletAndroid/bbs.insert">게시판 글쓰기</a>
				</div>
				<div class="item">
					<a href="../servletAndroid/bbs.list">게시판 긁읽기</a>
				</div>
			</div>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<c:if test="${id==null}">
				<div class="login"><jsp:include page="/user/login.jsp" /></div>
			</c:if>
			<c:if test="${id!=null}">
				<div class="logout">
					<div>안녕하세요! ${name}님</div>
					<button onClick="location.href='/servletAndroid/user.logout'">로그아웃</button>
				</div>
			</c:if>
			<div id="content">
				<!-- 여기에 출력할 내용 작성 시작 -->
				<h2>[회사소개]</h2>
				한빛미디어(주)는 지난 15년 동안 국내 컴퓨터/정보통신 분야의 성장과 더블어 IT 전문가들의 풍부한 실무경험과 현장
				노하우를 책으로 출간하면서 해당 분야의 IT 개발자들과 함께 발전해 왔습니다.
				<!-- 여기에 출력할 내용 작성 종료 -->
			</div>
		</div>
		<div id="footer">
			<h3>Copyright@ 1993-2020 한빛미디어(주)</h3>
		</div>
	</div>
</body>
</html>