package service.impl;

import dao.MerchantDao;
import dao.impl.MerchantDaoImpl;
import domain.Merchant;
import service.MerchantService;

import java.util.List;

public class MerchantServiceImpl implements MerchantService {
    MerchantDao merchantDao = new MerchantDaoImpl();
    @Override
    public int add(Merchant merchant) {
        return merchantDao.add(merchant);
    }

    @Override
    public int delete(int id) {
        return merchantDao.delete(id);
    }

    @Override
    public int update(Merchant merchant) {
        return merchantDao.update(merchant);
    }

    @Override
    public Merchant getMerchantByMId(int id) {
        return merchantDao.getMerchantByMId(id);
    }

    @Override
    public List<Merchant> getMerchantByName(String name) {
        return merchantDao.getMerchantByName(name);
    }

    @Override
    public Merchant getMerchantByPhone(String phone) {
        return merchantDao.getMerchantByPhone(phone);
    }

    @Override
    public Merchant getMerchantByEmail(String email) {
        return merchantDao.getMerchantByEmail(email);
    }

    @Override
    public List<Merchant> getAllMerchant() {
        return merchantDao.getAllMerchant();
    }
}
