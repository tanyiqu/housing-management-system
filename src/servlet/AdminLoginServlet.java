package servlet;

import bean.Admin;
import bean.Income;
import service.AdminService;
import service.UserService;
import service.impl.AdminServiceImpl;
import service.impl.UserServiceImpl;
import util.TextUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        //接收参数
        String username = req.getParameter("userName");
        String passwd = req.getParameter("passwd");
        PrintWriter out = resp.getWriter();

        AdminService adminService = new AdminServiceImpl();
        //验证用户名和密码
        boolean correct = adminService.adminCorrect(username,passwd);
        if(!correct){
            String script = TextUtil.errText("密码错误！","admin_login.jsp");
            out.println(script);
            return;
        }

        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPasswd(passwd);
        req.setAttribute("admin",admin);
        //出售信息

        //收入统计
        Income income = adminService.getIncomeStatistics();
        req.setAttribute("income",income);
        //报表

        RequestDispatcher dispatcher = req.getRequestDispatcher("admin.jsp");
        dispatcher.forward(req, resp);

    }
}
