<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정 보</title>
<style type="text/css">
ol {
	list-style: none;
	text-align: center;
}

#section2 {
	margin: 0 auto;
	padding: 50px;
	width: 1200px;
}

#section2::after {
	content: '';
	display: block;
	clear: both;
}

#section2 li {
	float: left;
	width: 300px;
	height: 300px;
}


section2 li+li {
	margin-left: 15xp;
}
#info a {text-decoration:none; color:black;}
#info {text-align:left; margin: 0 auto;}
#page {margin-top: -20%;}
</style>
</head>
<body>

	<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />

	<form method="post" name="form">


		<center>
			<h1>${menu }</h1>
		</center>
		<hr>
		<table cellpadding="10" width="50%" id="info" style="table-layout:fixed; ">
		<tr>
		<td><a href="information.do?kind=1&page=1"> ${menu2}</a></td>
		<td><a href="information.do?kind=2&page=1"> ${menu3}</a></td>
		<td><a href="information.do?kind=3&page=1"> ${menu4}</a></td>
		<td><a href="information.do?kind=4&page=1"> ${menu5}</a></td>
		
		</tr>
		</table>
		
		
		<hr>
		<p>
		<ol id="section2">
			<c:forEach var="info" items="${infoList }">

				<li><a href="informationD.do?iseq=${info.iseq }&kind=${info.kind}&page=${page}"><img src="image/information/${info.image}"
						width="250" height="250" />
					<p>${info.title }</p></a></li>

			</c:forEach>
		</ol>
		</p>
		<div id="page">
		<jsp:include page="frame/Paging2.jsp">
			   <jsp:param value="${paging.page}" name="page"/>
               <jsp:param value="${paging.beginPage}" name="beginPage"/>
               <jsp:param value="${paging.endPage}" name="endPage"/>
               <jsp:param value="${paging.prev}" name="prev"/>
               <jsp:param value="${paging.next}" name="next"/>
               <jsp:param value="${kind}" name="kind"/>
	    	</jsp:include>
		</div>

		<jsp:include page="frame/Tail.jsp" />
</body>
</html>