package service.impl;

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public int checkParam(String type,String userName, String passwd, String repasswd, String email, String vc_input, String vc_send) {
//        System.out.println("检测");
//        System.out.println(type + " " + userName + " "+ passwd);
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
        UserDao userDao = new UserDaoImpl();
        String type = "1";
        if(isBuyer){
            type = "0";
        }
        User user = userDao.find(userName,type);
        return user.getUserName() != null;
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
        UserDao userDao = new UserDaoImpl();
        String type = "1";
        if(isBuyer){
            type = "0";
        }
        User user = userDao.find(userName,passwd,type);
        return user.getUserName() != null;
    }

    /**
     * 根据用户名和类型返回用户
     * @param userName 用户名（账号）
     * @param type 用户名类型
     * @return User
     */
    @Override
    public User find(String userName,String type) {
        UserDao userDao = new UserDaoImpl();
        return userDao.find(userName,type);
    }


}
