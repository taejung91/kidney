<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>병원 등록</title>
<script>
function post() {
	var url = "adminaddress.do";
	window.open(url,'post','width=400, height=400, top=300, left=300, toolbar=no, menubar=no, scrollbars=yes, resizable=no');
}

function hos_add(){
	
	document.hosadd.action = "adminhosadd.do";
	document.hosadd.submit();
	
	
}

</script>

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
			<h2>병원 등록</h2>
		</center>

		<form name="hosadd" method="post">

			<hr>
			<center>
				<table>
					<tr>
						<td><b>병원명</b> <input type="text" name="name"><br></td>
					</tr>
								
					<tr>
						<td><b>주소</b> <input type="text" name="address" size="30">
					</tr>
					<tr>
						<td><b>전화번호</b> <input type="text" name="tel" size="10"><br></td>
					</tr>
					<tr>
						<td><b>학회인증</b>
						 <select name="confirm">
						        <option value="O">O
								<option value="X">X
						</select><br></td>
					</tr>
					<tr>
						<td><b>담당의</b> <input type="text" name="doctor" size="10"><br></td>
					</tr>
					<tr>
						<td><b>전문의</b> <input type="text" name="doctor_yn" size="10"><br></td>
					</tr>
				</table>
				
				<p></p>
				<input type="hidden" value="${page }"></center>
		</form>
             <center>
				<div id="buttons">
					<input type="reset" value="다시 작성">
					<input type="submit" value="등록"> 
					<input type="button" value="취소" onclick="location.href='adminhoslist.do?page=${page}'">
				</div>
			</center>
	</article>

</body>
</html>