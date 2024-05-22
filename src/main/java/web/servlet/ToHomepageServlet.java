package web.servlet;

import dao.CategoryDao;
import dao.TagDao;
import dao.impl.CategoryDaoImpl;
import dao.impl.TagDaoImpl;
import domain.Category;
import domain.News;
import domain.Tag;
import service.NewsService;
import service.impl.CategoryServiceImpl;
import service.impl.NewsServiceImpl;
import service.impl.TagServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/ToHomepageServlet")
public class ToHomepageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryId = request.getParameter("category");
        String tagId = request.getParameter("tag");

        NewsService newsService = new NewsServiceImpl();
        List<News> newsList;
        if(categoryId != null)
        {
            // 指定栏目的新闻
            newsList = newsService.getNewsByCategory(Integer.valueOf(categoryId));

            CategoryServiceImpl categoryService = new CategoryServiceImpl();
            Category category = categoryService.getCategoryById(Integer.parseInt(categoryId));

            request.setAttribute("category",category);

        } else if(tagId != null)
        {
            // 指定标签类的新闻

            newsList = newsService.getNewsByTag(Integer.valueOf(tagId));

            TagServiceImpl tagService = new TagServiceImpl();
            Tag tag = tagService.getTagById(Integer.parseInt(tagId));

            request.setAttribute("tag",tag);

        } else
        {
            // stick新闻
            newsList = newsService.getStickNews(10); //默认查询置顶（首页）新闻
        }

        //新闻列表写入request
        request.setAttribute("newsList", newsList);
        /*--------------------------------------------------------------------------------*/
        // stick新闻
        List<News> stickList = newsService.getStickNews(10); //默认查询置顶（首页）新闻
        request.setAttribute("stickList", stickList);
        /*--------------------------------------------------------------------------------*/

        //侧边栏热点新闻写入request
        List<News> hotNews = newsService.getHotNews();
        request.setAttribute("hotNews", hotNews);
        /*--------------------------------------------------------------------------------*/
        //所有的栏目写入request
        CategoryDao categoryDao = new CategoryDaoImpl();
        List<Category> categories = categoryDao.getAllCategories();
        request.setAttribute("categories",categories);
        /*--------------------------------------------------------------------------------*/
        //所有的栏目新闻统计条数写入request， 封装为list, map形势为 {id=1, name=时政, count=6}
        List<Map<String,Object>> list = newsService.statNewsCountByCategory();
        request.setAttribute("statList",list);
        /*--------------------------------------------------------------------------------*/
        //所有的标签写入request
        TagDao tagDao = new TagDaoImpl();
        List<Tag> tags = tagDao.getAllTags();
        request.setAttribute("tags",tags);
        /*--------------------------------------------------------------------------------*/

        try {
            request.getRequestDispatcher("/homepage.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }
}