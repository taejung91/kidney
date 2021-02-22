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

<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />
	
	<form method="post" name="form">
	
	
	<center>
	<h1> ${name } </h1>
	</center>
	<hr>
	
	<table border="1" cellpadding="10" width="65%"  rules="rows" id="tour_d" style="table-layout:fixed;">
	<tr>
	<td>
	<img src="image/tour/${tour.image }"/>
	</td>
	<td> <p align="left">${tour.name }</p>
	 <p align="left"> ${tour.content }</p>
	 <p align="right"> 성인 1인</p>
	 <p align="right" style="font-size:30px; font-weight: bold;"><fmt:formatNumber value="${tour.price1}"/> 원</p>
	  </td>
	</tr>
	</table>
	<p></p>
	<hr>
	
	<div id="wrap">
	
	<jsp:include page="frame/Nav2.jsp" />
	
	<table cellpadding="10" width="900" id="tour_d2" style="table-layout:fixed;">
	<tr colspan="2">
	<td width="140px" style="font-size:20px; font-weight: bold;"> 여행 주요일정</td>
	<td ></td>
	</tr>
	<tr>
	<td>일 정</td>
	<td>${tour.schedule}<br>
	<p>일정시작: ${tour.s_schedule }</p>
	<p>일정종료: ${tour.e_schedule }</p>
	</td>
	</tr>
	<tr>
	<td>여행 도시</td>
	<td>${tour.route }</td>
	</tr>
	<tr>
	<td>예약 현황</td>
	<td>
	<p>남은 인원: ${tour.quantity } 명 </p></td>
	</table>
	<hr>
	
	<table cellpadding="10" width="900" id="tour_d3" style="table-layout:fixed;">
	<tr colspan="2">
	<td width="140px" style="font-size:20px; font-weight: bold;"> 상품 가격</td>
	</tr>
	<tr>
	<td>성 인 <br>(만 12세 이상)</td>
	<td><fmt:formatNumber value="${tour.price1}"/> 원</td>
	</tr>
	<tr>
	<td>아 동 <br>(만 12세 미만)</td>
	<td><fmt:formatNumber value="${tour.price2}"/> 원</td>
	</tr>
	<tr>
	<td colspan="2"> 1인 객실 사용시 추가요금 발생됩니다.<br>
         1인 객실 사용료 : 문의</td>
         <td></td>
         </tr>
	</table>
	<hr>
	 <input type="button" value="목록" onclick="location.href='tour.do?kind=${kind}&page=${page }'">

	</div>
	<div id="seo"></div>
	</form>
	
	



<jsp:include page="frame/Tail.jsp" />
</body>
</html>