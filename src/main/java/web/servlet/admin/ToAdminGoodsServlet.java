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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/toAdminGoodsServlet")
public class ToAdminGoodsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService goodsService = new GoodsServiceImpl();

        String startString = request.getParameter("start");
        if (startString == null){
            startString = (String) request.getAttribute("start");
        }
        int start = Integer.parseInt(startString)*10;
        int pageSumNumber = goodsService.goodsPageSum(goodsService.getAllGoods())/10+1;

        List<Goods> goods = goodsService.findByPage(start,10);

        List<Goods> goodsList = new ArrayList<>();
        for (Goods goods1:goods){
            String[] imageArray = goods1.getPhoto().split("#");
            goods1.setPhoto(imageArray[0]);
            goodsList.add(goods1);
        }
        request.setAttribute("pageSumNumber",pageSumNumber);
        request.setAttribute("goodsList",goodsList);

        request.getRequestDispatcher("admin/goods.jsp").forward(request,response);
    }
}