package web.servlet.backstage;

import domain.Goods;
import domain.Merchant;
import service.GoodsService;
import service.MerchantService;
import service.impl.GoodsServiceImpl;
import service.impl.MerchantServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/doSoldServlet")
public class DoSoldOutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsService goodsService = new GoodsServiceImpl();
		MerchantService merchantService = new MerchantServiceImpl();

		int id,s;

		String m_idParam = request.getParameter("merchant");
		if (m_idParam == null){
			m_idParam = (String) request.getAttribute("merchant");
		}
		int m_id = Integer.parseInt(m_idParam);
		Merchant merchant = merchantService.getMerchantByMId(m_id);

		String id1 = request.getParameter("g_id");
		if (id1 ==null)
		{
			id = Integer.parseInt((String)request.getAttribute("g_id"));
		}else {
			id = Integer.parseInt(id1);
		}

		String s1 = request.getParameter("status");
		if (s1 ==null)
		{
			s = Integer.parseInt((String)request.getAttribute("status"));
		}else {
			s = Integer.parseInt(s1);
		}

		Goods goods = goodsService.getGoodsByGId(id);
		goods.setStatus(s);
		int i = goodsService.update(goods);
		request.setAttribute("status",i);

		List<Goods> goodsList = goodsService.findByPageByMId(m_id,0,10);
		int pageSumNumber = goodsService.goodsPageSum(goodsService.getGoodsByMId(m_id))/10+1;

		request.setAttribute("goodsList",goodsList);
		request.setAttribute("merchant", merchant);
		request.setAttribute("page",0);
		request.setAttribute("pageSumNumber",pageSumNumber);
		request.getRequestDispatcher("backstage/goods.jsp").forward(request,response);
    }
}