<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의하기</title>
<script type="text/javascript">
function qna_insert(){
	   
	   document.form9.action = "qnainsert.do";
	   document.form9.submit();
	   
}

</script>
<style type="text/css">

   #info {text-align:center; margin: 0 auto;}
   #qna {text-align:left; margin: 0 auto; width:800px;}
   
</style>
</head>
<body>
	<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />
	
	<form method="post" name="form9">
	
	<center>
	<h1> 문의하기</h1>
	</center>
	<hr>
	<fieldset id="qna" align="center">
	<legend>1:1 문의하기</legend><p></p>
	제목
	<input type="text" name="subject" size="90">
	<p>내용</p>
	<textarea name="content" rows="10" cols="100" style="resize:none;"> </textarea>
	<p></p>
	<div id="buttons" style="margin-left:500px;">
	<p></p>
				<input type="button" value="확인" onclick="qna_insert()">
				<input type="reset" value="지우기" >
				<input type="button" value="취소" onclick="location.href='qnalist.do?page=${page}'">
				</div>
	<input type="hidden" name="page" value="${page }">
	
	</fieldset>
	

	</form>
	


	<jsp:include page="frame/Tail.jsp" />

</body>
</html>