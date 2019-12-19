<%@ page import="java.util.List" %>
<%@ page import="bean.SellerCard" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="seller" type="bean.User" scope="session"/>
<jsp:useBean id="sellerCards" scope="request" type="java.util.List"/>
<html>
<head>
    <title>我的出售</title>
    <link href="css/head.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/table.css" rel="stylesheet">
    <script src="js/jquery-3.4.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>

<body>
    <a href="index.jsp">首页</a>
    <a href="login.jsp">${sessionScope.seller.userName}(退出登录)</a>
    <div class="nav">
        <h1>房屋中介</h1>
    </div>

    <a href="addHouse" target="_blank" style="margin-left:10px">
<%--        <input type="button" value="我要发布" style="width: 260px;height: 50px">--%>
        <button class="btn btn-primary" style="width: 260px;height: 50px;margin: 10px 0 10px 40px">我要发布</button>
    </a>

    <h1 style="margin-left: 50px">我的出售</h1>
    <c:if test="${empty sellerCards}">
        <h3>没有出售记录哦！</h3>
    </c:if>
    <c:if test="${!empty sellerCards}">
        <div style="margin: 10px 50px 10px 50px;">
            <table class="table table-bordered table-hover">
                <tr class="success">
                    <th>id</th>
                    <th>房间名称</th>
                    <th>售价（万）</th>
                    <th>已售</th>
                </tr>

                <c:forEach items="${sellerCards}" var="sellerCard">
                    <tr>
                        <td>${sellerCard.id}</td>
                        <td>${sellerCard.name}</td>
                        <td>${sellerCard.price}</td>
                        <td>${sellerCard.soldout}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>


</body>
</html>
