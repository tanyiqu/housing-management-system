package dao.impl;

import bean.BuyerCard;
import bean.House;
import bean.SellerCard;
import dao.HouseDao;
import util.DBUtil;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
        DBUtil.close();
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
        DBUtil.close();
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
        DBUtil.close();
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
        DBUtil.close();
        return house;
    }

    @Override
    public String findAvailableHouseId() {
        String sql = "{? = call fn_get_available_fy_fh()}";
        String id = null;
        CallableStatement cs = DBUtil.executeCall(sql);
        try {
            cs.registerOutParameter(1, Types.CHAR);
            cs.execute();
            id = cs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return id;
    }

    @Override
    public boolean insert(String host, String houseName, String type, int area, String year, String addr, String room, int price) {
        String sql = "{call sp_fy_add(?,?,?,?,?,?,?,?,?,?)}";
        boolean success = false;
        CallableStatement cs = DBUtil.executeCall(sql);
        try {
            //使用动态生成的房号
            cs.setString(1,findAvailableHouseId());
            cs.setString(2,host);
            cs.setString(3,houseName);
            cs.setString(4,type);
            cs.setInt(5,area);
            cs.setString(6,year);
            cs.setString(7,addr);
            cs.setString(8,room);
            cs.setInt(9,price);
            cs.setBoolean(10,true);
            success = cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public List<House> findHouseByAddr(String addr) {
        String sql = "select * from vi_kyfy where fy_dz like '%" + addr + "%'";
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
        DBUtil.close();
        return houses;
    }

    @Override
    public List<House> findHouseByArea(int lower, int higher) {
        String sql = "select * from vi_kyfy where fy_mj >= %s and fy_mj <= %s";
        sql = String.format(sql,lower,higher);
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
        DBUtil.close();
        return houses;
    }

    @Override
    public List<House> findHouseByPrice(int lower, int higher) {
        String sql = "select * from vi_kyfy where fy_sj >= %s and fy_sj <= %s";
        sql = String.format(sql,lower,higher);
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
        DBUtil.close();
        return houses;
    }
}
