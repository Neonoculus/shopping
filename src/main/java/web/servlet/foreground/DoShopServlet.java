package web.servlet.foreground;

import domain.Category;
import domain.Goods;
import domain.Tag;
import service.CategoryService;
import service.GoodsService;
import service.TagService;
import service.impl.CategoryServiceImpl;
import service.impl.GoodsServiceImpl;
import service.impl.TagServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/doShopServlet")
public class DoShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService goodsService = new GoodsServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();
        TagService tagService = new TagServiceImpl();

        //        分页操作
       String s =  request.getParameter("currentPage");

       String c_id = request.getParameter("cid");
        System.out.println(c_id);
        //      查询操作
        String word = request.getParameter("query");

        String minPrice = request.getParameter("v1");
        String maxPrice = request.getParameter("v2");

        String CID = request.getParameter("curId");

        System.out.println(CID);
        if(s!=null )
        {
            int start = (Integer.parseInt(request.getParameter("jspCurrentPage"))-1)*9;
            int totalPage = goodsService.getAllGoods().size()/9+1;
            int goodsCount = goodsService.getAllGoods().size();
            int rows = 9;
            List<Goods> gp = goodsService.findByPage(start,rows);
            request.setAttribute("totalPage",totalPage);
            request.setAttribute("gp",gp);
            request.setAttribute("currentPage",(start/9)+1);
            request.setAttribute("goodsCount",goodsCount);
            request.getRequestDispatcher("/foreground/shop.jsp").forward(request,response);
        }
        if (word!=null){
            List<Goods> w =  goodsService.getGoodByAllQuery(word);
            int totalPage = w.size()/9+1;

            request.setAttribute("goodsList",w);
            request.setAttribute("value",word);
            request.setAttribute("goodsCount",w.size());
            request.setAttribute("totalPage",totalPage);
            request.getRequestDispatcher("/foreground/shop.jsp").forward(request,response);
        }

        if(c_id!=null &&minPrice==null&&maxPrice==null){
            List<Category> categories = categoryService.getAllCategory();

            //   通过类别编号获取商品
            int start = (Integer.parseInt(request.getParameter("jspCurrentPage"))-1)*9;
            int rows = 9;
            List<Goods> goodsList = goodsService.getGoodsByCIdAndPage(Integer.parseInt(c_id),start,rows);
            request.setAttribute("goodsList",goodsList);
            int totalPage = goodsList.size()/9+1;

            Category category = categoryService.getCategoryByCId(Integer.parseInt(c_id));
//       通过类别编号获取标签
            List<Tag> tagList = tagService.getTagByCId(Integer.parseInt(c_id));
            request.setAttribute("tagList",tagList);
            request.setAttribute("categories",categories);
            request.setAttribute("curCategory",category);
            request.setAttribute("totalPage",totalPage);
            request.setAttribute("currentPage",(start/9)+1);
            request.setAttribute("goodsCount",goodsList.size());

            request.getRequestDispatcher("/foreground/shop.jsp").forward(request,response);
        }

        if(CID!=null&&minPrice!=null&&maxPrice!=null){
            //            通过类别筛选价格
            int vp1 = Integer.parseInt(minPrice);
            int vp2 = Integer.parseInt(maxPrice);
            int start = (Integer.parseInt(request.getParameter("curName"))-1)*9;
            int rows = 9;
            String[] t_id = request.getParameterValues("tags");
            List<Integer> tagList = new ArrayList<>();
            for (String string : t_id) {
                tagList.add(Integer.parseInt(string));
            }
            System.out.println(vp1);
            System.out.println(vp2);
            System.out.println(start);
            System.out.println(tagList);
            List<Goods> goodsList = goodsService.getGoodsByCIdAndTidsAndPrice(Integer.parseInt(CID),tagList, (double) vp1, (double) vp2,start,rows);
            System.out.println(goodsList);
            int totalPage = goodsList.size()/9+1;
            request.setAttribute("goodsCount",goodsList.size());
            request.setAttribute("totalPage",totalPage);
            request.setAttribute("goodsList",goodsList);
            request.setAttribute("value1",vp1);
            request.setAttribute("value2",vp2);

//            List<Category> allCategory = categoryService.getAllCategory();
//            List<Tag> tagByCId = tagService.getTagByCId(Integer.parseInt(CID));
//            List<Tag> checkedByTid = tagService.getTagByTId();
//
//            request.setAttribute("",tagList);

            request.getRequestDispatcher("/foreground/shop.jsp").forward(request,response);


        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}