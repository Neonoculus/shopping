package web.servlet.backstage;

import dao.BuyerDao;
import dao.LoginDao;
import dao.MerchantDao;
import dao.impl.BuyerDaoImpl;
import dao.impl.LoginDaoImpl;
import dao.impl.MerchantDaoImpl;
import domain.Login;
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

@WebServlet("/doLoginServlet")
public class DoLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginService loginService = new LoginServiceImpl();

        Login login = loginService.Login(request.getParameter("username"),request.getParameter("password"));
        if(login==null){
            request.setAttribute("warning","账号或者密码错误");
            request.getRequestDispatcher("backstage/signin.jsp").forward(request,response);
        }
        else if (login.getType() == 0)
        {
            request.setAttribute("warning","账号已被封禁，如果有需要请联系管理员");
            request.getRequestDispatcher("backstage/signin.jsp").forward(request,response);
        }
        else if (login.getType() == 1)
        {
            String id = String.valueOf(login.getId());
            request.setAttribute("b_id",id);
            request.getRequestDispatcher("toBuyerIndexServlet").forward(request,response);
        }
        else if (login.getType() == 2)
        {
            String id = String.valueOf(login.getId());
            request.setAttribute("merchant", id);
            request.getRequestDispatcher("toIndexServlet").forward(request,response);
        }
        else if (login.getType() == 3)
        {
            request.getRequestDispatcher("admin/merchant.jsp").forward(request,response);
        }
    }
}