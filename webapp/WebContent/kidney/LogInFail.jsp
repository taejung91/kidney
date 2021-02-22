<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패</title>
<style type="text/css">
#section {
	width: 500px;
	height: 400px;
	text-align: left;
	padding: 10px;
	position: abolute;
	margin: 0 auto;
	margin-top: 50px;
}


</style>

</head>
<body>

	<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />

	<center>
		<p>
		<h2>로그인 실패</h2>
		</p>
	</center>
	<form method="post">
		<div id="section">


			<fieldset>
				<b> 로그인 실패</b>
				<hr>
				아이디 또는 비밀번호를 확인 후 다시 로그인 해 주세요.
			</fieldset>

			<center>
				<p>
					<input type="button" value="확인" onclick="location.href='login.do'"
						style="width: 120px; height: 40px;">
				</p>
			</center>

		</div>
	</form>




	<jsp:include page="frame/Tail.jsp" />
</body>
</html>