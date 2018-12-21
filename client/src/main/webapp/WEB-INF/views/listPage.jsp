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

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <title>TouristApp</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>
<body>

    <jsp:include page="includes/naval.jsp"></jsp:include>

    <div class="listGroup" style="align-content: left; position: absolute; width: 20%; height: 100%; background-color: #6c757d">
        <div class="list-group">
            <c:forEach var="monument" items="${monuments}">
                <a <%--href="#"--%> class="list-group-item list-group-item-action" onclick="changeActiveClass()">${monument.name}</a>
            </c:forEach>
        </div>
    </div>

    <script>
        function changeActiveClass() {
            $(".list-group-item").on("click",function(){
                $(".list-group-item.active").removeClass('active');
                $(this).addClass('active');
            });
        }

    </script>


</body>
</html>
