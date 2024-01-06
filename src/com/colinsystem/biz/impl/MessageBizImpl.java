package com.colinsystem.biz.impl;

import com.colinsystem.biz.MessageBiz;
import com.colinsystem.entity.Message;
import com.colinsystem.util.Daos;

import java.sql.SQLException;

/**
 * 消息业务逻辑实现
 * @author FrancisGaozhu
 * 2023-11-24 20:27:45
 */
public class MessageBizImpl implements MessageBiz, Daos {
    @Override
    public boolean newPost(Message newMessage) {
        try {
            return MESSAGE_DAO.insertMessage(newMessage) == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteMessage(long messageId) {
        try {
            return MESSAGE_DAO.deleteById(messageId) == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
