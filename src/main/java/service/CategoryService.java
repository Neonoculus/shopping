package service;

import domain.*;

import java.util.List;

public interface CategoryService {
    /**
     * 获取所有新闻分类
     * @return
     */
    List<Category> getAllCategories();

    Category getCategoryById(int categoryId);

}
