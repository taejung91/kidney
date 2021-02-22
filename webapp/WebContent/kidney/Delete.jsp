<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>탈 퇴</title>
<script>

   function delete_go(){
	   
	   
	   var id = frmmm.id.value;
	   var pw = frmmm.pw.value;
	   var name = frmmm.name.value;
	   
	   var customer_id = frmmm.customer_id.value;
	   var customer_pw = frmmm.customer_pw.value;
	   var customer_name = frmmm.customer_name.value;
	   
	   
	   if(id == customer_id && pw == customer_pw && name == customer_name){
	   
	   var cf = confirm("정말 탈퇴하시겠습니까???");
	   if(cf == true){
		
	   document.frmmm.action = "delete.do";
	   document.frmmm.submit();
	   alert("회원 탈퇴가 완료되었습니다.");
	   }else{
		   frmmm.id.focus();
	   }
	   }else{
		   alert("입력하신 정보가 일치하지 않습니다.");
	   }
	   
   }

</script>
<style type="text/css">
#section {
	width: 200px;
	height: 400px;
	text-align: left;
	padding: 10px;
	position: abolute;
	margin: 0 auto;
	margin-top: 50px;
}
</style>

</head>
<body>
	<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />

	<center>
		<p>
		<h2>회 원 탈 퇴</h2>
		</p>
	</center>

	<form name="frmmm" method="post">

		<div id="section">
		
		<p>
				<input type="text" name="id" placeholder="아이디">
				<input type="hidden" name="customer_id" value="${customer.id }">
			</p>
		
		<p>
				<input type="password" name="pw" placeholder="비밀번호">
				<input type="hidden" name="customer_pw" value="${customer.pw }">
				
			</p>
		
			<p>
				<input type="text" name="name" placeholder="이름">
				<input type="hidden" name="customer_name" value="${customer.name }">
				
			</p>


			<p>
				<input type="button" value="탈퇴하기" style="width: 175px" onclick="delete_go()">
			</p>



		</div>
	</form>



	<jsp:include page="frame/Tail.jsp" />



</body>
</html>