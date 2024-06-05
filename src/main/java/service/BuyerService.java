package service;

import domain.Buyer;

import java.util.List;

public interface BuyerService {
    int add(Buyer buyer);
    int delete(int id);
    int update(Buyer buyer);
    Buyer getBuyerByBid(int id);
    List<Buyer> getBuyerByName(String name);
    Buyer getBuyerByEmail(String email);
    Buyer getBuyerByPhone(String phone);
    List<Buyer> getAllBuyer();
}
