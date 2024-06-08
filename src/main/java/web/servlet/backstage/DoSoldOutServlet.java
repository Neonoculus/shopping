package web.servlet.backstage;

import domain.Goods;
import service.GoodsService;
import service.impl.GoodsServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doSoldServlet")
public class DoSoldOutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsService goodsService = new GoodsServiceImpl();

		int id,s;

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
		request.getRequestDispatcher("backstage/goods.jsp").forward(request,response);
    }
}