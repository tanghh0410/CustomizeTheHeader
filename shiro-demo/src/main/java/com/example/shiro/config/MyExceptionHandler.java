package com.example.shiro.config;


import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: tanghh18
 * @Date: 2020/4/6 11:28
 */
public class MyExceptionHandler implements HandlerExceptionResolver {
    private static Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        ModelAndView mv = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        Map map = new HashMap();
        if (ex instanceof UnauthenticatedException|| ex instanceof IncorrectCredentialsException || ex instanceof AuthenticationException) {
            map.put("msg", "用户名或密码错误");
        } else if (ex instanceof UnauthorizedException) {
            map.put("msg", "无权限");
        } else {
            map.put("msg", ex.getMessage());
            logger.info(ex.getMessage());
            ex.printStackTrace();
        }
        view.setAttributesMap(map);
        mv.setView(view);
        return mv;
    }
}
