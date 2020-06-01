package com.example.shiro.config;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;


/**
 * @Author: tanghh18
 * @Date: 2020/4/6 11:30
 */
public class MyHashedCredentialsMatcher extends HashedCredentialsMatcher {
    @Override public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
       MyUsernamePasswordToken mupt = (MyUsernamePasswordToken)token;
        if ("nopassword".equals(mupt.getLoginType())) {
            return true;
        }else {
            return super.doCredentialsMatch(token, info);
        }
    }
}

