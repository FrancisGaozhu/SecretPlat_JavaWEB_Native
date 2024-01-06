package com.colinsystem.dao;

import com.colinsystem.entity.Message;

import java.sql.SQLException;
import java.util.List;

/**
 * 留言数据访问层
 * @author FrancisGaozhu
 * 2023-11-23 17:17:30
 */
public interface MessageDao {

    /**
     * 添加新的消息
     * @param message 消息数据模型
     * @return 数据库受影响数据行数
     */
    int insertMessage(Message message) throws SQLException;

    /**
     * 根据ID删除对应的消息
     * @param messageId 消息ID
     * @return 数据库受影响数据行数
     */
    int deleteById(long messageId) throws SQLException;

    /**
     * 根据账户变好删除对应账号的所有留言
     * @param accountId 账号ID
     * @return 删除条目数
     */
    int deleteByAccountId(long accountId) throws SQLException;

    /**
     * 根据帖子Id删除对应留言消息
     * @param topicId 帖子ID
     * @return 删除条目数
     */
    int deleteByTopicId(long topicId) throws SQLException;

    /**
     * 根据帖子编号加载对应所有留言信息
     * @param topicId 帖子编号
     * @return 留言信息
     */
    List<Message> selectByTopicId(long topicId);
}
