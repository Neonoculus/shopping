package dao;

import domain.Goods;
import domain.GoodsTag;

public interface GoodsTagDao {
    void add(GoodsTag goodsTag);
    void delete(int id);
    void update(GoodsTag goodsTag,int id);
    GoodsTag[] gIdSelect(int id);
    Goods[] tIdSelect(int id);
    GoodsTag[] Select();
}
