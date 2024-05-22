package service.impl;

import domain.Tag;
import service.TagService;

import java.util.List;
import java.util.Set;

public class TagServiceImpl implements TagService {
    @Override
    public List<Tag> getAllTags() {
        return null;
    }

    @Override
    public Tag getTagById(int TagId) {
        return null;
    }

    @Override
    public Set<Tag> getTagsByNewsId(int newsId) {
        return null;
    }

    @Override
    public void addTagsForNews(int newsId, Set<Integer> tagIds) {

    }

    @Override
    public void updateTagsForNews(int newsId, Set<Integer> tagIds) {

    }
}
