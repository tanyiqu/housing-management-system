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

public class InsertHouseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        //检测用户是否登录
        HttpSession session = req.getSession();
        User seller = (User) session.getAttribute("seller");
        if(seller == null){
            String script = TextUtil.errText("请先登录！","login.jsp");
            resp.getWriter().println(script);
            return;
        }
        //接收参数
        String houseName = req.getParameter("houseName").trim();
        String type = req.getParameter("type");
        int area = Integer.parseInt(req.getParameter("area").trim());
        String year = req.getParameter("year").trim();
        String addr = req.getParameter("addr").trim();
        String room = req.getParameter("room").trim();
        int price = Integer.parseInt(req.getParameter("price").trim());
        switch (type){
            case "0":
                type = "普通住宅";
                break;
            case "1":
                type = "公寓";
                break;
            case "2":
                type = "别墅";
                break;
            case "3":
                type = "平房";
                break;
            case "4":
                type = "四合院";
                break;
            default:
                type = "其他";
        }
        HouseService houseService = new HouseServiceImpl();
        houseService.addHouse(seller.getUserName(),houseName,type,area,year,addr,room,price);
        //添加成功后，返回页面
//        RequestDispatcher dispatcher = req.getRequestDispatcher("seller?&userName=" + seller.getUserName() + "&passwd=" + seller.getPasswd());
//        dispatcher.forward(req, resp);
        resp.sendRedirect("add_house_success.jsp");
    }
}
