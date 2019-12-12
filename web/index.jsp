<%@ page import="util.DBUtil" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="u" class="bean.User"/>

<html>
  <head>
    <title>首页</title>
  </head>

  <body style="background-image:url(imgs/bg_index.png);background-size:100%">

    <h1 style="text-align: center">房屋中介管理</h1>
    <a href="https://github.com/Tanyiqu/FWGLXT">项目地址</a> &nbsp; <a href="https://baidu.com">百度</a><br>

    <a href="login.jsp">登录</a> &nbsp; <a href="registered.jsp">注册</a> &nbsp; <a href="admin_login.jsp">后台</a> <br>

    <%--测试连接数据库的语句--%>
    <%
      String sql = "select * from gmr";
      ResultSet rs = DBUtil.executeQuery(sql);
      StringBuilder sb = new StringBuilder();
      while (true) {
        try {
          if (!rs.next()) break;
          sb.append(rs.getString(1));
          sb.append("   ");
          sb.append(rs.getString(2));
          sb.append("   ");
          sb.append(rs.getString(3));
          sb.append("   ");
          sb.append(rs.getString(4));
          sb.append("   ");
          sb.append(rs.getString(5));
          sb.append("   ");
          sb.append("<br>");
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      //关闭
      try {
        rs.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      out.println(sb);
    %>

  </body>
</html>
