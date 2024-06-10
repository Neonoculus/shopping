package web.servlet.foreground;

import domain.*;
import service.*;
import service.impl.*;
import utils.PhotoUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JSP 页面的 Servlet
 */
@WebServlet("/toSingleProductServlet")
public class ToSingleProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuyerService buyerService = new BuyerServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();
        TagService tagService = new TagServiceImpl();
        GoodsTagService goodsTagService = new GoodsTagServiceImpl();
        GoodsService goodsService = new GoodsServiceImpl();
        PhotoUtil photoUtil = new PhotoUtil();

        //  toOrderDetailServlet  需要的参数
        String b_idTemp =  request.getParameter("b_id");
        int b_id = Integer.parseInt(b_idTemp);
        int g_id = Integer.parseInt(request.getParameter("g_id"));
        //  用户个人信息
        Buyer buyer = buyerService.getBuyerByBid(b_id);
        request.setAttribute("buyer",buyer);
        //  商品信息
        Goods goods = goodsService.getGoodsByGId(g_id);
        request.setAttribute("goods",goods);
        List<String> photoList = photoUtil.getPhotoList(goods.getPhoto());
        request.setAttribute("photoList",photoList);
        //  商品类别信息
        Category category = categoryService.getCategoryByCId(goods.getC_id());
        request.setAttribute("category",category);
        //  商品标签信息
        List<GoodsTag> goodsTagList = goodsTagService.getGoodsTagByGId(goods.getG_id());
        List<Tag> tagList = new ArrayList<>();
        for(GoodsTag goodsTag : goodsTagList){
            tagList.add(tagService.getTagByTId(goodsTag.getT_id()));
        }
        request.setAttribute("tagList",tagList);
        System.out.println("1111111111111111");
        System.out.println(tagList);
        System.out.println("1111111111111111");

        request.getRequestDispatcher("foreground/single-product.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}