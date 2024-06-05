package service.impl;

import dao.GoodsDao;
import dao.impl.GoodsDaoImpl;
import domain.Goods;
import service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    GoodsDao goodsDao = new GoodsDaoImpl();
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
    public List<Goods> getGoodsByPrice(Double minPrice, Double maxPrice) {
        return goodsDao.getGoodsByPrice(minPrice,maxPrice);
    }

    @Override
    public List<Goods> getGoodsByStatus(int status) {
        return goodsDao.getGoodsByStatus(status);
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.getAllGoods();
    }
}
