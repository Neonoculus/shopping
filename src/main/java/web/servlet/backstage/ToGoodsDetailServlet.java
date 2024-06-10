package web.servlet.backstage;

import domain.*;
import service.*;
import service.impl.*;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/toGoodsDetailServlet")
public class ToGoodsDetailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService goodsService = new GoodsServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();
        TagService tagService = new TagServiceImpl();
        CategoryTagService categoryTagService = new CategoryTagServiceImpl();
        GoodsTagService goodsTagService = new GoodsTagServiceImpl();
        MerchantService merchantService = new MerchantServiceImpl();

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

        Category category = categoryService.getCategoryByCId(goods.getC_id());

        List<Tag> tags = new ArrayList<>(),goodsTags = new ArrayList<>();
        List<CategoryTag> categoryTags = categoryTagService.getCategoryTagByCid(goods.getC_id());
        for (CategoryTag categoryTag : categoryTags){
           Tag tag = tagService.getTagByTId(categoryTag.getT_id());
           tags.add(tag);
        }
        List<GoodsTag> goodsTags1 = goodsTagService.getGoodsTagByGId(goods.getG_id());
        for (GoodsTag goodsTag : goodsTags1){
            Tag tag = tagService.getTagByTId(goodsTag.getT_id());
            goodsTags.add(tag);
        }
        List<Tag> tagList = new ArrayList<>();
        for(int a=0;a<tags.size();a++){
            boolean panduan = true;
            for(int b=0;b<goodsTags.size();b++){
                if(tags.get(a).getT_id()==goodsTags.get(b).getT_id()){
                    panduan=false;
                    break;
                }
            }
            if(panduan){
                tagList.add(tags.get(a));
            }
        }


        int start = Integer.parseInt(request.getParameter("start"));

        int m_id = Integer.parseInt(request.getParameter("m_id"));
        Merchant merchant = merchantService.getMerchantByMId(m_id);
        request.setAttribute("merchant",merchant);
        request.setAttribute("goods",goods);
        request.setAttribute("category",category);
        request.setAttribute("tags",tagList);
        request.setAttribute("goodsTags",goodsTags);
        request.setAttribute("start",start);
        request.getRequestDispatcher("backstage/goods-detail.jsp").forward(request,response);

    }
}