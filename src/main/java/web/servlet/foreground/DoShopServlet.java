package web.servlet.foreground;

import domain.*;
import service.*;
import service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/doShopServlet")
public class DoShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService goodsService = new GoodsServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();
        TagService tagService = new TagServiceImpl();
        CartService cartService = new CartServiceImpl();

        HttpSession session = request.getSession(false);

        //  用户
        String b_id = request.getParameter("b_id");
        if(b_id==null){
            b_id = (String) request.getAttribute("b_id");
        }
        if(b_id!=null){
            request.setAttribute("b_id",b_id);
        }
        // 点击类别的链接
        String a = request.getParameter("a");
        // 当前要显示页数
        String curPage = request.getParameter("curPage");
        if(curPage==null){
            curPage = (String) request.getAttribute("curPage");
        }
        // 当前类别
        String c_id = request.getParameter("c_id");
        if(c_id==null){
            c_id = (String) request.getAttribute("c_id");
        }
        //  点击搜索框
        String search = request.getParameter("search");
        if(search==null){
            search = (String) request.getAttribute("search");
        }
        // 当前选择的标签
        String[ ] curTagList = request.getParameterValues("curTagList");
        if(curTagList==null){
            System.out.println("doShopServlet里t_idList为null.................");
        }
        // 价格
        String maxPrice = request.getParameter("maxPrice");
        if(maxPrice==null) {
            maxPrice = (String) request.getAttribute("maxPrice");
        }
        if(maxPrice==null){
            System.out.println("doShopServlet里maxPrice为null.................");
        }
        String minPrice = request.getParameter("minPrice");
        if(minPrice==null){
            minPrice = (String) request.getAttribute("minPrice");
        }
        if(minPrice==null){
            System.out.println("doShopServlet里minPrice为null.................");
        }

        //  商品加入购物车
        String addCart = request.getParameter("addCart");
        if(addCart!=null){
            int g_id= Integer.parseInt(request.getParameter("g_id"));
            Goods goods = goodsService.getGoodsByGId(g_id);
            List<Cart> cartList = cartService.getCartByBId(Integer.parseInt(b_id));
            boolean judge = true;
            for(Cart cart : cartList){
                if(cart.getB_id()==Integer.parseInt(b_id) && cart.getG_id()==g_id){
                    Cart updateCart = new Cart(g_id,Integer.parseInt(b_id),cart.getCount()+1,goods.getPrice(),goods.getStatus());
                    cartService.update(updateCart);
                    judge = false;
                    break;
                }
            }
            if(judge){
                Cart cart = new Cart(g_id,Integer.parseInt(b_id),1,goods.getPrice(),goods.getStatus());
                cartService.add(cart);
            }
            request.getRequestDispatcher("toCartServlet").forward(request,response);
        }

        //  点击类别
        if(a!=null && curTagList==null && maxPrice==null &&minPrice==null){
            removeSession(request);
            session.setAttribute("shop","a");
            session.setAttribute("c_id",Integer.parseInt(c_id));
            request.setAttribute("curPage","1");
            request.getRequestDispatcher("toShopServlet").forward(request,response);
        }
        //  搜索框搜索
        if(search!=null && curTagList==null && maxPrice==null &&minPrice==null){
            removeSession(request);
            session.setAttribute("shop","search");
            String words = request.getParameter("words");
            if(words==null) {
                words = (String) request.getAttribute("words");
            }
            session.setAttribute("words",words);
            request.getRequestDispatcher("toShopServlet").forward(request,response);
        }
        //  类别和价格
        if((c_id!=null&& !"".equals(c_id)) && curTagList==null && maxPrice!=null &&minPrice!=null){
            System.out.println("进入设置CPrice会话这里");
            System.out.println("doShopServlet里CPrice里的minPrice:"+minPrice);
            System.out.println("doShopServlet里CPrice里的maxPrice:"+maxPrice);
            removeSession(request);
            session.setAttribute("shop","CPrice");
            session.setAttribute("c_id",c_id);
            session.setAttribute("minPrice",minPrice);
            session.setAttribute("maxPrice",maxPrice);
            request.getRequestDispatcher("toShopServlet").forward(request,response);
        }
        //  类别和标签
        if((c_id!=null&& !"".equals(c_id)) && curTagList!=null && (maxPrice==null||"".equals(maxPrice)) && (minPrice==null||"".equals(minPrice))){
            System.out.println("进入设置CT会话这里");
            System.out.println("doShopServlet这里的curTagList:");
            for (String curTag : curTagList){
                System.out.println(curTag);
            }
            removeSession(request);
            session.setAttribute("shop","CT");
            session.setAttribute("c_id",c_id);
            session.setAttribute("curTagList",curTagList);
            request.getRequestDispatcher("toShopServlet").forward(request,response);
        }
        //  类别和标签和价格
        if((c_id!=null&& !"".equals(c_id)) && curTagList!=null && maxPrice!=null && minPrice!=null){
            System.out.println("进入设置CTPrice会话这里");
            System.out.println("doShopServlet这里的curTagList:");
            for (String curTag : curTagList){
                System.out.println(curTag);
            }
            removeSession(request);
            session.setAttribute("shop","CTPrice");
            session.setAttribute("c_id",c_id);
            session.setAttribute("curTagList",curTagList);
            session.setAttribute("minPrice",minPrice);
            session.setAttribute("maxPrice",maxPrice);
            request.getRequestDispatcher("toShopServlet").forward(request,response);
        }
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