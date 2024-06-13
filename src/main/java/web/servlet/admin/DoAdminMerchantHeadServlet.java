package web.servlet.admin;

import domain.Buyer;
import domain.Login;
import domain.Merchant;
import service.LoginService;
import service.MerchantService;
import service.impl.LoginServiceImpl;
import service.impl.MerchantServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/doAdminMerchantHeadServlet")
public class DoAdminMerchantHeadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MerchantService merchantService = new MerchantServiceImpl();
        LoginService loginService = new LoginServiceImpl();

        String select = request.getParameter("select");
        String soldOut = request.getParameter("SoldOut");
        String soldIn = request.getParameter("SoldIn");
        String[] selectedItems ;
        if (select!=null)
        {
            String search = request.getParameter("search");

            List<Merchant> merchants = merchantService.getMerchantByName(search);

            request.setAttribute("merchants",merchants);

        }else if (soldOut!=null)
        {
            Login login;
            selectedItems = request.getParameterValues("checkbox");
            for (String item : selectedItems){
                int id = Integer.parseInt(item);
                login = loginService.getLoginById(id);
                login.setType(0);
                loginService.update(login);
            }
            List<Merchant> merchants = merchantService.findByPage(0,10);
            List<Login> logins = new ArrayList<>();
            for (Merchant merchant : merchants)
            {
                logins.add(loginService.getLoginById(merchant.getM_id()));
            }


            request.setAttribute("merchants",merchants);
            request.setAttribute("logins",logins);
        }else if (soldIn!=null)
        {
            selectedItems = request.getParameterValues("checkbox");
            Login login;
            for (String item : selectedItems){
                int id = Integer.parseInt(item);
                login = loginService.getLoginById(id);
                login.setType(2);
                loginService.update(login);
            }
            List<Merchant> merchants = merchantService.findByPage(0,10);
            List<Login> logins = new ArrayList<>();
            for (Merchant merchant : merchants)
            {
                logins.add(loginService.getLoginById(merchant.getM_id()));
            }


            request.setAttribute("merchants",merchants);
            request.setAttribute("logins",logins);
        }

        int pageSumNumber = merchantService.merchantPageSum(merchantService.getAllMerchant());

        request.setAttribute("page",0);
        request.setAttribute("pageSumNumber",pageSumNumber);
        request.getRequestDispatcher("admin/merchant.jsp").forward(request,response);
    }
}