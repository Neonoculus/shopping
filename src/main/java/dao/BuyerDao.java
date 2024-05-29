package dao;

import domain.Buyer;

public interface BuyerDao {
    void add(Buyer buyer);
    void delete(int id);
    void update(Buyer buyer, int id);
    Buyer bIdSelect(int id);
    Buyer[] nameSelect(String name);
    Buyer emailSelect(String email);
    Buyer phoneSelect(String phone);
    Buyer[] Select();
}
