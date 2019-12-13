package servlet;

import bean.SellerCard;
import bean.User;
import service.HouseService;
import service.UserService;
import service.impl.HouseServiceImpl;
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

public class SellerServlet extends HttpServlet {
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
        //获取房源服务实例
        HouseService houseService = new HouseServiceImpl();

        //判断用户名密码是否正确 卖家
        boolean exist = userService.isExist(userName,passwd,false);
        //如果用户不存在，提示并返回
        if(!exist){
            String script = TextUtil.errText("用户名不存在或密码错误！","login.jsp");
            out.println(script);
            return;
        }
        //把user存入session域
        User user = userService.find(userName,"1");
        req.getSession().setAttribute("seller",user);
        //获取卖方登记卡
        List<SellerCard> sellerCards =  houseService.getSellerCard(userName);
        //将卖方登记卡存入request域
        req.setAttribute("sellerCards",sellerCards);
        //转发
        RequestDispatcher dispatcher = req.getRequestDispatcher("seller.jsp");
        dispatcher.forward(req, resp);
    }
}
