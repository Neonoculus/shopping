package web.servlet.foreground;

import domain.Cart;
import service.CartService;
import service.impl.CartServiceImpl;

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
@WebServlet("/doCartServlet")
public class DoCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartService cartService = new CartServiceImpl();

        String a = request.getParameter("a");
        String button = request.getParameter("button");

        if(a!=null){
            int b_id = Integer.parseInt(request.getParameter("b_id"));
            int g_id = Integer.parseInt(request.getParameter("g_id"));
            List<Cart> cartList = cartService.getCartByBId(b_id);
            for(Cart cart : cartList){
                if(cart.getB_id()==b_id&&cart.getG_id()==g_id){
                    cartService.delete(cart);
                    break;
                }
            }
            request.setAttribute("b_id",b_id);
            request.getRequestDispatcher("toCartServlet").forward(request,response);
        }
        if(button!=null){
            String update = request.getParameter("update");
            String goon = request.getParameter("continue");
            String pay = request.getParameter("pay");
            int b_id = Integer.parseInt(request.getParameter("b_id"));
            if(update!=null && !"".equals(update)){
                int length = Integer.parseInt(request.getParameter("length"));
                for (int i=0;i<length;i++){
                    int g_id = Integer.parseInt(request.getParameter("goodsList"+i));
                    int quantity = Integer.parseInt(request.getParameter("quantityList"+i));
                    List<Cart> cartList = cartService.getCartByBId(b_id);
                    for(Cart cart : cartList){
                        if(cart.getB_id()==b_id&&cart.getG_id()==g_id){
                            cart.setCount(quantity);
                            cartService.update(cart);
                            break;
                        }
                    }
                }
                request.setAttribute("b_id",b_id);
                request.getRequestDispatcher("toCartServlet").forward(request,response);
            }
            if(goon!=null && !"".equals(goon)){
                request.setAttribute("b_id",b_id);
                request.setAttribute("shop","first");
                request.getRequestDispatcher("toShopServlet").forward(request,response);
            }
            if(pay!=null && !"".equals(pay)){
                request.setAttribute("b_id",b_id);
                request.setAttribute("cart","cart");
                request.getRequestDispatcher("toCheckoutServlet").forward(request,response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}