package com.colinsystem.entity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 帖子
 * @author FrancisGaozhu
 * 2023-11-21 16:43:49
 */
public class Topic {

    public Topic() {
    }

    /**
     * 全字段初始化
     * @param id ID
     * @param title 标题
     * @param content 内容
     * @param createTime 创建时间
     * @param accountId 发帖账户ID
     */
    public Topic(long id, String title, String content, LocalDateTime createTime, Long accountId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.accountId = accountId;
    }

    /**
     * ID
     */
    private long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 发帖账户ID
     */
    private Long accountId;
    /**
     * 发帖账户
     */
    private Account account;
    /**
     * 关联留言消息
     */
    List<Message> messages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
