<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#section2 {
	margin: 0 auto;
	font-size: 18px;
}
</style>
</head>
<body>
	<div id="map" style="width: 100%; height: 400px;"></div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cac20b50eede8c9e7cc88000c3b6025b&libraries=services"></script>

	<form name="form5">
		<input type="hidden" name="addrr" value="${hospital.address }">
		<input type="hidden" name="name_hos" value="${hospital.name }">
	</form>


	<script>
		var name_hos = form5.name_hos.value;

		var container = document.getElementById('map'); // 지도를 표시할 div 
		var options = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 5
		// 지도의 확대 레벨
		};

		// 지도를 생성
		var map = new kakao.maps.Map(container, options);

		// 주소-좌표 변환 객체를 생성
		var geocoder = new kakao.maps.services.Geocoder();

		//var addr = '부산광역시 연제구 중앙대로 1091 (연산동, 제세빌딩) 7층';
		var addr = form5.addrr.value;
		//alert(addr);

		// 주소로 좌표를 검색

		var callback = function(result, status) {
			// 정상적으로 검색이 완료
			if (status === kakao.maps.services.Status.OK) {

				var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

				// 결과값으로 받은 위치를 마커로 표시
				var marker = new kakao.maps.Marker({
					map : map,
					position : coords
				});

				// 인포윈도우로 장소에 대한 설명을 표시
				var infowindow = new kakao.maps.InfoWindow(
						{
							content : "<div style='width:150px;text-align:center;padding:6px 0; font-size:16px'>"
									+ name_hos + "</div>"
						});
				infowindow.open(map, marker);

				// 지도의 중심을 결과값으로 받은 위치로 이동
				map.setCenter(coords);
			}
		}

		geocoder.addressSearch(addr, callback);
	</script>

	<p></p>
	<form name="form55" method="post">
		<table id="section2" width="100%" border="1" rules="rows"
			cellpadding="10">

			<tr>
				<td bgcolor="#FFF5EE" align="center">병원명</td>
				<td>${hospital.name }</td>
			</tr>
			<tr>
				<td bgcolor="#FFF5EE" align="center">주소</td>
				<td>${hospital.address }</td>
			</tr>
			<tr>
				<td bgcolor="#FFF5EE" align="center">전화번호</td>
				<td>${hospital.tel }</td>
			</tr>
			<tr>
				<td bgcolor="#FFF5EE" align="center">담당의</td>
				<td>${hospital.doctor }</td>
			</tr>
			<tr>
				<td bgcolor="#FFF5EE" align="center">전문의</td>
				<td>${hospital.doctor_yn }</td>
			</tr>
			<tr>
				<td bgcolor="#FFF5EE" align="center">학회인증</td>
				<td>${hospital.confirm }</td>
			</tr>

		</table>

	</form>


</body>
</html>