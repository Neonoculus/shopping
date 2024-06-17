package web.servlet.admin;

import domain.Login;
import domain.Merchant;
import service.LoginService;
import service.MerchantService;
import service.impl.LoginServiceImpl;
import service.impl.MerchantServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doUpdateAdminPasswordServlet")
public class DoUpdateAdminPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginService loginService = new LoginServiceImpl();

        String lostPassword = request.getParameter("password");
        String newPassword1 = request.getParameter("password1");
        String newPassword2 = request.getParameter("password2");

        Login login = loginService.getLoginById(0);
        if (login.getPassword().equals(lostPassword)){
            request.setAttribute("warning","输入的旧密码错误");
            request.getRequestDispatcher("admin/setting.jsp").forward(request,response);
        }else if (newPassword1.equals(newPassword2)){
            request.setAttribute("warning","两次输入的密码不相同");
            request.getRequestDispatcher("admin/setting.jsp").forward(request,response);
        }else {
            login.setPassword(newPassword1);
            loginService.update(login);
        }

        request.getRequestDispatcher("admin/setting.jsp").forward(request,response);
    }
}