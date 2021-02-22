<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>병원</title>
<style type="text/css">


#section2 {
	text-align: center;
	margin: 0 auto;
}
</style>
</head>
<body>

	<jsp:include page="frame/AdminHeader1.jsp" />
	<form method="post" name="form13">


		<center>
			<h1>병원</h1>
		</center>
		<hr>
		<table id="section2" width="90%" cellpadding="10">
				<tr bgcolor="#FFF5EE">
					<td width="50">병원명</td> 
					<td width="50">주소</td>
					<td width="50">전화번호</td>
					<td width="50">학회인증</td>
					<td width="50">담당의</td>
					<td width="50">전문의</td>
					<td width="50">삭제</td>
				</tr>

				<c:forEach var="hos" items="${hosList}" varStatus="status">
					<tr>
					
					    <td><a href="adminhosdetail.do?no=${hos.no}&page=${page}">${hos.name }</a></td>
					    <td>${hos.address }</td>
					    <td>${hos.tel }</td>
					    <td>${hos.confirm }</td>
					    <td>${hos.doctor}</td>
					    <td>${hos.doctor_yn }</td>
					    
					<td><input type="button" value="삭제" onclick="location.href='adminhosdelete.do?no=${hos.no}&page=${page }'"> </td>
				
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
				<input type="button" value="병원 추가하기" onclick="location.href='adminhosadd.do?page=${page}'">
				</div>
			
			</form>

</body>
</html>