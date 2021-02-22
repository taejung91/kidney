<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 상세</title>
<style type="text/css">


#section2 {
	text-align: center;
	margin: 0 auto;
}
</style>
</head>
<body>

	<jsp:include page="frame/AdminHeader1.jsp" />
	<form method="post" name="form12" action="adminorderdetail.do">


		<center>
			<h1>예약 상세</h1>
		</center>
		<hr>
		<table id="section2" width="90%" cellpadding="10">
				<tr bgcolor="#FFF5EE">
					<td width="50">아이디</td> 
					<td width="50">이름</td>
					<td width="50">전화번호</td>
					<td width="50">이메일주소</td>
					<td width="50">여행명</td>
					<td width="50">여행일정</td>
					<td width="50">인원</td>
					<td width="50">금액</td>
					<td width="50">예약신청일</td>
					<td width="50">예약상태</td>
				</tr>
					<tr>
					    <td>${order.id }</td>
					    <td>${order.cname }</td>
					    <td>${order.tel }</td>
					    <td>${order.email}</td>
					    <td>${order.pname}</td>
					    <td>${order.s_schedule}<br>
					        ${order.e_schedule}</td>
					    <td>성인 : ${order.quantity1 } 명<br>
					                  아동 : ${order.quantity2 } 명</td>
					     <td>성인 : <fmt:formatNumber value="${order.price1 * order.quantity1}"/> 원<br>
					                    아동 : <fmt:formatNumber value="${order.price2 * order.quantity2}"/> 원</td>
					    <td><fmt:formatDate value="${order.indate }" type="date" /></td>
					    <td><select name="result">
						<option value="1" <c:if test="${order.result == 1 }">selected</c:if>>예약 중</option>
						<option value="2" <c:if test="${order.result == 2 }">selected</c:if>>예약 완료</option>
						</select></td>
					</tr>
				
			</table>
			<p>
			
				<div id="buttons" style="margin-left:1040px;">
				<input type="submit" value="예약 변경">
				<input type="button" value="취소" onclick="location.href='adminorderlist.do?page=${page}' ">
				
				</div>
			</form>

</body>
</html>