<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="buyer" type="bean.User" scope="session"/>
<html>
<head>
    <title>首页</title>
</head>
<body style="background-color: rgb(240, 240, 240)">

    <div>
        <form method="post" action="">
            <input type="text" id="keyword">
            <select>
                <option id="0">按地区</option>
                <option id="1">按价格</option>
                <option id="2">按面积</option>
            </select>
            <input type="submit" id="search" value="搜房源">
        </form>

    </div>

    <h1>优质房源</h1>

    <jsp:getProperty name="buyer" property="userName"/>

    <table>
        <tr>
            <td><img width="100%"  src="imgs/bg_index.png"></td>
            <td><img width="100%"  src="imgs/bg_index.png"></td>
            <td><img width="100%"  src="imgs/bg_index.png"></td>
            <td><img width="100%"  src="imgs/bg_index.png"></td>
        </tr>
    </table>

    <h1>优质房源</h1>
    <table>
        <tr>
            <td><img width="100%"  src="imgs/bg_index.png"></td>
            <td><img width="100%"  src="imgs/bg_index.png"></td>
            <td><img width="100%"  src="imgs/bg_index.png"></td>
            <td><img width="100%"  src="imgs/bg_index.png"></td>
        </tr>
    </table>


</body>
</html>
