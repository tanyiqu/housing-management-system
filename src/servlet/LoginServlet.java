package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        //接收参数
        String type = req.getParameter("type");
        //根据类型转发给买家或卖家
        if(type.equals("0")){
            RequestDispatcher dispatcher = req.getRequestDispatcher("buyer");
            dispatcher.forward(req, resp);
        }else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("seller");
            dispatcher.forward(req, resp);
        }

    }
}
