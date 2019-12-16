package servlet;

import bean.User;
import service.HouseService;
import service.impl.HouseServiceImpl;
import util.TextUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class BuyServlet extends HttpServlet {

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
        //判断登录
        User buyer = (User) session.getAttribute("buyer");
        if(buyer == null){
            String script = TextUtil.errText("请先登录！","login.jsp");
            out.println(script);
            return;
        }
        //接收参数
        String id = req.getParameter("id");

        //获取当前时间
        Date date = new Date();
        long time = date.getTime();
        String datetime = TextUtil.transferLongToDate(time);

        //调用service
        HouseService houseService = new HouseServiceImpl();
        houseService.buy(buyer.getUserName(),id,datetime);

        //购买成功后，返回页面
        RequestDispatcher dispatcher = req.getRequestDispatcher("buyer?&userName=" + buyer.getUserName() + "&passwd=" + buyer.getPasswd());
        dispatcher.forward(req, resp);

    }
}
