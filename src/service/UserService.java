package service;

import bean.User;

public interface UserService {

    public static final int OK = 0x01;                      //正常
    public static final int USER_ALREADY_EXISTS = 0x02;     //用户已存在
    public static final int VC_ERROR = 0x03;                //验证码不正确

    /**
     * 检测用户是否能够被创建
     * @param type 用户类型
     * @param userName 用户名
     * @param passwd 密码
     * @param repasswd 重复密码
     * @param email 邮箱
     * @param vc_input 用户输入的验证码
     * @param vc_send 服务器发送的验证码
     * @return code
     */
    public int checkParam(String type,String userName,String passwd,String repasswd,String email,String vc_input,String vc_send);

    /**
     * 添加用户
     * @param type 类型
     * @param userName 用户名/账号
     * @param passwd 密码
     * @param trueName 真实姓名
     * @param tel 手机号
     * @param email 邮箱
     * @return 是否成功
     */
    public boolean addUser(String type,String userName,String passwd,String trueName,String tel,String email);

    /**
     * 用户是否存在
     * @param userName 用户名
     * @param isBuyer 是否为买家
     * @return true=已存在
     */
    public boolean isExist(String userName,boolean isBuyer);

    /**
     * 判断用户是否存在
     * @param userName 用户名
     * @param passwd 密码
     * @param isBuyer 是否为买家
     * @return 返回是否存在
     */
    public boolean isExist(String userName,String passwd,boolean isBuyer);

    /**
     * 根据用户名和类型返回用户
     * @param userName 用户名（账号）
     * @param type 用户名类型
     * @return 用户（bean）
     */
    public User find(String userName,String type);

}
