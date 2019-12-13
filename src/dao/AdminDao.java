package dao;

import bean.Income;

import java.util.List;

public interface AdminDao {

    /**
     * 验证管理员密码
     * @param userName 账号
     * @param passwd 密码
     * @return 是否正确
     */
    public boolean checkAdmin(String userName, String passwd);

    /**
     * 查找收入统计
     * @return list
     */
    public Income findIncomeStatistics();

}
