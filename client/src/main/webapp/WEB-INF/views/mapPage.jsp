<%--
  Created by IntelliJ IDEA.
  User: krzys
  Date: 11.12.2018
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${authservice.isLoggedIn() == false}">
    <c:redirect url="/"/>
</c:if>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8">
    <title>TouristApp</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />



    <script
            src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
    <script>
        var map;
        function initialize() {
            var mapOptions = {
                zoom: 14,
                center: new google.maps.LatLng(50.049683, 19.944544)
            };
            map = new google.maps.Map(document.getElementById('map-canvas'),
                mapOptions);
        }

        google.maps.event.addDomListener(window, 'load', initialize);
    </script>
</head>

<body>

    <jsp:include page="includes/naval.jsp"></jsp:include>
    <jsp:include page="mapView/palette.jsp"></jsp:include>


<div id="map-canvas" style="height:670px; width:1700px; width: 80%;"></div>

</body>

</html>
