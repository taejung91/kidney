<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투어</title>
<style type="text/css">
ol {
	list-style: none;
	text-align: center;
}

#section2 {
	margin: 0 auto;
	padding: 50px;
	width: 1250px;
}

#section2::after {
	content: '';
	display: block;
	clear: both;
}

#section2 li {
	float: left;
	width: 300px;
	height: 400px;
}


section2 li+li {
	margin-left: 15xp;
}
a {text-decoration:none; color:black;}
#tour {text-align:left; margin: 0 auto;}
#page {text-align:center; margin-top: -100px;}
</style>
</head>
<body>

	<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />

	<form method="post" name="form">


		<center>
			<h1>투어</h1>
		</center>
		<hr>
		<table cellpadding="10" width="50%" id="tour" style="table-layout:fixed; ">
		<tr>
		<td><a href="tour.do?kind=1&page=1"> 국내</a></td>
		<td><a href="tour.do?kind=2&page=1"> 해외</a></td>
		
		</tr>
		</table>
		
		
		<hr>
		<p>
		<ol id="section2">
		
			<c:forEach var="product" items="${productList }">
			

				<li><a href="tourdetail.do?pseq=${product.pseq }&kind=${kind }&page=${page}"><img src="image/tour/${product.image}" width="280" height="250"/>
					<p style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${product.name }</p>
					<p style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${product.content }</p>
					<p><fmt:formatNumber value="${product.price1}"/> 원</p>
					</a></li>
				
			</c:forEach> 
			
		</ol>
		</p>
		<div id="page">		<jsp:include page="frame/Paging2.jsp">
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