package web.servlet.foreground;

import domain.Buyer;
import domain.dto.CartDto;
import service.BuyerService;
import service.CartService;
import service.impl.BuyerServiceImpl;
import service.impl.CartServiceImpl;
import utils.PhotoUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * JSP 页面的 Servlet
 */
@WebServlet("/toCartServlet")
public class ToCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuyerService buyerService = new BuyerServiceImpl();
        CartService cartService = new CartServiceImpl();
        PhotoUtil photoUtil = new PhotoUtil();
        //  toCartServlet需要的参数
        String bid = request.getParameter("b_id");
        if(bid == null){
            bid = (String) request.getAttribute("b_id");
        }
        int b_id = Integer.parseInt(bid);
        System.out.println("购物车里的用户id:"+bid);
        //   用户信息
        Buyer buyer = buyerService.getBuyerByBid(b_id);
        request.setAttribute("buyer",buyer);
        //  用户购物车信息
        List<CartDto> cartDtoList = cartService.getCartDtoById(b_id);
        double total = 0;
        for(int i=0;i<cartDtoList.size();i++){
            String photo = cartDtoList.get(i).getPhoto();
            photo = photoUtil.getPhotoList(photo).get(0);
            cartDtoList.get(i).setPhoto(photo);
            total = total + cartDtoList.get(i).getCount()*cartDtoList.get(i).getMoney();
        }
        request.setAttribute("total",total);
        request.setAttribute("cartDtoList",cartDtoList);
        request.getRequestDispatcher("foreground/cart.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}