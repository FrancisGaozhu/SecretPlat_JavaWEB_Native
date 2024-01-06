package com.colinsystem.biz.impl;

import com.colinsystem.biz.AccountBiz;
import com.colinsystem.entity.Account;
import com.colinsystem.util.Daos;

import java.sql.SQLException;

/**
 * 用户业务逻辑实现
 * @author FrancisGaozhu
 * 2023-11-22 16:08:42
 */
public class AccountBizImpl implements AccountBiz, Daos {
    @Override
    public Account login(String name, String password) {
        try {
            Account account = ACCOUNT_DAO.selectByNamePassword(name, password);
            return account;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean changeDefaultAnonymous(Account account) {
        try {
            account.setAnonymous(!account.getAnonymous());
            return ACCOUNT_DAO.updateById(account.getId(), account) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteAccountById(long id) {
        try {
            MESSAGE_DAO.deleteByAccountId(id);
            TOPIC_DAO.deleteByAccountId(id);
            return ACCOUNT_DAO.deleteByAccountId(id) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean register(Account account) {
        try {
            return ACCOUNT_DAO.insertAccount(account) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
