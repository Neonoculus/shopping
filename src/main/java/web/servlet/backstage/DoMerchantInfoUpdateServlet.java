package web.servlet.backstage;

import domain.Merchant;
import service.MerchantService;
import service.impl.MerchantServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doMerchantInfoUpdateServlet")
public class DoMerchantInfoUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MerchantService merchantService = new MerchantServiceImpl();

        int m_id = Integer.parseInt(request.getParameter("merchant"));

        String name = request.getParameter("name");
        String photo = request.getParameter("photo1Input");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String note = request.getParameter("note");
        Merchant merchant = new Merchant(m_id,name,phone,address,email,photo,note);

        int i = merchantService.update(merchant);

        request.getRequestDispatcher("/toMerchantInfoServlet").forward(request,response);

    }
}