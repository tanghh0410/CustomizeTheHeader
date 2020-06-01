package com.example.shiro.config;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author: tanghh18
 * @Date: 2020/4/6 11:29
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected AuthenticationToken createToken(String username, String password, ServletRequest request, ServletResponse response) {
        boolean rememberMe = isRememberMe(request);
        String host = getHost(request);
        String loginType = "password";
        if(request.getParameter("loginType")!=null && !"".equals(request.getParameter("loginType").trim())){
            loginType = request.getParameter("loginType");
        }
        return new MyUsernamePasswordToken(username, password,loginType,rememberMe,host);
    }
}
