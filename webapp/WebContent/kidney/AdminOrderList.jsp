<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 관리</title>
<style type="text/css">


#section2 {
	text-align: center;
	margin: 0 auto;
}
</style>
</head>
<body>

	<jsp:include page="frame/AdminHeader1.jsp" />
	<form method="post" name="form21">


		<center>
			<h1>예약 관리</h1>
		</center>
		<hr>
		<table id="section2" width="90%" cellpadding="10">
				<tr bgcolor="#FFF5EE">
					<td width="50">예약 번호</td> 
					<td width="50">아이디</td>
					<td width="50">예약자</td>
					<td width="100">여행명</td>
					<td width="50">여행일정</td>
					<td width="50">인원</td>
					<td width="50">총 금액</td>
					<td width="50">예약신청일</td>
					<td width="50">예약상태</td>
					<td width="50">취소</td>
				</tr>

				<c:forEach var="order" items="${orderList}" varStatus="status">
					<tr>
					   <td>
						<a href="adminorderdetail.do?oseq=${order.oseq}&page=${page}">${order.oseq }</a>
						</td>
					    
					    <td>${order.id }</td>
					    <td>${order.cname }</td>
					    <td>${order.pname }</td>
					    <td>${order.s_schedule }<br> ${order.e_schedule }</td>
					    <td>${order.quantity1 + order.quantity2 } 명</td>
					    <td><fmt:formatNumber value="${(order.price1 * order.quantity1) + (order.price2 * order.quantity2)}"/> 원</td>
					    <td><fmt:formatDate value="${order.indate }" type="date" /></td>
					    <td><c:choose>
						<c:when test="${order.result =='1'}"><span style="color:red;">예약 중</span> </c:when>
						<c:when test="${order.result =='2'}"><span style="color:blue;">예약 완료</span></c:when>
						</c:choose></td>
					    
					<td><input type="button" value="취소" onclick="location.href='adminorderdelete.do?oseq=${order.oseq}&page=${page }'"> </td>
				
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
			
			</form>

</body>
</html>