package com.colinsystem.biz;

import com.colinsystem.entity.Topic;

import java.util.List;

/**
 * 帖子业务逻辑
 *
 * @author FrancisGaozhu
 * 2023-11-21 18:38:23
 */
public interface TopicBiz {

    /**
     * 获取所有的帖子数据
     *
     * @param loadAccount  加载账户信息
     * @param loadMessages 加载留言消息信息
     * @return 帖子数据集合
     */
    List<Topic> getAll(boolean loadAccount, boolean loadMessages);

    /**
     * 根据ID获取帖子数据
     *
     * @param topicId 帖子Id
     * @param loadAccount 加载账户信息
     * @param loadMessages 加载留言消息信息
     * @param loadMessagesAccount 加载留言消息中的账户信息
     * @return 帖子数据实体
     */
    Topic getById(long topicId, boolean loadAccount, boolean loadMessages, boolean loadMessagesAccount);

    /**
     * 添加新的帖子数据
     * @param newTopic 新帖子数据模型
     * @return 添加结果
     */
    boolean addNew(Topic newTopic);

    /**
     * 删除对应的帖子
     * 同时关联删除对应回复消息
     * @param topicId 被删除帖子的ID
     * @return 如果删除成功则为true，否则false
     */
    boolean deleteTopicById(long topicId);

}
