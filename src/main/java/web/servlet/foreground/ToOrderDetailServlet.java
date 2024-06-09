package web.servlet.foreground;

import domain.Buyer;
import domain.Goods;
import domain.Order;
import domain.OrderDetails;
import service.BuyerService;
import service.GoodsService;
import service.OrderDetailsService;
import service.OrderService;
import service.impl.BuyerServiceImpl;
import service.impl.GoodsServiceImpl;
import service.impl.OrderDetailsServiceImpl;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JSP 页面的 Servlet
 */
@WebServlet("/toOrderDetailServlet")
public class ToOrderDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuyerService buyerService = new BuyerServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        OrderDetailsService orderDetailsService = new OrderDetailsServiceImpl();
        GoodsService goodsService = new GoodsServiceImpl();
        //  toOrderDetailServlet  需要的参数
        String b_idTemp =  request.getParameter("b_id");
        int b_id = Integer.parseInt(b_idTemp);

        long o_id = Long.parseLong(request.getParameter("o_id"));
        //  用户个人信息
        Buyer buyer = buyerService.getBuyerByBid(b_id);
        request.setAttribute("buyer",buyer);
        System.out.println(buyer);
        //订单信息
        Order order = orderService.getOrderByOId(o_id).get(0);
        request.setAttribute("order",order);
        // 订单详情信息
        List<OrderDetails> orderDetailsList = orderDetailsService.getOrderDetailsByOId(o_id);
        request.setAttribute("orderDetailsList",orderDetailsList);
        // 商品信息  图片 名字
        List<Goods> goodsList = new ArrayList<>();
        for (OrderDetails orderDetails : orderDetailsList){
            Goods goods = goodsService.getGoodsByGId(orderDetails.getG_id());

            goodsList.add(goods);
        }
        request.setAttribute("goodsList",goodsList);

        request.getRequestDispatcher("foreground/order_detail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}