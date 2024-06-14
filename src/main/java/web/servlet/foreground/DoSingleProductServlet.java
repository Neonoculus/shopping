package web.servlet.foreground;

import domain.*;
import service.*;
import service.impl.*;
import utils.PhotoUtil;

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
@WebServlet("/doSingleProductServlet")
public class DoSingleProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuyerService buyerService = new BuyerServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();
        TagService tagService = new TagServiceImpl();
        GoodsTagService goodsTagService = new GoodsTagServiceImpl();
        CartService cartService = new CartServiceImpl();
        GoodsService goodsService = new GoodsServiceImpl();
        PhotoUtil photoUtil = new PhotoUtil();

        //  doOrderDetailServlet  需要的参数
        String addToOrder = request.getParameter("add-to-order");
        String addToCart = request.getParameter("add-to-cart");
        //  用户信息
        String b_idTemp = request.getParameter("b_id");
        if(b_idTemp==null){
            b_idTemp = String.valueOf(request.getAttribute("b_id"));
        }
        int b_id = Integer.parseInt(b_idTemp);
        Buyer buyer = buyerService.getBuyerByBid(b_id);
        // 商品信息
        int g_id = Integer.parseInt(request.getParameter("g_id"));
        Goods goods = goodsService.getGoodsByGId(g_id);
        //  购买数量
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        if(addToOrder!=null){
            request.setAttribute("g_id",g_id);
            request.setAttribute("quantity",quantity);
            request.setAttribute("product","product");
            request.setAttribute("b_id",b_id);
            request.getRequestDispatcher("toCheckoutServlet").forward(request,response);
        }
        if(addToCart!=null){
            List<Cart> cartList = cartService.getCartByBId(b_id);
            boolean judge = true;
            for(Cart cart : cartList){
                if(cart.getB_id()==b_id&&cart.getG_id()==g_id){
                    Cart updateCart = new Cart(g_id,b_id,cart.getCount()+quantity,goods.getPrice(),goods.getStatus());
                    cartService.update(updateCart);
                    judge = false;
                    break;
                }
            }
            if(judge){
                Cart addCart = new Cart(g_id,b_id,quantity,goods.getPrice(),goods.getStatus());
                cartService.add(addCart);
            }
            request.setAttribute("b_id",b_id);
            request.getRequestDispatcher("toCartServlet").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}