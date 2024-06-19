package web.servlet.foreground;

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

@WebServlet("/doPasswordUpdate")
public class DoPasswordUpdate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        String bid = request.getParameter("b_id");

		if (bid == null) bid = (String) request.getAttribute("b_id");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		LoginService loginService = new LoginServiceImpl();
		Login login = loginService.getLoginById(Integer.parseInt(bid));


		BuyerService buyerService = new BuyerServiceImpl();
		Buyer buyerByBid = buyerService.getBuyerByBid(Integer.parseInt(bid));
		String photo = buyerByBid.getPhoto();
		Buyer buyer = new Buyer();
		buyer.setB_id(Integer.parseInt(bid));
		buyer.setPhoto(photo);
		request.setAttribute("buyer",buyer);

		if (bid!=null){
			if (oldPassword.equals(login.getPassword())){
				if (oldPassword.equals(newPassword)){
					request.setAttribute("warning","修改的密码不能和之前的密码相同！");
					request.getRequestDispatcher("/foreground/password-update.jsp").forward(request,response);
				}else{
					if (!newPassword.equals(confirmPassword)){
						request.setAttribute("warning","两次修改密码不一样！");
						request.getRequestDispatcher("/foreground/password-update.jsp").forward(request,response);
					}else {
						login.setPassword(newPassword);
						loginService.update(login);
						request.getRequestDispatcher("/backstage/signin.jsp").forward(request,response);
					}
				}
			}else {
				request.setAttribute("warning","旧密码错误！");
				request.getRequestDispatcher("/foreground/password-update.jsp").forward(request,response);
			}
		}

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}