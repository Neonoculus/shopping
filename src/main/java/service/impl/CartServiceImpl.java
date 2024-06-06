package service.impl;

import dao.CartDao;
import dao.impl.CartDaoImpl;
import domain.Cart;
import domain.dto.CartDto;
import service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    CartDao cartDao = new CartDaoImpl();
    @Override
    public int add(Cart cart) {
        return cartDao.add(cart);
    }

    @Override
    public int delete(Cart cart) {
        return cartDao.delete(cart);
    }

    @Override
    public int update(Cart cart) {
        return cartDao.update(cart);
    }

    @Override
    public List<Cart> getCartByBId(int id) {
        return cartDao.getCartByBId(id);
    }

    @Override
    public List<Cart> getAllCart() {
        return cartDao.getAllCart();
    }

    @Override
    public List<CartDto> getCartDtoById(int id) {
        return cartDao.getCartDtoById(id);
    }
}
