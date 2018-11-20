<%--
  Created by IntelliJ IDEA.
  User: krzys
  Date: 15.11.2018
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    <title>TouristApp</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div>
        <a class="navbar-brand" href="/">Home</a>
    </div>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">

        </ul>
    </div>

    <!-- naval with buttons -->
    <div class="btn-group"  style="position: relative" role="group" aria-label="Basic example">
        <button type="button" class="btn btn-secondary" name="login" onclick="window.location.href='/loginPage'">Zaloguj się</button>
        <button type="button" class="btn btn-secondary" name="signup" onclick="window.location.href='/registrationPage'">Stwórz konto</button>
    </div>
</nav>


<%--<div class="card text-center" style="alignment: left; width: 30%; left: 5%; top: 50px">--%>
    <%--<div class="card-header">--%>
        <%--<ul class="nav nav-tabs card-header-tabs">--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Home</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Profile</a>--%>
                <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link active" onclick="status=login">Logowanie</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="/loginPage">Rejestracja</a>--%>
            <%--</li>--%>
        <%--</ul>--%>
    <%--</div>--%>
    <%--<div class="card-body">--%>
        <%--&lt;%&ndash;<c:if test="${param.status == 'login'}">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<div class="alert alert-danger">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<p>Logowanie</p>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</c:if>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<c:if test="${param.status == 'registration'}">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<div class="alert alert-danger">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<p>Rejestracja</p>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</c:if>&ndash;%&gt;--%>

        <%--&lt;%&ndash;<h5 class="card-title">Special title treatment</h5>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<p class="card-text">With supporting text below as a natural lead-in to additional content.</p>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<a href="#" class="btn btn-primary">Go somewhere</a>&ndash;%&gt;--%>
    <%--</div>--%>
<%--</div>--%>

</body>
</html>
