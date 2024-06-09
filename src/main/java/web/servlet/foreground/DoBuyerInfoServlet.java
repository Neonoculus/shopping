package web.servlet.foreground;

import domain.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JSP 页面的 Servlet
 */
@WebServlet("/doBuyerInfoServlet")
public class DoBuyerInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService orderService = new OrderServiceImpl();

        // doBuyerInfoServlet  需要的参数
        int b_id = Integer.parseInt(request.getParameter("b_id"));
        long o_id = Long.parseLong(request.getParameter("o_id"));
        int status = Integer.parseInt(request.getParameter("status"));
        Order order = orderService.getOrderByOId(o_id).get(0);
        order.setStatus(status);
        orderService.update(order);

        request.getRequestDispatcher("toBuyerInfoServlet?&b_id="+b_id).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}