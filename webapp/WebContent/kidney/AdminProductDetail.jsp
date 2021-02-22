<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    	    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투어 디테일</title>
<style type="text/css">

   #tour_d {text-align:center; margin: 0 auto;}
   #tour_d2 {text-align:left; margin: 0 auto;}
   #tour_d3 {text-align:left; margin: 0 auto;}
   #wrap {width: 1850px;}
</style>
</head>
<body>

	<jsp:include page="frame/AdminHeader1.jsp" />
	<form method="post" name="form16" action="adminproductdetail.do">
	
	
	<center>
	<h1> 투어 </h1>
	</center>
	<hr>
	
	<table border="1" cellpadding="10" width="65%"  rules="rows" id="tour_d" style="table-layout:fixed;">
	<tr>
	<td>
	<img src="image/tour/${tour.image }"/>
	</td>
	<td> <p align="left"> 여행명<br><input type="text" name="name" size="60" value="${tour.name }"></p>
	 <p align="left"> 여행내용<br><textarea rows="5" cols="60" style="resize: none;" name="content">${tour.content }</textarea>
	  </td>
	</tr>
	</table>
	<p></p>
	<hr>
	
	<div id="wrap">
	
	<table cellpadding="10" width="900" id="tour_d2" style="table-layout:fixed;">
	<tr colspan="2">
	<td width="140px" style="font-size:20px; font-weight: bold;"> 여행 주요일정</td>
	<td ></td>
	</tr>
	<tr>
	<td>일 정</td>
	<td> 여행일정 <input type="text" name="schedule" value="${tour.schedule}" size="5"><br>
	<p>일정시작: ${tour.s_schedule } <input type="date" value="${tour.s_schedule }" name="s_schedule"></p>
	<p>일정종료: ${tour.e_schedule } <input type="date" value="${tour.e_schedule }" name="e_schedule"></p>
	</td>
	</tr>
	<tr>
	<td>여행 도시</td>
	<td><input type="text" name="route" value="${tour.route }"></td>
	</tr>
	<tr>
	<td>인원</td>
	<td><input type="text" name="quantity" value="${tour.quantity }" size="5"> 명 </p></td>
	</table>
	
	
	<table cellpadding="10" width="900" id="tour_d3" style="table-layout:fixed;">
	<tr colspan="2">
	<td width="140px" style="font-size:20px; font-weight: bold;"> 상품 가격</td>
	</tr>
	<tr>
	<td>성 인 <br>(만 12세 이상)</td>
	<td><input type="text" name="price1" value="${tour.price1}" size="5"/> 원</td>
	</tr>
	<tr>
	<td>아 동 <br>(만 12세 미만)</td>
	<td><input type="text" name="price2" value="${tour.price2}" size="5"/> 원</td>
	</tr>
	<tr>
	<td colspan="2"> 1인 객실 사용시 추가요금 발생됩니다.<br>
         1인 객실 사용료 : 문의</td>
         <td></td>
	</table>
	<hr>
             <div id="buttons" style="margin-left:1040px;">
				<input type="submit" value="변경하기">
				<input type="button" value="취소" onclick="location.href='adminproductlist.do?page=${page}'">
				</div>



	</div>
	</form>
	


</body>
</html>