<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의</title>
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
			<h1>문의</h1>
		</center>
		<hr>
		<table id="section2" width="90%" cellpadding="10">
				<tr bgcolor="#FFF5EE">
					<td width="10">No</td> 
					<td width="100">제목</td>
					<td width="20">작성자</td>
					<td width="20">답변 상황</td>
					<td width="20">작성일</td>
				</tr>

				<c:forEach var="qna" items="${qnaList}" varStatus="status">
					<tr>
					    <td>${status.count }</td>
					    <td><a href="adminqnadetail.do?qseq=${qna.qseq}&page=${page}">${qna.subject }</a></td>
					    <td>${qna.id }</td>
					    <td>
						<c:choose>
						<c:when test="${qna.rep =='1'}" ><span style="color:red;">답변 대기 </span></c:when>
						<c:when test="${qna.rep =='2'}" ><span style="color:blue;">답변 완료</span> </c:when>
						</c:choose>
						</td>
					    <td><fmt:formatDate value="${qna.indate }" type="date" /></td>
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
				</div>
			
			</form>

</body>
</html>