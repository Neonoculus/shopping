package dao;

import domain.Like;

public interface LikeDao {
    void add(Like like);
    void delete(int id);
    void update(Like like,int id);
    Like[] bIdSelect(int id);
    Like[] Select();
}
