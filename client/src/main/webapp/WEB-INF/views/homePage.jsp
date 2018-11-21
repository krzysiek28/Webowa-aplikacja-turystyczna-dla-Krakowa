<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${authservice.isLoggedIn() == false}">
    <c:redirect url="/"/>
</c:if>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>TouristApp</title>
    <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
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

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div>
            <a class="navbar-brand" href="/home">Home</a>
        </div>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">

            </ul>
        </div>

        <div class="nick" style="padding-right: 10px; color: white">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <h4>Zalogowano jako: ${pageContext.request.userPrincipal.name}</h4>
            </c:if>
        </div>

        <!-- naval with buttons -->
        <div class="btn-group" role="group" aria-label="Basic example">
            <button type="button" class="btn btn-secondary" onclick="window.location.href='/logout'">Wyloguj się</button>
        </div>
    </nav>



    <div id="map-canvas" style="height:1000px; width:1700px"></div>

</body>

</html>
