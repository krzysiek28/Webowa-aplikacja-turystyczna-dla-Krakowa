<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mvc:annotation-driven ignoreDefaultModelOnRedirect="true" />
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login page</title>
    <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet">
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
    <a class="navbar-brand" href="/">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>

<div id="map-canvas" style="height:1000px; width:1700px; position: relative;"></div>

<div class="card text-center" style="alignment: left; width: 30%; left: 5%; top: 90px; position: absolute;">
    <div class="card-header">
        Logowanie:
    </div>
    <div class="card-body">
        <c:url var="loginUrl" value="/loginPage" />
        <form action="/login" method="post" class="form-horizontal">
            <c:if test="${param.error == 'loginfirst'}">
                <div class="alert alert-danger">
                    <p>Najpierw się zaloguj</p>
                </div>
            </c:if>
            <c:if test="${param.error == 'badcredentials'}">
                <div class="alert alert-danger">
                    <p>Niepoprawna nazwa użytkownika lub hasło</p>
                </div>
            </c:if>
            <c:if test="${param.logout != null}">
                <div class="alert alert-success">
                    <p>Jesteś zalogowany.</p>
                </div>
            </c:if>
            <div class="input-group input-sm">
                <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Nazwa użytkownika" required>
            </div>
            <br/>
            <div class="input-group input-sm">
                <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Hasło" required>
            </div>
            <br/>
            <div class="form-actions">
                <input type="submit" class="btn btn-block btn-primary btn-default" value="Zaloguj">
            </div>
        </form>
    </div>
</div>

</body>
</html>
