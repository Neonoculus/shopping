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

@WebServlet("/toPasswordUpdate")
public class ToPasswordUpdate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuyerService buyerService = new BuyerServiceImpl();
        String bid = request.getParameter("b_id");
        Buyer buyerByBid = buyerService.getBuyerByBid(Integer.parseInt(bid));
        String photo = buyerByBid.getPhoto();
        Buyer buyer = new Buyer();
        buyer.setB_id(Integer.parseInt(bid));
        buyer.setPhoto(photo);
        request.setAttribute("buyer",buyer);

        request.getRequestDispatcher("/foreground/password-update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}