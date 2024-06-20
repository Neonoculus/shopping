package web.servlet.foreground;

import domain.Buyer;
import domain.Category;
import domain.Goods;
import domain.Tag;
import service.BuyerService;
import service.CategoryService;
import service.GoodsService;
import service.TagService;
import service.impl.BuyerServiceImpl;
import service.impl.CategoryServiceImpl;
import service.impl.GoodsServiceImpl;
import service.impl.TagServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/toShopServlet")
public class ToShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuyerService buyerService = new BuyerServiceImpl();
        GoodsService goodsService = new GoodsServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();
        TagService tagService = new TagServiceImpl();

        HttpSession session = request.getSession(false);

        //   可能需要的参数
        // 用户信息
        String b_id = request.getParameter("b_id");
        if(b_id==null){
            b_id = (String) request.getAttribute("b_id");
        }
        if(b_id!=null && !"".equals(b_id)){
            Buyer buyer = buyerService.getBuyerByBid(Integer.parseInt(b_id));
            request.setAttribute("buyer",buyer);
        }
        // shop  判断值，主要用于判断分页操作是执行的哪一个
        String shop = request.getParameter("shop");
        if(shop==null){
            shop = (String) request.getAttribute("shop");
        }
        if(shop==null){
            shop = (String) session.getAttribute("shop");
        }
        // 当前页数
        String curPage = request.getParameter("curPage");
        if(curPage==null){
            curPage = (String) request.getAttribute("curPage");
        }


        //  第一次访问shop页面
        if("first".equals(shop)){
            removeSession(request);
            session.setAttribute("shop",shop);
            // 商品数量
            int goodsCount = goodsService.getAllGoods().size();
            // 总页数
            int totalPage = goodsCount/ 9;
            if(goodsCount%9!=0) totalPage+=1;
            if(curPage==null){
                curPage = "1";
            }
            //  展示商品
            int start = (Integer.parseInt(curPage)-1)*9;
            List<Goods> goodsList = goodsService.findByPage(start,9);
            // 商品列表写入request
            request.setAttribute("goodsList", goodsList);
            request.setAttribute("curPage", curPage);
            request.setAttribute("goodsCount", goodsCount);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("all","all");
        }
        //   只通过类别访问shop页面
        if("a".equals(shop)){
            //  当前类别
            int c_id = (int) session.getAttribute("c_id");
            Category curCategory = categoryService.getCategoryByCId(c_id);
            //  当前页数
            if(curPage==null || "".equals(curPage)){
                curPage = "1";
            }
            //  展示商品
            int start = (Integer.parseInt(curPage)-1)*9;
            List<Goods> goodsList = goodsService.getGoodsByCIdAndPage(c_id,start,9);
            // 商品个数
            int goodsCount = goodsService.getGoodsByCId(c_id).size();
            // 总页数
            int totalPage = goodsCount/ 9;
            if(goodsCount%9!=0) totalPage+=1;
            // 标签展示
            List<Tag> tagList = tagService.getTagByCId(c_id);
            // 商品列表写入request
            request.setAttribute("curCategory",curCategory);
            request.setAttribute("goodsList", goodsList);
            request.setAttribute("curPage", curPage);
            request.setAttribute("goodsCount", goodsCount);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("tagList",tagList);
        }
        //  通过搜索框访问shop页面
        if("search".equals(shop)){
            session.removeAttribute("tidList");
            session.removeAttribute("maxPrice");
            session.removeAttribute("minPrice");
            String words = (String) session.getAttribute("words");
            //  当前页数
            if(curPage==null || "".equals(curPage)){
                curPage = "1";
            }
            //  展示商品
            int start = (Integer.parseInt(curPage)-1)*9;
            List<Goods> goodsList = goodsService.getGoodByAllQueryPage(words,start,9);
            // 商品个数
            int goodsCount = goodsService.getGoodByAllQuery(words).size();
            // 总页数
            int totalPage = goodsCount/ 9;
            if(goodsCount%9!=0) totalPage+=1;
            // 商品列表写入request
            request.setAttribute("goodsList", goodsList);
            request.setAttribute("curPage", curPage);
            request.setAttribute("goodsCount", goodsCount);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("words",words);
        }
        //  通过类别和价格搜索
        if("CPrice".equals(shop)){
            System.out.println("进入到CPrice这里.............");
            // 类别
            String c_id = (String) session.getAttribute("c_id");
            Category curCategory = categoryService.getCategoryByCId(Integer.parseInt(c_id));
            //  价格
            String minPrice = (String) session.getAttribute("minPrice");
            String maxPrice = (String) session.getAttribute("maxPrice");
            System.out.println("CPrice里的minPrice:"+minPrice);
            System.out.println("CPrice里的maxPrice:"+maxPrice);
            //  当前页数
            if(curPage==null || "".equals(curPage)){
                curPage = "1";
            }
            //  展示商品
            int start = (Integer.parseInt(curPage)-1)*9;
            List<Goods> goodsList = goodsService.getGoodsPriceByCIdPage(Integer.parseInt(c_id),Integer.parseInt(minPrice),Integer.parseInt(maxPrice),start,9);
            // 商品个数
            int goodsCount = goodsService.getGoodsPriceByCId(Integer.parseInt(c_id),Integer.parseInt(minPrice),Integer.parseInt(maxPrice)).size();
            // 总页数
            int totalPage = goodsCount/ 9;
            if(goodsCount%9!=0) totalPage+=1;
            // 标签展示
            List<Tag> tagList = tagService.getTagByCId(Integer.parseInt(c_id));
            // 商品列表写入request
            request.setAttribute("goodsList", goodsList);
            request.setAttribute("curPage", curPage);
            request.setAttribute("goodsCount", goodsCount);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("curCategory",curCategory);
            request.setAttribute("minPrice",minPrice);
            request.setAttribute("maxPrice",maxPrice);
            request.setAttribute("tagList",tagList);
        }
        //   类别和标签查询
        if("CT".equals(shop)){
            System.out.println("进入到CT这里.............");
            // 类别
            String c_id = (String) session.getAttribute("c_id");
            Category curCategory = categoryService.getCategoryByCId(Integer.parseInt(c_id));
            //  当前页数
            if(curPage==null || "".equals(curPage)){
                curPage = "1";
            }
            //  获取被选种的标签
            String[] curTag = (String[]) session.getAttribute("curTagList");
            System.out.println("---------------------------------");
            System.out.println("toShopServlet这里CT的标签：");
            List<Integer> curTagList = new ArrayList<>();
            for(String tag : curTag){
                System.out.println("tag");
                curTagList.add(Integer.valueOf(tag));
            }
            System.out.println("---------------------------------");
            //  展示商品
            int start = (Integer.parseInt(curPage)-1)*9;
            List<Goods> goodsList = goodsService.getGoodsByCIdAndTidsPage(Integer.parseInt(c_id),curTagList,start,9);
            // 商品个数
            int goodsCount = goodsService.getGoodsByCIdAndTids(Integer.parseInt(c_id),curTagList).size();
            // 总页数
            int totalPage = goodsCount/ 9;
            if(goodsCount%9!=0) totalPage+=1;
            // 标签展示
            List<Tag> tagList = tagService.getTagByCId(Integer.parseInt(c_id));
            // 商品列表写入request
            request.setAttribute("goodsList", goodsList);
            request.setAttribute("curPage", curPage);
            request.setAttribute("goodsCount", goodsCount);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("curCategory",curCategory);
            request.setAttribute("tagList",tagList);
            request.setAttribute("curTagList",curTagList);
        }
        //  类别和标签和价格查询
        if("CTPrice".equals(shop)){
            System.out.println("进入到CT这里.............");
            // 类别
            String c_id = (String) session.getAttribute("c_id");
            Category curCategory = categoryService.getCategoryByCId(Integer.parseInt(c_id));
            //  当前页数
            if(curPage==null || "".equals(curPage)){
                curPage = "1";
            }
            //  获取被选种的标签
            String[] curTag = (String[]) session.getAttribute("curTagList");
            System.out.println("---------------------------------");
            System.out.println("toShopServlet这里CT的标签：");
            List<Integer> curTagList = new ArrayList<>();
            for(String tag : curTag){
                System.out.println("tag");
                curTagList.add(Integer.valueOf(tag));
            }
            System.out.println("---------------------------------");
            //  价格
            String minPrice = (String) session.getAttribute("minPrice");
            String maxPrice = (String) session.getAttribute("maxPrice");
            System.out.println("CTPrice里的minPrice:"+minPrice);
            System.out.println("CTPrice里的maxPrice:"+maxPrice);
            //  展示商品
            int start = (Integer.parseInt(curPage)-1)*9;
            List<Goods> goodsList = goodsService.getGoodsByCIdAndTidsAndPricePage(Integer.parseInt(c_id),curTagList, (double) Integer.parseInt(minPrice), (double) Integer.parseInt(maxPrice),start,9);
            // 商品个数
            int goodsCount = goodsService.getGoodsByCIdAndTidsAndPrice(Integer.parseInt(c_id),curTagList, (double) Integer.parseInt(minPrice), (double) Integer.parseInt(maxPrice)).size();
            // 总页数
            int totalPage = goodsCount/ 9;
            if(goodsCount%9!=0) totalPage+=1;
            // 标签展示
            List<Tag> tagList = tagService.getTagByCId(Integer.parseInt(c_id));
            // 商品列表写入request
            request.setAttribute("goodsList", goodsList);
            request.setAttribute("curPage", curPage);
            request.setAttribute("goodsCount", goodsCount);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("curCategory",curCategory);
            request.setAttribute("tagList",tagList);
            request.setAttribute("curTagList",curTagList);
            request.setAttribute("minPrice",minPrice);
            request.setAttribute("maxPrice",maxPrice);
        }

        //  转发
        List<Category> categories = categoryService.getAllCategory();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/foreground/shop.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
    private void removeSession(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("shop");
            session.removeAttribute("c_id");
            session.removeAttribute("curTagList");
            session.removeAttribute("maxPrice");
            session.removeAttribute("minPrice");
            session.removeAttribute("words");
        }
    }
}