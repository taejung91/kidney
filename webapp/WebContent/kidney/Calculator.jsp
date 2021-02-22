<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="dao2.CalculatorDao" %>
    <%@ page import="dto2.Calculator" %>
    <%@ page import="dto2.Food" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식단 계산기</title>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<script>
 
 function search_food(){
	 document.search.action = "cal_form2.do?page=1&page2=1";
		document.search.submit();
 }
 
 function search_food2(){
	 document.search.action = "cal_form2.do?page=1&page2=1";
		document.search.submit();
 }

 function insert_food(form){
	 var fseq2 = form.fseq.value;
	 var fseq = Number(fseq2);
	 document.form.action = "cal.do";
		document.form.submit();
 }
 
 
 google.charts.load('current', {packages: ['corechart']});
 google.charts.setOnLoadCallback(drawChart);

 function drawChart() {
	 var Kcal = Number(graph.Kcal.value);
	 var Na = Number(graph.Na.value);
	 var protein = Number(graph.protein.value);
	 var K = Number(graph.K.value);
	 var P = Number(graph.P.value);
	 var Ca = Number(graph.Ca.value);
	
	 
     var data = google.visualization.arrayToDataTable([
       ['종류', '섭취량(%)', { role: 'style' } ],
       ['칼로리', Kcal, 'color: gray'],
       ['나트륨', Na, 'color: #76A7FA'],
       ['단백질', protein, 'opacity: 0.2'],
       ['칼륨', K, 'color: #76A7FA'],
       ['인', P, 'color: #76A7FA'],
       ['칼슘', Ca, 'color: #76A7FA']
     ]);

     var view = new google.visualization.DataView(data);
     view.setColumns([0, 1,
                      { calc: "stringify",
                        sourceColumn: 1,
                        type: "string",
                        role: "annotation" },
                      2]);
     
     
     var options = {
       title: '식단 계산기',
       width:'100%',
       height:300,
       chartArea: {width: '20%' },
       hAxis: {
         title: '하루 섭취량 (%)',
         minValue: 0,
         viewWindow:{max:100, min:0}
       },
       vAxis: {
         title: ''
       },
       bar: { groupWidth: "70%" },
       animation:{ startup:true, duration:1000, easing:'linear'},
       
     };

     var chart = new google.visualization.BarChart(document.getElementById('chart_div'));

     chart.draw(view, options);
     
     window.addEventListener('resize', function() { chart.draw(view, options); }, false);

   }
 google.charts.setOnLoadCallback(drawChart);


</script>


<style type="text/css">

#ss a {text-decoration: none;
	color: black;}
#cal {text-align:center; margin: 0 auto;}
#list {text-align:left;}

#list3 {float:right; margin-top:-280px; text-align:left; }

#list2 {

  font-size:12px;  
}

#wrap{text-align:left; margin-left: 50px;}


