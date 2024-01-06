package com.colinsystem.biz.impl;

import com.colinsystem.biz.TopicBiz;
import com.colinsystem.entity.Message;
import com.colinsystem.entity.Topic;
import com.colinsystem.util.Daos;

import java.sql.SQLException;
import java.util.List;

/**
 * 帖子业务逻辑实现
 *
 * @author FrancisGaozhu
 * 2023-11-21 18:39:06
 */
public class TopicBizImpl implements TopicBiz, Daos {
    @Override
    public List<Topic> getAll(boolean loadAccount, boolean loadMessages) {
        try {
            List<Topic> list = TOPIC_DAO.selectAll();
            if (loadAccount) {
                for (Topic topic : list) {
                    topic.setAccount(ACCOUNT_DAO.selectById(topic.getAccountId()));
                }
            }
            if (loadMessages) {
                for (Topic topic : list) {
                    topic.setMessages(MESSAGE_DAO.selectByTopicId(topic.getId()));
                }
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Topic getById(long topicId, boolean loadAccount, boolean loadMessages, boolean loadMessagesAccount) {
        Topic topic = TOPIC_DAO.selectById(topicId);
        if (topic != null) {
            if (loadAccount) {
                topic.setAccount(ACCOUNT_DAO.selectById(topic.getAccountId()));
            }
            if (loadMessages) {
                topic.setMessages(MESSAGE_DAO.selectByTopicId(topic.getId()));
                if (loadMessagesAccount) {
                    for (Message msg : topic.getMessages()) {
                        msg.setAccount(ACCOUNT_DAO.selectById(msg.getAccountId()));
                    }
                }
            }
        }
        return topic;
    }

    @Override
    public boolean addNew(Topic newTopic) {
        try {
            return TOPIC_DAO.insert(newTopic) == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteTopicById(long topicId) {
        try {
            MESSAGE_DAO.deleteByTopicId(topicId);
            return TOPIC_DAO.deleteById(topicId) == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
