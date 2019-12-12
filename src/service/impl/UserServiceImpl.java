package service.impl;

import bean.User;
import service.UserService;
import util.DBUtil;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

public class UserServiceImpl implements UserService {

    @Override
    public int checkParam(String type,String userName, String passwd, String repasswd, String email, String vc_input, String vc_send) {
        System.out.println("检测");
        System.out.println(type + " " + userName + " "+ passwd);

        //判断验证码是否一致
        if(!vc_input.equals(vc_send)){
            return UserService.VC_ERROR;
        }
        //判断用户名是否已存在（数据库）
        boolean flag = false;
        if(type.equals("0")){//买
            flag = true;
        }
        flag = isExist(userName,flag);
        if(flag){
            return UserService.USER_ALREADY_EXISTS;
        }
        return UserService.OK;
    }

    @Override
    public boolean addUser(String type, String userName, String passwd, String trueName, String tel, String email) {
        return false;
    }

    /**
     * 用户是否存在
     * @param userName 用户名
     * @param isBuyer 是否为买家
     * @return true=已存在
     */
    @Override
    public boolean isExist(String userName, boolean isBuyer){
        String sql;
        int exist = 0;
        if(isBuyer){
            sql = "{? = call fn_buyerExist(?)}";
        }else {
            sql = "{? = call fn_sellerExist(?)}";
        }
        CallableStatement cs = DBUtil.executeCall(sql);
        try {
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setString(2,userName);
            cs.execute();
            exist = cs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return exist==1;

    }

    /**
     * 用户和密码是否正确
     * @param userName 用户名
     * @param passwd 密码
     * @param isBuyer 是否为买家
     * @return true=正确
     */
    @Override
    public boolean isExist(String userName, String passwd, boolean isBuyer) {
        String sql;
        int exist = 0;
        if(isBuyer){
            sql = "{? = call fn_buyerCorrect(?,?)}";
        }else {
            sql = "{? = call fn_sellerCorrect(?,?)}";
        }
        CallableStatement cs = DBUtil.executeCall(sql);
        try {
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setString(2,userName);
            cs.setString(3,passwd);
            cs.execute();
            exist = cs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return exist==1;
    }

    /**
     * 根据用户名和类型返回用户
     * @param userName 用户名（账号）
     * @param type 用户名类型
     * @return User
     */
    @Override
    public User find(String userName,String type) {
        User user = new User();
        //调用存储过程
        String sql = null;
        if(type.equals("0")){//买
            sql = "{call sp_gmr_find(?,?,?,?,?,?)}";
        }else {//卖
            sql = "{call sp_csr_find(?,?,?,?,?,?)}";
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


}
