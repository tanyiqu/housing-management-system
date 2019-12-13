<%@ page import="bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="house" scope="request" type="bean.House"/>
<jsp:useBean id="host" scope="request" type="bean.User"/>
<html>
<head>
    <title>详情</title>
    <link href="css/head.css" rel="stylesheet">
</head>
<body>
    <a href="index.jsp">首页</a>
    <a href="index.jsp">${sessionScope.buyer.userName}(退出登录)</a>
    <div class="nav">
        <h1>详情</h1>
    </div>


    <h2>${house.houseName}</h2>
    <h2>地址：${house.addr}</h2>
    <h2>类型：${house.type}</h2>

    <h2>房间：${house.room}</h2>
    <h2>建筑年份：${house.year}</h2>
    <h2>面积：${house.area}</h2>
    <h2>价格：${house.price}</h2>

    <h2>房主：${host.trueName}</h2>
    <h2>联系电话：${host.tel}</h2>



</body>
</html>
