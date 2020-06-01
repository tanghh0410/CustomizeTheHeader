package com.example.service.impl;

import com.example.model.BosUserModel;
import com.example.service.BosUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author tanghh
 * @Date 2020/4/6 10:49
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BosUserServiceImpl implements BosUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 根据名字查询用户数据
     * @param name
     * @return
     */
    @Override
    public BosUserModel findUserModelByName(String name) {
        String sql = "select * from bos_user where user_name=?";
        Map map = new HashMap<>();
        map.put("name",name);
        BosUserModel userModel = this.jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<BosUserModel>(BosUserModel.class),name);
        return userModel;
    }
}
