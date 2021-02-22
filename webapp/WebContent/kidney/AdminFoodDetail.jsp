<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>푸드 상세</title>
<script>
 function nullCheck(){
	 
		//공백
		var empJ = /\s/g;
		//아이디 정규식
		var idJ = /^[a-z0-9]{4,16}$/;
		//숫자
		var tel = /^[0-9]{3,4}$/;
		var tel2J = /^[0-9]{4,4}$/;

		
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
	<form method="post" name="form12" action="admincaldetail.do">


		<center>
			<h1>푸드 상세</h1>
		</center>
		<hr>
		<table id="section2" width="65%" cellpadding="10">
				<tr bgcolor="#FFF5EE">
					<td width="50">종 류</td> 
					<td width="50">음식명</td>
					<td width="50">칼로리 kcal</td>
					<td width="50">나트륨 mg</td>
					<td width="50">단백질 g</td>
					<td width="50">칼륨 mg</td>
					<td width="50">인 mg</td>
					<td width="50">칼슘 mg</td>
					<td width="50">용량 g</td>
				</tr>

				
					<tr>
					   <td>
						<select name="kind">
						<option value="1" <c:if test="${food.kind == 1 }">selected</c:if>>음식</option>
						<option value="2" <c:if test="${food.kind == 2 }">selected</c:if>>식재료</option>
						<option value="3" <c:if test="${food.kind == 3 }">selected</c:if>>가공식품</option>
						</select></td>
					    
					    <td><input type="text" name="fname" value="${food.fname }" size="20"></td>
					    <td><input type="text" name="Kcal" value="${food.kcal }" size="5"></td>
					    <td><input type="text" name="Na" value="${food.na }" size="5"></td>
					    <td><input type="text" name="protein" value="${food.protein }" size="5"></td>
					    <td><input type="text" name="K" value="${food.k }" size="5"></td>
					    <td><input type="text" name="P" value="${food.p }" size="5"></td>
					    <td><input type="text" name="Ca" value="${food.ca }" size="5"></td>
					    <td><input type="text" name="capacity" value="${food.capacity }" size="5"></td>
					</tr>
				
			</table>
			<p>
				<div id="buttons" style="margin-left:1040px;">
				<input type="submit" value="변경하기">
				<input type="button" value="취소" onclick="location.href='admincallist.do?page=${page}'">
				</div>
			
			</form>

</body>
</html>