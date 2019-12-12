<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" type="bean.User" scope="request"/>
<html>
<head>
    <title>我的出售</title>
</head>
<body>
    <h1>Seller</h1>
</body>
    <%
        out.println(user.toString());
    %>
</html>
