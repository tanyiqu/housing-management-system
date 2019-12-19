<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="houses" scope="request" type="java.util.List"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>搜索结果</title>
    <link href="css/head.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/table.css" rel="stylesheet">
    <script src="js/jquery-3.4.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/check_search.js"></script>
</head>
<body>

    <a href="index.jsp">首页</a>
    <a href="login.jsp">${sessionScope.buyer.userName}(退出登录)</a>
    <div class="nav">
        <h1>共搜索到${houses.size()}条记录</h1>
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
            <form name="f2" method="post" action="search_result" class="form-inline" style="text-align: center" onsubmit="return check_f2()">
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
            <form name="f3" method="post" action="search_result" class="form-inline" style="text-align: center" onsubmit="return check_f3()">
                <div class="form-group">
                    <p class="form-control-static">按价格（万）：</p>
                </div>
                <div class="form-group">
                    <input type="number" name="keyword_price_lower" class="form-control" style="width:166px">~
                    <input type="number" name="keyword_price_higher" class="form-control" style="width:166px">
                </div>
                <button type="submit" class="btn btn-default">搜房源</button>
            </form>
        </div>

    </div>

    <c:if test="${empty houses}">
        <h1>没有搜索到记录</h1>
    </c:if>

    <c:if test="${!empty houses}">
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
    </c:if>



</body>
</html>
