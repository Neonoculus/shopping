package service.impl;

import dao.*;
import dao.impl.*;
import domain.News;
import service.NewsService;

import java.util.List;
import java.util.Map;

public class NewsServiceImpl implements NewsService {
    NewsDao newsDao = new NewsDaoImpl();
    @Override
    public List<News> getNewsByCategory(Integer categoryId) {
        return newsDao.getNewsByCategory(categoryId);
    }

    @Override
    public List<News> getNewsByTag(Integer tagId) {
        return null;
    }

    @Override
    public List<News> getStickNews(int limit) {
        return null;
    }

    @Override
    public List<News> getAllNews() {
        return null;
    }

    @Override
    public Integer addNews(News news) {
        return null;
    }

    @Override
    public void updateNews(News news) {

    }

    @Override
    public News getNewsById(int newsId) {
        return null;
    }

    @Override
    public List<News> getHotNews() {
        return null;
    }

    @Override
    public List<News> getRecommendedNews(int newsId) {
        return null;
    }

    @Override
    public void updateClickCount(int newsId) {

    }

    @Override
    public List<Map<String, Object>> statNewsCountByCategory() {
        return null;
    }

    @Override
    public List<Map<String, Object>> statNewsCountByTag() {
        return null;
    }

    @Override
    public List<Map<String, Object>> statNewsCommentCountByDate() {
        return null;
    }

    @Override
    public List<Map<String, Object>> statNewsCommentCountByUser() {
        return null;
    }

    @Override
    public Page<News> getPagedNews(int pageNumer, int pageSize, String key) {
        return null;
    }
}
