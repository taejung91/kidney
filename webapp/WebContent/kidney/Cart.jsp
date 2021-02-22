<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<script>
</script>

<style type="text/css">

#list a {text-decoration:none; color:black;}
#list {text-align:center; margin: 0 auto;}

</style>
</head>
<body>

	<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />

	<form method="post" name="form6">
	
	<center>
			<h1>장바구니</h1>
		</center>
		<hr>


		<table border="1" cellpadding="20" width="65%"  id="list" style="table-layout: fixed; border-left: none; border-right: none;">
			<tr style="background: #FFF5EE">
				<td >
				상품명</td>
				<td width="100px">예약인원</td>
				<td width="100px">여행날짜</td>
				<td width="100px">상품금액</td>
				<td width="100px">예약하기</td>
				</tr>
				
				<c:forEach var="cart" items="${cartList }">
						<tr>
							<td><a href="tourdetail.do?kind=${cart.kind }&pseq=${cart.pseq}&page=${page}">${cart.pname }</a></td>
							<td>성인 : ${cart.quantity1} 명 <br>
							    아동 : ${cart.quantity2 } 명</td>
							    
							<td>${cart.s_schedule }</td>
							<td><fmt:formatNumber value="${(cart.price1 * cart.quantity1) + (cart.price2 * cart.quantity2)}"/> 원</td>
							<td><input type="button" value="예약하기" onclick="location.href='orderinsert.do?cseq=${cart.cseq }&pseq=${cart.pseq}&quantity1=${cart.quantity1 }&quantity2=${cart.quantity2}'" style="height: 30px; width:80px"><p></p>
							<input type="button" value="삭제" onclick="location.href='cartdelete.do?cseq=${cart.cseq}&page=${page }'"style="height: 30px; width:80px;">
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