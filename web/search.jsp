<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索</title>
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
        <h1>搜索房源</h1>
    </div>

    <div style="background-color: rgb(236, 250, 235);padding: 5px">
        <div style="margin: 0 0 0 4px">
            <form method="post" action="search_result" class="form-inline" style="text-align: center">
                <div class="form-group">
                    <p class="form-control-static">搜地区：</p>
                </div>
                <div class="form-group">
                    <input type="text" name="keyword_addr" class="form-control" placeholder="输入县区/路名/小区" style="width:233px">
                </div>
                <button type="submit" class="btn btn-default">搜房源</button>
            </form>
        </div>
        <div style="margin: 4px">
            <form method="post" action="search_result" class="form-inline" style="text-align: center">
                <div class="form-group">
                    <p class="form-control-static">按面积（㎡）：</p>
                </div>
                <div class="form-group">
                    <input type="number" name="keyword_area_lower" class="form-control" style="width:166px">~
                    <input type="number" name="keyword_area_higher" class="form-control" style="width:166px">
                </div>
                <button type="submit" class="btn btn-default">搜房源</button>
            </form>
        </div>
        <div style="margin: 4px 0 0 0">
            <form method="post" action="search_result" class="form-inline" style="text-align: center">
                <div class="form-group">
                    <p class="form-control-static">按面积（㎡）：</p>
                </div>
                <div class="form-group">
                    <input type="number" name="keyword_price_lower" class="form-control" style="width:166px">~
                    <input type="number" name="keyword_price_higher" class="form-control" style="width:166px">
                </div>
                <button type="submit" class="btn btn-default">搜房源</button>
            </form>
        </div>

    </div>

</body>
</html>
