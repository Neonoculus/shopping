package service;

import domain.Cart;
import domain.dto.CartDto;

import java.util.List;

public interface CartService {
    int add(Cart cart);
    int delete(Cart cart);
    int update(Cart cart);
    List<Cart> getCartByBId(int id);
    List<Cart> getAllCart();
    List<CartDto> getCartDtoById(int id);
}
