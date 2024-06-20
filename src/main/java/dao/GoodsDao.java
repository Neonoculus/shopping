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
    List<Goods> getGoodsByCIdAndTidsPage(int cid,List<Integer> tid,int start,int rows);
    List<Goods> getGoodsByCIdAndTidsAndPrice(int cid,List<Integer> tid,Double minPrice,Double maxPrice);
    List<Goods> getGoodsByCIdAndTidsAndPricePage(int cid,List<Integer> tid,Double minPrice,Double maxPrice,int start,int rows);
    List<Goods> getGoodsByMId(int id);
    List<Goods> getGoodsByName(String name);
    List<Goods> getGoodsByPrice(Double minPrice, Double maxPrice);
    List<Goods> getGoodByAllQuery(String word);
    List<Goods> getGoodByAllQueryPage(String word,int start,int rows);
    List<Goods> getGoodsByStatus(int status);
    List<Goods>  findByPage(int start, int rows);
    List<Goods>  findByPageByMId(int id,int start, int rows);
    List<Goods> getAllGoods();
    List<Goods> getGoodsByCIdAndPage(int cid, int start, int rows);

    List<Goods> getGoodsPriceByCId(int cid,int minPrice,int maxPrice);
    List<Goods> getGoodsPriceByCIdPage(int cid,int minPrice,int maxPrice,int start,int rows);
}
