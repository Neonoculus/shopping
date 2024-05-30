package dao;

import domain.GoodsTag;

import java.util.List;

public interface GoodsTagDao {
    int add(GoodsTag goodsTag);
    int delete(int g_id,int t_id);
    List<GoodsTag> getGoodsTagByGId(int id);
    List<GoodsTag> getGoodsTagByTId(int id);
    List<GoodsTag> getAllGoodsTag();
}
