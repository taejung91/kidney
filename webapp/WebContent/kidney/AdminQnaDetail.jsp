<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의</title>
<script type="text/javascript">


</script>
<style type="text/css">

   #info {text-align:center; margin: 0 auto;}
   #qna {text-align:left; margin: 0 auto; width:800px;}
   
</style>
</head>
<body>
	<jsp:include page="frame/AdminHeader1.jsp" />
	
	<form method="post" name="form20" action="adminqnadetail.do">
	
	<center>
	<h1> 문의 답변하기</h1>
	</center>
	<hr>
	<fieldset id="qna" align="center">
	<legend>답변하기</legend><p></p>
	제목
	<input type="text" name="subject" value="${qna.subject }"size="90" readonly >
	<p>등록일 <fmt:formatDate value="${qna.indate}" type="date"/></p>
	<p>작성자 ${qna.id }</p>
	<input type="hidden" value="${qna.qseq }">
	<p>문의 내용</p>
	<textarea name="content" rows="10" cols="100" readonly style="resize:none;">${qna.content } </textarea>
	<p></p>
	<p>답변 내용</p>
	<textarea name="reply" rows="10" cols="100" style="resize:none;">${qna.reply } </textarea>
	<div id="buttons" style="margin-left:500px;">
	<p></p>
	
				<input type="submit" value="확인">
				<input type="button" value="취소" onclick="location.href='adminqnalist.do?page=${page}'">
				</div>
	
	
	</fieldset>
	

	</form>
	



</body>
</html>