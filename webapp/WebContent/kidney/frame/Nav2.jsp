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
   
   function cart_insert(){
	   var login = form5.login.value;
	   var quantity1 = Number(document.getElementById('quantity1').value);
	   var quantity2 = Number(document.getElementById('quantity2').value);
	   var total_quantity = Number(document.getElementById('total_quantity').value);
	   
	   if(login == ""){
		 	document.form5.action = "login.do";
	       	document.form5.submit();
       }else{
    	  
    	   var result = confirm("장바구니로 이동하겠습니까??");
    	   if(result){
    		   var cart = 1;
    		   document.form5.action = "cartinsert.do?page=1&cart=" + cart + "&quantity1=" + quantity1 + "&quantity2=" + quantity2;
       		   document.form5.submit();
    	   }else{
    		   var cart = 0;
    		   document.form5.action = "cartinsert.do?page=1&cart=" + cart + "&quantity1=" + quantity1 + "&quantity2=" + quantity2;
       		   document.form5.submit();
    	   }
   		  
       
       }
	   
	   
		//   document.form5.action = "cartinsert.do";
		//   document.form5.submit();
	
	   }
   
   function order_insert(){
	   
	   var quantity1 = Number(document.getElementById('quantity1').value);
	   var quantity2 = Number(document.getElementById('quantity2').value);
	   var total_quantity = Number(document.getElementById('total_quantity').value);
	   
	   
	   var cart = 2;
	   document.form5.action = "cartinsert.do?page=1&cart=" + cart + "&quantity1=" + quantity1 + "&quantity2=" + quantity2;
	   document.form5.submit();
	   
		
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


    <form method="post" name="form">
	<div id="nav4">
	
	<p>인원 선택</p>
	<table>
	<tr>
	<td align="center">성인</td>
	<td rowspan="2"> <input type="button" value=" ─ " onclick="sub_q(this.form)">
	 <input type="text" size="1" id="quantity1" value="1" readonly>
	  <input type="button" value=" + " onclick="add_q(this.form)"></p>
	</td>
	
	<tr>
	<td><fmt:formatNumber value="${tour.price1}"/> 원</td>
	<input type="hidden" value="${tour.price1 }" id="price1">
	</tr>
	<tr>
	<td> </td>
	</tr>
	<tr>
	<td align="center">아동</td>
	<td rowspan="2"> <input type="button" value=" ─ " onclick="sub_q2(this.form)">
	 <input type="text" size="1" id="quantity2" value="0" readonly>
	 <input type="hidden" value="${tour.quantity }" id="total_quantity">
	  <input type="button" value=" + " onclick="add_q2(this.form)"></p>
	</td>
	
	<tr>
	<td><fmt:formatNumber value="${tour.price2}"/> 원</td>
	<input type="hidden" value="${tour.price2 }" id="price2">
	</tr>
	</table>
	<hr>
	
	<p>총 금액</p>
	<div id="total" align="right" style="font-size:30px; color:red;">
	 <fmt:formatNumber value="${tour.price1}"/> 원
	</div>
	<input type="hidden" id="total2" value="${total }">
	<hr>
	</form>

	<form method="post" name="form5">
	<div id="button" align="center">
	<input type="button" value="예약하기" style="width:200px; height:50px;" onclick="order_insert()" <c:if test="${tour.quantity == 0 }">disabled</c:if>>
	<input type="button" value="장바구니" style="height:50px;" onclick="cart_insert()" <c:if test="${tour.quantity == 0 }">disabled</c:if>>
	<input type="hidden" value="${tour.pseq }" name="pseq">
	<input type="hidden" value="${loginInfo.id}" name="login">
	<input type="hidden" value="${kind }" name="kind">
	
	</div>
	</form>
	
	

	</div>
	
	


</body>
</html>