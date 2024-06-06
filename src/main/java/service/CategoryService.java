package service;

import domain.Category;

import java.util.List;

public interface CategoryService {
    int add(Category category);
    int delete(int id);
    int update(Category category);
    Category getCategoryByCId(int id);
    List<Category> getCategoryByName(String name);
    List<Category> getAllCategory();
}
