<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style type="text/css">
#section {
	width: 200px;
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
		<h2>아이디 찾기</h2>
		</p>
	</center>

	<form action="searchid.do" method="post">

		<div id="section">
			<p>
				<input type="text" name="name" placeholder="이름">
			</p>

			<table>
				<tr>
					<td>전화 번호</td>
				</tr>
				<tr>
					<td><input type="text" name="tel1" maxlength="3" size="1">
						- <input type="text" name="tel2" maxlength="4" size="1"> -
						<input type="text" name="tel3" maxlength="4" size="1">
					</p></td>
				</tr>
			</table>



			<p>
				<input type="submit" value="확인" style="width: 175px">
			</p>



		</div>
	</form>



	<jsp:include page="frame/Tail.jsp" />



</body>
</html>