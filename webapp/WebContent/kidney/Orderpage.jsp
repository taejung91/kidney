<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
<style type="text/css">
   #order {text-align:left; margin: 0 auto;}
   #order2 {text-align:left; margin: 0 auto;}
   #wrap {width: 1850px;}
</style>
</head>
<body>

	<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />

	<form method="post" name="form5">

		<center>
			<h1>예약하기</h1>
		</center>
		<hr>
		
		<div id="wrap">
		
		<jsp:include page="frame/Nav3.jsp" />
	
		<table border="1" cellpadding="20" width="900" id="order" style="table-layout:fixed; border-collapse:collapse; border-left:none; border-right:none;">
		<tr>
		<td width="100px"  style="background: #FFF5EE">여행명</td><td>${product.name }</td>
		</tr>
		<tr>
			<td style="background: #FFF5EE">여행기간</td> <td>${product.s_schedule } ~ ${product.e_schedule } / ${product.schedule }</td>
			</tr>
			<tr>
			<td style="background: #FFF5EE">이용호텔</td> <td>호텔</td>
			</tr>
			<tr>
			<td  style="background: #FFF5EE">이용병원</td> <td> 병원</td>
			</tr>
			<tr>
			<td  style="background: #FFF5EE">남은 인원</td> <td> ${product.quantity } 명</td>
			</tr>
			
			
			</table>
			
			<p>예약자 정보</p>
			
			<table border="1" cellpadding="30" width="900" id="order2" style="table-layout:fixed; border-collapse:collapse; border-left:none; border-right:none;">
		<tr>
			<td width="80px" style="background: #FFF5EE">이름</td>
			 <td><input type="text" name="name" value="${customer.name }" readonly style="height:20px;"> </td>
			 <td width="80px" style="background: #FFF5EE"> 생년월일</td>
			 <td><input type="text" name="birth" value="${customer.birth }" readonly style="height:20px;"> </td>
			</tr>
			<tr>
			<td style="background: #FFF5EE">이메일</td>
			<td><input type="text" name="email" value="${customer.email }"readonly style="height:20px;"> </td>
			<td style="background: #FFF5EE"> 전화 번호</td>
			 <td><input type="text" name="tel" value="${customer.tel }"readonly style="height:20px;"> </td>
			</tr>
			</table>
			
		
	</div>
	</form>

	<jsp:include page="frame/Tail.jsp" />

</body>
</html>