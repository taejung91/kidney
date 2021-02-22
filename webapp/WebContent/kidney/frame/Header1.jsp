<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header1</title>
<style type="text/css">

@import url('https://fonts.googleapis.com/css2?family=Grandstander:ital,wght@1,600&display=swap');


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
	width: 300px;
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

#header2 > ul{
display:none;
height: 120px;

}
#header2:hover >ul{
display:block;
}

#header2 > ul > li{
right: 90%;

}

#menu1 {
	position: absolute;
	width: 1080px;
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

#menu2 > ul{
display:none;
height: 150px;

}
#menu2:hover > ul{
display:block;
}

#menu2 > ul > li{
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
	margin-top: 100px;
	text-align:center;
}

#footer {
	background-color: #FFCC00;
	height: 100px;
	clear: both;
}

#title{
font-family: 'Grandstander', cursive; font-size: 60px;}

#title a{display: block;
	text-decoration: none;
	color: black;}
</style>
</head>
<body>


<form method="post" name="form">
	<div id="header">
	<p></p>
	<div id="title">
  <a href="index.do"> <center> KIDNEY BEAN </center></a></div>
		<c:choose>
			<c:when test="${loginInfo != null}">
				<ul id="header1">
					<li id="header2">${loginInfo.name}님<span><a href="logout.do">로그아웃</a></span></li>
					<input type="hidden" name="id" value="${loginInfo.id }">
					
					<li id="header2">마이페이지
						<ul>
							<li><a href="mypage.do?id=${loginInfo.id}">내 정보 </a></li>
							<li><a href="mypageadd.do?id=${loginInfo.id}">추가정보 </a></li>
							<li><a href="cartlist.do?id=${loginInfo.id}&page=1">장바구니</a></li>
							<li><a href="orderpage.do?page=1">예약내역</a></li>

						</ul>
					</li>
				</ul>
				</span>
			</c:when>
			<c:otherwise>
				<ul id="header1">
				
					<li id="header2"><a href="login.do">로그인</a></li>
					<li id="header2"><a href="create.do">회원가입</a></li>
					
					<li id="header2">마이페이지
						<ul>
							<li><a href="login.do">내 정보 </a></li>
							<li><a href="login.do">추가정보</a></li>
							<li><a href="login.do">장바구니</a></li>
							<li><a href="login.do">주문내역</a></li>
						</ul>
					</li>
				</ul>

			</c:otherwise>
		</c:choose>

	  
	
		<ul id="menu1">
		
	   

			<li id="menu2" >소식 
			   <ul>
			     <li><a href="information.do?kind=1&page=1">소식지</a> </li>
			   </ul>
			</li>


			<li id="menu2">신장질환 정보
			   <ul>
			      <li><a href="information.do?kind=2&page=1">질병 정보</a></li>
			      <li><a href="information.do?kind=3&page=1">운동 정보</a></li>
			      <li><a href="information.do?kind=4&page=1">식단정보</a></li>
			      
			   </ul>
		    </li>
		 	   
			<li id="menu2"><a href="cal_form.do?page=1&page2=1">식단 계산기</a></li>
			
 			 
			<li id="menu2"><a href="hospital.do?&page=1&search=">투석 병원 찾기</a></li>
			 
			 
			<li id="menu2">투석 투어 
			   <ul>
			      <li><a href="tour.do?kind=1&page=1">국내</a></li>
			      <li><a href="tour.do?kind=2&page=1">해외</a></li>
			      
			   </ul>
			 </li>
			   
			<li id="menu2">고객센터
			   <ul>
			      <li><a href="notice.do?kind=5&page=1">공지사항</a></li>
			      <li><a href="qnalist.do?page=1">1:1 문의</a></li>
			      
			   </ul>
			 </li>

		</ul>
	</div>


	<div id="main">
	
		<p>
			<a href="index.do"><img src="image/main/가로21.jpg" style="width:1280px; height:320px;"></a>
		</p>
		
	</div>



	<%--
		<c:choose>
			<c:when test="${loginUser != null}">
				<ul id="header1">
					<li id="header3">${loginUser.name}님 <span><a href="">로그아웃</a></span>
					<li id="header3"><a href="">마이페이지</a></li>
				</ul>
				</span>
			</c:when>
			<c:otherwise>
				<ul id="header1">
					<li id="header3"><a href="">로그인</a></li>
					<li id="header3"><a href="">회원가입</a></li>
					<li id="header3"><a href="">마이페이지</a></li>
				</ul>

			</c:otherwise>
		</c:choose> 
 --%>
</form>




</body>
</html>