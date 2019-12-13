package dao.impl;

import bean.BuyerCard;
import bean.House;
import bean.SellerCard;
import dao.HouseDao;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HouseDaoImpl implements HouseDao {

    @Override
    public List<BuyerCard> findBuyerCard(String username) {
        //查询买方登记卡视图
        String sql = "select * from vi_gfdjk where gmr_zh = '%s'";
        sql = String.format(sql,username);

        ResultSet rs = DBUtil.executeQuery(sql);

        List<BuyerCard> buyerCards = new ArrayList<>();

        while (true){
            try {
                if (!rs.next()) break;
                BuyerCard buyerCard = new BuyerCard();
                buyerCard.setName(rs.getString("fy_fm"));
                buyerCard.setPrice(rs.getInt("fy_sj"));
                buyerCard.setDate(rs.getString("gf_rq"));
                buyerCard.setHostname(rs.getString("csr_xm"));
                buyerCard.setHosttel(rs.getString("csr_sj"));
                buyerCards.add(buyerCard);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return buyerCards;
    }

    @Override
    public List<SellerCard> findSellerCard(String username) {
        //查询卖方登记卡视图
        String sql = "select * from vi_sfdjk where csr_zh = '%s'";
        sql = String.format(sql,username);

        ResultSet rs = DBUtil.executeQuery(sql);

        List<SellerCard> sellerCards = new ArrayList<>();

        while (true){
            try {
                if (!rs.next()) break;
                SellerCard sellerCard = new SellerCard();
                //房号
                sellerCard.setId(rs.getString("fy_fh"));
                //房名
                sellerCard.setName(rs.getString("fy_fm"));
                //价格
                sellerCard.setPrice(rs.getInt("fy_sj"));
                //已售
                sellerCard.setSoldout(rs.getString("fy_mc"));
                sellerCards.add(sellerCard);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sellerCards;
    }

    @Override
    public List<House> findAllBuyableHouse() {
        String sql = "select * from vi_kyfy";
        ResultSet rs = DBUtil.executeQuery(sql);
        List<House> houses = new ArrayList<>();
        while (true){
            try {
                if (!rs.next()) break;
                House house = new House();
                house.setHouseId(rs.getString("fy_fh"));
                house.setHost(rs.getString("csr_zh"));
                house.setHouseName(rs.getString("fy_fm"));
                house.setType(rs.getString("fy_lx"));
                house.setArea(rs.getInt("fy_mj"));
                house.setYear(rs.getString("fy_nf"));
                house.setAddr(rs.getString("fy_dz"));
                house.setRoom(rs.getString("fy_fj"));
                house.setPrice(rs.getInt("fy_sj"));
                house.setSoldout(false);
                houses.add(house);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return houses;
    }

    @Override
    public House find(String id) {
        String sql = "select * from fy where fy_fh = '%s'";
        sql = String.format(sql,id);
        House house = new House();
        ResultSet rs = DBUtil.executeQuery(sql);
        while (true){
            try {
                if (!rs.next()) break;
                house.setHouseId(rs.getString("fy_fh"));
                house.setHost(rs.getString("csr_zh"));
                house.setHouseName(rs.getString("fy_fm"));
                house.setType(rs.getString("fy_lx"));
                house.setArea(rs.getInt("fy_mj"));
                house.setYear(rs.getString("fy_nf"));
                house.setAddr(rs.getString("fy_dz"));
                house.setRoom(rs.getString("fy_fj"));
                house.setPrice(rs.getInt("fy_sj"));
                house.setSoldout(!rs.getBoolean("fy_km"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return house;
    }
}
