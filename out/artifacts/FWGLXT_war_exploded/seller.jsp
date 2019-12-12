<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="seller" type="bean.User" scope="session"/>
<html>
<head>
    <title>我的出售</title>
    <style>
        *{
            margin:0;
            padding:0;
        }
        .nav{
            background-color: rgb(35, 143, 242);
            height: 70px;

        }
        .nav h1{
            font-size:30px;
            color: #100a67;
            font-weight:400;
            text-align:center;
            padding-top: 13px;
        }
        h1{
            font-size:30px;
            color: #100a67;
            font-weight:400;
            padding-top: 10px;
            padding-left: 10px;
        }

    </style>
</head>
<body>
    <a href="index.jsp">首页</a>
    <div class="nav">
        <h1>房屋中介</h1>
    </div>

    <h1>欢迎<jsp:getProperty name="seller" property="userName"/></h1>

    <h1>正在出售</h1>
    <table border="1px">
        <tr>
            <th>房间名称</th>
            <th>地址</th>
            <th>售价</th>
            <th>已售</th>
        </tr>
    </table>

    <a href="addHouse" target="_blank">
        <input type="button" value="我要发布" style="height: 100px;width: 300px; border-radius: 20px">
    </a>


</body>
</html>
