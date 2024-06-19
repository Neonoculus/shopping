package web.servlet.foreground;

import domain.Cart;
import domain.Order;
import domain.OrderDetails;
import service.BuyerService;
import service.CartService;
import service.OrderDetailsService;
import service.OrderService;
import service.impl.BuyerServiceImpl;
import service.impl.CartServiceImpl;
import service.impl.OrderDetailsServiceImpl;
import service.impl.OrderServiceImpl;
import utils.Date;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author LiuHe
 * @version 1.0
 * @ClassName DoCheckoutServlet
 * @date 2024/6/12 9:10
 */
@WebServlet("/doCheckoutServlet")
public class DoCheckoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        BuyerService buyerService = new BuyerServiceImpl();
        CartService cartService = new CartServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        OrderDetailsService orderDetailsService = new OrderDetailsServiceImpl();
        Date date = new Date();

        String cart = request.getParameter("cart");
        String product = request.getParameter("product");
        String b_id = request.getParameter("b_id");
        if(b_id==null) b_id = (String) request.getAttribute("b_id");
        String total = request.getParameter("total");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        // 生成订单
        Order order = new Order();
        order.setO_id(date.getLongDate());
        order.setB_id(Integer.parseInt(b_id));
        order.setMoney(Double.valueOf(total));
        order.setStartTime(LocalDateTime.now());
        order.setName(name);
        order.setPhone(phone);
        order.setAddress(address);
        order.setStatus(1);
        orderService.add(order);
        System.out.println(order+"..................");
        if(cart!=null){
            List<Cart> cartList = cartService.getCartByBId(Integer.parseInt(b_id));
            long o_id = order.getO_id();
            for(Cart c : cartList){
                int g_id = c.getG_id();
                int count = c.getCount();
                double money = c.getMoney()*count;
                OrderDetails orderDetails = new OrderDetails(g_id,o_id,count,money);
                orderDetailsService.add(orderDetails);
                cartService.delete(c);
            }
        }
        if(product!=null){
            long o_id = order.getO_id();
            int g_id = Integer.parseInt(request.getParameter("g_id"));
            int count = Integer.parseInt(request.getParameter("count"));
            double money = Double.parseDouble(request.getParameter("money"));
            OrderDetails orderDetails = new OrderDetails(g_id,o_id,count,money);
            orderDetailsService.add(orderDetails);
        }
        request.setAttribute("b_id",b_id);
        request.getRequestDispatcher("toShopServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}