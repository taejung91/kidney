<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script>
</script>
<style type="text/css">
#nav4 {
	background-color: white;
	color: black;
	width: 300px;
	height: 800px;
	float: right;
	border-left: 1px solid black;
}

</style>
</style>
</head>
<body>


    <form method="post" name="form7">
	<div id="nav4">
	
	<p>인원 선택</p>
	<table>
	<tr>
	<td align="center">성인</td>
	<td rowspan="2"> <input type="button" value=" ─ " onclick="sub_q(this.form)">
	 <input type="text" size="1" id="quantity1" value="${order.quantity1 }" readonly>
	  <input type="button" value=" + " onclick="add_q(this.form)"></p>
	</td>
	
	<tr>
	<td><fmt:formatNumber value="${product.price1}"/> 원</td>
	<input type="hidden" value="${product.price1 }" id="price1">
	</tr>
	<tr>
	<td> </td>
	</tr>
	<tr>
	<td align="center">아동</td>
	<td rowspan="2"> <input type="button" value=" ─ " onclick="sub_q2(this.form)">
	 <input type="text" size="1" id="quantity2" value="${order.quantity2 }" readonly>
	 <input type="hidden" value="${product.quantity }" id="total_quantity">
	  <input type="button" value=" + " onclick="add_q2(this.form)"></p>
	</td>
	
	<tr>
	<td><fmt:formatNumber value="${product.price2}"/> 원</td>
	<input type="hidden" value="${product.price2 }" id="price2">
	</tr>
	</table>
	<hr>
	
	<p>총 금액</p>
	<div id="total" align="right" style="font-size:30px; color:red;">
	 <fmt:formatNumber value="${totalPrice}"/> 원
	</div>
	<input type="hidden" id="total2" value="${totalPrice }">
	<hr>
	</form>

	<form method="post" name="form5">
	<div id="button" align="center">
	
	<input type="hidden" value="${product.pseq }" name="pseq">
	<input type="hidden" value="${customer.id}" name="login">
	<input type="hidden" value="${order.odseq}" name="cseq">
	
	
	</div>
	</form>
	
	

	</div>
	
	


</body>
</html>