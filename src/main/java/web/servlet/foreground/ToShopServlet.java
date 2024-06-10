package web.servlet.foreground;

import domain.Category;
import domain.Goods;

import domain.Tag;
import service.CategoryService;
import service.GoodsService;
import service.TagService;
import service.impl.CartServiceImpl;
import service.impl.CategoryServiceImpl;
import service.impl.GoodsServiceImpl;
import service.impl.TagServiceImpl;

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

        GoodsService goodsService = new GoodsServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();
        TagService tagService = new TagServiceImpl();

        int totalPage = goodsService.getAllGoods().size() / 9 + 1;
//        展示商品
        List<Goods> goodsList = goodsService.getAllGoods();
//        商品列表写入request
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