<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body style="background-image:url(https://raw.githubusercontent.com/Tanyiqu/FWGLXT/master/web/imgs/bg.png);background-size:100%">
    <h1 style="text-align: center">用户注册</h1><br>

    <div>
        <form method="post" action="registered">

            用户名：<input type="text" name="userName"><span style="color: red;">*</span><br>

            密码：<input type="text" name="passwd"><span style="color: red;">*</span><br>

            邮箱：<input type="text" name="email"><span style="color: red;">*<input type="button" value="发送验证码"></span><br>

            验证码：<input type="text" name="vc"><span style="color: red;"></span><br>

            <input type="submit" value="注册">

        </form>
    </div>


</body>
</html>
