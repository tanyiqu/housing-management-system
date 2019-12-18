<%@ page import="bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="house" scope="request" type="bean.House"/>
<jsp:useBean id="host" scope="request" type="bean.User"/>
<html>
<head>
    <title>详情</title>
    <link href="css/head.css" rel="stylesheet">
    <script>
        function buy() {
            var r = confirm("确认购买吗？此操作不可撤销！");
            if(r){
                // window.alert("确定");
                // window.location.href = "buyer?&userName=w15139744921&passwd=108412696" ;
                <%--var str = "${sessionScope.buyer.userName}买${house.houseId}";--%>
                <%--window.alert(str);--%>
                window.location.href = "buy?&id=${house.houseId}";
            }else {
                window.alert("操作已取消！");
            }
        }
    </script>
</head>
<body>
    <a href="index.jsp">首页</a>
    <a href="login.jsp">${sessionScope.buyer.userName}(退出登录)</a>
    <div class="nav">
        <h1>详情</h1>
    </div>

    <div style="margin: 10px 0 0 20px">
        <h2>ID:${house.houseId}</h2>
        <h2>${house.houseName}</h2>
        <h2>地址：${house.addr}</h2>
        <h2>类型：${house.type}</h2>
        <h2>房间：${house.room}</h2>
        <h2>建筑年份：${house.year}</h2>
        <h2>面积：${house.area}㎡</h2>
        <h2>价格：${house.price}万</h2>
        <h2>房主：${host.trueName}</h2>
        <h2>房主id：${host.userName}</h2>
        <h2>联系电话：${host.tel}</h2>
        <input type="button" value="立即购买" style="width: 260px;height: 50px" onclick="buy()">
    </div>


</body>
</html>
