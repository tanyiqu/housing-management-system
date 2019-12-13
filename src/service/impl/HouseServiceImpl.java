package service.impl;

import bean.BuyerCard;
import bean.House;
import bean.SellerCard;
import dao.HouseDao;
import dao.impl.HouseDaoImpl;
import service.HouseService;

import java.util.ArrayList;
import java.util.List;

public class HouseServiceImpl implements HouseService {

    HouseDao houseDao = new HouseDaoImpl();

    @Override
    public List<BuyerCard> getBuyerCard(String username) {
        return houseDao.findBuyerCard(username);
    }

    @Override
    public List<SellerCard> getSellerCard(String username) {

        return houseDao.findSellerCard(username);
    }

    @Override
    public List<House> getBuyableHouse() {
        return houseDao.findAllBuyableHouse();
    }

    @Override
    public House getHouse(String id) {
        return houseDao.find(id);
    }
}
