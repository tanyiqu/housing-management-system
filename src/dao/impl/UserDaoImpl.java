package dao.impl;

import bean.User;
import dao.UserDao;
import util.DBUtil;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

public class UserDaoImpl implements UserDao {

    @Override
    public User find(String userName, String type) {
        User user = new User();
        //调用存储过程
        String sql = null;
        if(type.equals("0")){//买
            sql = "{call sp_gmr_find_by_zh(?,?,?,?,?,?)}";
        }else {//卖
            sql = "{call sp_csr_find_by_zh(?,?,?,?,?,?)}";
        }
        CallableStatement cs = DBUtil.executeCall(sql);
        try {
            cs.setString(1,userName);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.registerOutParameter(5, Types.CHAR);
            cs.registerOutParameter(6, Types.VARCHAR);
            cs.execute();
            user.setUserName(cs.getString(2));
            user.setPasswd(cs.getString(3));
            user.setTrueName(cs.getString(4));
            user.setTel(cs.getString(5));
            user.setEmail(cs.getString(6));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return user;
    }

    @Override
    public User find(String userName, String passwd, String type) {
        User user = new User();
        //调用存储过程
        String sql = null;
        if(type.equals("0")){//买
            sql = "{call sp_gmr_find_by_zhmm(?,?,?,?,?,?,?)}";
        }else {//卖
            sql = "{call sp_csr_find_by_zhmm(?,?,?,?,?,?,?)}";
        }
        CallableStatement cs = DBUtil.executeCall(sql);
        try {
            cs.setString(1,userName);
            cs.setString(2,passwd);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.registerOutParameter(6, Types.CHAR);
            cs.registerOutParameter(7, Types.VARCHAR);
            cs.execute();
            user.setUserName(cs.getString(3));
            user.setPasswd(cs.getString(4));
            user.setTrueName(cs.getString(5));
            user.setTel(cs.getString(6));
            user.setEmail(cs.getString(7));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return user;
    }

    @Override
    public boolean insert(String type, String userName, String passwd, String trueName, String tel, String email) {
        String sql;
        boolean success = false;
        if(type.equals("0")){
            sql = "{call sp_gmr_add(?,?,?,?,?)}";
        }else {
            sql = "{call sp_csr_add(?,?,?,?,?)}";
        }
        CallableStatement cs = DBUtil.executeCall(sql);
        try {
            cs.setString(1,userName);
            cs.setString(2,passwd);
            cs.setString(3,trueName);
            cs.setString(4,tel);
            cs.setString(5,email);
            success = cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return success;
    }
}
