package web.servlet.foreground;

import domain.Buyer;
import domain.Category;
import domain.Goods;

import domain.Tag;
import service.BuyerService;
import service.CategoryService;
import service.GoodsService;
import service.TagService;
import service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/toShopServlet")
public class ToShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuyerService buyerService = new BuyerServiceImpl();
        GoodsService goodsService = new GoodsServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();
        TagService tagService = new TagServiceImpl();

        String b_id = request.getParameter("b_id");
        if(b_id==null){
            b_id = (String) request.getAttribute("b_id");
        }
        Buyer buyer = buyerService.getBuyerByBid(Integer.parseInt(b_id));
        //总页数
        int totalPage = goodsService.getAllGoods().size() / 9 + 1;
//        展示商品
        List<Goods> goodsList = goodsService.getAllGoods();
//        商品列表写入request
        request.setAttribute("buyer",buyer);
        request.setAttribute("goodsList", goodsList);
        request.setAttribute("currentPage", 1);
        request.setAttribute("goodsCount", goodsList.size());
        request.setAttribute("totalPage", totalPage);


        List<Category> categories = categoryService.getAllCategory();
        request.setAttribute("categories", categories);
//  转发
        request.getRequestDispatcher("/foreground/shop.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}