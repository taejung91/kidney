<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정 보</title>
<script>


 function search_hos(){
	 
	// var search = form.search.value;
	 document.hos.action = "hospital.do";
		document.hos.submit();
	 
 }


</script>

<style type="text/css">
a {
	text-decoration: none;
	color: black;
}

#hospital {
	text-align: center;
	margin: 0 auto;
}

#section {
	text-align: center;
}

#section2 {
	text-align: center;
	margin: 0 auto;
}
</style>
</head>
<body>

	<jsp:include page="frame/Header1.jsp" />
	<jsp:include page="frame/Nav.jsp" />

	<form method="post" name="hos">

		<center>
			<h1>투석 병원 찾기</h1>
		</center>
		<hr>
		<table cellpadding="10" width="50%" id="hospital"
			style="table-layout: fixed;">
			<tr>
		     	<td><a href="hospital.do?search=&page=1"> 전체</a></td>
				<td><a href="hospital.do?search=서울특별&page=1"> 서울</a></td>
				<td><a href="hospital.do?search=인천광역&page=1"> 인천</a></td>
				<td><a href="hospital.do?search=대전광역&page=1"> 대전</a></td>
				<td><a href="hospital.do?search=세종특별&page=1"> 세종</a></td>
				<td><a href="hospital.do?search=광주광역&page=1"> 광주</a></td>
				<td><a href="hospital.do?search=대구광역&page=1"> 대구</a></td>
				<td><a href="hospital.do?search=울산광역&page=1"> 울산</a></td>
				<td><a href="hospital.do?search=부산광역&page=1"> 부산</a></td>
				</tr>
				<tr>
				<td><a href="hospital.do?search=경기도&page=1"> 경기</a></td>
				<td><a href="hospital.do?search=강원도&page=1"> 강원</a></td>
				<td><a href="hospital.do?search=충청남도&page=1"> 충남</a></td>
				<td><a href="hospital.do?search=충청북도&page=1"> 충북</a></td>
				<td><a href="hospital.do?search=전라북도&page=1"> 전북</a></td>
				<td><a href="hospital.do?search=전라남도&page=1"> 전남</a></td>
				<td><a href="hospital.do?search=경상북도&page=1"> 경북</a></td>
				<td><a href="hospital.do?search=경상남도&page=1"> 경남</a></td>
				<td><a href="hospital.do?search=제주특별&page=1"> 제주</a></td>
			</tr>
		</table>
		<hr>


		<div id="wrap">

			<div id="section">
				<img src="image/main/전국지도1.jpg" alt="지도" usemap="#map">

				<map name="map" id="map">
					<area shape="poly" coords="139,156,150,171,176,170,167,139"
						href="hospital.do?search=서울특별&page=1" alt="서울">
					<area shape="poly" coords="139,154,128,145,87,155,88,168,133,176"
						href="hospital.do?search=인천광역&page=1" alt="인천">
					<area shape="poly"
						coords="118,149,117,125,177,66,226,121,217,152,244,165,225,216,181,240,140,232,122,202,140,165,169,176,183,160,171,135"
						href="hospital.do?search=경기도&page=1" alt="경기도">
					<area shape="poly"
						coords="179,66,319,67,393,224,232,209,244,163,222,144,229,112"
						href="hospital.do?search=강원도&page=1" alt="강원">
					<area shape="poly"
						coords="194,262,169,233,135,244,107,218,60,251,112,348,143,327,204,348,149,309,164,258"
						href="hospital.do?search=충청남도&page=1" alt="충청남도">
					<area shape="poly"
						coords="317,232,255,211,184,241,207,282,225,283,225,300,212,347,237,351,230,283"
						href="hospital.do?search=충청북도&page=1" alt="충청북도">
					<area shape="poly"
						coords="181,270,168,263,153,298,225,298,222,285,184,283"
						href="hospital.do?search=세종특별&page=1" alt="세종">
					<area shape="poly" coords="187,299,162,312,181,332,216,321,199,299"
						href="hospital.do?search=대전광역&page=1" alt="대전">
					<area shape="poly"
						coords="440,219,309,240,237,288,246,378,273,403,288,366,332,362,350,384,304,415,396,398"
						href="hospital.do?search=경상북도&page=1" alt="경상북도">
					<area shape="poly"
						coords="233,373,209,388,198,464,221,520,319,532,319,465,361,446,331,419,258,409,252,384"
						href="hospital.do?search=경상남도&page=1" alt="경상남도">
					<area shape="poly"
						coords="345,381,342,390,315,391,280,414,287,369,317,365"
						href="hospital.do?search=대구광역&page=1" alt="대구">
					<area shape="poly" coords="344,426,356,406,392,417,409,432,373,455"
						href="hospital.do?search=울산광역&page=1" alt="울산">
					<area shape="poly" coords="325,481,329,466,369,448,392,479,337,490"
						href="hospital.do?search=부산광역&page=1" alt="부산">
					<area shape="poly"
						coords="230,359,181,359,170,344,99,352,92,433,120,412,145,420,149,437,197,435,196,402"
						href="hospital.do?search=전라북도&page=1" alt="전라북도">
					<area shape="poly"
						coords="111,473,161,471,159,449,102,432,122,417,169,451,184,439,211,485,212,539,73,593,10,494,80,420,94,464"
						href="hospital.do?search=전라남도&page=1" alt="전라남도">
					<area shape="poly" coords="157,464,110,468,98,457,109,442,156,452"
						href="hospital.do?search=광주광역&page=1" alt="광주">
					<area shape="rect" coords="409,455,525,519"
						href="hospital.do?search=제주특별&page=1" alt="제주">

				</map>

			</div>
			<p></p>

			<table id="section2" width="500" cellspacing="1" cellpadding="0">
				<tr>
					<td bgcolor="#FFF5EE" align="center" width="100">병원명 / 주소</td>
					<td align="left"><input type="text" name="search" maxlength="20"> 
					<input type="button" name="button"value="검색" onclick="search_hos()"></td>

				</tr>
			</table>
			<p></p>
			<table id="section2" width="900" border="1" cellspacing="1"
				cellpadding="0">

				<tr bgcolor="#FFF5EE">
					<td width="15">No</td>
					<td width="250">병원명</td>
					<td width="250">주소</td>
					<td width="115">전화번호</td>
					<td width="65">학회인증</td>
					<td width="10">담당의</td>
					<td width="5">전문의</td>
				</tr>
				<input type="hidden" value="${page }" name="page">

				<c:forEach var="hos" items="${hospitalList }" varStatus="status">
					<tr>
						<td>${status.count }</td>
					    <td><a href="#" onclick="window.open('hospitaldetail.do?no=${hos.no}','팝업이름','width=600,height=800');return false">${hos.name }</a></td>
						
						<td>${hos.address }</td>
						<td>${hos.tel }</td>
						<td>${hos.confirm }</td>
						<td>${hos.doctor }</td>
						<td width="20">${hos.doctor_yn }<br></td>
					</tr>
					
				</c:forEach>

			</table>
			
				<jsp:include page="frame/Paging5.jsp">
			   <jsp:param value="${paging.page}" name="page"/>
               <jsp:param value="${paging.beginPage}" name="beginPage"/>
               <jsp:param value="${paging.endPage}" name="endPage"/>
               <jsp:param value="${paging.prev}" name="prev"/>
               <jsp:param value="${paging.next}" name="next"/>
               <jsp:param value="${search}" name="search"/>
               
	    	</jsp:include>
		</div>

	</form>

	<p></p>
	<jsp:include page="frame/Tail.jsp" />
</body>
</html>