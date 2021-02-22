<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 선택</title>
<script>
/*
function add_q(form){
	  
	var total_quantity = Number(document.getElementById('total_quantity').value);
	var quantity = Number(document.getElementById('quantity1').value);
	var quantity2 = Number(document.getElementById('quantity2').value);
	var add = quantity + 1;
	var price1 = Number(document.getElementById('price1').value);
	var sum = Number(document.getElementById('total2').value);
	       sum += price1;
	var sum2 = sum.toLocaleString();
	
	if(total_quantity > quantity+quantity2){

	 document.getElementById('total').innerHTML = sum2 + " 원";
	 form.total2.value = sum;
	 form.quantity1.value = add;
	}
  }

  function sub_q(form){
	  var quantity = Number(document.getElementById('quantity1').value);
		var add = quantity - 1;
		
		if(add != 0){
			var price1 = Number(document.getElementById('price1').value);
			var sum = Number(document.getElementById('total2').value);
			sum -= price1;
			
			 var sum2 = sum.toLocaleString();
			 document.getElementById('total').innerHTML = sum2 + " 원";
			 form.total2.value = sum;
         	 form.quantity1.value = add;
		}
  }
  
  function add_q2(form){
	  
	    var total_quantity = Number(document.getElementById('total_quantity').value);
		var quantity = Number(document.getElementById('quantity1').value);
		var quantity2 = Number(document.getElementById('quantity2').value);
		var add = quantity2 + 1;
		var price2 = Number(document.getElementById('price2').value);
		var sum = Number(document.getElementById('total2').value);
		       sum += price2;
		var sum2 = sum.toLocaleString();
		
		if(total_quantity > quantity+quantity2){
			
		 document.getElementById('total').innerHTML = sum2 + " 원";
		 form.total2.value = sum;
		 form.quantity2.value = add;
		}
	  }

   function sub_q2(form){
		  var quantity2 = Number(document.getElementById('quantity2').value);
			var add = quantity2 - 1;
			if(add != -1){
				var price2 = Number(document.getElementById('price2').value);
				var sum = Number(document.getElementById('total2').value);
				sum -= price2;
				
				 var sum2 = sum.toLocaleString();
				 document.getElementById('total').innerHTML = sum2 + " 원";
				 form.total2.value = sum;
			     form.quantity2.value = add;
			}
	  }
*/
   function orderinsert(form){
	   
	   var quantity1 = Number(document.getElementById('quantity1').value);
	   var quantity2 = Number(document.getElementById('quantity2').value)
	   
	   
		document.form.action = "orderinsert.do";
		document.form.submit();
	   
   }
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
	 <input type="text" size="1" id="quantity1" value="${cart.quantity1 }" readonly>
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
	 <input type="text" size="1" id="quantity2" value="${cart.quantity2 }" readonly>
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
	<input type="button" value="예약하기"
	<c:if test="${product.quantity == 0 }">disabled</c:if>
	 onclick="location.href='orderinsert.do?id=${customer.id}&cseq=${cart.cseq }&pseq=${cart.pseq}&quantity1=${cart.quantity1 }&quantity2=${cart.quantity2}'" style="width:200px; height:50px;">
	<input type="hidden" value="${product.pseq }" name="pseq">
	<input type="hidden" value="${customer.id}" name="login">
	<input type="hidden" value="${cart.cseq}" name="cseq">
	
	
	</div>
	</form>
	
	

	</div>
	
	


</body>
</html>