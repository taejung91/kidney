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

	<form method="post" name="form8">


		<center>
			<h1>문의게시판</h1>
		</center>
		<hr>
		<table id="section2" width="65%" cellpadding="10">
				<tr bgcolor="#FFF5EE">
					<td width="15">번호</td>
					<td width="250">제목</td>
					<td width="50">작성일</td>
					<td width="50">답변 여부</td> 
				</tr>

				<c:forEach var="qna" items="${qnaList}" varStatus="status">
					<tr>
					    <td>${status.count }</td>
					    <td><a href="qnadetail.do?qseq=${qna.qseq }&page=${page}">${qna.subject }</a></td>
					<td><fmt:formatDate value="${qna.indate }" type="date" /></td>
					<td>
						<c:choose>
						<c:when test="${qna.rep =='1'}">답변 대기중 </c:when>
						<c:when test="${qna.rep == '2'}">답변 완료</c:when>
						</c:choose>
						</td>
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
				<input type="button" value="문의하기" onclick="location.href='qnainsert.do?page=${page}'">
				</div>
			</form>

		<jsp:include page="frame/Tail.jsp" />
</body>
</html>