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
</head>
<body>

    <jsp:include page="includes/naval.jsp"></jsp:include>

    <div class="listGroup" style="align-content: left; position: absolute; width: 20%; height: 100%; background-color: #6c757d">
        <div class="list-group">
            <a href="#" class="list-group-item list-group-item-action active">Monument0</a>
            <a href="#" class="list-group-item list-group-item-action">Monument1</a>
            <a href="#" class="list-group-item list-group-item-action">Monument2</a>
            <a href="#" class="list-group-item list-group-item-action">Monument3</a>
            <c:forEach var="monument" items="${monuments}">
                ${monument.name}
            </c:forEach>
        </div>
    </div>



</body>
</html>
