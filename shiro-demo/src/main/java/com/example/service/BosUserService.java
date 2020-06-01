package com.example.service;

import com.example.model.BosUserModel;

/**
 * @Author tanghh
 * @Date 2020/4/6 10:48
 */
public interface BosUserService {
    /**
     * 根据名字查询用户数据
     * @param name
     * @return
     */
    BosUserModel findUserModelByName(String name);
}
