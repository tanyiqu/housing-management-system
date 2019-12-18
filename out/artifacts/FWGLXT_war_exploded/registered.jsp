<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <link rel="stylesheet" href="css/registered.css">
    <script src="js/jquery-3.4.1.js" type="text/javascript"></script>
    <script src="js/registered.js" type="text/javascript"></script>
    <script>

        /**
         * 发送验证码
         * @param wait 倒计时时长
         */
        function sendVCEmail(wait){
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
<body style="background-image: url(imgs/house/01.png);background-repeat: no-repeat;background-size: cover">
    <a href="index.jsp">首页</a>
    <div class="div">
        <form name="f1" action="registered" method="post" class="registered" onsubmit="return check()">
            <h1 style="text-align: center;">房屋中介-用户注册</h1>
            <label>
                <span>类型：</span>
                <select id="template" name="type">
                    <option value="0">买房注册</option>
                    <option value="1">卖房注册</option>
                </select>
            </label>
            <label>
                <span>用户名：</span>
                <input type="text" name="userName" placeholder=" 6-16位字母数字组合，以字母头" />
            </label>
            <label>
                <span>密码：</span>
                <input type="password" name="passwd" placeholder=" 6-16位"/>
            </label>

            <label>
                <span>确认密码：</span>
                <input type="password" name="repasswd" placeholder=" 6-16位"/>
            </label>

            <label>
                <span>真实姓名：</span>
                <input type="text" name="trueName" placeholder=" 请输入真实姓名"/>
            </label>

            <label>
                <span>电话：</span>
                <input type="text" name="tel" placeholder=" 请输入电话"/>
            </label>

            <label>
                <span>邮箱：</span>
                <input type="email" name="email" id="email" placeholder=" 请输入邮箱"/>
                <input type="button" id="sendBtn" value="发送验证码" onclick="sendVCEmail(30)">
            </label>

            <label>
                <span>验证码：</span>
                <input type="text" name="vc" placeholder=" 请输入验证码（区分大小写）"/>
            </label>

            <label style="width: 100%;">
                <span>&nbsp;</span>
                <input type="submit" class="button" value="注册" />
            </label>
        </form>
    </div>



</body>
</html>
