<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="dto2.Address, java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>주소 검색</title>
<script>
	function result(zipCode, sido, gugun, dong) { // 서블릿에서 데이터 처리 후 데이터를 뿌리고 검색된 정보를 선택시 함수로 이동
		
		
		opener.document.hosadd.address.value = sido + " " + gugun + " " + dong;
		self.close();

	}
</script>

</head>
<body>
	<form name=form method="post" action="adminaddress.do">
		<center>
			<h3>주소 검색</h3>

			<p style="font-size: 15px;">
				<b> 동 이름 </b> <input type='text' name='dong' size='15'> <input
					type='submit' value='찾기' class="submit">
		</center>
	</form>
	<center>
		<table id="zipcode">
			<tr>
				<th>우편번호</th>
				<th>주소</th>

				<c:if test="${addressList != null}">
					<c:forEach var="data" items="${addressList}">
						<tr>
							<td>${data.zipCode}</td>
							<td><a href="#"
								onclick="result('${data.zipCode}', '${data.sido}', '${data.gugun}', '${data.dong}')">
									${data.sido} ${data.gugun} ${data.dong}</a></td>
						</tr>
						</center>
					</c:forEach>
				</c:if>
			</tr>

		
</body>
</html>