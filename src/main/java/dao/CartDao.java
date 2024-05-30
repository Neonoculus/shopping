package dao;

import domain.Cart;

import java.util.List;

public interface CartDao {
    int add(Cart cart);
    int delete(Cart cart);
    int update(Cart cart);
    List<Cart> getCartByBId(int id);
    List<Cart> getAllCart();
}
