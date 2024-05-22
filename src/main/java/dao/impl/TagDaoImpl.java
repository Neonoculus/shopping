package dao.impl;

import dao.TagDao;
import domain.Tag;

import java.util.List;
import java.util.Set;

public class TagDaoImpl implements TagDao {
    @Override
    public List<Tag> getAllTags() {
        return null;
    }

    @Override
    public Set<Tag> getTagsByNewsId(int newsId) {
        return null;
    }

    @Override
    public boolean isNewsTagExisted(int newsId, int tagId) {
        return false;
    }

    @Override
    public void addTagForNews(int newsId, int tagId) {

    }

    @Override
    public void deleteTagsForNews(int newsId) {

    }

    @Override
    public Tag getTagById(int tagId) {
        return null;
    }
}
