<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索</title>
    <link href="css/head.css" rel="stylesheet">
</head>

<body>

    <a href="index.jsp">首页</a>
    <a href="index.jsp">${sessionScope.buyer.userName}(退出登录)</a>
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
</body>
</html>
