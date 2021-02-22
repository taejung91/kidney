<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 등록</title>
<style type="text/css">
input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}
</style>
<script>

</script>
</head>
<body>
<jsp:include page="frame/AdminHeader1.jsp" />

	<article>
		<center>
			<h2>정보 등록</h2>
		</center>

		<form name="info" method="post" enctype="multipart/form-data" action="admininfo.do">

			<hr>
			<center>
				<table id="add">
					<tr>
						<td><b>정보 제목</b> <input type="text" size="48" name="title"><br></td>
					</tr>
					<tr>
						<td><b>종 류
						<select name="kind">
						        <option value="1">소식지
								<option value="2">질병정보
								<option value="3">운동정보
								<option value="4">식단정보
								<option value="5">공지사항
						</select><br></td>
					</tr>
					<tr>
						<td><b>정 보 사 진</b> <input type="file" name="image"><br>
					<tr>
						<td><b>정 보 내 용</b><br> <textarea rows="10" cols="60" name="content" style="resize: none;"></textarea><br></td>
					</tr>
				</table>
				<p></p>

				<div id="buttons">
					<input type="reset" value="다시 작성">
					<input type="submit" value="등록"> 
					<input type="button" value="취소" onclick="location.href='admininfolist.do?page=1'">
				</div>
			</center>
		</form>
	</article>

</body>
</html>