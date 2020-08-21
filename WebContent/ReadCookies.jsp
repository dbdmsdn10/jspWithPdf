
<html>
<head>
<title>쿠키 데이터 읽기</title>
</head>
<body>

	<%
		String name = "";
	String gender = "";
	String age = "";

	for (Cookie cookie : request.getCookies()) {
		if (cookie.getName().equals("name")) {
			name = cookie.getValue();
		} else if (cookie.getName().equals("gender")) {
			gender = cookie.getValue();
		} else if (cookie.getName().equals("age")) {
			age = cookie.getValue();
		}
	}
	%>
	이름:<%=name%><br> 성별:<%=gender%><br> 나이:<%=age%><br><br>
	
	${cookie.name.value}<br>
	${cookie.gender.value}<br>
	${cookie.age.value}
	
	
	</body>
</body>
</html>