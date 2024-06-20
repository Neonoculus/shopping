package web.servlet.foreground;

import domain.Buyer;
import service.BuyerService;
import service.impl.BuyerServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toUpdateInfoServlet")
public class ToUpdateInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuyerService buyerService = new BuyerServiceImpl();

        String bid = request.getParameter("b_id");

        if (bid!=null){
            Buyer buyer = buyerService.getBuyerByBid(Integer.parseInt(bid));
            request.setAttribute("buyer",buyer);
        }

        request.getRequestDispatcher("/foreground/info-update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}