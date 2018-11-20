<%--
  Created by IntelliJ IDEA.
  User: krzys
  Date: 19.11.2018
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login page</title>
    <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>

<div class="card text-center" style="alignment: left; width: 30%; left: 5%; top: 90px">
    <div class="card-header">
        Rejestracja:
    </div>
    <div class="card-body">
        <form action="/addUser" method="post">
            <c:if test="${param.error != null}">
                <c:if test="${param.message == 'email'}">
                    <div class="alert alert-danger">
                        <p>Użytkownik o podanym adresie email już istnieje</p>
                    </div>
                </c:if>
                <c:if test="${param.message == 'username'}">
                    <div class="alert alert-danger">
                        <p>Użytkownik o podanej nazwie już istnieje</p>
                    </div>
                </c:if>
                <c:if test="${param.message == 'login'}">
                    <div class="alert alert-danger">
                        <p>Login jest już zajęty</p>
                    </div>
                </c:if>
                <c:if test="${param.message == other}">
                    <div class="alert alert-danger">
                        <p><c:out value="${param.message}"/></p>
                    </div>
                </c:if>
            </c:if>
            <div class="input-group input-sm">
                <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                <input type="text" class="form-control" id="email" name="email" placeholder="Adres email" required>
            </div>
            <br/>
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
            <br/>
            <div class="form-actions">
                <input type="submit" class="btn btn-block btn-primary btn-default" value="Utwórz konto">
            </div>
        </form>
    </div>
</div>

</body>
</html>
