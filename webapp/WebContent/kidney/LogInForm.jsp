<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
 #section {margin-top:100px; }

</style>
</head>
<body>
<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />


<div id="section">
	<center>
		<h2> 로그인</h2>
	
	<form action="login.do" method="post">
		<p><input type="text" name="id" placeholder="아이디"></p>
		<p><input type="password" name="pw" placeholder="비밀번호"> </p>
		<p><input type="submit" value="로그인" style="width:175px"></p>
		
	
		<p >
		<a href="searchid.do" style="text-decoration:none; color:black; font-size:11px;">아이디 찾기</a> | 
		<a href="searchpw.do" style="text-decoration:none; color:black; font-size:11px;"> 비밀번호 찾기</a> | 
		<a href="create.do" style="text-decoration:none; color:black; font-size:11px;"> 회원가입</a>
		</p>


	</form>
</center>



	<jsp:include page="frame/Tail.jsp" />

</div>

</body>
</html>