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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AddHouseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("seller");
        PrintWriter out = resp.getWriter();
        //获取不到user
        if(user == null){
            String script = TextUtil.errText("请先登录！","login.jsp");
            out.println(script);
            return;
        }
        UserService userService = new UserServiceImpl();
        boolean corr = userService.isExist(user.getUserName(),user.getPasswd(),false);
        //密码不正确
        if(!corr){
            String script = TextUtil.errText("请先登录！","login.jsp");
            out.println(script);
            return;
        }
        //转发给
        RequestDispatcher dispatcher = req.getRequestDispatcher("add_house.jsp");
        dispatcher.forward(req, resp);

    }
}
