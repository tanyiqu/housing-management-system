<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="admin" scope="request" type="bean.Admin"/>
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


    <h1>销售统计</h1>


    <h1>报表</h1>

</body>
</html>
