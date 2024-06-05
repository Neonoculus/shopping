package service.impl;

import dao.LikeDao;
import dao.impl.LikeDaoImpl;
import domain.Like;
import service.LikeService;

import java.util.List;

public class LikeServiceImpl implements LikeService {
    LikeDao likeDao = new LikeDaoImpl();
    @Override
    public int add(Like like) {
        return likeDao.add(like);
    }

    @Override
    public int delete(int id) {
        return likeDao.delete(id);
    }

    @Override
    public List<Like> getLikeByBId(int id) {
        return likeDao.getLikeByBId(id);
    }

    @Override
    public List<Like> getAllLike() {
        return likeDao.getAllLike();
    }
}
