<%@ page import="model.dao.imp.BaseGetInfo" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: mturo
  Date: 27.05.2019
  Time: 3:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/webresourse/css/main.css"%>
    </style>

    <div style="height:50px;left:2%;position: fixed;top: 2%;" >
        <button class="addRouteButton" onclick="window.location.href='/sock/mainJsp'">Home</button>
    </div>

<%   BaseGetInfo baseGetInfo = new BaseGetInfo();
     ArrayList<Integer> stationList = baseGetInfo.getCrossIndex(request.getParameter("stationName"));
%>

    <form  style="margin-left: 35%;" action="/sock/info" method="get">
        <input type=text name="stationName"  class="css-input" placeholder="Enter station" >
       <button type="submit" class="getInfoButton">Get Info</button></form>
    <br>

    <table class="cinereousTable">
        <thead>
        <tr>
            <th>Train</th>
            <th>Crossing name</th>
            <th>Start time</th>
            <th>End time</th>
        </tr>
        </thead>

        <tbody>
    <%for (int i = 0;i<stationList.size();i++){%>
      <%ArrayList<Integer> startTime=baseGetInfo.getStartCrossingTimeArray(stationList.get(i));%>
      <%ArrayList<Integer> endTime=baseGetInfo.getEndCrossingTimeArray(stationList.get(i));%>
      <%String trainName = baseGetInfo.getNameTrainInSchedule(baseGetInfo.getRouteId(stationList.get(i)));%>
         <%for (int j = 0;j<startTime.size();j++){%>
        <tr>
            <td><%=trainName%></td>
            <td><%=baseGetInfo.getDoubleNameCrossing(stationList.get(i)).get(0)+"  -  "+baseGetInfo.getDoubleNameCrossing(stationList.get(i)).get(1)%></td>
            <td><%=startTime.get(j)%></td>
            <td><%=endTime.get(j)%></td>
        </tr>
        </tbody>
         <%}%>
    <%}%>
    </table>




</head>
<body>

</body>
</html>
