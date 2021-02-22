<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="dto2.CustomerData"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추가 정보</title>
<script>
function nullCheck() {
	var num1 = /^[0-9.]{3,5}$/;
	var num2 = /^[0-9.]{2,5}$/;
	var empJ = /\s/g;
	var weight = myadd.weight.value;
	var height = myadd.height.value;
	
	if(num1.test(height) == false || empJ.test(height) == true){
		alert("숫자만 입력해주세요.");
		myadd.height.focus();
		return false;
	}
	else if(num2.test(weight) == false || empJ.test(weight) == true){
		alert("숫자만 입력해주세요.");
		myadd.weight.focus();
		return false;
	}
	
	document.myadd.action = "mypageadd.do";
	document.myadd.submit();
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

	<form method="post" name="myadd">


		<div id="section">
			<center>

				<h1>추가 정보</h1>
				<h4>
					<p>(계산기를 이용하시려면 입력해주세요.)</p>
				</h4>

			</center>
			<input type="hidden" name="id" value="${data.id }">

			<table>
				<tr>
					<td style="color: red; font-size: 12px">
						<p>* 입력 시 자동 계산</p>
					</td>
				</tr>
				<tr>
					<td>키 (cm) <span style="color: red"> ＊ </span></td>
				</tr>
				<tr>
					<td><input type="text" name="height" size="15" value="${data.height }"></td>
				</tr>
				<tr>

					<td>몸무게 (kg) <span style="color: red"> ＊ </span></td>
				</tr>
				<tr>
					<td><input type="text" name="weight" size="15" value="${data.weight }"></td>

				</tr>

				
				<tr>

					<td>표준 체중 (kg)</td>
				</tr>
				<tr>
					<td><input type="text" name="s_weight" size="15" value="${data.s_weight }" readonly></td>

				</tr>




				<tr>
					<td>칼로리 (Kcal)</td>
				</tr>
				<tr>
					<td><input type="text" name="Kcal" value="${data.kcal}" readonly></td>
				</tr>

				<tr>
					<td>나트륨 (mg)</td>
				</tr>
				<tr>
					<td><input type="text" name="Na" value="${data.na }" readonly></td>

				</tr>


				<tr>
					<td>단백질 (g)</td>
				</tr>
				<tr>
					<td><input type="text" name="protein" value="${data.protein }" readonly></td>

				</tr>


				<tr>
					<td>칼륨 (mg)</td>
				</tr>
				<tr>
					<td><input type="text" name="K" value="${data.k }" readonly></td>
				</tr>
				<tr>
					<td>인 (mg)</td>
				</tr>
				<tr>
					<td><input type="text" name="P" value="${data.p }" readonly></td>

				</tr>

				<tr>
					<td>칼슘 (mg)</td>
				</tr>
				<tr>
					<td><input type="text" name="Ca" value="${data.ca }" readonly></td>
				</tr>


			</table>

			<center>
				<div id="section2">
					<p style="margin-top: 10px;">
						<input type="button" value="확인" onclick="nullCheck()" style="width: 120px; height: 30px;">
						 <input type="button" value="취소" onclick="location.href='index.do'">

					</p>
			</center>
		</div>

		</div>




		<jsp:include page="frame/Tail.jsp" />
</body>
</html>