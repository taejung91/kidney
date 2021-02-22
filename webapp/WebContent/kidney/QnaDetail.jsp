<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의하기</title>
<script type="text/javascript">


</script>
<style type="text/css">

   #info {text-align:center; margin: 0 auto;}
   #qna {text-align:left; margin: 0 auto; width:800px;}
   
</style>
</head>
<body>
	<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />
	
	<form method="post" name="form7">
	
	<center>
	<h1> 문의하기</h1>
	</center>
	<hr>
	<fieldset id="qna" align="center">
	<legend>1:1 문의하기</legend><p></p>
	제목
	<input type="text" name="subject" value="${qna.subject }"size="90" readonly >
	<p>등록일 <fmt:formatDate value="${qna.indate}" type="date"/></p>
	<p>문의 내용</p>
	<textarea name="content" rows="10" cols="100" readonly style="resize:none;">${qna.content } </textarea>
	<p></p>
	<p>답변 내용</p>
	<textarea name="reply" rows="10" cols="100" readonly style="resize:none;">${qna.reply }</textarea>
	<div id="buttons" style="margin-left:500px;">
	<p></p>
				<input type="button" value="목록" onclick="location.href='qnalist.do?page=${page}'">
				<input type="button" value="삭제하기" onclick="location.href='qnadelete.do?qseq=${qna.qseq}&page=${page}'">
				</div>
	
	
	</fieldset>
	

	</form>
	


	<jsp:include page="frame/Tail.jsp" />

</body>
</html>