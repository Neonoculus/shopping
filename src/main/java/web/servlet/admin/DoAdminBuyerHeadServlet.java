package web.servlet.admin;

import domain.Buyer;
import domain.Login;
import service.BuyerService;
import service.LoginService;
import service.impl.BuyerServiceImpl;
import service.impl.LoginServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utils.PhotoUtil.getPhotoList;

@WebServlet("/doAdminBuyerHeadServlet")
public class DoAdminBuyerHeadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuyerService buyerService = new BuyerServiceImpl();
        LoginService loginService = new LoginServiceImpl();

		String select = request.getParameter("select");
        String soldOut = request.getParameter("SoldOut");
        String soldIn = request.getParameter("SoldIn");
        String[] selectedItems ;
        if (select!=null)
        {
            String search = request.getParameter("search");

            List<Buyer> buyers = buyerService.getBuyerByName(search);

            request.setAttribute("buyers",buyers);

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
            List<Buyer> buyers = buyerService.findByPage(0,10);
            List<Login> logins = new ArrayList<>();
            for (Buyer buyer : buyers)
            {
                logins.add(loginService.getLoginById(buyer.getB_id()));
            }


            request.setAttribute("buyers",buyers);
            request.setAttribute("logins",logins);
        }else if (soldIn!=null)
        {
            selectedItems = request.getParameterValues("checkbox");
            Login login;
            for (String item : selectedItems){
                int id = Integer.parseInt(item);
                login = loginService.getLoginById(id);
                login.setType(1);
                loginService.update(login);
            }
            List<Buyer> buyers = buyerService.findByPage(0,10);
            List<Login> logins = new ArrayList<>();
            for (Buyer buyer : buyers)
            {
                logins.add(loginService.getLoginById(buyer.getB_id()));
            }


            request.setAttribute("buyers",buyers);
            request.setAttribute("logins",logins);
        }
        int pageSumNumber = buyerService.buyerPageSum(buyerService.getAllBuyer());

        request.setAttribute("page",0);
        request.setAttribute("pageSumNumber",pageSumNumber);
        request.getRequestDispatcher("admin/buyer.jsp").forward(request,response);

    }
}