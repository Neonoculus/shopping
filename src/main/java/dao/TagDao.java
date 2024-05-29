package dao;

import domain.Tag;

public interface TagDao {
    void add(Tag tag);
    void delete(int id);
    void update(Tag tag,int id);
    Tag tIdSelect(int id);
    Tag[] nameSelect(String name);
    Tag[] Select();
}
