package web.servlet.foreground;

import domain.Buyer;
import service.BuyerService;
import service.impl.BuyerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JSP 页面的 Servlet
 */
@WebServlet("/toBuyerIndexServlet")
public class ToBuyerIndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BuyerService buyerService = new BuyerServiceImpl();
        int b_id =  Integer.parseInt((String)request.getAttribute("b_id") );

        Buyer buyer = buyerService.getBuyerByBid(b_id);
        request.setAttribute("buyer",buyer);
        request.getRequestDispatcher("foreground/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}