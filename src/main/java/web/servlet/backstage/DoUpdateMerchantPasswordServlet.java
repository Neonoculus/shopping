package web.servlet.backstage;

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

@WebServlet("/doUpdateMerchantPasswordServlet")
public class DoUpdateMerchantPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginService loginService = new LoginServiceImpl();
		MerchantService merchantService = new MerchantServiceImpl();

		String m_idParam = request.getParameter("merchant");
		if (m_idParam == null){
			m_idParam = (String) request.getAttribute("merchant");
		}
		int m_id = Integer.parseInt(m_idParam);
		String lostPassword = request.getParameter("password");
		String newPassword1 = request.getParameter("password1");
		String newPassword2 = request.getParameter("password2");

		Merchant merchant = merchantService.getMerchantByMId(m_id);
		request.setAttribute("merchant", merchant);
		Login login = loginService.getLoginById(m_id);

		if (login.getId()!=m_id){
			request.setAttribute("warning","系统错误");
			request.getRequestDispatcher("backstage/signin.jsp").forward(request,response);
		}else if (!login.getPassword().equals(lostPassword)){
			request.setAttribute("warning","输入的旧密码错误");
			request.getRequestDispatcher("backstage/setting.jsp").forward(request,response);
		}else if (newPassword1.equals(lostPassword)){
			request.setAttribute("warning","新的密码不能和旧密码相同");
			request.getRequestDispatcher("backstage/setting.jsp").forward(request,response);
		}else if (!newPassword1.equals(newPassword2)){
			request.setAttribute("warning","两次输入的密码不相同");
			request.getRequestDispatcher("backstage/setting.jsp").forward(request,response);
		}else {
			login.setPassword(newPassword1);
			loginService.update(login);
		}



		request.getRequestDispatcher("backstage/setting.jsp").forward(request,response);
    }
}