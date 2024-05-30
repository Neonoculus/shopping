package dao;

import domain.Buyer;

import java.util.List;

public interface BuyerDao {
    int add(Buyer buyer);
    int delete(int id);
    int update(Buyer buyer);
    Buyer getBuyerByBId(int id);
    List<Buyer> getBuyerByName(String name);
    Buyer getBuyerByEmail(String email);
    Buyer getBuyerByPhone(String phone);
    List<Buyer> getAllBuyer();
}
