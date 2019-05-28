<%--
  Created by IntelliJ IDEA.
  User: mturo
  Date: 27.05.2019
  Time: 1:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>

    <style>
        <%@include file="/webresourse/css/main.css"%>
    </style>


</head>

<body>
<div class="addRoute">
    <form action="/sock/main" method="get">
        <input type="hidden" name="addRoute" value="addRoute">
        <button type="submit" class="addRouteButton" >Add new Route</button>
    </form>
</div>

<div class="getInfo">
    <form action="/sock/main" method="get">
        <input type="hidden" name="getInfo" value="getInfo">
        <button type="submit" class="getInfoButton">Information</button>
    </form>
</div>
</body>
</html>
