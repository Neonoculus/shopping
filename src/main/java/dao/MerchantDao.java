package dao;

import domain.Merchant;

public interface MerchantDao {
    void add(Merchant merchant);
    void delete(int id);
    void update(Merchant merchant,int id);
    Merchant mIdSelect(int id);
    Merchant[] nameSelect(String name);
    Merchant phoneSelect(String phone);
    Merchant emailSelect(String email);
    Merchant[] Select();
}
