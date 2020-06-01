package com.example.service;

import com.example.vo.CommonVo;

import java.util.List;

/**
 * @Author tanghh
 * @Date 2020/5/28 11:25
 */
public interface ShowColumnService {
    /**
     * 查询搜索自定义字段
     * @param vo
     * @return
     */
    List listShowColumnField(CommonVo vo);



}
