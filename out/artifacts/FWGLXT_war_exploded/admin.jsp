<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="admin" scope="request" type="bean.Admin"/>
<jsp:useBean id="income" scope="request" type="bean.Income"/>
<jsp:useBean id="sales" scope="request" type="java.util.List"/>
<%@ page errorPage="admin_500.jsp" %>
<html>
<head>
    <title>后台管理</title>
    <link href="css/head.css" rel="stylesheet">
</head>
<body>
    <a href="index.jsp">首页</a>
    <div class="nav">
        <h1>后台管理-报表</h1>
    </div>

    <h2>${admin.username}</h2>
    <h1>出售信息</h1>
    <table border="1">
        <tr>
            <th>买方ID</th>
            <th>买方姓名</th>
            <th>房源ID</th>
            <th>房名</th>
            <th>价格（万）</th>
            <th>购买日期</th>
        </tr>
        <c:forEach items="${sales}" var="sale">
            <tr>
                <td>${sale.buyer_username}</td>
                <td>${sale.buyer_truename}</td>
                <td>${sale.houseId}</td>
                <td>${sale.housename}</td>
                <td>${sale.price}</td>
                <td>${sale.date}</td>
            </tr>
        </c:forEach>

    </table>

    <h1>收入统计</h1>
    <table border="1">
        <tr>
            <th>总交易额（万）</th>
            <th>交易笔数</th>
            <th>单笔均价（万）</th>
        </tr>
        <tr>
            <th>${income.total}</th>
            <th>${income.nums}</th>
            <th>${income.avg}</th>
        </tr>

    </table>



</body>
</html>
