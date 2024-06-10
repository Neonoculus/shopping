package web.servlet.backstage;

import domain.Goods;
import domain.Merchant;
import domain.Order;
import service.MerchantService;
import service.OrderService;
import service.impl.MerchantServiceImpl;
import service.impl.OrderServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/toOrderServlet")
public class ToOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService orderService = new OrderServiceImpl();
        MerchantService merchantService = new MerchantServiceImpl();

        String startString = request.getParameter("start");
        if (startString == null){
            startString = (String) request.getAttribute("start");
        }
        int start = Integer.parseInt(startString)*10;
        String m_idParam = request.getParameter("merchant");
        if (m_idParam == null){
            m_idParam = (String) request.getAttribute("merchant");
        }
        int m_id = Integer.parseInt(m_idParam);
        Merchant merchant = merchantService.getMerchantByMId(m_id);

        List<Order> orderList = orderService.getOrderByMId(m_id,start,10);
        int pageSumNumber = goodsService.goodsPageSum(goodsService.getGoodsByMId(m_id))/10+1;
        start = start/10;

        request.setAttribute("goodsList",goodsList);
        request.setAttribute("merchant", merchant);
        request.setAttribute("page",start);
        request.setAttribute("pageSumNumber",pageSumNumber);

        request.getRequestDispatcher("backstage/goods.jsp").forward(request,response);
    }
}