package web.servlet.foreground;


import domain.Buyer;
import service.BuyerService;
import service.impl.BuyerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/doUpdateInfoServlet")
public class DoUpdateInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String photo = request.getParameter("avatar");
        String bid = request.getParameter("b_id");
        if (bid == null) bid = (String) request.getAttribute("b_id");
        String name = request.getParameter("fname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        BuyerService buyerService = new BuyerServiceImpl();
        if ("".equals(photo) || photo == null) {

            Buyer buyer = new Buyer();
            buyer.setB_id(Integer.parseInt(bid));
            buyer.setName(name);
            buyer.setEmail(email);
            buyer.setAddress(address);
            buyer.setPhone(phone);
            buyer.setPhoto(photo);

            buyerService.update(buyer);

            request.setAttribute("buyer",buyer);
            request.getRequestDispatcher("toBuyerInfoServlet").forward(request, response);
        }else {
            Buyer buyer = new Buyer();
            buyer.setB_id(Integer.parseInt(bid));
            buyer.setName(name);
            buyer.setEmail(email);
            buyer.setAddress(address);
            buyer.setPhone(phone);
            buyer.setPhoto(photo);

            buyerService.update(buyer);

            request.setAttribute("buyer",buyer);
            request.getRequestDispatcher("toBuyerInfoServlet").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}