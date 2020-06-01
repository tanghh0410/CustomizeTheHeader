package com.example.shiro.config;

import com.example.model.BosUserModel;
import com.example.service.BosUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Author: tanghh18
 * @Date: 2020/4/6 11:34
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    BosUserService bosUserService;

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 认证
     *
     * @param arg0
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        //将父类的AuthenticationToken强转为UsernamePasswordToken(因为需要调用UsernamePasswordToken的方法)
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) arg0;
        //获取用户名
        String uname = usernamePasswordToken.getUsername();
        //模拟通过数据库查询到用户名的密码
        BosUserModel user = bosUserService.findUserModelByName(uname);
        //认证信息(参数填写的是用户输入的用户名和数据库查询的密码)
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(uname, user.getPassword(), getName());
        return info;
    }
}
