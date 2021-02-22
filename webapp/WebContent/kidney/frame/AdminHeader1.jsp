<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지</title>
<style type="text/css">
body {
	font: 14px "굴림", Gulim;
	font-weight: bold;
}

#header {
	position: fixed;
	height: 150px;
	background-color: #FFF5EE;
	font-size: 12px;
	top: 0;
	left: 0;
	right: 0;
}

#header1 {
	position: absolute;
	width: 200px;
	right: 5%;
	top: 5px;
}

#header1 li {
	margin-top: 1px;
	float: left;
	list-style: none;
	position: relative;
	width: 85px;
	height: 30px;
	line-height: 30px;
	margin-right: 5px;
	text-align: center;
	background: #F5EBE4;
}

span:hover {
	text-decoration: underline;
	color: black;
}

#header2>ul {
	display: none;
	height: 120px;
}

#header2:hover>ul {
	display: block;
}

#header2>ul>li {
	right: 90%;
}

#menu1 {
	position: absolute;
	width: 1500px;
	left: 50%;
	margin-left: -600px;
	top: 50px;
}

#menu1 li {
	margin-top: 10px;
	float: left;
	list-style: none;
	position: relative;
	width: 120px;
	height: 40px;
	line-height: 40px;
	margin-right: 60px;
	text-align: center;
	background: #F5EBE4;
}

#menu2>ul {
	display: none;
	height: 150px;
}

#menu2:hover>ul {
	display: block;
}

#menu2>ul>li {
	right: 50%;
}

li:last-child {
	margin-right: 0;
}

li a {
	display: block;
	text-decoration: none;
	color: black;
}

#main {
	margin-top: 200px;
	text-align: center;
}

#footer {
	background-color: #FFCC00;
	height: 100px;
	clear: both;
}

#header a {
	display: block;
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>


	<form method="post" name="form">
		<div id="header">
		<center><p style="font-size:25px;" ><a href="adminindex.do">관리자 페이지</a></p></center>
                         
		         <ul id="header1">
					<li id="header2">${loginInfo.name}님<span><a href="logout.do">로그아웃</a></span></li>
					<input type="hidden" name="id" value="${loginInfo.id }">
	</ul>
		<ul id="menu1">

			<li id="menu2"><a href="admininfolist.do?page=1">정보 등록 </a></li>
			<li id="menu2"><a href="admincallist.do?page=1">계산기 DB등록</a></li>
			<li id="menu2"><a href="adminhoslist.do?page=1">병원 DB등록</a></li>
			<li id="menu2"><a href="adminproductlist.do?page=1">여행 등록</a></li>
			<li id="menu2"><a href="adminorderlist.do?page=1">예약 관리</a></li>
			<li id="menu2"><a href="admincustomerlist.do?page=1">회원 관리</a></li>
			<li id="menu2"><a href="adminqnalist.do?page=1">문의 관리</a></li>
			
			 </ul>
			 </div>
			 
			 <div id="main">
	
		<p>
		</p>
		
	</div>




</body>
</html>