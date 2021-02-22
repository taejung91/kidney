<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기 푸드</title>
<style type="text/css">


#section2 {
	text-align: center;
	margin: 0 auto;
}
</style>
</head>
<body>

	<jsp:include page="frame/AdminHeader1.jsp" />
	<form method="post" name="form11">


		<center>
			<h1>계산기 푸드</h1>
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
					<td width="50">삭제</td>
				</tr>

				<c:forEach var="food" items="${foodList}" varStatus="status">
					<tr>
					   <td>
						<c:choose>
						<c:when test="${food.kind =='1'}">음식 </c:when>
						<c:when test="${food.kind =='2'}">식재료 </c:when>
						<c:when test="${food.kind =='3'}">가공 식품 </c:when>
						</c:choose>
						</td>
					    
					    <td><a href="admincaldetail.do?fseq=${food.fseq }&page=${page}">${food.fname }</a></td>
					    <td>${food.kcal }</td>
					    <td>${food.na }</td>
					    <td>${food.protein }</td>
					    <td>${food.k }</td>
					    <td>${food.p }</td>
					    <td>${food.ca }</td>
					    <td>${food.capacity }</td>
					    
					<td><input type="button" value="삭제" onclick="location.href='admincaldelete.do?fseq=${food.fseq}&page=${page}'"> </td>
				
					</tr>
				</c:forEach>
			</table>
			
				<jsp:include page="frame/Paging.jsp">
			   <jsp:param value="${paging.page}" name="page"/>
               <jsp:param value="${paging.beginPage}" name="beginPage"/>
               <jsp:param value="${paging.endPage}" name="endPage"/>
               <jsp:param value="${paging.prev}" name="prev"/>
               <jsp:param value="${paging.next}" name="next"/>
	    	</jsp:include>
			
			<p>
				<div id="buttons" style="margin-left:1040px;">
				<input type="button" value="음식 추가하기" onclick="location.href='admincaladd.do?page=${page}'">
				</div>
			</form>
			
			

</body>
</html>