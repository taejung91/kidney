<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">


#section2 {
	text-align: center;
	margin: 0 auto;
}
</style>
</head>
<body>

	<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />

	<form method="post" name="form">


		<center>
			<h1>${menu}</h1>
		</center>
		<hr>
		<table id="section2" width="65%" cellpadding="10">
				<tr bgcolor="#FFF5EE">
					<td width="15">번호</td>
					<td width="250">제목</td>
					<td width="50">작성일</td>
				</tr>

				<c:forEach var="notice" items="${infoList}" varStatus="status">
					<tr>
					    <td>${status.count }</td>
					    <td><a href="noticedetail.do?iseq=${notice.iseq }&kind=${notice.kind}&page=${page}">${notice.title }</a></td>
					<td><fmt:formatDate value="${notice.indate }" type="date" /></td>
					</tr>
					
				</c:forEach>

			</table>
				<jsp:include page="frame/Paging2.jsp">
			   <jsp:param value="${paging.page}" name="page"/>
               <jsp:param value="${paging.beginPage}" name="beginPage"/>
               <jsp:param value="${paging.endPage}" name="endPage"/>
               <jsp:param value="${paging.prev}" name="prev"/>
               <jsp:param value="${paging.next}" name="next"/>
                   <jsp:param value="${kind}" name="kind"/>
	    	</jsp:include>
			</form>

		<jsp:include page="frame/Tail.jsp" />
</body>
</html>