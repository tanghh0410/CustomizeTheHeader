package com.example.service.impl;

import com.example.repository.ShowColumnRepository;
import com.example.repository.jpa.ShowColumnJPARepository;
import com.example.service.ShowColumnService;
import com.example.vo.CommonVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author tanghh
 * @Date 2020/5/28 11:28
 */
@Service
public class ShowColumnServiceImpl implements ShowColumnService {
    private Logger logger = LoggerFactory.getLogger(ShowColumnServiceImpl.class);
    @Autowired
    private ShowColumnRepository showColumnRepository;

    @Override
    public List listShowColumnField(CommonVo vo) {
        try{
            //查询项目数据
            List projectList = showColumnRepository.listShowColumnData(vo);
            return projectList;
        }catch (Exception e){
            logger.error("查询失败",e);
            return null;
        }
    }


}
