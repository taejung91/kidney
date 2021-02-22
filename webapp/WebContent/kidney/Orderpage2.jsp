<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 주문 내역</title>
</head>
<body>


	<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />

	<form method="post" name="form6">
	
	<center>
			<h1>예약 내역</h1>
		</center>
		<hr>


		<table border="1" cellpadding="20" width="65%"  id="list" style="table-layout: fixed; border-left: none; border-right: none;">
			<tr style="background: #FFF5EE">
				<td width="100px">예약일</td>
				<td>상풍명</td>
				<td width="100px">결제금액</td>
				<td width="100px">인원</td>
				<td width="100px">출발일/귀국일</td>
				<td width="100px">예약상태</td>
				<td width="100px">상세보기</td>
				</tr>
				
				<c:forEach var="order" items="${orderList }">
						<tr>
						<td><fmt:formatDate value="${order.indate }" type="date" /></td>
							<td><a href="tourdetail.do?pseq=${order.pseq}&kind=${order.kind}&page=${page}">${order.pname }</a></td>
							<td><fmt:formatNumber value="${ (order.price1 * order.quantity1) + (order.price2 * order.quantity2) }" /> 원</td>
							</td>
							<td>성인 : ${order.quantity1} 명 <br>
							    아동 : ${order.quantity2 } 명</td>
							  
							<td>${order.s_schedule }<br>
							${order.e_schedule }</td>
							<td><c:choose>
							<c:when test='${order.result == "1"}'><span style="color: red;">  예약 중</span></c:when>
							<c:otherwise>
							<span style="color: blue;"> 예약완료</span>
							</c:otherwise>
							</c:choose></td>
							<td><input type="button" value="상세보기" onclick="location.href='orderdetail.do?odseq=${order.odseq }&pseq=${order.pseq}&quantity1=${order.quantity1 }&quantity2=${order.quantity2}&page=${page}'" >
							    <p></p>
							    <c:if test="${order.result == 1 }">
							     <input type="button" value="예약취소" onclick="location.href='orderdelete.do?oseq=${order.oseq}&page=${page}'" ></c:if>
							<input type="hidden" value="1" name="quantity1">
							<input type="hidden" value="0" name="quantity2">
							
							
							</td>
						</tr>
					</c:forEach></td>
			</tr>
			
			</table>
			
				   <jsp:include page="frame/Paging.jsp">
			   <jsp:param value="${paging.page}" name="page"/>
               <jsp:param value="${paging.beginPage}" name="beginPage"/>
               <jsp:param value="${paging.endPage}" name="endPage"/>
               <jsp:param value="${paging.prev}" name="prev"/>
               <jsp:param value="${paging.next}" name="next"/>
	    	</jsp:include>
			
	</form>

	<jsp:include page="frame/Tail.jsp" />

</body>
</html>