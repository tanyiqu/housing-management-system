package dao;

import bean.Admin;
import bean.User;

public interface UserDao {

    /**
     * 根据用户名和类型查找用户
     * @param userName 用户名
     * @param type 类型
     * @return 用户
     */
    public User find(String userName,String type);

    /**
     * 根据用户名、密码和类型查找用户
     * @param userName 用户名
     * @param passwd 密码
     * @param type 类型
     * @return 用户
     */
    public User find(String userName,String passwd,String type);

    /**
     * 插入
     * @param type 类型
     * @param userName 用户名
     * @param passwd 密码
     * @param trueName 姓名
     * @param tel 电话
     * @param email 游戏
     * @return 是否成功
     */
    public boolean insert(String type, String userName, String passwd, String trueName, String tel, String email);

    /**
     * 验证管理员密码
     * @param userName 账号
     * @param passwd 密码
     * @return 是否正确
     */
    public boolean checkAdmin(String userName, String passwd);

}