</style>
</head>
<body>

	<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />
	
	<form method="post" name="search">
		<center>
			<h1>식단 계산기</h1>
		</center>
		<hr>
		<div id="ss">
		<table cellpadding="10" width="50%" id="cal" style="table-layout:fixed; ">
		<tr>
		<td><a href="cal_form3.do?page=1&page2=1&kind=1"> 음식</a></td>
		<td><a href="cal_form3.do?page=1&page2=1&kind=2"> 식재료</a></td>
		<td><a href="cal_form3.do?page=1&page2=1&kind=3"> 가공 식품</a></td>
		
		</tr>
		</table>
		</div>
		<hr>
		<p></p>
		
		
		
		<table id="cal" width="500" cellspacing="1" cellpadding="0">
				<tr>
					<td bgcolor="#FFF5EE" align="center" width="100">음식 찾기</td>
					<td align="left"><input type="text" name="search" maxlength="20"> 
					<input type="button" name="button"value="검색" onclick="search_food()">
					<input type="button" name="button"value="전체검색" onclick="search_food2()">
					<input type="button" name="reset" value="초기화" onclick="location.href='calreset.do?page=${page}&page2=${page2 }'">
					
					</td>
					

				</tr>
			</table>
			<p></p>
			
			
			<table border="1" cellpadding="10" width="25%"  rules="rows" id="list" style="table-layout:fixed; border-left:none; border-right:none;">
	

	<tr>
	<td width="100px" style="background:#FFF5EE">총  ${size } 건
	</td>
	</tr>

	<c:forEach var="food" items="${foodList }">
	<tr>
	<td>${food.fname } (${food.capacity }g)<br>
	    칼로리 :${food.kcal} kcal | 나트륨 : ${food.na } mg | 단백질 : ${food.protein } g    <input type="button" value="담기" onclick="location.href='cal.do?fseq=${food.fseq}&page=${page }&page2=${page2 }'" style="margin-left:20px"><br>
	    칼륨 : ${food.k } mg | 인 : ${food.p } mg | 칼슘 : ${food.ca } mg
	 <input type="hidden" name="fseq" value="${food.fseq }">
	 </td> 
	</tr> 
	</c:forEach>
	</table>
	
	<div id="wrap">
		<jsp:include page="frame/Paging3.jsp">
			   <jsp:param value="${paging.page}" name="page"/>
               <jsp:param value="${paging.beginPage}" name="beginPage"/>
               <jsp:param value="${paging.endPage}" name="endPage"/>
               <jsp:param value="${paging.prev}" name="prev"/>
               <jsp:param value="${paging.next}" name="next"/>
               <jsp:param value="${search}" name="search"/>
                <jsp:param value="${kind}" name="kind"/>
                <jsp:param value="${page2}" name="page2"/>
                
	    	</jsp:include>
	</div>
	
	<p></p>


	
	<table border="1" cellpadding="10" width="40%" rules="rows"  id="list2" style="table-layout:fixed; border-left:none; border-right:none;">

	<tr>
	<td width="20px" style="background:#FFF5EE"> 내 정보</td>
	<td width="60px" style="background:#FFF5EE"> 선택한 음식</td>
	</tr>

	<tr>
	<td>키 : ${c_data.height} cm <br>
	표준체중 : ${c_data.s_weight} kg<br><br>
	      하루 섭취량<p></p><br>
	    칼로리 : ${c_data.kcal } kcal <br> 나트륨 : ${c_data.na } mg <br> 단백질 : ${c_data.protein } g    <br>
	    칼륨 : ${c_data.k } mg <br> 인 : ${c_data.p } mg <br> 칼슘 : ${c_data.ca } mg <br>
	 <input type="hidden" name="id" value="${c_data.id }">
	 </td>
	 
	 <td>
	 <c:forEach items="${foodSelect}" var="cart">
	  <p> ${cart.fname } <br>
	      칼로리 :${cart.kcal} kcal | 나트륨 : ${cart.na } mg | 단백질 : ${cart.protein } g    <input type="button" value="삭제" onclick="location.href='cal_delete.do?cseq=${cart.cseq}&page=${page }&page2=${page2 }'" style="margin-left:20px"><br>
	      칼륨 : ${cart.k } mg | 인 : ${cart.p } mg | 칼슘 : ${cart.ca } mg<br>
	       <input type="hidden" name="cseq" value="${cart.cseq }">
	   	</c:forEach>
	 </p>
	 </td> 
	</tr> 
	</table>
		
		<jsp:include page="frame/Paging4.jsp">
			   <jsp:param value="${paging2.page}" name="page"/>
               <jsp:param value="${paging2.beginPage}" name="beginPage"/>
               <jsp:param value="${paging2.endPage}" name="endPage"/>
               <jsp:param value="${paging2.prev}" name="prev"/>
               <jsp:param value="${paging2.next}" name="next"/>
                <jsp:param value="${search}" name="search"/>
                <jsp:param value="${kind}" name="kind"/>
                 <jsp:param value="${page}" name="page"/>
	    	</jsp:include>

		</form>
		<p></p>
	
	
	<div id="chart_div"></div></td>

      <form name="graph" method="post">
      <input type="hidden" id="Kcal" value="${cal_data.kcal }">
      <input type="hidden" id="Na" value="${cal_data.na }">
      <input type="hidden" id="protein" value="${cal_data.protein }">
      <input type="hidden" id="K" value="${cal_data.k }">
      <input type="hidden" id="P" value="${cal_data.p }">
      <input type="hidden" id="Ca" value="${cal_data.ca }">
      
      
      </form>


	<jsp:include page="frame/Tail.jsp" />
</body>
</html>