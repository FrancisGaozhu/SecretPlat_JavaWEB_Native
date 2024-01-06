package com.colinsystem.dao.impl;

import com.colinsystem.dao.AccountDao;
import com.colinsystem.entity.Account;
import com.colinsystem.util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 账户信息数据层实现
 *
 * @author FrancisGaozhu
 * 2023-11-21 16:11:25
 */
public class AccountDaoImpl implements AccountDao {

    /**
     * ResultSet数据解析
     *
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private Account resultSetToAccount(final ResultSet resultSet) throws SQLException {
        return new Account(
                resultSet.getLong("a_id"),
                resultSet.getString("a_name"),
                resultSet.getString("a_password"),
                resultSet.getBoolean("a_anonymous")
        );
    }

    @Override
    public Account selectById(long id) {
        String sql = "SELECT a_id, a_name, a_password, a_anonymous FROM t_account WHERE a_id = ?";
        try (Connection connection = DruidUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setObject(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next())
                    return null;
                return resultSetToAccount(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insertAccount(Account account) throws SQLException {
        String sql = "INSERT INTO t_account(a_name, a_password, a_anonymous) VALUES(?, ?, ?)";
        return DruidUtil.doUpdate(sql, account.getName(), account.getPassword(), account.getAnonymous());
    }

    @Override
    public Account selectByNamePassword(String name, String password) throws SQLException {
        String sql = "SELECT a_id, a_name, a_password, a_anonymous FROM t_account WHERE a_name=? AND a_password = ?";
        try (Connection connection = DruidUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next())
                    return null;
                return resultSetToAccount(resultSet);
            }
        }
    }

    @Override
    public int deleteByAccountId(long id) throws SQLException {
        return DruidUtil.doUpdate("DELETE FROM t_account WHERE a_id = ?", id);
    }

    @Override
    public int updateById(long id, Account newInfo) throws SQLException {
        return DruidUtil.doUpdate("UPDATE t_account SET a_name = ?, a_password = ?, a_anonymous = ? WHERE a_id = ?",
                newInfo.getName(),
                newInfo.getPassword(),
                newInfo.getAnonymous(),
                newInfo.getId()
                );
    }


}
