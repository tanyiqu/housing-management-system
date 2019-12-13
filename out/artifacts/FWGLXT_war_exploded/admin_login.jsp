<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
    <link rel="stylesheet" type="text/css" href="css/admin_login.css"/>
</head>
<body style="background-image:url(imgs/bg_index.png);background-size: 100%">

    <h1 style="text-align: center;">房屋中介管理</h1>
    <div class="main">
        <h1>管理员登录</h1>
        <form name="form_login" action="admin_login" method="post" onsubmit="return check()">
            <input type="text" name="userName" placeholder="请输入账号" value="15139744921" onfocus="this.value='';">
            <input type="password" name="passwd" placeholder="请输入密码" value="108412696wu" onfocus="this.value='';">
            <input type="submit" value="登录">
        </form>
    </div>
</body>
</html>
