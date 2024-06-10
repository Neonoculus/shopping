package service;

import domain.Goods;

import java.util.List;

public interface GoodsService {
    int add(Goods goods);
    int delete(int id);
    int update(Goods goods);
    Goods getGoodsByGId(int id);
    List<Goods> getGoodsByCId(int id);
    List<Goods> getGoodsByMId(int id);
    List<Goods> getGoodsByName(String name);
    List<Goods> getGoodsByCIdAndTids(int cid, List<Integer> tid);
    List<Goods> getGoodsByCIdAndTidsAndPrice(int cid,List<Integer> tid,Double minPrice,Double maxPrice,int start,int rows);
    List<Goods> getGoodsByPrice(Double minPrice, Double maxPrice);
    List<Goods> getGoodsByStatus(int status);
    int goodsPageSum(List<Goods> goods);
    List<Goods> findByPage(int start,int rows);
    List<Goods>  findByPageByMId(int id,int start, int rows);
    List<Goods> getGoodByAllQuery(String word);
    List<Goods> getAllGoods();
    List<Goods> getGoodsByCIdAndPage(int cid,int start,int rows);

    List<Goods> getGoodsPriceByCId(int cid,int v1,int v2);
}
