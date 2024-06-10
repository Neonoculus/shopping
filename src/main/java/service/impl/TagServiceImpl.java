package service.impl;

import dao.TagDao;
import dao.impl.TagDaoImpl;
import domain.Tag;
import service.TagService;

import java.util.List;

public class TagServiceImpl implements TagService {
    TagDao tagDao = new TagDaoImpl();
    @Override
    public int add(Tag tag) {
        return tagDao.add(tag);
    }

    @Override
    public int delete(int id) {
        return tagDao.delete(id);
    }

    @Override
    public int update(Tag tag) {
        return tagDao.update(tag);
    }

    @Override
    public Tag getTagByTId(int id) {
        return tagDao.getTagByTId(id);
    }

    @Override
    public List<Tag> getTagByName(String name) {
        return tagDao.getTagByName(name);
    }

    @Override
    public List<Tag> getAllTag() {
        return tagDao.getAllTag();
    }

    @Override
    public List<Tag> getTagByCId(int cid) {
        return tagDao.getTagByCId(cid);
    }
}
