package dao;

import domain.Goods;

import java.util.List;

public interface GoodsDao {
    int add(Goods goods);
    int delete(int id);
    int update(Goods goods);
    Goods getGoodsByGId(int id);
    List<Goods> getGoodsByCId(int id);
    List<Goods> getGoodsByMId(int id);
    List<Goods> getGoodsByName(String name);
    List<Goods> getGoodsByPrice(Double minPrice, Double maxPrice);
    List<Goods> getGoodsByStatus(int status);
    List<Goods> getAllGoods();

}
