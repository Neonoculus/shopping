package web.servlet.backstage;

import domain.Buyer;
import domain.Login;
import domain.Merchant;
import service.BuyerService;
import service.LoginService;
import service.MerchantService;
import service.impl.BuyerServiceImpl;
import service.impl.LoginServiceImpl;
import service.impl.MerchantServiceImpl;
import utils.SendEmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet("/doSignUpServlet")
public class DoSignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random random = new Random();
        HttpSession session = request.getSession();
        LoginService loginService = new LoginServiceImpl();
        BuyerService buyerService = new BuyerServiceImpl();
        MerchantService merchantService = new MerchantServiceImpl();

        int a = random.nextInt(900000) + 100000;

        String submit = request.getParameter("send");
        String email = request.getParameter("email");
        String code = String.valueOf(a);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String user = request.getParameter("user");

        if (!(submit == null)){
            new SendEmail(email,code);
            session.setAttribute("code",code);
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            request.setAttribute("user",user);
            request.setAttribute("email",email);

        }else {

            String inputCode = request.getParameter("inputCode");
            code = (String) session.getAttribute("code");
            if (!code.equals(inputCode)){
                request.setAttribute("warning","验证码错误");
                request.getRequestDispatcher("backstage/signup.jsp").forward(request,response);
            }
            int type = 0,id = 0;
            if (user.equals("buyer")){
                type = 1;
                id = 500000000+buyerService.getAllBuyer().size()+1;
                buyerService.add(new Buyer(0,"",email,"","",""));
            }else if (user.equals("merchant")){
                type = 2;
                id = 100000000+merchantService.getAllMerchant().size()+1;
                merchantService.add(new Merchant(0,"","","",email,"",""));
            }else {
                request.setAttribute("warning","请选择账户类型");
                request.getRequestDispatcher("backstage/signup.jsp").forward(request,response);
            }


            Login login = new Login(0,username,password,type,id);
            loginService.add(login);
            request.getRequestDispatcher("backstage/signin.jsp").forward(request,response);

        }
        request.getRequestDispatcher("backstage/signup.jsp").forward(request,response);
    }
}