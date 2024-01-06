package com.colinsystem.dao;

import com.colinsystem.entity.Account;

import java.sql.SQLException;

/**
 * 账户信息数据层
 * @author FrancisGaozhu
 * 2023-11-21 16:11:17
 */
public interface AccountDao {

    /**
     * 添加新账户
     *
     * @param account 需要添加的账户信息
     * @return 数据库受影响数据行数
     */
    int insertAccount(final Account account) throws SQLException;

    /**
     * 根据ID获取特定账户信息
     * @param id 账户Id
     * @return 账户结果模型，如果获取失败，则返回null。
     */
    Account selectById(final long id);

    /**
     * 根据用户名和密码查询获取账户信息
     *
     * @param name 账户名
     * @param password 密码
     * @return 得到的对应账户信息，如果得不到返回null。
     */
    Account selectByNamePassword(final String name, final String password) throws SQLException;

    /**
     * 根据ID删除特定账户信息
     *
     * @param id 被删除账户的所属ID
     * @return 数据库受影响数据行数
     */
    int deleteByAccountId(final long id) throws SQLException;

    /**
     * 根据ID修改特定的账户信息
     *
     * @param id      需要修改的账户对应ID
     * @param newInfo 新的信息对象
     * @return 数据库受影响数据行数
     */
    int updateById(final long id, final Account newInfo) throws SQLException;
}
