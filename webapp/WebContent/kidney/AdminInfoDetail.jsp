<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 디테일</title>
<script type="text/javascript">


</script>
<style type="text/css">

   #info {text-align:center; margin: 0 auto;}
   #qna {text-align:left; margin: 0 auto; width:800px;}
   
</style>
</head>
<body>
<jsp:include page="frame/AdminHeader1.jsp" />

	<form method="post" name="form">
	
	<center>
	<h1> 정보</h1>
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
	<img alt="" src="image/information/${info.image }">
	</td>
	</tr>
	
	</table>

	</p>
	<table width="50%" rules="rows" id="info" style="table-layout:fixed; text-align:left">
	<tr>
	<td>
	
	<input type="button" value="목록" onclick="location.href='admininfolist.do?page=${page}'"></p>
	</td>
	</tr>
	</table>
	
	</form>


</body>
</html>