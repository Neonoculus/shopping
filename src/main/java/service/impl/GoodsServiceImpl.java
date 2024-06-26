package service.impl;

import dao.CategoryDao;
import dao.GoodsDao;
import dao.impl.CategoryDaoImpl;
import dao.impl.GoodsDaoImpl;
import domain.Category;
import domain.Goods;
import service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private final GoodsDao goodsDao = new GoodsDaoImpl();
    private final CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public int add(Goods goods) {
        return goodsDao.add(goods);
    }

    @Override
    public int delete(int id) {
        return goodsDao.delete(id);
    }

    @Override
    public int update(Goods goods) {
        return goodsDao.update(goods);
    }

    @Override
    public Goods getGoodsByGId(int id) {
        return goodsDao.getGoodsByGId(id);
    }

    @Override
    public List<Goods> getGoodsByCId(int id) {
        return goodsDao.getGoodsByCId(id);
    }

    @Override
    public List<Goods> getGoodsByMId(int id) {
        return goodsDao.getGoodsByMId(id);
    }

    @Override
    public List<Goods> getGoodsByName(String name) {
        return goodsDao.getGoodsByName(name);
    }

    @Override
    public List<Goods> getGoodsByCIdAndTids(int cid, List<Integer> tid) {
        return goodsDao.getGoodsByCIdAndTids(cid,tid);
    }

    @Override
    public List<Goods> getGoodsByCIdAndTidsPage(int cid, List<Integer> tid, int start, int rows) {
        return goodsDao.getGoodsByCIdAndTidsPage(cid,tid,start,rows);
    }

    @Override
    public List<Goods> getGoodsByCIdAndTidsAndPrice(int cid, List<Integer> tid, Double minPrice, Double maxPrice) {
        return goodsDao.getGoodsByCIdAndTidsAndPrice(cid,tid,minPrice,maxPrice);
    }

    @Override
    public List<Goods> getGoodsByCIdAndTidsAndPricePage(int cid, List<Integer> tid, Double minPrice, Double maxPrice,int start,int rows) {
        return goodsDao.getGoodsByCIdAndTidsAndPricePage(cid,tid,minPrice,maxPrice,start, rows);
    }

    @Override
    public List<Goods> getGoodsByPrice(Double minPrice, Double maxPrice) {
        return goodsDao.getGoodsByPrice(minPrice,maxPrice);
    }

    @Override
    public List<Goods> getGoodsByStatus(int status) {
        return goodsDao.getGoodsByStatus(status);
    }

    @Override
    public int goodsPageSum(List<Goods> goods) {
        return goodsDao.getAllGoods().size();
    }

    //  商品分页
    @Override
    public List<Goods> findByPage(int start, int rows) {
        return goodsDao.findByPage(start,rows);
    }

    @Override
    public List<Goods> findByPageByMId(int id, int start, int rows) {
        return goodsDao.findByPageByMId(id,start,rows);
    }

    @Override
    public List<Goods> getGoodByAllQuery(String word) {
        return goodsDao.getGoodByAllQuery(word);
    }

    @Override
    public List<Goods> getGoodByAllQueryPage(String word, int start, int rows) {
        return goodsDao.getGoodByAllQueryPage(word,start,rows);
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.getAllGoods();
    }

    @Override
    public List<Goods> getGoodsByCIdAndPage(int cid, int start, int rows) {
        return goodsDao.getGoodsByCIdAndPage(cid,start,rows);
    }

    @Override
    public List<Goods> getGoodsPriceByCId(int cid,int v1,int v2) {
        return goodsDao.getGoodsPriceByCId(cid,v1,v2) ;
    }

    @Override
    public List<Goods> getGoodsPriceByCIdPage(int cid, int minPrice, int maxPrice, int start, int rows) {
        return goodsDao.getGoodsPriceByCIdPage(cid,minPrice,maxPrice,start,rows);
    }
}
