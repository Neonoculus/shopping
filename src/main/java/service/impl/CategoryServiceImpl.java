package service.impl;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import domain.Category;
import service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public int add(Category category) {
        return categoryDao.add(category);
    }

    @Override
    public int delete(int id) {
        return categoryDao.delete(id);
    }

    @Override
    public int update(Category category) {
        return categoryDao.update(category);
    }

    @Override
    public Category getCategoryByCId(int id) {
        return categoryDao.getCategoryByCId(id);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }
}
