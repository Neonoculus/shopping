package web.servlet.admin;

import domain.Buyer;
import domain.Goods;
import domain.Login;
import service.GoodsService;
import service.impl.GoodsServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/doAdminGoodsHeadServlet")
public class DoAdminGoodsHeadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        GoodsService goodsService = new GoodsServiceImpl();

        String select = request.getParameter("select");
        String soldOut = request.getParameter("SoldOut");
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
        int pageSumNumber = goodsService.goodsPageSum(goodsService.getAllGoods());


        request.setAttribute("page",0);
        request.setAttribute("pageSumNumber",pageSumNumber);
        request.getRequestDispatcher("admin/goods.jsp").forward(request,response);
    }
}
