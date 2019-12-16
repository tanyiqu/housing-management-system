package servlet;

import util.EmailUtil;
import util.TextUtil;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SendEmailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //接收邮箱参数
        String email = req.getParameter("em");
        //随机验证码
        String vc = TextUtil.randomVC(6);
        //发送邮件
        EmailUtil.sendHtml("房屋中介",email,"验证码",vc);

        HttpSession session = req.getSession();

        session.setAttribute("vc",vc);

    }
}
