<%@ page import="bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="house" scope="request" type="bean.House"/>
<jsp:useBean id="host" scope="request" type="bean.User"/>
<html>
<head>
    <title>详情</title>
    <link href="css/head.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.4.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
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
        <h3>ID:${house.houseId}</h3>
        <h3>${house.houseName}</h3>
        <h3>地址：${house.addr}</h3>
        <h3>类型：${house.type}</h3>
        <h3>房间：${house.room}</h3>
        <h3>建筑年份：${house.year}</h3>
        <h3>面积：${house.area}㎡</h3>
        <h3>价格：${house.price}万</h3>
        <h3>房主：${host.trueName}</h3>
        <h3>房主id：${host.userName}</h3>
        <h3>联系电话：${host.tel}</h3>
        <input type="button" value="立即购买" class="btn btn-default btn-sm" style="width: 260px;height: 50px" onclick="buy()">
    </div>


</body>
</html>
