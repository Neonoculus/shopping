package web.servlet.foreground;

import domain.Buyer;
import domain.Order;
import service.BuyerService;
import service.OrderService;
import service.impl.BuyerServiceImpl;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * JSP 页面的 Servlet
 */
@WebServlet("/toBuyerInfoServlet")
public class ToBuyerInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BuyerService buyerService = new BuyerServiceImpl();
        int b_id =  Integer.parseInt((String)request.getParameter("b_id"));

        //  用户个人信息
        Buyer buyer = buyerService.getBuyerByBid(b_id);
        request.setAttribute("buyer",buyer);

        OrderService orderService = new OrderServiceImpl();
        List<Order> orders = orderService.getOrderByBId(b_id);
        request.setAttribute("orders",orders);
        for (Order order : orders){
            System.out.println(order);
        }
        request.getRequestDispatcher("foreground/buyer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}