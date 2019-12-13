package dao.impl;

import bean.Income;
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
