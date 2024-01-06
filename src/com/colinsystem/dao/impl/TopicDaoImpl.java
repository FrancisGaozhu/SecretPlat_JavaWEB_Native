package com.colinsystem.dao.impl;

import com.colinsystem.dao.TopicDao;
import com.colinsystem.entity.Topic;
import com.colinsystem.util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 帖子数据层实现
 * @author FrancisGaozhu
 * 2023-11-21 18:26:31
 */
public class TopicDaoImpl implements TopicDao {

    private Topic resultSetToTopic(final ResultSet resultSet) throws SQLException {
        return new Topic(
                resultSet.getLong("t_id"),
                resultSet.getString("t_title"),
                resultSet.getString("t_content"),
                resultSet.getTimestamp("t_create_time").toLocalDateTime(),
                resultSet.getLong("t_account_id")
        );
    }

    @Override
    public List<Topic> selectAll() throws SQLException {
        try (Connection connection = DruidUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT t_id, t_title, t_content, t_create_time, t_account_id FROM t_topic ORDER BY t_create_time DESC");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            List<Topic> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(this.resultSetToTopic(resultSet));
            }
            return list;
        }
    }

    @Override
    public int deleteByAccountId(long accountId) throws SQLException {
        return DruidUtil.doUpdate("DELETE FROM t_topic WHERE t_account_id=?", accountId);
    }

    @Override
    public int deleteById(long topicId) throws SQLException {
        return DruidUtil.doUpdate("DELETE FROM t_topic WHERE t_id = ?", topicId);
    }

    @Override
    public Topic selectById(long topicId) {
        try (Connection connection = DruidUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT t_id, t_title, t_content, t_create_time, t_account_id FROM t_topic WHERE t_id = ?");) {
            preparedStatement.setLong(1, topicId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next())
                    return null;
                return this.resultSetToTopic(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(Topic newTopic) throws SQLException {
        return DruidUtil.doUpdate(
                "INSERT INTO t_topic(T_TITLE, T_CONTENT, T_CREATE_TIME, T_ACCOUNT_ID) VALUES(?, ?, ?, ?)",
                newTopic.getTitle(),
                newTopic.getContent(),
                newTopic.getCreateTime(),
                newTopic.getAccountId()
                );
    }
}
