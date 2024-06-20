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

@WebServlet("/doMerchantGoodsHeadServlet")
public class DoMerchantGoodsHeadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsService goodsService = new GoodsServiceImpl();
		MerchantService merchantService = new MerchantServiceImpl();

		String m_idParam = request.getParameter("merchant");
		if (m_idParam == null){
			m_idParam = (String) request.getAttribute("merchant");
		}
		int m_id = Integer.parseInt(m_idParam);
		Merchant merchant = merchantService.getMerchantByMId(m_id);
		request.setAttribute("merchant", merchant);

		String select = request.getParameter("select");
		String soldOut = request.getParameter("SoldOut");
		String soldIn = request.getParameter("SoldIn");
		String[] selectedItems ;
		if (select!=null)
		{
			String search = request.getParameter("search");

			List<Goods> goodsList = goodsService.getGoodsByName(search);

			request.setAttribute("goodsList",goodsList);
		}else if (soldOut!=null)
		{
			Goods goods;
			selectedItems = request.getParameterValues("checkbox");
			for (String item : selectedItems){
				int id = Integer.parseInt(item);
				goods = goodsService.getGoodsByGId(id);
				goods.setStatus(0);
				int i = goodsService.update(goods);
			}
			List<Goods> goodsList = goodsService.findByPage(0,10);
			request.setAttribute("goodsList",goodsList);
		}
		if (soldIn!=null) {


			request.getRequestDispatcher("toAddGoodsServlet").forward(request,response);
		}else {
			int pageSumNumber = goodsService.goodsPageSum(goodsService.getAllGoods());

			request.setAttribute("page",0);
			request.setAttribute("pageSumNumber",pageSumNumber);
			request.getRequestDispatcher("backstage/goods.jsp").forward(request,response);
		}


	}
}