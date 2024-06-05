package service.impl;

import dao.BuyerDao;
import dao.impl.BuyerDaoImpl;
import domain.Buyer;
import service.BuyerService;

import java.util.List;

public class BuyerServiceImpl implements BuyerService {
    BuyerDao buyerDao = new BuyerDaoImpl();
    @Override
    public int add(Buyer buyer) {
        return buyerDao.add(buyer);
    }

    @Override
    public int delete(int id) {
        return buyerDao.delete(id);
    }

    @Override
    public int update(Buyer buyer) {
        return buyerDao.update(buyer);
    }

    @Override
    public Buyer getBuyerByBid(int id) {
        return buyerDao.getBuyerByBId(id);
    }

    @Override
    public List<Buyer> getBuyerByName(String name) {
        return buyerDao.getBuyerByName(name);
    }

    @Override
    public Buyer getBuyerByEmail(String email) {
        return buyerDao.getBuyerByEmail(email);
    }

    @Override
    public Buyer getBuyerByPhone(String phone) {
        return buyerDao.getBuyerByPhone(phone);
    }

    @Override
    public List<Buyer> getAllBuyer() {
        return buyerDao.getAllBuyer();
    }
}
