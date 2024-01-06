package com.colinsystem.dao.impl;

import com.colinsystem.dao.MessageDao;
import com.colinsystem.entity.Message;
import com.colinsystem.util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 留言数据访问层实现
 * @author FrancisGaozhu
 * 2023-11-23 17:19:16
 */
public class MessageDaoImpl implements MessageDao {


    private Message resultSetToMessage(ResultSet resultSet) throws SQLException {
        return new Message(
                resultSet.getLong("m_id"),
                resultSet.getString("m_content"),
                resultSet.getTimestamp("m_create_time").toLocalDateTime(),
                resultSet.getLong("m_topic_id"),
                resultSet.getLong("m_account_id")
        );
    }


    @Override
    public int insertMessage(Message message) throws SQLException {
        return DruidUtil.doUpdate(
                "INSERT INTO t_message (m_content, m_create_time, m_topic_id, m_account_id) VALUES(?, ?, ?, ?)",
                message.getContent(),
                message.getCreateTime(),
                message.getTopicId(),
                message.getAccountId()
                );
    }

    @Override
    public int deleteByAccountId(long accountId) throws SQLException {
        return DruidUtil.doUpdate("DELETE FROM t_message WHERE m_account_id = ?", accountId);
    }

    @Override
    public List<Message> selectByTopicId(long topicId) {
        try (Connection connection = DruidUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT m_id, m_content, m_create_time, m_topic_id, m_account_id FROM t_message where m_topic_id = ? ORDER BY m_create_time")) {
            preparedStatement.setLong(1, topicId);
            List<Message> messages = new ArrayList<>();
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next())
                    messages.add(this.resultSetToMessage(resultSet));
            }
            return messages;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteByTopicId(long topicId) throws SQLException {
        return DruidUtil.doUpdate("DELETE FROM `t_message` WHERE `m_topic_id` = ?", topicId);
    }

    @Override
    public int deleteById(long messageId) throws SQLException {
        return DruidUtil.doUpdate("DELETE FROM t_message WHERE m_id = ?", messageId);
    }
}
