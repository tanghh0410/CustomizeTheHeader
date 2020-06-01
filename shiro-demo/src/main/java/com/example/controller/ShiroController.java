package com.example.controller;


import com.example.model.BosUserModel;
import com.example.service.BosUserService;
import com.example.shiro.config.MyUsernamePasswordToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wwc
 * @Date: 2019/3/6 14:26
 * @Version 1.0
 */
@RestController
public class ShiroController {

    @Autowired
    private BosUserService bosUserService;


    @GetMapping(value = "/test")
    public void test(){
        System.out.println("这是测试接口-----");
    }


    /**
     * 登录方法
     *
     * @return
     */
    @GetMapping(value = "/vueLogin")
    public void login(HttpSession session) throws Exception {

        //shiro登录，普通的用户名和密码登录
        Subject subject = SecurityUtils.getSubject();
        BosUserModel user = new BosUserModel();
        user.setId(1);
        user.setUserName("soup_tang");
        user.setPassword("1");
//        user.setPassword("c4ca4238a0b923820dcc509a6f75849b");
        UsernamePasswordToken token = new MyUsernamePasswordToken(user.getUserName(), user.getPassword());
        subject.login(token);
        //用户数据保存到session里
        BosUserModel bosUserModel = bosUserService.findUserModelByName(user.getUserName());
        if(bosUserModel!=null){
            System.out.println("登录成功");
            session.setAttribute("user", bosUserModel);
        }else{
            System.out.println("登录失败");
        }
    }


    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     *
     * @return
     */
    @RequestMapping(value = "/unauth")
    @ResponseBody
    public Object unauth() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "未登录");
        return map;
    }
}
