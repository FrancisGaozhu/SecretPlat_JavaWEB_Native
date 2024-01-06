package com.colinsystem.dao;

import com.colinsystem.entity.Topic;

import java.sql.SQLException;
import java.util.List;

/**
 * 帖子数据层
 * @author FrancisGaozhu
 * 2023-11-21 18:24:42
 */
public interface TopicDao {

    /**
     * 获取所有帖子
     * @return 帖子结果集合
     */
    List<Topic> selectAll() throws SQLException;

    /**
     * 删除对应用户的所有帖子
     * @param accountId 账户ID
     * @return 数据库受影响数据行数
     * @throws SQLException
     */
    int deleteByAccountId(long accountId) throws SQLException;

    /**
     * 删除对应Id的帖子
     * @param topicId 帖子ID
     * @return 数据库受影响数据行数
     */
    int deleteById(long topicId) throws SQLException;

    /**
     * 根据ID找到对应的帖子信息
     * @param topicId 帖子Id
     * @return 帖子数据实体
     */
    Topic selectById(long topicId);

    /**
     * 添加新的帖子数据
     * @param newTopic 数据模型
     * @return 数据库受影响数据行数
     */
    int insert(Topic newTopic) throws SQLException;
}
