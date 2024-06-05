package service.impl;

import dao.GoodsTagDao;
import dao.impl.GoodsTagDaoImpl;
import domain.GoodsTag;
import service.GoodsTagService;

import java.util.List;

public class GoodsTagServiceImpl implements GoodsTagService {
    GoodsTagDao goodsTagDao = new GoodsTagDaoImpl();
    @Override
    public int add(GoodsTag goodsTag) {
        return goodsTagDao.add(goodsTag);
    }

    @Override
    public int delete(int g_id, int t_id) {
        return goodsTagDao.delete(g_id,t_id);
    }

    @Override
    public List<GoodsTag> getGoodsTagByGId(int id) {
        return goodsTagDao.getGoodsTagByGId(id);
    }

    @Override
    public List<GoodsTag> getGoodsTagByTId(int id) {
        return goodsTagDao.getGoodsTagByTId(id);
    }

    @Override
    public List<GoodsTag> getAllGoodsTag() {
        return goodsTagDao.getAllGoodsTag();
    }
}
