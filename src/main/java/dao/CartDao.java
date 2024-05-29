package dao;

import domain.Cart;

public interface CartDao {
    void add(Cart cart);
    void delete(int id);
    void update(Cart cart, int id);
    Cart[] bIdSelect(int id);
    Cart[] Select();
}
