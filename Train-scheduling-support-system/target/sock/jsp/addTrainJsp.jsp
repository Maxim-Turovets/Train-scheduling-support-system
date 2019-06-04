<%@ page import="java.util.ArrayList" %>
<%@ page import="model.dao.imp.BaseGetInfo" %>
<%@ page import="model.dao.daointerfaces.DAoTrain" %>
<%@ page import="model.dao.imp.TrainTableInfo" %><%--
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
        <th>Add Train </th>
    </tr>
    <thead>

</table>


<%
    DAoTrain dAoTrain = new TrainTableInfo();
    ArrayList<String> trainList = (ArrayList<String>) dAoTrain.getAvailableTrain();
%>







<table class="cinereousTable" style="max-width: 100px;margin-left: 45%;margin-top: 2%">

    <thead>
    <tr>
        <th>Available trains</th>
    </tr>
    <thead>

        <% for (int i = 0; i < trainList.size(); i++) { %>
    <tbody>
    <tr>
        <th><%= trainList.get(i)%></th>
    </tr>
    </tbody>
    <%}%>

</table>



<form action="/sock/addTrain" method="post" style="margin-left: 40%;margin-top: 2%" >
    <input type=text class="css-input" name="nameTrain">
    <br>
    <br>
    <button style="margin-left: 6%" class="getInfoButton" type="submit">add Train</button>
</form>


<%--<form action="/sock/addRoute" method="post" style="margin-left: 40%">--%>
    <%--<input type=hidden name="save" value="save">--%>
    <%--<button style="margin-left: 8%;" type="submit" class="addRouteButton">Save route</button></form>--%>


</body>
</html>
