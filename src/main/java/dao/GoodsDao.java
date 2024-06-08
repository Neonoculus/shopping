package dao;

import domain.Goods;

import java.util.List;

public interface GoodsDao {
    int add(Goods goods);
    int delete(int id);
    int update(Goods goods);
    Goods getGoodsByGId(int id);
    List<Goods> getGoodsByCId(int id);
    List<Goods> getGoodsByCIdAndTids(int cid,List<Integer> tid);
    List<Goods> getGoodsByCIdAndTidsAndPrice(int cid,List<Integer> tid,Double minPrice,Double maxPrice);
    List<Goods> getGoodsByMId(int id);
    List<Goods> getGoodsByName(String name);
    List<Goods> getGoodsByPrice(Double minPrice, Double maxPrice);
    List<Goods> getGoodByAllQuery(String word);
    List<Goods> getGoodsByStatus(int status);
    List<Goods>  findByPage(int start, int rows);
    List<Goods>  findByPageByMId(int id,int start, int rows);
    List<Goods> getAllGoods();
}
