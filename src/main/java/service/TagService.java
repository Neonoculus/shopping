package service;

import domain.Tag;

import java.util.List;

public interface TagService {
    int add(Tag tag);
    int delete(int id);
    int update(Tag tag);
    Tag getTagByTId(int id);
    List<Tag> getTagByName(String name);
    List<Tag> getAllTag();
    List<Tag> getTagByCId(int cid);
}
