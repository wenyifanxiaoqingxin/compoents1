package com.compoent.entity;

import javax.persistence.*;

@Table(name = "component_user")
public class ComponentUser {
    /**
     * id
     */
    @Id
    private String id;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户状态
     */
    @Column(name = "user_status")
    private String userStatus;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户角色
     */
    @Column(name = "user_role")
    private String userRole;

    private String extr1;

    /**
     * 获取id
     *
     * @return id - id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户状态
     *
     * @return user_status - 用户状态
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * 设置用户状态
     *
     * @param userStatus 用户状态
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户角色
     *
     * @return user_role - 用户角色
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * 设置用户角色
     *
     * @param userRole 用户角色
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * @return extr1
     */
    public String getExtr1() {
        return extr1;
    }

    /**
     * @param extr1
     */
    public void setExtr1(String extr1) {
        this.extr1 = extr1;
    }
}