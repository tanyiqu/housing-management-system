package servlet;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;
import util.TextUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BuyerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        //接收参数
        String userName = req.getParameter("userName");
        String passwd = req.getParameter("passwd");
        PrintWriter out = resp.getWriter();

        //获取用户服务实例
        UserService userService = new UserServiceImpl();
        //判断用户名密码是否正确 卖家
        boolean exist = userService.isExist(userName,passwd,true);
        //如果用户不存在，提示并返回
        if(!exist){
            String script = TextUtil.errText("用户名不存在或密码错误！","login.jsp");
            out.println(script);
            return;
        }
        //把user设置为转发接受者的beam
        User user = userService.find(userName,"0");
        req.getSession().setAttribute("buyer",user);
        //转发
        RequestDispatcher dispatcher = req.getRequestDispatcher("buyer.jsp");
        dispatcher.forward(req, resp);
    }
}
