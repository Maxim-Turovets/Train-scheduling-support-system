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

<body style="overflow: hidden">



<%--<div class="addRoute">--%>
    <%--<form action="/sock/main" method="get">--%>
        <%--<input type="hidden" name="addRoute" value="addRoute">--%>
        <%--<button type="submit" class="addRouteButton" >Add new Route</button>--%>
    <%--</form>--%>
<%--</div>--%>

<%--<div class="getInfo">--%>
    <%--<form action="/sock/main" method="get">--%>
        <%--<input type="hidden" name="getInfo" value="getInfo">--%>
        <%--<button type="submit" class="getInfoButton">Information</button>--%>
    <%--</form>--%>
<%--</div>--%>



<div class="all">
    <div class="lefter">
        <div class="text">Hosting</div>
    </div>
    <div class="left">
        <div class="text">Web Design</div>
    </div>



    <div class="center">
        <%--<button type="submit"  style="width: 100%;height: 100%;opacity:-5.7"></button>--%>
        <button class="explainer" onclick="window.location.href='/sock/scheduleJsp'"><span>Hover me</span></button>
        <div class="text">Schedule</div>
    </div>


        <div class="right">
            <form action="/sock/main" method="get">
            <input type="hidden" name="addRoute" value="addRoute">
                <button type="submit" style="width: 100%;height: 100%;opacity:-5.7"></button>
            </form>
            <div class="text">Add New Route</div>
        </div>


    <div class="righter">
        <form action="/sock/main" method="get">
            <input type="hidden" name="getInfo" value="getInfo">
            <button type="submit" style="width: 100%;height: 100%;opacity:-5.7"></button>
        </form>
        <div class="text">Get Info Station</div>
    </div>
</div>
</body>
</html>
