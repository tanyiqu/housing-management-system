<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="gb2312">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/login.js" type="text/javascript"></script>
</head>
<body style="background-image:url(imgs/bg_login.png);background-size: auto">
    <a href="index.jsp">首页</a>
    <h1 style="text-align: center">房屋中介管理</h1>

    <div class="main">
        <h1>账号登录</h1>
        <form name="form_login" action="login" method="post" onsubmit="return check()">
            <select name="type">
                <option value="0">买房</option>
                <option value="1">卖房</option>
            </select>
            <input type="text" name="userName" placeholder="请输入账号" value="gf10001" onfocus="this.value='sf10001'">
            <input type="password" name="passwd" placeholder="请输入密码" value="gfmm10001" onfocus="this.value='sfmm10001'">
            <input type="submit" value="登录">
            <p>
                <a href="#">忘记密码</a>
                <a href="#">修改密码</a>
            </p>
        </form>
    </div>
</body>
</html>