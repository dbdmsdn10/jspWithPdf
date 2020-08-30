<h2>[회원가입]</h2>
<form action="../servletAndroid/user.insert" method="post">
	<table border=1 width=500>
		<tr>
			<td width=100>아 이 디</td>
			<td><input type="text" name="id" size=10></td>
		</tr>
		<tr>
			<td width=100>비밀번호</td>
			<td><input type="password" name="password" size=10></td>
		</tr>
		<tr>
			<td width=100>회원성명</td>
			<td><input type="text" name="name" size=10></td>
		</tr>
	</table>
	<div id="btnMenu">
		<input type="submit" value="저장"><input type="reset" value="취소">
	</div>
</form>