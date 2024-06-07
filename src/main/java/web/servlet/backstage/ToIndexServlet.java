package web.servlet.backstage;

import dao.MerchantDao;
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

@WebServlet("/toIndexServlet")
public class ToIndexServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取商家 ID
        String merchantId1 = request.getParameter("merchant");
        int merchantId;
        if (merchantId1 == null){
           merchantId = Integer.parseInt((String) request.getAttribute("merchant"));
        }else {
            merchantId = Integer.parseInt(merchantId1);
        }


        // 获取商家对象
        MerchantService merchantService = new MerchantServiceImpl();
        Merchant merchant = merchantService.getMerchantByMId(merchantId);
        request.setAttribute("merchant", merchant);

        // 获取商家订单
        OrderService orderService = new OrderServiceImpl();
        List<Order> orders = orderService.getOrderByMId(merchantId);

        // 处理订单数据并设置请求属性
        int[] orderAmountNumber = orderService.OrderAmountNumber(orders);
        request.setAttribute("orderAmountSum", orderAmountNumber[0]);
        request.setAttribute("todayOrderAmount", orderAmountNumber[1]);

        Double[] orderMoneyNumber = orderService.OrderMoneyNumber(orders);
        request.setAttribute("orderMoneySum", orderMoneyNumber[0]);
        request.setAttribute("todayOrderMoney", orderMoneyNumber[1]);

        // 转发请求
        request.getRequestDispatcher("backstage/index.jsp").forward(request, response);
    }
}