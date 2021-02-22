<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="dto2.Address, java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�ּ� �˻�</title>
<script>
	function result(zipCode, sido, gugun, dong) { // �������� ������ ó�� �� �����͸� �Ѹ��� �˻��� ������ ���ý� �Լ��� �̵�
		
		
		opener.document.hosadd.address.value = sido + " " + gugun + " " + dong;
		self.close();

	}
</script>

</head>
<body>
	<form name=form method="post" action="adminaddress.do">
		<center>
			<h3>�ּ� �˻�</h3>

			<p style="font-size: 15px;">
				<b> �� �̸� </b> <input type='text' name='dong' size='15'> <input
					type='submit' value='ã��' class="submit">
		</center>
	</form>
	<center>
		<table id="zipcode">
			<tr>
				<th>�����ȣ</th>
				<th>�ּ�</th>

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