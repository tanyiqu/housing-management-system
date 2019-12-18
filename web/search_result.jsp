<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="houses" scope="request" type="java.util.List"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>结果</title>
    <link href="css/head.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/table.css" rel="stylesheet">
    <script src="js/jquery-3.4.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

    <a href="index.jsp">首页</a>
    <a href="login.jsp">${sessionScope.buyer.userName}(退出登录)</a>
    <div class="nav">
        <h1>搜索</h1>
    </div>

    <div style="background-color: rgb(236, 250, 235)">
        <form method="post" action="search_result" style="text-align: center">
            搜地区
            <input type="text" name="keyword_addr">
            <input type="submit" value="搜房源">
        </form>
        <form method="post" action="search_result" style="text-align: center">
            按面积（㎡）
            <input type="number" name="keyword_area_lower">~
            <input type="number" name="keyword_area_higher">
            <input type="submit" value="搜房源">
        </form>
        <form method="post" action="search_result" style="text-align: center">
            按价格（万）
            <input type="number" name="keyword_price_lower">~
            <input type="number" name="keyword_price_higher">
            <input type="submit" value="搜房源">
        </form>
    </div>


    <div>
        <table class="table table-bordered table-hover">
            <tr class="success">
                <th>id</th>
                <th>房名</th>
                <th>地址</th>
                <th>类型</th>
                <th>年份</th>
                <th>房间</th>
                <th>面积（㎡）</th>
                <th>售价（万）</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${houses}" var="house">
                <tr>
                    <td>${house.houseId}</td>
                    <td>${house.houseName}</td>
                    <td>${house.addr}</td>
                    <td>${house.type}</td>
                    <td>${house.year}</td>
                    <td>${house.room}</td>
                    <td>${house.area}</td>
                    <td>${house.price}</td>
                    <th><a href="detail?&id=${house.houseId}" target="_blank"><input type="button" value="查看详情" class="btn btn-default btn-sm"></a></th>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
