package dao;

import domain.Merchant;

import java.util.List;

public interface MerchantDao {
    int add(Merchant merchant);
    int delete(int id);
    int update(Merchant merchant);
    Merchant getMerchantByMId(int id);
    List<Merchant> getMerchantByName(String name);
    Merchant getMerchantByPhone(String phone);
    Merchant getMerchantByEmail(String email);
    List<Merchant> findByPage(int start, int rows);
    List<Merchant> getAllMerchant();
}
