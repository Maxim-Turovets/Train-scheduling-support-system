<%@ page import="java.util.ArrayList" %>
<%@ page import="model.dao.imp.BaseGetInfo" %><%--
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
<table class="cinereousTable" style="max-width: 250px;margin-left: 40%;margin-top: 2%">

    <thead>
    <tr>
        <th>Add station and start time</th>
    </tr>
    <thead>

</table>


    <%
            BaseGetInfo baseGetInfo = new BaseGetInfo();
            ArrayList<String> stationList = (ArrayList<String>) request.getSession().getAttribute("stationList");
            String lastStation = stationList.get(stationList.size() - 1);
            ArrayList<String> list = baseGetInfo.getArrayNameStation(baseGetInfo.getPossibleWay(baseGetInfo.getIndexStation(lastStation)));%>
    <%ArrayList<String> list2 = (ArrayList<String>) request.getSession().getAttribute("stationList");%>
    <%ArrayList<Integer> list3 = (ArrayList<Integer>) request.getSession().getAttribute("timeList");%>


<table class="cinereousTable">
    <tbody>
    <tr>
        <% for (int i = 0; i < list2.size(); i++) { %>
        <td><%=" " + list2.get(i) + "(" + list3.get(i) + "h) ⟹"%></td>
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

        <% for (int i = 0; i < list.size(); i++) { %>
        <tbody>
          <tr>
        <th><%= list.get(i)%></th>
          </tr>
         </tbody>
        <%}%>

</table>



<form action="/sock/addRoute" method="post" style="margin-left: 40%;margin-top: 2%" >
    <input type=text class="css-input" name="nextStation">
    <br>
    <br>
    <button style="margin-left: 6%" class="getInfoButton" type="submit">add station</button>
</form>


<form action="/sock/addRoute" method="post" style="margin-left: 40%">
    <input type=hidden name="save" value="save">
    <button style="margin-left: 8%;" type="submit" class="addRouteButton">Save route</button></form>


</body>
</html>
