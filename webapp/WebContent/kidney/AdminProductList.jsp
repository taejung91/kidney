<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품</title>
<style type="text/css">


#section2 {
	text-align: center;
	margin: 0 auto;
}
</style>
</head>
<body>

	<jsp:include page="frame/AdminHeader1.jsp" />
	<form method="post" name="form16">


		<center>
			<h1>여행</h1>
		</center>
		<hr>
		<table id="section2" width="90%" cellpadding="10">
				<tr bgcolor="#FFF5EE">
					<td width="100">여행명</td> 
					<td width="30">종류</td>
					<td width="30">성인요금</td>
					<td width="30">아동요금</td>
					<td width="30">인원</td>
					<td width="30">숙박일</td>
					<td width="30">여행시작일</td>
					<td width="30">여행종료일</td>
					<td width="50">경로</td>
					<td width="30">등록일</td>
					<td width="30">삭제</td>
					
				</tr>

				<c:forEach var="tour" items="${productList}" varStatus="status">
					<tr>
					    <td><a href="adminproductdetail.do?pseq=${tour.pseq}&page=${page}">${tour.name }</a></td>
					    <td><c:choose>
						<c:when test="${tour.kind =='1'}">국내 </c:when>
						<c:when test="${tour.kind =='2'}">해외</c:when>
						</c:choose></td>
					    <td><fmt:formatNumber value="${tour.price1}"/> 원</td>
					    <td><fmt:formatNumber value="${tour.price2}"/> 원</td>
					    <td>${tour.quantity} 명</td>
					    <td>${tour.schedule }</td>
					    <td>${tour.s_schedule}</td>
					    <td>${tour.e_schedule}</td>
					    <td>${tour.route}</td>
					    <td><fmt:formatDate value="${tour.indate }" type="date" /></td>
					    
					<td><input type="button" value="삭제" onclick="location.href='adminproductdelete.do?pseq=${tour.pseq}&page=${page }'"> </td>
				
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
				<input type="button" value="여행 추가하기" onclick="location.href='adminpadd.do?page=${page}'">
				</div>
			
			</form>

</body>
</html>