<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="admin" scope="request" type="bean.Admin"/>
<jsp:useBean id="income" scope="request" type="bean.Income"/>
<%@ page errorPage="admin_500.jsp" %>
<html>
<head>
    <title>后台管理</title>
    <link href="css/head.css" rel="stylesheet">
</head>
<body>
    <a href="index.jsp">首页</a>
    <div class="nav">
        <h1>后台管理</h1>
    </div>

    <h2>${admin.username}</h2>

    <h1>出售信息</h1>


    <h1>收入统计</h1>
    <table border="1">
        <tr>
            <th>总售价（万）</th>
            <th>收入笔数</th>
            <th>单笔均价（万）</th>
        </tr>
        <tr>
            <th>${income.total}</th>
            <th>${income.nums}</th>
            <th>${income.avg}</th>
        </tr>

    </table>

    <h1>报表</h1>

</body>
</html>
