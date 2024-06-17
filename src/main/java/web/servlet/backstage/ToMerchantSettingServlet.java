package web.servlet.backstage;

import domain.Merchant;
import service.MerchantService;
import service.impl.MerchantServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toMerchantSettingServlet")
public class ToMerchantSettingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MerchantService merchantService = new MerchantServiceImpl();

		String m_idParam = request.getParameter("merchant");
		if (m_idParam == null){
			m_idParam = (String) request.getAttribute("merchant");
		}
		int m_id = Integer.parseInt(m_idParam);

		Merchant merchant = merchantService.getMerchantByMId(m_id);
		request.setAttribute("merchant", merchant);
		request.getRequestDispatcher("backstage/setting.jsp").forward(request, response);
    }
}