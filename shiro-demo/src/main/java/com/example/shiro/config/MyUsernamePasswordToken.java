package com.example.shiro.config;

import org.apache.shiro.authc.UsernamePasswordToken;


/**
 * @Author: tanghh18
 * @Date: 2020/4/6 14:00
 */
public class MyUsernamePasswordToken extends UsernamePasswordToken {
    /**
     * 免密登录/账号密码登录
     */
    private String loginType;

    public MyUsernamePasswordToken() {
        super();
    }
    /**
     * 账号密码登录
     * @param username
     * @param password
     * @param loginType
     * @param rememberMe
     * @param host
     */
    public MyUsernamePasswordToken(String username, String password, String loginType, boolean rememberMe,  String host) {
        super(username, password, rememberMe, host);
        this.loginType = loginType;
    }

    /**
     * 免密登录
     * @param username
     */
    public MyUsernamePasswordToken(String username) {
        super(username, "", false, null);
        this.loginType = "nopassword";
    }

    public MyUsernamePasswordToken(String username, String password) {
        super(username, password, false, null);
        this.loginType ="password";
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}