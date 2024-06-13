package web.servlet.admin;

import domain.Buyer;
import domain.Login;
import domain.Merchant;
import service.BuyerService;
import service.LoginService;
import service.MerchantService;
import service.impl.BuyerServiceImpl;
import service.impl.LoginServiceImpl;
import service.impl.MerchantServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/toAdminMerchantServlet")
public class ToAdminMerchantServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MerchantService merchantService = new MerchantServiceImpl();
        LoginService loginService = new LoginServiceImpl();

        String start1 = request.getParameter("start");
        int start ;
        if (start1 == null){
            start = (int) request.getAttribute("start");
        }else {
            start = Integer.parseInt(start1);
        }
        List<Merchant> merchants = merchantService.findByPage(start,10);
        int pageSumNumber = merchantService.merchantPageSum(merchantService.getAllMerchant());

        List<Login> logins = new ArrayList<>();
        for (Merchant merchant : merchants)
        {
            logins.add(loginService.getLoginById(merchant.getM_id()));
        }

        request.setAttribute("merchants",merchants);
        request.setAttribute("logins",logins);
        request.setAttribute("page",start);
        request.setAttribute("pageSumNumber",pageSumNumber);

        request.getRequestDispatcher("admin/merchant.jsp").forward(request,response);
    }
}