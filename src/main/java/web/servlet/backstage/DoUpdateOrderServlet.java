package web.servlet.backstage;

import domain.Merchant;
import domain.Order;
import service.MerchantService;
import service.OrderService;
import service.impl.MerchantServiceImpl;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/doUpdateOrderServlet")
public class DoUpdateOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService orderService = new OrderServiceImpl();
        MerchantService merchantService = new MerchantServiceImpl();

        Long order = Long.valueOf(request.getParameter("order"));
        Order order1 = orderService.getOrderByOId(order).get(0);
        int status = Integer.parseInt(request.getParameter("status"));
        order1.setStatus(status);

        int i = orderService.update(order1);

        String startString = request.getParameter("start");
        if (startString == null){
            startString = (String) request.getAttribute("start");
        }
        int start = Integer.parseInt(startString);
        String m_idParam = request.getParameter("m_id");
        if (m_idParam == null){
            m_idParam = (String) request.getAttribute("m_id");
        }
        int m_id = Integer.parseInt(m_idParam);
        Merchant merchant = merchantService.getMerchantByMId(m_id);

        List<Order> orderList = orderService.findByPageAndMId(m_id,start*10,10);
        int pageSumNumber = orderService.OrderAmountNumber(orderService.getOrderByMId(m_id))[0]/10+1;
        start = start/10;

        request.setAttribute("orderList",orderList);
        request.setAttribute("merchant", merchant);
        request.setAttribute("page",start);
        request.setAttribute("pageSumNumber",pageSumNumber);

        request.getRequestDispatcher("backstage/order.jsp").forward(request,response);
    }
}