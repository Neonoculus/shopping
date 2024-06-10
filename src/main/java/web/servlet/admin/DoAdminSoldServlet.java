package web.servlet.admin;

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

@WebServlet("/doAdminSoldServlet")
public class DoAdminSoldServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService goodsService = new GoodsServiceImpl();

        int g_id = Integer.parseInt(request.getParameter("g_id"));
        int status = Integer.parseInt(request.getParameter("status"));

        Goods goods = goodsService.getGoodsByGId(g_id);

        goods.setStatus(status);

        int i = goodsService.update(goods);

        request.getRequestDispatcher("admin/goods.jsp").forward(request,response);
    }
}