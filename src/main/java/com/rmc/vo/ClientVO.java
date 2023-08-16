package com.rmc.vo;

public class ClientVO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户状态 “未完成” “已完成”
     */
    private String userStatus;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
