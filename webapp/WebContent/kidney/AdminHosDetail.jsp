<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>병원 상세</title>
<script>
function post() {
	var url = "adminaddress.do";
	window.open(url,'post','width=400, height=400, top=300, left=300, toolbar=no, menubar=no, scrollbars=yes, resizable=no');
}

</script>
<style type="text/css">


#section2 {
	text-align: center;
	margin: 0 auto;
}
</style>
</head>
<body>

	<jsp:include page="frame/AdminHeader1.jsp" />
	<form method="post" name="form14" action="adminhosdetail.do">


		<center>
			<h1>병원 상세</h1>
		</center>
		<hr>
		<table id="section2" width="65%" cellpadding="10">
				<tr bgcolor="#FFF5EE">
					<td width="50">병원명</td>
					<td width="50">주소</td>
					<td width="50">전화번호</td>
					<td width="50">학회인증</td>
					<td width="50">담당의</td>
					<td width="50">전문의</td>
				</tr>

				
					<tr>
					    <td><input type="text" name="name" value="${hosDetail.name }" size="40"></td>
					    <td><input type="text" name="address" value="${hosDetail.address }" size="60"></td>
					
					    <td><input type="text" name="tel" value="${hosDetail.tel }" size="10"></td>
					     <td>
						<select name="confirm">
						<option value="O" <c:if test="${hosDetail.confirm == 'O' }">selected</c:if>>O</option>
						<option value="X" <c:if test="${hosDetail.confirm == 'X' }">selected</c:if>>X</option>
						</select></td>
					    
					    <td><input type="text" name="doctor" value="${hosDetail.doctor }" size="50"></td>
					    <td><input type="text" name="doctor_yn" value="${hosDetail.doctor_yn}" size="10"></td>
					</tr>
				
			</table>
			<p>
				<div id="buttons" style="margin-left:1040px;">
				<input type="submit" value="변경하기">
				<input type="button" value="취소" onclick="location.href='adminhoslist.do?page=${page}'">
				</div>
			
			</form>

</body>
</html>