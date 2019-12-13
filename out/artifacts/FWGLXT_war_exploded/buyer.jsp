<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="buyer" type="bean.User" scope="session"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="buyerCards" scope="request" type="java.util.List"/>
<jsp:useBean id="houses" scope="request" type="java.util.List"/>

<html>
<head>
    <title>首页</title>
    <style type="text/css">
        h1{
            font-size:30px;
            font-weight:400;
            padding-top: 10px;
            padding-left: 10px;
        }
    </style>
    <link href="css/head.css" rel="stylesheet">
    <link href="css/table.css" rel="stylesheet">

</head>
<body style="background-color: rgb(240, 240, 240)">

    <a href="index.jsp">首页</a>
    <a href="index.jsp">${sessionScope.buyer.userName}(退出登录)</a>
    <div class="nav">
        <h1>房屋中介</h1>
    </div>

    <div>
        <form method="post" action="" style="text-align: center">
            <input type="text" id="keyword">
            <select>
                <option id="0">按地区</option>
                <option id="1">按价格</option>
                <option id="2">按面积</option>
            </select>
            <input type="submit" id="search" value="搜房源">
        </form>
    </div>

    <h1>优质房源</h1>
    <div>
        <table>
            <tr>
                <th>id</th>
                <th>房名</th>
                <th>地址</th>
                <th>类型</th>
                <th>年份</th>
                <th>房间</th>
                <th>面积（平）</th>
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
                    <th><a href="detail?&id=${house.houseId}" target="_blank"><input type="button" value="查看详情"></a></th>
                </tr>
            </c:forEach>
        </table>
    </div>

    <h1>购买记录</h1>
    <c:if test="${empty buyerCards}">
        <h3>没有购买记录哦！</h3>
    </c:if>
    <c:if test="${!empty buyerCards}">
        <table border="1">
            <tr>
                <th>房名</th>
                <th>价格（万）</th>
                <th>购买时间</th>
                <th>房主</th>
                <th>房主手机</th>
            </tr>
            <c:forEach items="${buyerCards}" var="buyerCard">
                <tr>
                    <td>${buyerCard.name}</td>
                    <td>${buyerCard.price}</td>
                    <td>${buyerCard.date}</td>
                    <td>${buyerCard.hostname}</td>
                    <td>${buyerCard.hosttel}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>


</body>
</html>
