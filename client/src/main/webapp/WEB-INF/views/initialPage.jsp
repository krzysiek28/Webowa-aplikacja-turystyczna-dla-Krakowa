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


<!-- space to add welcome page, getting started-->

</body>
</html>
