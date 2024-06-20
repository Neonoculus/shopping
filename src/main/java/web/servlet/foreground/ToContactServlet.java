package web.servlet.foreground;

import domain.Buyer;
import service.BuyerService;
import service.impl.BuyerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author LiuHe
 * @version 1.0
 * @ClassName ToContactServlet
 * @date 2024/6/20 11:57
 */
@WebServlet("/toContactServlet")
public class ToContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuyerService buyerService = new BuyerServiceImpl();
        String b_id = request.getParameter("b_id");
        if(b_id==null){
            b_id= (String) request.getAttribute("b_id");
        }
        Buyer buyer = buyerService.getBuyerByBid(Integer.parseInt(b_id));
        request.setAttribute("buyer",buyer);
        request.getRequestDispatcher("foreground/contact.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}