package com.colinsystem.util;

import com.colinsystem.biz.AccountBiz;
import com.colinsystem.biz.MessageBiz;
import com.colinsystem.biz.TopicBiz;
import com.colinsystem.biz.impl.AccountBizImpl;
import com.colinsystem.biz.impl.MessageBizImpl;
import com.colinsystem.biz.impl.TopicBizImpl;

/**
 * 所有的业务逻辑层接口
 * 通过实现此接口可以直接继承对象以此来达到对象共享的目的
 * @author FrancisGaozhu
 * 2023-11-21 15:36:52
 */
public interface Bizs {

    /**
     * 帖子业务逻辑
     */
    TopicBiz TOPIC_BIZ = new TopicBizImpl();

    /**
     * 账户业务逻辑
     */
    AccountBiz ACCOUNT_BIZ = new AccountBizImpl();

    /**
     * 消息业务逻辑
     */
    MessageBiz MESSAGE_BIZ = new MessageBizImpl();
}
