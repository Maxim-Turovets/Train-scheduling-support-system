<%--
  Created by IntelliJ IDEA.
  User: mturo
  Date: 26.05.2019
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Start Station</title>


</head>
    <style>
        <%@include file="/webresourse/css/main.css"%>
    </style>
</head>
<body>
<div style="height:50px;width: 100%;left:2%;position: fixed;top: 2%;" >
    <button class="addRouteButton" onclick="window.location.href='/sock/mainJsp'">Home</button>
</div>

<table class="cinereousTable" style="max-width: 250px;margin-left: 40%;margin-top: 15%">

    <thead>
    <tr>
        <th>Add station and start time</th>
    </tr>
    <thead>

</table>

<form onsumbit="return validata()" action="/sock/addRoute" method="post">
    <input style="margin-left:30%;margin-top:5%;" id="btn" class="css-input" type=text     name="startStation" placeholder="Station name">
    <input class="css-input" type="number"   name="startTime" placeholder="start time">
    <button type="submit" class="getInfoButton" onClick="validata()">Next</button>
</form>




<script>
    var station = ['Cache', 'Inferno','Mirage','Train','Overpass','Nuke','Subzero','Office','Dust','Vertigo'];

    function validata() {
        var str = document.getElementById("btn").value;


        for(i=0;i<station.length;i++)
        {
            if(str==station[i])
            {
                console.log(str);
                return true;
            }
        }
        alert("Enter correct value");
        console.log("Err");
        return false;
    }
</script>
</body>
</html>
