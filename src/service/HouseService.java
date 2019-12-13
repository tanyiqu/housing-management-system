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

}