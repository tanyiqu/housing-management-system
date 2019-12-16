package dao;

import bean.Income;
import bean.Sale;

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
     * 查找出售统计
     * @return list
     */
    public List<Sale> findSaleInfo();

    /**
     * 查找收入统计
     * @return Income
     */
    public Income findIncomeStatistics();

}
