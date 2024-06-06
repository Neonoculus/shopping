package service;

import domain.CategoryTag;

import java.util.List;

public interface CategoryTagService {
    int add(CategoryTag categoryTag);
    int delete(int c_id,int t_id);
    List<CategoryTag> getCategoryTagByCid(int id);
    List<CategoryTag> getAllCategoryTag();
}
