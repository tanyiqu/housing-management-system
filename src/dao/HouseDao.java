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
     * @param host 房主id
     * @param houseName 房名
     * @param type 房子类型
     * @param area 面积
     * @param year 年份
     * @param addr 地址
     * @param room 房间数
     * @param price 价格
     */
    public void insert(String host,String houseName, String type, int area, String year, String addr, String room, int price);

    /**
     * 根据地址查找
     * @param addr 地址
     * @return lsit
     */
    public List<House> findHouseByAddr(String addr);

    /**
     * 根据面积查找
     * @param lower 下
     * @param higher 上
     * @return list
     */
    public List<House> findHouseByArea(int lower,int higher);

    /**
     * 根据价格查找
     * @param lower 下
     * @param higher 上
     * @return list
     */
    public List<House> findHouseByPrice(int lower,int higher);

    /**
     * 插入买房表
     * @param username 用户名
     * @param houseId 房号
     * @param time 时间
     */
    public void insert_gf(String username, String houseId,String time);

}
