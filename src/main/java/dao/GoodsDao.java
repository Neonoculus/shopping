package dao;

import domain.Goods;

public interface GoodsDao {
    void add(Goods goods);
    void delete(int id);
    void update(Goods goods,int id);
    Goods GIdSelect(int id);
    Goods[] cIdSelect(int id);
    Goods[] mIdSelect(int id);
    Goods[] nameSelect(String name);
    Goods[] priceSelect(Double minPrice,Double maxPrice);
    Goods[] statusSelect(int status);
    Goods[] Select();

}
