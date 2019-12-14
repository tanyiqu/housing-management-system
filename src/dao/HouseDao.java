package dao;

import bean.BuyerCard;
import bean.House;
import bean.SellerCard;

import java.util.List;

public interface HouseDao {

    /**
     * 查找买方登记卡
     * @param username 账号
     * @return list
     */
    public List<BuyerCard> findBuyerCard(String username);


    /**
     * 查找卖方登记卡
     * @param username 账号
     * @return list
     */
    public List<SellerCard> findSellerCard(String username);

    /**
     * 查找所有房源
     * @return list
     */
    public List<House> findAllBuyableHouse();

    /**
     * 查找House
     * @param id 房号
     * @return House
     */
    public House find(String id);

    /**
     * 返回一个可用的房号
     * @return 房号
     */
    public String findAvailableHouseId();

    /**
     * 插入
     * @param host
     * @param houseName
     * @param type
     * @param area
     * @param year
     * @param addr
     * @param room
     * @param price
     * @return
     */
    public boolean insert(String host,String houseName, String type, int area, String year, String addr, String room, int price);

    public List<House> findHouseByAddr(String addr);

    public List<House> findHouseByArea(int lower,int higher);

    public List<House> findHouseByPrice(int lower,int higher);

}
