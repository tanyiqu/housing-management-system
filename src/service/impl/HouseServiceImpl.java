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

    @Override
    public void addHouse(String host, String houseName, String type, int area, String year, String addr, String room, int price) {
        houseDao.insert(host,houseName,type,area,year,addr,room,price);
    }

    @Override
    public List<House> getHouseByAddr(String addr) {
        return houseDao.findHouseByAddr(addr);
    }

    @Override
    public List<House> getHouseByArea(int lower, int higher) {
        return houseDao.findHouseByArea(lower,higher);
    }

    @Override
    public List<House> getHouseByPrice(int lower, int higher) {
        return houseDao.findHouseByPrice(lower,higher);
    }

    @Override
    public void buy(String username, String houseId,String time) {
        houseDao.insert_gf(username,houseId,time);
    }
}
