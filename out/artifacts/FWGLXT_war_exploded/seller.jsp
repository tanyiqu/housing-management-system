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
    <link href="css/table.css" rel="stylesheet">
</head>
<body>
    <a href="index.jsp">首页</a>
    <a href="index.jsp">${sessionScope.seller.userName}</a>
    <div class="nav">
        <h1>房屋中介</h1>
    </div>

    <h1>我的出售</h1>
    <c:if test="${empty sellerCards}">
        <h3>没有出售记录哦！</h3>
    </c:if>
    <c:if test="${!empty sellerCards}">
        <table border="1px">
            <tr>
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
    </c:if>


    
    <a href="addHouse" target="_blank">
        <input type="button" value="我要发布" style="height: 100px;width: 300px; border-radius: 20px">
    </a>


</body>
</html>
