package web.servlet.backstage;

import domain.Category;
import domain.Merchant;
import service.CategoryService;
import service.MerchantService;
import service.impl.CategoryServiceImpl;
import service.impl.MerchantServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/toAddGoodsServlet")
public class ToAddGoodsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService categoryService = new CategoryServiceImpl();
        MerchantService merchantService = new MerchantServiceImpl();

        String m_idParam = request.getParameter("merchant");
        if (m_idParam == null){
            m_idParam = (String) request.getAttribute("merchant");
        }
        int m_id = Integer.parseInt(m_idParam);
        Merchant merchant = merchantService.getMerchantByMId(m_id);
        request.setAttribute("merchant",merchant);

        List<Category> categoryList = categoryService.getAllCategory();
        request.setAttribute("categoryList",categoryList);

        request.getRequestDispatcher("backstage/goods-add.jsp").forward(request,response);
    }
}