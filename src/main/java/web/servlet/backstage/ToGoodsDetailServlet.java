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

@WebServlet("/ToGoodsDetailServlet")
public class ToGoodsDetailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService goodsService = new GoodsServiceImpl();

        int id,i = 0;

        String id1 = request.getParameter("g_id");
        if (id1 ==null)
        {
            id = Integer.parseInt((String)request.getAttribute("g_id"));
        }else {
            id = Integer.parseInt(id1);
        }

        Goods goods = goodsService.getGoodsByGId(id);
        String[] imageArray = goods.getPhoto().split("#");
        for (String imagePath : imageArray) {
            i++;
            if (!imagePath.trim().isEmpty()) {
                request.setAttribute("photo"+i,imagePath);
            }
        }
        request.setAttribute("goods",goods);
        request.getRequestDispatcher("backstage/goods-detail.jsp");

    }
}