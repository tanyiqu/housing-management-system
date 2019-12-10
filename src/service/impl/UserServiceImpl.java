package service.impl;

import service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public int checkParam(String userName, String passwd, String repasswd, String email, String vc_input, String vc_send) {

        //判断验证码是否一致
        if(!vc_input.equals(vc_send)){
            return UserService.VC_ERROR;
        }
        //判断用户名是否已存在（数据库）

        return UserService.OK;
    }

    @Override
    public boolean addUser(String type, String userName, String passwd, String trueName, String tel, String email) {
        return false;
    }


}
