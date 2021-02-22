<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
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
			<h1>회원관리</h1>
		</center>
		<hr>
		<table id="section2" width="90%" cellpadding="10">
				<tr bgcolor="#FFF5EE">
					<td width="30">아이디 </td> 
					<td width="10">이름</td>
					<td width="20">생일</td>
					<td width="10">성별</td>
					<td width="20">전화번호</td>
					<td width="20">이메일주소</td>
					<td width="10">수신여부</td>
					<td width="80">주소</td>
					<td width="20">가입일</td>
					<td width="10">상태</td>
					<td width="10">탈퇴</td>
				</tr>

				<c:forEach var="customer" items="${CustomerList}" varStatus="status">
					<tr>
					    <td><a href="admincustomerdetail.do?id=${customer.id }&page=${page}">${customer.id }</a></td>
					   <td>
						${customer.name }
						</td>
					    <td>${customer.birth }</td>
					    <td>${customer.gender }</td>
					    <td>${customer.tel }</td>
					    <td>${customer.email}</td>
					    <td>${customer.receive }</td>
					    <td>${customer.add1} ${customer.add2 }</td>
					    <td><fmt:formatDate value="${customer.indate }" type="date" /></td>
					    <td>
						<c:choose>
						<c:when test="${customer.deleteyn =='사용중'}" ><span style="color:blue;">사용 중</span></c:when>
						<c:when test="${customer.deleteyn =='회원탈퇴'}"><span style="color:red;">회원 탈퇴</span> </c:when>
						</c:choose>
						</td>
					    <td><c:if test="${customer.deleteyn == '회원탈퇴'}"><input type="button" value="탈퇴" onclick="location.href='admincustomerdelete.do?id=${customer.id}&page=${page }'">  </c:if></td>
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
			<p></p>
			<center>
				<input type="button" value="계산기 초기화" onclick="location.href='admincalreset.do'">
				</center>
			</form>

</body>
</html>