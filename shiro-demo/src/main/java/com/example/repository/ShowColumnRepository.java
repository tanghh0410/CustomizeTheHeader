package com.example.repository;

import com.example.vo.CommonVo;

import java.util.List;

/**
 * @Author tanghh
 * @Date 2020/5/28 11:30
 */
public interface ShowColumnRepository {

    /**
     * 查询搜索项目页面数据
     * @param vo
     * @return
     */
    List listShowColumnData(CommonVo vo);


    /**
     * 查询用户自定义的字段
     * @param page
     * @param uid
     * @return
     */
    List listMyColumnField(String page,int uid);
}
