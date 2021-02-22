<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto2.Customer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정 보</title>
<script>
	function post() {
		var url = "address.do";
		window
				.open(
						url,
						'post',
						'width=400, height=400, top=300, left=300, toolbar=no, menubar=no, scrollbars=yes, resizable=no');
	}

	function nullCheck33() {
		var tel2 = create.tel2.value;
		var tel3 = create.tel3.value;
		var email = create.email.value;

		//공백
		var empJ = /\s/g;

		// 이메일 검사 정규식
		var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		// 전화번호 검사 정규식
		var tel = /^[0-9]{3,4}$/;
		var tel2J = /^[0-9]{4,4}$/;
		if (tel2 == "") {
			alert("전화번호를 입력해주세요.");
			create.tel2.focus();
			return false;
		} else if (tel.test(tel2) == false || empJ.test(tel2) == true) {
			alert("전화번호를 정확히 입력해주세요.");
			create.tel2.focus();
			return false;
		} else if (tel3 == "") {
			alert("전화번호를 입력해주세요.");
			create.tel3.focus();
			return false;

		} else if (tel2J.test(tel3) == false || empJ.test(tel3) == true) {
			alert("전화번호를 정확히 입력해주세요.");
			createe.tel3.focus();
			return false;
		} else if (email != "") {
			if (mailJ.test(email) == false || empJ.test(email) == true) {

				alert("이메일 양식을 정확히 입력해주세요.");
				create.email.focus();
				return false;
			}

			document.create.action = "mypage.do";
			document.create.submit();
			alert("정보수정이 완료되었습니다");
			return true;

		
	}
		document.create.action = "mypage.do";
		document.create.submit();
		alert("정보수정이 완료되었습니다");
	
	}
</script>

<style type="text/css">
#section {
	width: 400px;
	height: 600px;
	text-align: left;
	padding: 10px;
	position: abolute;
	margin: 0 auto;
}

#section2 {
	width: 800px;
	height: 700px;
	text-align: left;
	padding: 10px;
	position: abolute;
	margin: 0 auto;
}
</style>
</head>
<body>

	<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />

	<form method="post" name="create">


		<div id="section">
			<center>
				<p style="font-size: 20px;">
					<b>내 정 보</b>
				</p>
			</center>

			<table>

				<td>아이디</td>
				</tr>
				<tr>
					<td><input type="text" name="id" size="15"
						value="${mypage.id }" readonly></td>

				</tr>

				<tr>
					<td>이름</td>
				</tr>
				<tr>
					<td><input type="text" name="name" size="15"
						value="${mypage.name }" readonly></td>
				</tr>
				<tr>
					<td>생년월일</td>
				</tr>
				<tr>
					<td><input type="date" name="birth" value="${mypage.birth }"></td>
				</tr>

				<tr>
					<td>성별</td>
				</tr>
				<tr>
					<td><input type="radio" name="gender" value="남자"
						<c:if test="${mypage.gender == '남자'}">checked  </c:if>> 남자
						<input type="radio" name="gender" value="여자"
						<c:if test="${mypage.gender == '여자'}">checked  </c:if>>여자</td>
				</tr>


				<tr>
					<td>전화번호</td>
				</tr>
				<tr>
					<td><c:forTokens var="tel1" items="${mypage.tel}" delims="-"
							begin="0" end="0">

							<select name="tel1">
								<option value="010" <c:if test="${tel1 == 010}">selected </c:if>>010</option>
								<option value="02" <c:if test="${tel1 == 02}">selected </c:if>>02</option>
								<option value="031" <c:if test="${tel1 == 031}">selected </c:if>>031</option>
								<option value="032" <c:if test="${tel1 == 032}">selected </c:if>>032</option>
								<option value="033" <c:if test="${tel1 == 033}">selected </c:if>>033</option>
								<option value="041" <c:if test="${tel1 == 041}">selected </c:if>>041</option>
								<option value="042" <c:if test="${tel1 == 042}">selected </c:if>>042</option>
								<option value="043" <c:if test="${tel1 == 043}">selected </c:if>>043</option>
								<option value="044" <c:if test="${tel1 == 044}">selected </c:if>>044</option>
								<option value="051" <c:if test="${tel1 == 051}">selected </c:if>>051</option>
								<option value="052" <c:if test="${tel1 == 052}">selected </c:if>>052</option>
								<option value="053" <c:if test="${tel1 == 053}">selected </c:if>>053</option>
								<option value="054" <c:if test="${tel1 == 054}">selected </c:if>>054</option>
								<option value="055" <c:if test="${tel1 == 055}">selected </c:if>>055</option>
								<option value="061" <c:if test="${tel1 == 061}">selected </c:if>>061</option>
								<option value="062" <c:if test="${tel1 == 062}">selected </c:if>>062</option>
								<option value="063" <c:if test="${tel1 == 063}">selected </c:if>>063</option>
								<option value="064" <c:if test="${tel1 == 064}">selected </c:if>>064</option>

							</select>
						</c:forTokens> - <c:forTokens var="tel2" items="${mypage.tel}" delims="-"
							begin="1" end="1">
							<input type="text" name="tel2" size="2" maxlength="4"
								value="${tel2}">
						</c:forTokens> - <c:forTokens var="tel3" items="${mypage.tel}" delims="-"
							begin="2" end="2">
							<input type="text" name="tel3" size="2" maxlength="4"
								value="${tel3 }"></td>
					</c:forTokens>
				</tr>


				<tr>
					<td>이메일주소</td>
				</tr>
				<tr>
					<td><input type="text" name="email" value="${mypage.email }"></td>
				</tr>
				<tr>
					<td>마케팅 수신여부</td>
				</tr>
				<tr>
					<td><input type="radio" name="receive" value="yes"
						<c:if test="${mypage.receive == 'yes'}">checked  </c:if>>
						예 <input type="radio" name="receive" value="no"
						<c:if test="${mypage.receive == 'no'}">checked  </c:if>>
						아니오</td>

				</tr>

				<tr>
					<td>주소</td>
				</tr>
				<tr>
					<td><input type="text" name="add1" size="30"
						value="${mypage.add1 }" readonly> <input type="button"
						name="button1" value="검색" onclick="post()"></td>
				</tr>


				<tr>
					<td>나머지주소</td>
				</tr>
				<tr>
					<td><input type="text" name="add2" size="30"
						value="${mypage.add2 }"></td>
				</tr>

			</table>

			<center>
				<div id="section2">
					<p style="margin-top: 10px;">
						<input type="button" value="수정하기" onclick="nullCheck33()"
							style="width: 120px; height: 30px;"> <input type="button"
							value="탈퇴하기" onclick="location.href='delete.do?id=${mypage.id}'">

					</p>
			</center>
		</div>

		</div>




		<jsp:include page="frame/Tail.jsp" />
</body>
</html>