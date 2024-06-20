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

@WebServlet("/toAdminBuyerServlet")
public class ToAdminBuyerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BuyerService buyerService = new BuyerServiceImpl();
		LoginService loginService = new LoginServiceImpl();

		String start1 = request.getParameter("start");
		int start ;
		if (start1 == null){
			start = (int) request.getAttribute("start");
		}else {
			start = Integer.parseInt(start1);
		}
		int pageSumNumber = buyerService.buyerPageSum(buyerService.getAllBuyer());


		List<Buyer> buyers = buyerService.findByPage(start*10,10);
		List<Login> logins = new ArrayList<>();
		for (Buyer buyer : buyers)
		{
			logins.add(loginService.getLoginById(buyer.getB_id()));
		}



		request.setAttribute("buyers",buyers);
		request.setAttribute("logins",logins);
		request.setAttribute("pageSumNumber",pageSumNumber);
		request.setAttribute("page",start);

		request.getRequestDispatcher("admin/buyer.jsp").forward(request,response);
    }
}