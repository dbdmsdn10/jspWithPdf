<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<%--<form name="frm" style="margin: 0px;">--%>
<form action="../user.login" method="post">
	<div>
		아 이 디 : <input type="text" name="id" size=10>
	</div>
	<div>
		비밀번호: <input type="password" name="password" size=10>
	</div>
	<div>
		<input type="submit" value="로그인"> <a
			href="/servletAndroid/user/insert.jsp" style="font-size: 12px;">회원가입</a>
	</div>
</form>
<script>
	$(frm).submit(function(e) {
		e.preventDefault();
		var id = $(frm.id).val();
		var password = $(frm.password).val();
		$.ajax({
			type : "post",
			url : "/user.login",
			data : {
				"id" : id,
				"password" : password
			},
			dataType : "json",
			success : function(data) {
				if (data.id == null) {
					alert("아이디 비밀번호가 일치하지 않습니다.");
				} else {
					location.href = "/index.jsp";
				}
			}
		});
	});
</script>