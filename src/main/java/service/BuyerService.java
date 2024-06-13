package service;

import domain.Buyer;
import domain.Goods;

import java.util.List;

public interface BuyerService {
    int add(Buyer buyer);
    int delete(int id);
    int update(Buyer buyer);
    Buyer getBuyerByBid(int id);
    List<Buyer> getBuyerByName(String name);
    Buyer getBuyerByEmail(String email);
    Buyer getBuyerByPhone(String phone);
    int buyerPageSum(List<Buyer> buyers);
    List<Buyer> findByPage(int start, int rows);
    List<Buyer> getAllBuyer();
}
