package service;

import bean.Income;

import java.util.List;

public interface AdminService {

    /**
     * 判断管理员账号和密码是否正确
     * @param userName 账号
     * @param passwd 密码
     * @return 是否正确
     */
    public boolean adminCorrect(String userName,String passwd);


    /**
     * 获取收入统计
     * @return list
     */
    public Income getIncomeStatistics();

}
