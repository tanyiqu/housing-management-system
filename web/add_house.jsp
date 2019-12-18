<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="seller" type="bean.User" scope="session"/>
<html>
<head>
    <title>发布房源</title>
    <link href="css/head.css" rel="stylesheet">
    <link href="css/add_house.css" rel="stylesheet">

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
    <a href="login.jsp">${sessionScope.seller.userName}(退出登录)</a>
    <div class="nav">
        <h1>发布房源</h1>
    </div>

<%--    <h1>${seller.userName}</h1>--%>

    <div class="smart-green" style="margin-top: 50px">
        <h1>发布房源
            <span>发布者：${seller.userName}</span>
        </h1>
        <form name="f" action="insertHouse" method="post" onsubmit="return check()">

            <label>
                <span>描述（最多50个汉字）：</span>
                <textarea name="houseName" placeholder="请输入描述..."></textarea>
            </label>

            <label>
                <span>类型：</span>
                <select name="type">
                    <option value="0">普通住宅</option>
                    <option value="1">公寓</option>
                    <option value="2">别墅</option>
                    <option value="3">平房</option>
                    <option value="4">四合院</option>
                    <option value="5">其他</option>
                </select>
            </label>

            <label>
                <span>面积：</span>
                <input type="text" name="area" placeholder="例：120">
            </label>

            <label>
                <span>厅室（？室？厅？卫）：</span>
                <input type="text" name="room" placeholder="例：3室2厅1卫">
            </label>


            <label>
                <span>建筑年份：</span>
                <input type="text" name="year" placeholder="例：2019">
            </label><br>

            <label>
                <span>地址（市-县区-路）：</span>
                <input type="text" name="addr" placeholder="例：平顶山-新华区-龙翔大道">
            </label><br>

            <label>
                <span>价格（万）：</span>
                <input type="text" name="price" placeholder="例：80">
            </label>

            <input type="submit" class="button" value="确定" />
        </form>
    </div>

</body>
</html>
