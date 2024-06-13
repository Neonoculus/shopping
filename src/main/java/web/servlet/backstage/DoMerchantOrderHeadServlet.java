package web.servlet.backstage;

import domain.Goods;
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

@WebServlet("/doMerchantOrderHeadServlet")
public class DoMerchantOrderHeadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService orderService = new OrderServiceImpl();
        MerchantService merchantService = new MerchantServiceImpl();


        String m_idParam = request.getParameter("merchant");
        if (m_idParam == null){
            m_idParam = (String) request.getAttribute("merchant");
        }
        int m_id = Integer.parseInt(m_idParam);
        Merchant merchant = merchantService.getMerchantByMId(m_id);

        String soldOut = request.getParameter("SoldOut");
        String soldIn = request.getParameter("SoldIn");
        String[] selectedItems ;

        if (soldOut!=null)
        {
            Order order;
            selectedItems = request.getParameterValues("checkbox");
            for (String item : selectedItems){
                int id = Integer.parseInt(item);
                order = orderService.getOrderByOId(id).get(0);
                order.setStatus(0);
                int i = orderService.update(order);
            }
            List<Order> orderList = orderService.findByPageAndMId(m_id,0,10);
            request.setAttribute("orderList",orderList);
        }else if (soldIn!=null) {
            Order order;
            selectedItems = request.getParameterValues("checkbox");
            for (String item : selectedItems){
                int id = Integer.parseInt(item);
                order = orderService.getOrderByOId(id).get(0);
                order.setStatus(1);
                int i = orderService.update(order);
            }
            List<Order> orderList = orderService.findByPageAndMId(m_id,0,10);
            request.setAttribute("orderList",orderList);
        }

        int pageSumNumber = orderService.OrderAmountNumber(orderService.getAllOrder())[0];

        request.setAttribute("merchant", merchant);
        request.setAttribute("page",0);
        request.setAttribute("pageSumNumber",pageSumNumber);
        request.getRequestDispatcher("backstage/goods.jsp").forward(request,response);
    }
}