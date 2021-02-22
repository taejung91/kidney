<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 디테일</title>
<style type="text/css">

   #info {text-align:center; margin: 0 auto;}
</style>
</head>
<body>
	<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />
	
	<form method="post" name="form">
	
	<center>
	<h1> ${menu } </h1>
	</center>
	<hr>
	<table border="1" cellpadding="10" width="50%"  rules="rows" id="info" style="table-layout:fixed; border-left:none; border-right:none;">
	<tr>
	<td width="100px" style="background:#FFF5EE">제목</td> <td colspan="3" style="text-align:left">${info.title }</td>
	</tr>
	<tr>
	<td style="background:#FFF5EE" > 작성자 </td> <td colspan="3" style="text-align:left"> 관리자</td>
	</tr>
	<tr>
	 <td style="background:#FFF5EE">작성일</td> <td  colspan="3"  style="text-align:left"> ${info.indate }</td>
	 </tr>
	
	
	<tr>
	<td style="background:#FFF5EE"> 다운</td> <td colspan="3"  style="text-align:left"><a href="image/information/${info.content }"download>${info.content }</a></td>
	</tr>
	<tr>
	<td style="background:#FFF5EE"> 보기</td> <td colspan="3"  style="text-align:left"><a href="image/information/${info.content }">${info.content }</a></td>
	</tr> 
	</table>
	
	<p>
	<table border="1" cellpadding="10" width="50%"  rules="rows" id="info" style="table-layout:fixed;">
	<tr>
	<td>
	<img src="image/information/${info.image }"/>
	</td>
	</tr>
	</table>

	</p>
	<table width="50%" rules="rows" id="info" style="table-layout:fixed; text-align:left">
	<tr>
	<td>
	
	<input type="button" value="목록" onclick="location.href='information.do?kind=${info.kind}&page=${page}'"></p>
	</td>
	</tr>
	</table>
	
	</form>
	
	<table border="1"width="50%" rules="rows" id="info" style="table-layout:fixed; text-align:left">
	
	
	<%--
	
	<c:forEach var="infos" items="${infoList }" begin="0" end="0">
	<c:if test="${infos.iseq > info.iseq }"> 
	<tr>
	<td>▲ 다음 </td> <td><a href="informationD.do?iseq=${info.iseq + 1 }&kind=${info.kind}">링크</a></td>
	</tr>
	</c:if>
	</c:forEach>

	
	
	<c:if test="${0 < info.iseq }"> 
	<tr>
	<td>▼ 이전</td> <td><a href="informationD.do?iseq=${info.iseq - 1 }&kind=${info.kind}">링크</a> </td>
	</tr>
	</c:if>

	
	</table>
 --%>
	





	<jsp:include page="frame/Tail.jsp" />

</body>
</html>