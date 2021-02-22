<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행등록</title>
<style type="text/css">
input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}
</style>
<script>

    function nullCheck(form){
    	
    	var price1 = document.form.price1.value;
		var price2 = document.form.price2.value;
		var quantity = document.form.quantity.value;
		   //공백
		var empJ = /\s/g;
		// 번호
		var numJ = /^[0-9]/;
		
		var test = document.form;
		
		if(empJ.test(price1) == true || numJ.test(price1) == false){
			alert("정확한 값을 입력해주세요.");
			form.price1.focus();
			return false;
		}else if(empJ.test(price2) == true || numJ.test(price2) == false){
			alert("정확한 값을 입력해주세요.");
			form.price2.focus();
			return false;
		}else if(empJ.test(quantity) == true || numJ.test(quantity) == false){
			alert("정확한 값을 입력해주세요.");
			form.quantity.focus();
			return false;
        }
	//	 test.enctype = "multipart/form-data";
		 test.action = "adminpadd.do";
		 test.submit();
		 alert("등록되었습니다.");
		
    }

</script>
</head>
<body>
<jsp:include page="frame/AdminHeader1.jsp" />

	<article>
		<center>
			<h2>여행 등록</h2>
		</center>

		<form name="form" method="post" enctype = "multipart/form-data">

			<hr>
			<center>
				<table>
					<tr>
						<td><b>여행명</b> <input type="text" name="name"><br></td>
					</tr>
					<tr>
						<td><b>종 류
						<select name="kind">
						        <option value="1">국내</option>
								<option value="2">해외</option>
						</select><br></td>
					</tr>
					<tr>
						<td><b>성인요금</b> <input type="text" name="price1" size="5"> 원<br></td>
					</tr>
					<tr>
						<td><b>아동요금</b> <input type="text" name="price2" size="5"> 원 <br></td>
					</tr>
					<tr>
						<td><b>인원</b> <input type="text"  name="quantity" size="5"> 명<br></td>
					</tr>
					<tr>
						<td><b>숙박일</b> <input type="text" name="schedule" size="5"><br></td>
					</tr>
					<tr>
						<td><b>여행 시작일</b> <input type="date" name="s_schedule"><br></td>
					</tr>
					<tr>
						<td><b>여행 종료일</b> <input type="date" name="e_schedule"><br></td>
					</tr>
					<tr>
						<td><b>경로</b> <input type="text" name="route" size="20"><br></td>
					</tr>
					<tr>
					<td><b>여행 사진</b> <input type="file" name="image">
					</td>
					</tr>
					<tr>
					<td><b>내용</b><br><textarea rows="10" cols="60" name="content"  style="resize: none;"></textarea></td>
					</tr>
					
				
				</table>
				
				<p></p>

				<div id="buttons">
					<input type="reset" value="다시 작성">
					<input type="button" value="등록" onclick="nullCheck(this.form)"> 
					<input type="button" value="취소" onclick="location.href='adminproductlist.do?page=${page}'">
				<input type="hidden" name="page" value="${page }">
				
				</div>
			</center>
		</form>
	</article>

</body>
</html>