package service;

import bean.BuyerCard;
import bean.House;
import bean.SellerCard;

import java.util.List;

public interface HouseService {


    /**
     * 根据买方账号获取买方登记卡
     * @param username 买方账号
     * @return list
     */
    public List<BuyerCard> getBuyerCard(String username);

    /**
     * 根据卖方账号获取卖方登记卡
     * @param username 卖方账号
     * @return list
     */
    public List<SellerCard> getSellerCard(String username);

    /**
     * 获取所有可买房源
     * @return list
     */
    public List<House> getBuyableHouse();

    /**
     * 查找房源
     * @param id 房号
     * @return House
     */
    public House getHouse(String id);

    /**
     * 添加
     * @param host 房主id
     * @param houseName 房名
     * @param type 房子类型
     * @param area 面积
     * @param year 年份
     * @param addr 地址
     * @param room 房间数
     * @param price 价格
     */
    public void addHouse(String host,String houseName, String type, int area, String year, String addr, String room, int price);

    /**
     * 根据地址查找
     * @param addr 地址
     * @return list
     */
    public List<House> getHouseByAddr(String addr);

    /**
     * 根据面积查找
     * @param lower 下界
     * @param higher 上界
     * @return list
     */
    public List<House> getHouseByArea(int lower,int higher);

    /**
     * 根据价格查找
     * @param lower 下界
     * @param higher 上界
     * @return list
     */
    public List<House> getHouseByPrice(int lower,int higher);

    /**
     * 买房
     * @param username 用户名
     * @param houseId 房号
     * @param time 时间
     */
    public void buy(String username,String houseId,String time);

}
