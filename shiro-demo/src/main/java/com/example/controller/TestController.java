package com.example.controller;

import com.example.service.ShowColumnService;
import com.example.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author tanghh
 * @Date 2020/5/28 11:07
 */
@RestController
@RequestMapping(value = "/field")
public class TestController {

    @Autowired
    private ShowColumnService showColumnService;

    @PostMapping(value = "/listShowColumnInfo")
    public List listShowColumnInfo(@RequestBody CommonVo vo){
        return showColumnService.listShowColumnField(vo);
    }
}
