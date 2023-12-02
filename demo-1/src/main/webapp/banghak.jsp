<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>방학서클</title>
<link rel="stylesheet" href="/css/main.css" />
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script
  type="text/javascript"
  src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d980d42cfbe72c8baac3d3431112b796">
</script>
<%@ include file="/common/bootstrap_common.jsp"%>
<script>
function getloc(){
  const moveLatLon = new kakao.maps.LatLng(37.666311, 127.041043);
  map.panTo(moveLatLon);  
}
</script>
</head>
<body>
  <%@ include file="/include/banghak_header.jsp"%>
  <div class="container">
    <div class="main_header">
      <div class="main">
        <div>방학서클은?</div>
        <hr style="height: 3px;">
        <div class = "mapwrap">
            <div class="map" id="map" style="width: 500px; height: 400px">
              여기
            </div>
            <script type="text/javascript">
            const container = document.getElementById("map");
            const positions = [
              {
                content: '<div style="padding:5px;">다다름 공작소</div>',
                latlng: new kakao.maps.LatLng(37.666311, 127.041043),
              },
            ];
            const options = {
              center: positions[0].latlng,
              level: 4,
            };
            const map = new kakao.maps.Map(container, options);
            const markerPosition = new kakao.maps.LatLng(37.666311, 127.041043);
            const marker = new kakao.maps.Marker({
              position: markerPosition,
            });
            // 마커가 지도 위에 표시되도록 설정합니다
            marker.setMap(map);
              </script>
              <input class="btnGeoLoc" type="button" value="공작소" onclick="getloc()">
        </div>
        <div class="imagewrap">
          <img class="image" src="/images/공작소.jpeg" alt="공작소 사진">
        </div>  
        <hr style="height: 3px;">
        <table class="table" style="min-width: 700px;">
          <tbody style="border: 1px solid lightgrey;">
            <tr>
              <td style="border: 1px solid lightgrey;">📞연락처</td>
              <td>
                02-3491-2663
              </td>
            </tr>
            <tr>
              <td style="border: 1px solid lightgrey;">주소</td>
              <td>
                서울특별시 도봉구 방학로1길 76 다다름 공작소(초록 간판)
              </td>
            </tr>
            <tr>
              <td style="border: 1px solid lightgrey;">dddd</td>
              <td>
                dddddd
              </td>
            </tr>
          </tbody>
        </table>
        <input type="button" value="문의하기">
      </div>
    </div>
  </div>
  <%@ include file="/include/banghak_footer.jsp"%>
</body>
</html>