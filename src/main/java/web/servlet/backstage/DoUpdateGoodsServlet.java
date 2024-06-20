package web.servlet.backstage;

import domain.Goods;
import domain.GoodsTag;
import domain.Merchant;
import service.GoodsService;
import service.GoodsTagService;
import service.MerchantService;
import service.TagService;
import service.impl.GoodsServiceImpl;
import service.impl.GoodsTagServiceImpl;
import service.impl.MerchantServiceImpl;
import service.impl.TagServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/doUpdateGoodsServlet")
public class DoUpdateGoodsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		GoodsService goodsService = new GoodsServiceImpl();
		GoodsTagService goodsTagService = new GoodsTagServiceImpl();
		MerchantService merchantService = new MerchantServiceImpl();

		String photo = "";
		for (int j = 1 ; j < 5 ; j++)
		{
			if (request.getParameter("Photo"+j)!=null){
				photo = photo + request.getParameter("Photo"+j) + "#" ;
			}
			else break;
		}

		String name = request.getParameter("goods-name");
		Double price = Double.valueOf(request.getParameter("price"));
		int count = Integer.parseInt(request.getParameter("count"));
		String description = request.getParameter("description");
		int status = Integer.parseInt(request.getParameter("status"));
		String tags = request.getParameter("tags");
		int g_id = Integer.parseInt(request.getParameter("g_id"));
		int c_id = Integer.parseInt(request.getParameter("c_id"));
		int m_id = Integer.parseInt(request.getParameter("m_id"));

		Goods goods = new Goods(g_id,c_id,m_id,name,photo,price,description,status,count);
		int i = goodsService.update(goods);

		String[] tagArray = tags.split("#");
		GoodsTag goodsTag;
		int t_id;
		for (GoodsTag goodsTag1 : goodsTagService.getGoodsTagByGId(g_id))
		{
			goodsTagService.delete(g_id,goodsTag1.getT_id());
		}
		for (String t_idString : tagArray) {
			t_id = Integer.parseInt(t_idString);
			goodsTag = new GoodsTag(t_id,g_id);
			goodsTagService.add(goodsTag);
		}

		Merchant merchant = merchantService.getMerchantByMId(m_id);
		request.setAttribute("merchant",merchant);

		int start = Integer.parseInt(request.getParameter("start"));
		List<Goods> goodsList = goodsService.findByPageByMId(m_id,start*10,10);
		int pageSumNumber = goodsService.goodsPageSum(goodsService.getGoodsByMId(m_id))/10+1;

		start = start/10;

		request.setAttribute("goodsList",goodsList);
		request.setAttribute("pageSumNumber",pageSumNumber);
		request.setAttribute("m_id",m_id);;
		request.setAttribute("page",start);

		request.getRequestDispatcher("backstage/goods.jsp").forward(request,response);


    }
}