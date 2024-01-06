package com.colinsystem.entity;

import java.time.LocalDateTime;

/**
 * 留言信息数据实体
 *
 * @author FrancisGaozhu
 * 2023-11-24 13:45:22
 */
public class Message {

    public Message() {
    }

    /**
     * 初始化
     *
     * @param id         消息ID
     * @param content    消息内容
     * @param createTime 留言时间
     * @param topicId    关联帖子ID
     * @param accountId  关联账户ID
     */
    public Message(long id, String content, LocalDateTime createTime, long topicId, long accountId) {
        this.id = id;
        this.content = content;
        this.createTime = createTime;
        this.topicId = topicId;
        this.accountId = accountId;
    }

    /**
     * 初始化
     *
     * @param id         消息ID
     * @param content    消息内容
     * @param createTime 留言时间
     * @param topicId    关联帖子ID
     * @param topic      帖子数据实体
     * @param accountId  关联账户ID
     * @param account    关联账户数据实体
     */
    public Message(long id, String content, LocalDateTime createTime, long topicId, Topic topic, long accountId, Account account) {
        this.id = id;
        this.content = content;
        this.createTime = createTime;
        this.topicId = topicId;
        this.topic = topic;
        this.accountId = accountId;
        this.account = account;
    }

    /**
     * ID
     */
    private long id;
    /**
     * 留言内容
     */
    private String content;
    /**
     * 留言时间
     */
    private LocalDateTime createTime;
    /**
     * 关联帖子编号
     */
    private long topicId;
    /**
     * 关联帖子数据实体
     */
    private Topic topic;
    /**
     * 发帖账户ID
     */
    private long accountId;
    /**
     * 发帖账户
     */
    private Account account;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
