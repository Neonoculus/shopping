package web.servlet.backstage;

import domain.Merchant;
import service.MerchantService;
import service.impl.MerchantServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toMerchantInfoUpdateServlet")
public class ToMerchantInfoUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MerchantService merchantService = new MerchantServiceImpl();

        int m_id;
        String m_idString = request.getParameter("m_id");
        if (m_idString==null){
            m_id = Integer.parseInt((String)request.getAttribute("m_id"));
        }else {
            m_id = Integer.parseInt(m_idString);
        }

        Merchant merchant = merchantService.getMerchantByMId(m_id);


        request.setAttribute("merchant",merchant);


        request.getRequestDispatcher("backstage/info-update.jsp").forward(request,response);
    }
}