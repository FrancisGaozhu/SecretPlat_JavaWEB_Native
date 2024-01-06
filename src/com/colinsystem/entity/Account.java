package com.colinsystem.entity;

/**
 * 账户信息
 *
 * @author FrancisGaozhu
 * 2023-11-21 16:08:28
 */
public class Account {

    public Account() {
    }

    /**
     * 初始化
     *
     * @param id        账户ID
     * @param name      账户名
     * @param password  密码
     * @param anonymous 是否默认匿名发帖（和留言信息）
     */
    public Account(Long id, String name, String password, Boolean anonymous) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.anonymous = anonymous;
    }

    /**
     * 账户ID
     */
    private Long id;
    /**
     * 账户名称
     */
    private String name;
    /**
     * 账户密码
     */
    private String password;
    /**
     * 默认匿名
     */
    private Boolean anonymous;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }
}
