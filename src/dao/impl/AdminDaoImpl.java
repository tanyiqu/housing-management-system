package dao.impl;

import bean.Income;
import bean.Sale;
import dao.AdminDao;
import util.DBUtil;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    @Override
    public boolean checkAdmin(String userName, String passwd) {
        String sql = "{? = call fn_gly_correct(?,?)}";
        int exist = 0;
        CallableStatement cs = DBUtil.executeCall(sql);
        try {
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2,userName);
            cs.setString(3,passwd);
            cs.execute();
            exist = cs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist == 1;
    }

    @Override
    public List<Sale> findSaleInfo() {
        List<Sale> sales = new ArrayList<>();
        String sql = "select * from vi_csxx";
        ResultSet rs = DBUtil.executeQuery(sql);
        while (true){
            try {
                if (!rs.next()) break;
                Sale sale = new Sale();
                sale.setBuyer_username(rs.getString("gmr_zh"));
                sale.setBuyer_truename(rs.getString("gmr_xm"));
                sale.setHouseId(rs.getString("fy_fh"));
                sale.setHousename(rs.getString("fy_fm"));
                sale.setPrice(rs.getInt("fy_sj"));
                sale.setDate(rs.getString("gf_rq"));
                sales.add(sale);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sales;
    }

    @Override
    public Income findIncomeStatistics() {
        Income income = new Income();
        String sql = "select * from vi_srtj";
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            rs.next();
            income.setTotal(rs.getInt("zjs"));
            income.setNums(rs.getInt("srbs"));
            income.setAvg(rs.getInt("dbjj"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return income;
    }
}
