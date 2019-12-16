package servlet;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisteredServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();

        //接收所有参数
        String type = req.getParameter("type");
        String userName = req.getParameter("userName");
        String passwd = req.getParameter("passwd");
        String repasswd = req.getParameter("repasswd");
        String trueName = req.getParameter("trueName");
        String tel = req.getParameter("tel");
        String email = req.getParameter("email");
        String vc = req.getParameter("vc");
        //获取服务器发送的验证码
        String VC = (String) session.getAttribute("vc");
//        String VC = "1111";

        //调用service判断用户
        UserService user = new UserServiceImpl();
        int code = user.checkParam(type,userName,passwd,repasswd,email,vc,VC);

        String script;
        switch (code){
            case UserService.OK:
                break;
            case UserService.USER_ALREADY_EXISTS:
                script = "<script>alert('用户已存在！');location.href='registered.jsp'</script>";
                out.println(script);
                return;
            case UserService.VC_ERROR:
                script = "<script>alert('验证码输入错误！');location.href='registered.jsp'</script>";
                out.println(script);
                return;
        }

        //在数据库中插入用户
        user.addUser(type,userName,passwd,trueName,tel,email);
        //转发到注册成功页面

        out.println("<h1>注册成功</h1>");

        StringBuilder sb = new StringBuilder();

        sb.append("<table border='1'>");

        sb.append("<tr>");
        sb.append("<td>");
        sb.append(userName);
        sb.append("</td>");
        sb.append("</tr>");

        sb.append("<tr>");
        sb.append("<td>");
        sb.append(passwd);
        sb.append("</td>");
        sb.append("</tr>");

        sb.append("<tr>");
        sb.append("<td>");
        sb.append(trueName);
        sb.append("</td>");
        sb.append("</tr>");

        sb.append("<tr>");
        sb.append("<td>");
        sb.append(tel);
        sb.append("</td>");
        sb.append("</tr>");

        sb.append("<tr>");
        sb.append("<td>");
        sb.append(email);
        sb.append("</td>");
        sb.append("</tr>");

        sb.append("</table>");

        out.println(sb);

        out.println("<a href='login.jsp'>立即登录</a>");

    }
}
