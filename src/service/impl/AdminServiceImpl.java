package service.impl;

import bean.Income;
import bean.Sale;
import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    AdminDao adminDao = new AdminDaoImpl();

    @Override
    public boolean adminCorrect(String userName, String passwd) {
        return adminDao.checkAdmin(userName,passwd);
    }

    @Override
    public List<Sale> getSaleInfo() {
        return adminDao.findSaleInfo();
    }

    @Override
    public Income getIncomeStatistics() {
        return adminDao.findIncomeStatistics();
    }
}
