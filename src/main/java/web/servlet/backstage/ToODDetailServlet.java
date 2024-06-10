package web.servlet.backstage;

import domain.Goods;
import domain.Merchant;
import domain.OrderDetails;
import service.GoodsService;
import service.MerchantService;
import service.OrderDetailsService;
import service.OrderService;
import service.impl.GoodsServiceImpl;
import service.impl.MerchantServiceImpl;
import service.impl.OrderDetailsServiceImpl;
import service.impl.OrderServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toODDetailServlet")
public class ToODDetailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MerchantService merchantService = new MerchantServiceImpl();
        GoodsService goodsService = new GoodsServiceImpl();
        OrderDetailsService orderDetailsService = new OrderDetailsServiceImpl();

        int g_id = Integer.parseInt(request.getParameter("g_id"));
        int m_id = Integer.parseInt(request.getParameter("m_id"));
        Long o_id = Long.valueOf(request.getParameter("o_id"));

        Goods goods = goodsService.getGoodsByGId(g_id);
        Merchant merchant = merchantService.getMerchantByMId(m_id);
        OrderDetails orderDetails = orderDetailsService.getOrderDetailsByOId(o_id).get(0);

        String[] imageArray = goods.getPhoto().split("#");
        int i = 0;
        for (String imagePath : imageArray) {
            i++;
            if (!imagePath.trim().isEmpty()) {
                request.setAttribute("photo"+i,imagePath);
            }
        }


        request.setAttribute("goods",goods);
        request.setAttribute("merchant",merchant);
        request.setAttribute("orderDetails",orderDetails);

        request.getRequestDispatcher("backstage/od-detail.jsp").forward(request,response);
    }
}