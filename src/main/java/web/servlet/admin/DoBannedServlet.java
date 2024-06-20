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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/doBannedServlet")
public class DoBannedServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuyerService buyerService = new BuyerServiceImpl();
        LoginService loginService = new LoginServiceImpl();
        MerchantService merchantService = new MerchantServiceImpl();

        int id = Integer.parseInt(request.getParameter("id"));
        int type = Integer.parseInt(request.getParameter("type"));
        Login login = loginService.getLoginById(id);
        login.setType(type);
        int i = loginService.update(login);
        int j = Integer.parseInt(request.getParameter("j"));
        if (j==1){
            int pageSumNumber = buyerService.buyerPageSum(buyerService.getAllBuyer());
            List<Buyer> buyers = buyerService.findByPage(0,10);
            List<Login> logins = new ArrayList<>();
            for (Buyer buyer : buyers)
            {
                logins.add(loginService.getLoginById(buyer.getB_id()));
            }
            request.setAttribute("buyers",buyers);
            request.setAttribute("logins",logins);
            request.setAttribute("page",0);
            request.setAttribute("pageSumNumber",pageSumNumber);
            request.getRequestDispatcher("admin/buyer.jsp").forward(request,response);
        }else {
            int pageSumNumber = merchantService.merchantPageSum(merchantService.getAllMerchant())/10+1;
            List<Merchant> merchants = merchantService.findByPage(0,10);
            List<Login> logins = new ArrayList<>();
            for (Merchant merchant : merchants)
            {
                logins.add(loginService.getLoginById(merchant.getM_id()));
            }
            request.setAttribute("page",0);
            request.setAttribute("pageSumNumber",pageSumNumber);
            request.setAttribute("merchants",merchants);
            request.setAttribute("logins",logins);
            request.getRequestDispatcher("admin/merchant.jsp").forward(request,response);
        }

    }
}