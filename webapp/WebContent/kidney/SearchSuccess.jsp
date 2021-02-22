<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto2.Customer"  %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 찾기 성공</title>
<style type="text/css">
#section {
	width: 500px;
	height: 400px;
	text-align: left;
	padding: 10px;
	position: abolute;
	margin: 0 auto;
	margin-top: 50px;
}


</style>

</head>
<body>
<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />

  <center>
		<p><h2>${subject} 찾기 완료</h2></p>
</center>
	<form method="post">
	<div id="section">
	
	<fieldset>
	<b>  다음 정보로 가입된 ${subject}를 찾았습니다.</b>
	<hr>
	<p><b>아 이 디</b>        ${search.id } </p>
	<p><b>이  름</b>          ${search.name } </p>
	<c:if test="${search.pw != null }">
	<p><b>비밀 번호</b>  ${search.pw }
	</c:if>
	<p><b>가 입 일</b>         ${search.indate } </p>
	
	</fieldset>

    <p>고객님의 ${subject} 찾기가 성공적으로 이루어졌습니다. 항상 고객님의 즐겁고 편리한 이용을 위해 최선의 노력을 다하겠습니다.</p>
    
    <center>
   <p> <input type="button" value="로그인" onclick="location.href='login.do'" style="width: 180px; height: 50px;"></p></center>

	</div>
	
	</form>


<jsp:include page="frame/Tail.jsp" />

</body>
</html>