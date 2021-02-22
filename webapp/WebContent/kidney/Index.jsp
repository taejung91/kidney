<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kidney</title>

<style type="text/css">
#section {
	width: 65%;
	text-align: left;
	float: left;
	padding: 10px;
}

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
	margin-left: 15px;
}

a {
	text-decoration: none;
	color: black;
}

#section3 {
	margin: 0 auto;
	padding: 50px;
	width: 1250px;
}

#section3::after {
	content: '';
	display: block;
	clear: both;
}

#section3 li {
	float: left;
	width: 300px;
	height: 300px;
}

section3 li+li {
	margin-left: 15px;
}
</style>
</head>
<body>
	<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />



	<div id="section">

		<table cellpadding="10" width="100%" id="info"  style="table-layout:fixed;">
		<tr>
		<td>소식</td>
		</tr>
		<tr align="right">
		<td><a href="information.do?kind=1&page=1"> 더 보기 </a></td>
		</tr>
		</table>
	
		<p>
		<ol id="section2">
			<c:forEach var="info" items="${infoList }">

				<li><a
					href="informationD.do?iseq=${info.iseq }&kind=${info.kind}&page=1"><img
						src="image/information/${info.image}" wihtd="250" height="250" />
						<p>${info.title }</p></a></li>

			</c:forEach>
		</ol>
		</p>
		<hr>
		
		<table cellpadding="10" width="100%" id="tour"  style="table-layout:fixed;">
		<tr>
		<td>투어</td>
		</tr>
		<tr align="right">
		<td><a href="tour.do?kind=1&page=1"> 더 보기 </a></td>
		</tr>
		</table>
		<p>
		<ol id="section3">
			<c:forEach var="tour" items="${productList }">

				<li><a
					href="tourdetail.do?pseq=${tour.pseq }&kind=1&page=1"><img
						src="image/tour/${tour.image}" width="250" height="250" />
						<p>${tour.name }</p></a></li>

			</c:forEach>
		</ol>
		</p>
		
		
		
		
		
</div>





	<jsp:include page="frame/Tail.jsp" />


</body>
</html>