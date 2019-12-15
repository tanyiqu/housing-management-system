package servlet;

import bean.House;
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
import java.util.ArrayList;
import java.util.List;

public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        //接收参数
        String keyword_addr = req.getParameter("keyword_addr");
        String keyword_area_lower = req.getParameter("keyword_area_lower");
        String keyword_area_higher = req.getParameter("keyword_area_higher");
        String keyword_price_lower = req.getParameter("keyword_price_lower");
        String keyword_price_higher = req.getParameter("keyword_price_higher");
        //判断用户有没有登录
        HttpSession session = req.getSession();
        User buyer = (User) session.getAttribute("buyer");
        if(buyer == null){
            String script = TextUtil.errText("请先登录！","login.jsp");
            out.println(script);
            return;
        }
        //判断是哪种搜索
        //0 地区
        //1 面积
        //2 价格
        int type = 0;
        if(keyword_area_lower != null){
            type = 1;
        }
        if(keyword_price_lower != null){
            type = 2;
        }
        List<House> houses = new ArrayList<>();
        HouseService houseService = new HouseServiceImpl();
        switch (type){
            case 0:
                houses = houseService.getHouseByAddr(keyword_addr);
                break;
            case 1:
                houses = houseService.getHouseByArea(Integer.parseInt(keyword_area_lower),Integer.parseInt(keyword_area_higher));
                break;
            case 2:
                houses = houseService.getHouseByPrice(Integer.parseInt(keyword_price_lower),Integer.parseInt(keyword_price_higher));
                break;
        }
        out.println(type);

        req.setAttribute("houses",houses);

        //转发
        RequestDispatcher dispatcher = req.getRequestDispatcher("search_result.jsp");
        dispatcher.forward(req, resp);
    }
}
