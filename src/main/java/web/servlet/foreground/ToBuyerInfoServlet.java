package web.servlet.foreground;

import domain.*;
import service.BuyerService;
import service.GoodsService;
import service.OrderDetailsService;
import service.OrderService;
import service.impl.BuyerServiceImpl;
import service.impl.GoodsServiceImpl;
import service.impl.OrderDetailsServiceImpl;
import service.impl.OrderServiceImpl;
import utils.PhotoUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JSP 页面的 Servlet
 */
@WebServlet("/toBuyerInfoServlet")
public class ToBuyerInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BuyerService buyerService = new BuyerServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        OrderDetailsService orderDetailsService = new OrderDetailsServiceImpl();
        GoodsService goodsService = new GoodsServiceImpl();

        //  toBuyerInfoServlet  需要的参数
        String b_idTemp =  request.getParameter("b_id");
        if(b_idTemp==null){
            b_idTemp = (String) request.getAttribute("b_id");
        }
        int b_id = Integer.parseInt(b_idTemp);
        //  用户个人信息
        Buyer buyer = buyerService.getBuyerByBid(b_id);
        request.setAttribute("buyer",buyer);

        //订单信息
        List<Order> orders = orderService.getOrderByBId(b_id);
        request.setAttribute("orders",orders);

        //  订单里的商品信息
        Map<Integer,List<String>> goodsNameMap = new HashMap<>();
        for (int i=0;i<orders.size();i++){
            List<OrderDetails> orderDetailsList = orderDetailsService.getOrderDetailsByOId(orders.get(i).getO_id());
            List<String> goodsNameList = new ArrayList<>();
            for(OrderDetails orderDetails : orderDetailsList){
                Goods goods = goodsService.getGoodsByGId(orderDetails.getG_id());
                goodsNameList.add(goods.getName());
            }
            goodsNameMap.put(i,goodsNameList);
        }
        request.setAttribute("goodsNameMap",goodsNameMap);

        request.getRequestDispatcher("foreground/buyer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}