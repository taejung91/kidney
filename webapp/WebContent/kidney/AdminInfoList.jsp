<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보리스트</title>
<style type="text/css">


#section2 {
	text-align: center;
	margin: 0 auto;
}
</style>
</head>
<body>

	<jsp:include page="frame/AdminHeader1.jsp" />
	<form method="post" name="form10">


		<center>
			<h1>정보</h1>
		</center>
		<hr>
		<table id="section2" width="65%" cellpadding="10">
				<tr bgcolor="#FFF5EE">
					<td width="50">종 류</td> 
					<td width="250">제목</td>
					<td width="50">작성일</td>
					<td width="50">삭제</td>
					
				</tr>

				<c:forEach var="info" items="${infoList}" varStatus="status">
					<tr>
					   <td>
						<c:choose>
						<c:when test="${info.kind =='1'}">소식지 </c:when>
						<c:when test="${info.kind =='2'}">질병 정보 </c:when>
						<c:when test="${info.kind =='3'}">운동 정보 </c:when>
						<c:when test="${info.kind =='4'}">식단 정보 </c:when>
						<c:when test="${info.kind =='5'}">공지 사항 </c:when>
						</c:choose>
						</td>
					    
					    <td><a href="admininfodetail.do?iseq=${info.iseq }&kind=${info.kind }&page=${page}">${info.title }</a></td>
					<td><fmt:formatDate value="${info.indate }" type="date" /></td>
					<td><input type="button" value="삭제" onclick="location.href='amdininfodelete.do?iseq=${info.iseq}'"> </td>
				
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
				<input type="button" value="정보 추가하기" onclick="location.href='admininfo.do?page=${page}'">
				</div>
			
			</form>
			
			

</body>
</html>