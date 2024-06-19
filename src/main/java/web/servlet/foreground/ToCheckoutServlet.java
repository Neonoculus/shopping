package web.servlet.foreground;

import domain.Buyer;
import domain.Goods;
import domain.dto.CartDto;
import service.BuyerService;
import service.CartService;
import service.GoodsService;
import service.impl.BuyerServiceImpl;
import service.impl.CartServiceImpl;
import service.impl.GoodsServiceImpl;
import utils.PhotoUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * @author LiuHe
 * @version 1.0
 * @ClassName ToCheckOutServlet
 * @date 2024/6/11 10:51
 */
@WebServlet("/toCheckoutServlet")
public class ToCheckoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuyerService buyerService = new BuyerServiceImpl();
        CartService cartService = new CartServiceImpl();
        GoodsService goodsService = new GoodsServiceImpl();
        PhotoUtil photoUtil = new PhotoUtil();
        String b_id = request.getParameter("b_id");
        if(b_id==null){
            b_id = (String) request.getAttribute("b_id");
        }
        Buyer buyer = buyerService.getBuyerByBid(Integer.parseInt(b_id));
        request.setAttribute("buyer",buyer);

        String cart = (String) request.getAttribute("cart");
        String product = (String) request.getAttribute("product");
        if(cart!=null){
            //  用户购物车信息
            List<CartDto> cartDtoList = cartService.getCartDtoById(Integer.parseInt(b_id));
            double total = 0;
            for(int i=0;i<cartDtoList.size();i++){
                String photo = cartDtoList.get(i).getPhoto();
                photo = photoUtil.getPhotoList(photo).get(0);
                cartDtoList.get(i).setPhoto(photo);
                total = total + cartDtoList.get(i).getCount()*cartDtoList.get(i).getMoney();
            }
            request.setAttribute("total",total);
            request.setAttribute("cartDtoList",cartDtoList);
            request.setAttribute("cart",cart);
            request.getRequestDispatcher("foreground/checkout.jsp").forward(request,response);
        }
        if(product!=null){
            // 商品信息
            int g_id = (int) request.getAttribute("g_id");
            Goods goods = goodsService.getGoodsByGId(g_id);
            //  购买数量
            int quantity = (int) request.getAttribute("quantity");
            double total = goods.getPrice()*quantity;
            request.setAttribute("total",total);
            request.setAttribute("goods",goods);
            request.setAttribute("quantity",quantity);
            request.setAttribute("product","product");
            request.getRequestDispatcher("foreground/checkout.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}