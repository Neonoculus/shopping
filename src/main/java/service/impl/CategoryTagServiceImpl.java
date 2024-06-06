package service.impl;

import dao.CategoryTagDao;
import dao.impl.CategoryTagDaoImpl;
import domain.CategoryTag;
import service.CategoryTagService;

import java.util.List;

public class CategoryTagServiceImpl implements CategoryTagService {
    CategoryTagDao categoryTagDao = new CategoryTagDaoImpl();
    @Override
    public int add(CategoryTag categoryTag) {
        return categoryTagDao.add(categoryTag);
    }

    @Override
    public int delete(int c_id, int t_id) {
        return categoryTagDao.delete(c_id,t_id);
    }

    @Override
    public List<CategoryTag> getCategoryTagByCid(int id) {
        return categoryTagDao.getCategoryTagByCid(id);
    }

    @Override
    public List<CategoryTag> getAllCategoryTag() {
        return categoryTagDao.getAllCategoryTag();
    }
}
