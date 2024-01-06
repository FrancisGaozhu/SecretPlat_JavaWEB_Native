package com.colinsystem.biz;

import com.colinsystem.entity.Account;

/**
 * 账户业务逻辑层
 * @author FrancisGaozhu
 * 2023-11-22 16:05:42
 */
public interface AccountBiz {

    /**
     * 执行登录
     * @param name 用户名
     * @param password 密码
     * @return 查找到的用户信息
     */
    Account login(String name, String password);

    /**
     * 更改用户匿名状态
     * @param account 被更改的用户对象
     * @return 修改结果
     */
    boolean changeDefaultAnonymous(Account account);

    /**
     * 根据账户ID删除所属账户
     * @param id 账户ID
     * @return 删除成功返回true，否则返回false。
     */
    boolean deleteAccountById(long id);

    /**
     * 注册新用户
     * @param account 需要注册的新用户信息
     * @return 注册成功则为true，否则false。
     */
    boolean register(Account account);
}
