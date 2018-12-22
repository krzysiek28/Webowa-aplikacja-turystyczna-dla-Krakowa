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

    <div class="listView">
        <!-- List group -->
        <div class="list-group" id="myList" role="tablist" style="align-content: left; position: absolute; width: 20%; height: 100%; background-color: #6c757d">
            <c:forEach var="monument" items="${monuments}">
                <a class="list-group-item list-group-item-action" data-toggle="list" href="#monument${monument.id}" role="tab">${monument.name}</a>
            </c:forEach>
        </div>

        <!-- Tab panes -->
        <div class="tab-content" style="alignment: right; width: 80%; position: absolute; right: 1px;  background-image: image('/static/images/krakow-noca.jpg')">
            <c:forEach var="monument" items="${monuments}">
                <div class="tab-pane" id="monument${monument.id}" role="tabpanel" style=" padding: 10px; background-color: #6c757d">

                    <!--monument description-->
                    <div class="card">
                        <h5 class="card-header">${monument.name}</h5>
                        <div class="card-body">
                            <p class="card-text">${monument.description}</p>
                            <div style="padding-top: 35px; display: inline;">
                                <div style="float:left;"> Godziny otwarcia: ${monument.openingHours} </div>
                                <div style="float:right"> Koszt zwiadzania: ${monument.cost} zł </div>
                                <%--<div style="clear: left;"/>--%>
                            </div>
                        </div>
                    </div>

                    <!--comment content-->
                    <%--<c:forEach var="comment" items="${comments}">--%>
                        <%--<div class="card">--%>
                            <%--<h6 class="card-header"> Właściciel komentarza </h6>--%>
                            <%--<div class="card-body">--%>

                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</c:forEach>--%>

                </div>
            </c:forEach>
        </div>
    </div>

    <script>
        $('#listGroup a').on('click', function (e) {
            e.preventDefault()
            $(this).tab('show')
        })
    </script>




    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
