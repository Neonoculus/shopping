package web.servlet.backstage;

import domain.*;
import service.*;
import service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/toMerchantOrderDetailServlet")
public class ToOrderDetailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MerchantService merchantService = new MerchantServiceImpl();
        OrderDetailsService orderDetailsService = new OrderDetailsServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        BuyerService buyerService = new BuyerServiceImpl();
        GoodsService goodsService = new GoodsServiceImpl();

        int m_id = Integer.parseInt(request.getParameter("m_id"));
        Long o_id = Long.valueOf(request.getParameter("o_id"));
        List<OrderDetails> orderDetails = orderDetailsService.getOrderDetailsByMIdAndOId(m_id,o_id);
        List<Goods> goodsList = new ArrayList<>();
        Merchant merchant = merchantService.getMerchantByMId(m_id);
        for (OrderDetails orderDetails1 : orderDetails){
            goodsList.add(goodsService.getGoodsByGId(orderDetails1.getG_id()));
        }


        int b_id = orderService.getOrderByOId(o_id).get(0).getB_id();
        Buyer buyer = buyerService.getBuyerByBid(b_id);

        Order order = orderService.getOrderByOId(o_id).get(0);

        request.setAttribute("goodsList",goodsList);
        request.setAttribute("orderDetails",orderDetails);
        request.setAttribute("merchant",merchant);
        request.setAttribute("buyer",buyer);
        request.setAttribute("order",order);

        request.getRequestDispatcher("backstage/order-detail.jsp").forward(request,response);
    }
}