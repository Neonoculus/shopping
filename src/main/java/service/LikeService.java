package service;

import domain.Like;

import java.util.List;

public interface LikeService {
    int add(Like like);
    int delete(int id);
    List<Like> getLikeByBId(int id);
    List<Like> getAllLike();
}
