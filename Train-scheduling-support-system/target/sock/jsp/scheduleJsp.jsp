<%@ page import="model.dao.imp.BaseGetInfo" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: mturo
  Date: 28.05.2019
  Time: 2:31
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

<div style="height:50px;width: 100%;left:2%;position: fixed;top: 2%;" >
    <button class="addRouteButton" onclick="window.location.href='/sock/mainJsp'">Home</button>
</div>

        <table class="cinereousTable" style="border: 6px solid #fe8300; text-align: center">
            <thead>
            <tr>
                <th><h2>Start Route - End Route</h2></th>
                <th><h2>Time start - time end</h2></th>
            </tr>
            </thead>
        </table>
<%BaseGetInfo BD = new BaseGetInfo();%>
<%int count = BD.getCountRoute();%>
<%ArrayList<Integer>indexList = BD.getDistinctRouteSchedule();%>


    <%for (int i=0;i<count;i++){%>
        <%int currentIndex = indexList.get(i);%>
        <%ArrayList<String>stationList = BD.getStationSchedule(currentIndex);%>
        <%ArrayList<Integer>timeList = BD.getTimeSchedule(currentIndex);%>
        <%String trainName = BD.getNameTrainInSchedule(currentIndex);%>
      <table class="cinereousTable">
       <thead>
        <tr>
            <th><h2><b style="color:#476e9e"><%=trainName%></b>  <%=stationList.get(0)%>-<%=stationList.get(stationList.size()-1)%>- <b style="color:black"><%=currentIndex%></b></h2></th>
            <th><h2><%=timeList.get(0)%>-<%=timeList.get(timeList.size()-1)%></h2>
                <form action="/sock/info" method="get">
                    <input type="hidden" name="delete" value="<%=currentIndex%>">
                    <button type="submit">delete</button>
                </form>
            </th>
        </tr>
       </thead>

       <tbody>

            <%for (int j=0;j<stationList.size();j++){%>
            <tr>
                <th><%=stationList.get(j)%></th>
                <th><%=timeList.get(j)%></th>
            </tr>

            <%}%>
         </tbody>
          <br>
        <%}%>

</table>
</body>
</html>
