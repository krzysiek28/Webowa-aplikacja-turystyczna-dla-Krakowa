<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${authservice.isLoggedIn() == false}">
    <c:redirect url="/"/>
</c:if>
<html>
<head>
    <title>TouristApp</title>
</head>
<body>
    hello!
</body>
</html>
