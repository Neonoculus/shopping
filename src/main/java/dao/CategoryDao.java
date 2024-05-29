package dao;

import domain.Category;

public interface CategoryDao {
    void add(Category category);
    void delete(int id);
    void update(Category category,int id);
    void cIdSelect(int id);
    void Select();
}
