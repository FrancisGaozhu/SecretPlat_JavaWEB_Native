package com.colinsystem.biz;

import com.colinsystem.entity.Message;

/**
 * 消息业务逻辑层
 * @author FrancisGaozhu
 * 2023-11-24 20:19:44
 */
public interface MessageBiz {

    /**
     * 发布新消息
     * @param newMessage 消息数据模型
     * @return 发布结果
     */
    boolean newPost(Message newMessage);

    /**
     * 根据消息ID删除对应的消息数据
     * @param messageId 被删除的消息ID
     * @return 操作结果
     */
    boolean deleteMessage(long messageId);

}
