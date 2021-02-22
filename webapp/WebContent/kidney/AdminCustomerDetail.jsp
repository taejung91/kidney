<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 상세</title>
<style type="text/css">


#section2 {
	text-align: center;
	margin: 0 auto;
}
</style>
</head>
<body>

	<jsp:include page="frame/AdminHeader1.jsp" />
	<form method="post" name="form12" action="admincaldetail.do">


		<center>
			<h1>고객 상세</h1>
		</center>
		<hr>
		<table id="section2" width="90%" cellpadding="10">
				<tr bgcolor="#FFF5EE">
					<td width="50">아이디</td> 
					<td width="50">키</td>
					<td width="50">몸무게</td>
					<td width="50">표준체종</td>
					<td width="50">칼로리</td>
					<td width="50">나트륨</td>
					<td width="50">단백질</td>
					<td width="50">칼륨</td>
					<td width="50">인</td>
					<td width="50">칼슘</td>
				</tr>
					<tr>
					    <td>${customerData.id }</td>
					    <td>${customerData.height } cm</td>
					    <td>${customerData.weight } kg</td>
					    <td>${customerData.s_weight } kg</td>
					    <td>${customerData.kcal } kcal</td>
					    <td>${customerData.na } mg</td>
					    <td>${customerData.protein } g</td>
					    <td>${customerData.k } mg</td>
					    <td>${customerData.p } mg</td>
					    <td>${customerData.ca } mg</td>
					</tr>
				
			</table>
			<p>
			
				<div id="buttons" style="margin-left:1040px;">
				<input type="button" value="확인" onclick="location.href='admincustomerlist.do?page=${page}'">
				</div>
			</form>

</body>
</html>