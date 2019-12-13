<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="seller" type="bean.User" scope="session"/>
<html>
<head>
    <title>发布房源</title>
    <link href="css/head.css" rel="stylesheet">
    <script>
        function check() {
            var houseName = document.f.houseName.value;
            var area = document.f.area.value;
            var room = document.f.room.value;
            var year = document.f.year.value;
            var addr = document.f.addr.value;
            var price = document.f.price.value;
            var re = /^\s*$/;
            if(re.test(houseName)){
                window.alert("请输入描述！");
                return false;
            }
            if(re.test(area)){
                window.alert("请输入面积！");
                return false;
            }
            if(re.test(room)){
                window.alert("请输入房间数！");
                return false;
            }
            if(re.test(year)){
                window.alert("请输入建筑年份！");
                return false;
            }
            if(re.test(addr)){
                window.alert("请输入地址！");
                return false;
            }
            if(re.test(price)){
                window.alert("请输入价格！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <a href="index.jsp">首页</a>
    <a href="index.jsp">${sessionScope.seller.userName}(退出登录)</a>
    <div class="nav">
        <h1>发布房源</h1>
    </div>

    <h1>${seller.userName}</h1>

    <div>
        <form name="f" action="insertHouse" method="post" onsubmit="return check()">
            描述（最多50个汉字）：
            <textarea name="houseName"></textarea><br>
            类型：
            <select name="type">
                <option value="0">普通住宅</option>
                <option value="1">公寓</option>
                <option value="2">别墅</option>
                <option value="3">平房</option>
                <option value="4">四合院</option>
                <option value="5">其他</option>
            </select><br>
            面积：<input type="text" name="area"><br>
            厅室（？室？厅？卫）：<input type="text" name="room"><br>
            建筑年份：<input type="text" name="year"><br>
            地址（市-县区-路）：<input type="text" name="addr"><br>
            价格（万）：<input type="text" name="price"><br>
            <input type="submit" value="确定">
        </form>
    </div>

</body>
</html>
