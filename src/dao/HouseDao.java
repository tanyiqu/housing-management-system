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

}
