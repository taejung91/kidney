<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ page import="dto2.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인</title>

<script>
	function useID(form) {
		
		opener.document.create.check.value = "yes";
		opener.document.create.id.readOnly = true;
		self.close();
	}
	

	function repeat(form) {
		opener.document.create.id.value = "";
		window.close();
	}
</script>
<style type="text/css">
body {
	margin-top: 40px;
}
</style>
</head>
<body>

	<form name="frm2">
		<center>
			<c:choose>
				<c:when test="${check.id == null }">
                                                          사용 가능한 아이디입니다.
					<p><input type="button" value="확인" onclick="useID(this.form)"></p>
				</c:when>

				<c:otherwise>
                                                          이미 사용 중인 아이디 입니다.
					<p><input type="button" value="확인" onclick="repeat(this.form)"></p>
				</c:otherwise>
			</c:choose>
		</center>
	</form>


</body>
</html>