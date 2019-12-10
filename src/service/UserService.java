package service;

public interface UserService {

    public static final int OK = 0x01;                      //正常
    public static final int USER_ALREADY_EXISTS = 0x02;     //用户已存在
    public static final int VC_ERROR = 0x03;                //验证码不正确

    /**
     * 检测用户是否能够被创建
     * @param userName 用户名
     * @param passwd 密码
     * @param repasswd 重复密码
     * @param email 邮箱
     * @param vc_input 用户输入的验证码
     * @param vc_send 服务器发送的验证码
     * @return code
     */
    public int checkParam(String userName,String passwd,String repasswd,String email,String vc_input,String vc_send);



}
