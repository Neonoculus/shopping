package dao;

import domain.Category;

import java.util.List;

public interface CategoryDao {
    /**
     * 获取所有新闻分类
     * @return
     */
    List<Category> getAllCategories();

    Category getCategoryById(int categoryId);
}
