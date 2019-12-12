<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <script src="js/jquery-3.4.1.js" type="text/javascript"></script>
    <script src="js/registered.js" type="text/javascript"></script>
    <script>

        /**
         * 发送验证码
         * @param wait 倒计时时长
         */
        function sendVCEmail(wait){
            //sendEmailServlet
            //获取邮箱
            var em = document.getElementById("email");
            em = em.value;
            //判断邮箱是否合法
            var right = isEmail(em);
            if(!right){
                window.alert("邮箱不合法!");
                return;
            }
            //进入计时
            const btn = document.getElementById("sendBtn");
            btn.disabled=true;
            count(wait);
            //提交发送
            $.post("sendEmail", {em:em},function(){
                // alert("发送成功");
            });
        }

        /**
         * 按钮计时函数
         * @param i 还有多少秒
         */
        function count(i){
            var btn = document.getElementById("sendBtn");
            i--;
            if(i===0){
                btn.value = "发送验证码";
                btn.disabled=false;
            }
            else{
                btn.value = "发送验证码("+i+")";
                setTimeout("count("+i+")",1000)
            }
        }

    </script>

</head>
<body>
    <h1 style="text-align: center">用户注册</h1><br>

    <div>
        <form name="f1" method="post" action="registered" onsubmit="return check()">
            类型：
            <select name="type">
                <option value="0">买方注册</option>
                <option value="1">卖方注册</option>
            </select><br>

            用户名：<input type="text" name="userName">* 6-16位，字母数字组合，以字母开头<br>

            密码：<input type="password" name="passwd">* 6-16位，字母数字组合<br>

            确认密码：<input type="password" name="repasswd">*<br>

            真实姓名：<input type="text" name="trueName">*<br>

            电话：<input type="text" name="tel">*<br>

            邮箱：<input type="email" name="email" id="email">*
            <input type="button" id="sendBtn" value="发送验证码" onclick="sendVCEmail(10)"><br>

            验证码：<input type="text" name="vc">*<br>

            <input type="submit" value="注册">

        </form>
    </div>

</body>
</html>
