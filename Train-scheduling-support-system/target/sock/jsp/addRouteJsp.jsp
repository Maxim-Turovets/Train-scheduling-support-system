<%@ page import="java.util.ArrayList" %>
<%@ page import="model.dao.daointerfaces.DAoStation" %>
<%@ page import="model.dao.imp.StationTableInfo" %>
<%@ page import="java.util.List" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: mturo
  Date: 26.05.2019
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Route</title>
    <style>
        <%@include file="/webresourse/css/main.css"%>
    </style>

</head>


<body>
<div style="height:50px;width: 100%;left:2%;position: fixed;top: 2%;" >
    <button class="addRouteButton" onclick="window.location.href='/sock/mainJsp'">Home</button>
</div>

<table class="cinereousTable" style="max-width: 250px;margin-left: 40%;margin-top: 2%">

    <thead>
    <tr>
        <th>Add station and start time</th>
    </tr>
    <thead>

</table>

    <%
        DAoStation baseGetInfo = new StationTableInfo();
        ArrayList<String> stationList = (ArrayList<String>) request.getSession().getAttribute("stationList");
        String lastStation = stationList.get(stationList.size() - 1);
        ArrayList<String> possibleStation = baseGetInfo.getArrayNameStation(baseGetInfo.getPossibleWay(baseGetInfo.getIndexStation(lastStation)));%>
    <%ArrayList<Integer> timeList = (ArrayList<Integer>) request.getSession().getAttribute("timeList");%>


<%--<%--%>
    <%--List<String> q = new ArrayList<String>();--%>
    <%--q.add("Продукты");--%>
    <%--q.add("Одежда");--%>
    <%--q.add("Обувь");--%>
    <%--q.add("Спортивный инвентарь");--%>
    <%--request.setAttribute("possibleStation", q);--%>
<%--%>--%>

<%--<h3>Список групп товаров</h3>--%>
<%--<ul>--%>
    <%--<c:forEach items="${possibleStation}" var="i" >--%>
        <%--<li><c:out value="${i}" /></li><br />--%>
    <%--</c:forEach>--%>
<%--</ul>--%>


<table class="cinereousTable">
    <tbody>
    <tr>
        <% for (int i = 0; i < stationList.size(); i++) { %>
        <td><%=" " + stationList.get(i) + "(" + timeList.get(i) + "h) ⟹"%></td>
        <%}%>
    </tr>
    </tbody>
</table>
<table class="cinereousTable" style="max-width: 100px;margin-left: 45%;margin-top: 2%">
    <thead>
    <tr>
        <th>Station</th>
    </tr>
    <thead>
        <% for (int i = 0; i < possibleStation.size(); i++) { %>
    <tbody>
    <tr>
        <th><%= possibleStation.get(i)%></th>
    </tr>
    </tbody>
    <%}%>
</table>





<form onsubmit="return validata()" action="/sock/addRoute" method="post" style="margin-left: 40%;margin-top: 2%" >
    <input type=text class="css-input" name="nextStation">
    <input type=hidden name="command" value="addStation">
    <br>
    <br>
    <button style="margin-left: 6%" class="getInfoButton" id="btn" type="submit" >add station</button>
</form>


<form action="/sock/addRoute" method="post" style="margin-left: 40%">
    <input type=hidden name="command" value="addTrain">
    <button style="margin-left: 8%;" type="submit" class="addRouteButton">Save route</button></form>

<%--<script>--%>
    <%--var station = ['Cache', 'Inferno','Mirage','Train','Overpass','Nuke','Subzero','Office','Dust','Vertigo'];--%>

    <%--function validata() {--%>
        <%--var str = document.getElementById("btn").value;--%>


        <%--for(i=0;i<station.length;i++)--%>
        <%--{--%>
            <%--if(str==station[i])--%>
            <%--{--%>
                <%--console.log(str);--%>
                <%--return true;--%>
            <%--}--%>
        <%--}--%>
        <%--alert("Enter correct value");--%>
        <%--console.log("Err");--%>
        <%--// window.location.href='/sock/addRouteJsp';--%>
        <%--return false;--%>
    <%--}--%>
<%--</script>--%>
</body>
</html>
