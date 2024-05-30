package dao;

import domain.Tag;

import java.util.List;

public interface TagDao {
    int add(Tag tag);
    int delete(int id);
    int update(Tag tag);
    Tag getTagByTId(int id);
    List<Tag> getTagByName(String name);
    List<Tag> getAllTag();
}
