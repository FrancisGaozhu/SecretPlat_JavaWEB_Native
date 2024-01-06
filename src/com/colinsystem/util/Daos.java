package com.colinsystem.util;

import com.colinsystem.dao.AccountDao;
import com.colinsystem.dao.MessageDao;
import com.colinsystem.dao.TopicDao;
import com.colinsystem.dao.impl.AccountDaoImpl;
import com.colinsystem.dao.impl.MessageDaoImpl;
import com.colinsystem.dao.impl.TopicDaoImpl;

/**
 * 所有数据访问层对象
 * 通过实现此接口可以直接继承对象以此来达到对象共享的目的
 * @author FrancisGaozhu
 * 2023-11-21 15:36:42
 */
public interface Daos {
    /**
     * 账户
     */
    AccountDao ACCOUNT_DAO = new AccountDaoImpl();
    /**
     * 帖子
     */
    TopicDao TOPIC_DAO = new TopicDaoImpl();
    /**
     * 留言
     */
    MessageDao MESSAGE_DAO = new MessageDaoImpl();
}
