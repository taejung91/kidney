<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>푸드등록</title>

<script>

function nullCheck22(form) {
	
	var kcal = document.form.Kcal.value;
	var na = document.form.Na.value;
	var pro = document.form.protein.value;
	var k = document.form.K.value;
	var p = document.form.P.value;
	var ca = document.form.Ca.value;
 	var capacity = document.form.capacity.value;
    //공백
	var empJ = /\s/g;
	// 번호
	var numJ = /^[0-9]/;
	
//	alert("dd33");
	var test = document.form;


	if(empJ.test(kcal) == true || numJ.test(kcal) == false){
		alert("정확한 값을 입력해주세요.");
		form.Kcal.focus();
		return false;
	}else if(empJ.test(na) == true || numJ.test(na) == false){
		alert("정확한 값을 입력해주세요.");
		form.Na.focus();
		return false;
	}else if(empJ.test(pro) == true || numJ.test(pro) == false){
		alert("정확한 값을 입력해주세요.");
		form.protein.focus();
		return false;
	}else if(empJ.test(k) == true || numJ.test(k) == false){
		alert("정확한 값을 입력해주세요.");
		form.K.focus();
		return false;
	}else if(empJ.test(p) == true || numJ.test(p) == false){
		alert("정확한 값을 입력해주세요.");
		form.P.focus();
		return false;
	}else if(empJ.test(ca) == true || numJ.test(ca) == false){
		alert("정확한 값을 입력해주세요.");
		form.Ca.focus();
		return false;
	}else if(empJ.test(capacity) == true || numJ.test(capacity) == false){
		alert("정확한 값을 입력해주세요.");
		form.capacity.focus();
		return false;
	}

	 test.action = "admincaladd.do";
	 test.submit();
	 alert("등록되었습니다.");


}

</script>
<style type="text/css">
input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}
</style>
<script>

</script>
</head>
<body>
<jsp:include page="frame/AdminHeader1.jsp" />

	<article>
		<center>
			<h2>푸드 등록</h2>
		</center>

		<form name="food_add" method="post">

			<hr>
			<center>
				<table>
					<tr>
						<td><b>음식이름</b> <input type="text" name="fname"><br></td>
					</tr>
					<tr>
						<td><b>종 류
						<select name="kind">
						        <option value="1">음식</option>
								<option value="2">식재료</option>
								<option value="3">가공식품</option>
						</select><br></td>
					</tr>
					<tr>
						<td><b>칼로리</b> <input type="text" name="Kcal" size="5" > kcal<br></td>
					</tr>
					<tr>
						<td><b>나트륨</b> <input type="text" name="Na" size="5"> mg <br></td>
					</tr>
					<tr>
						<td><b>단백질</b> <input type="text" name="protein" size="5"> g<br></td>
					</tr>
					<tr>
						<td><b>칼륨</b> <input type="text" name="K" size="5"> mg<br></td>
					</tr>
					<tr>
						<td><b>인</b> <input type="text" name="P" size="5"> mg<br></td>
					</tr>
					<tr>
						<td><b>칼슘</b> <input type="text" name="Ca" size="5"> mg <br></td>
					</tr>
					<tr>
						<td><b>용량</b> <input type="text" name="capacity" size="5"> g<br></td>
					</tr>
				
				</table>
				
				<p></p>

				<div id="buttons">
					<input type="reset" value="다시 작성">
					<%-- <input type="submit" value="등록">  --%>
					
						<input type="button" value="등록" onclick="nullCheck22(this.form)">
					<input type="button" value="취소" onclick="location.href='admincallist.do?page=${page}'">
				<input type="hidden" name="page" value="${page }">
				</div>
			</center>
		</form>
	</article>

</body>
</html>