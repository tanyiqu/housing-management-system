<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <script src="js/jquery-3.4.1.js" type="text/javascript"></script>
    <script>

        function sendVCEmail(wait){
            //sendEmailServlet
            //获取邮箱
            var em = document.getElementById("email");
            em = em.value;
            //判断邮箱是否合法
            var right = isEmail(em);
            if(!right){
                return;
            }
            //进入计时
            const btn = document.getElementById("sendBtn");
            btn.disabled=true
            count(wait)
            //提交发送
            $.post("sendEmailServlet", {em:em},function(){
                // alert("发送成功");
            });
        }

        /**
         * 按钮计时函数
         * @param i 还有多少秒
         */
        function count(i){
            var btn = document.getElementById("sendBtn")
            i--;
            if(i==0){
                btn.value = "发送验证码"
                btn.disabled=false
            }
            else{
                btn.value = "发送验证码("+i+")"
                setTimeout("count("+i+")",1000)
            }
        }

        /**
         * 判断是否为邮箱
         * @param email 输入
         * @returns {boolean} 是否为邮箱
         */
        function isEmail(email) {
            return true;
        }

    </script>




</head>
<body style="background-image:url(imgs/bg.png);background-size:100%">
<%--https://raw.githubusercontent.com/Tanyiqu/FWGLXT/master/web/imgs/bg.png--%>
    <h1 style="text-align: center">用户注册</h1><br>

    <div>
        <form method="post" action="registered">

            用户名：<input type="text" name="userName"><span style="color: red;">*</span><br>

            密码：<input type="text" name="passwd"><span style="color: red;">*</span><br>

            邮箱：<input type="text" name="email" id="email"><span style="color: red;">*</span>
            <input type="button" id="sendBtn" value="发送验证码" onclick="sendVCEmail(10)"><br>

            验证码：<input type="text" name="vc"><span style="color: red;"></span><br>

            <input type="submit" value="注册">

        </form>
    </div>

</body>
</html>
