package com.example.repository.impl;

import com.example.repository.ShowColumnRepository;
import com.example.util.SpliceFiledUtil;
import com.example.vo.CommonVo;
import com.google.common.base.Strings;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: tanghh18
 * @Date: 2020/5/29 16:06
 */
@Repository
public class ShowColumnRepositoryImpl extends BaseRepository implements ShowColumnRepository {

    /**
     * 查询搜索项目页面数据
     * @param vo
     * @return
     */
    @Override
    public List listShowColumnData(CommonVo vo) {
        StringBuffer stringBuffer = new StringBuffer();
        Map map = new HashMap();
        stringBuffer.append("select * from project a where a.is_del='0' ");
        //查询页面字段(查询为id 为1 的用户字段)
        String page = vo.getPage();
        int uid = 2;
        List projectColumnList = listMyColumnField(page,uid);
        //根据搜索框拼接查询条件
        if(!Strings.isNullOrEmpty(vo.getInput())){
          String inputCondition = SpliceFiledUtil.spliceInputCondition(projectColumnList);
          stringBuffer.append(" "+inputCondition);
          map.put("input","%"+vo.getInput()+"%");
        }
        //替换需要查询的字段
        String sql = stringBuffer.toString();
        String fieldCondition = SpliceFiledUtil.spliceFiledCondition(projectColumnList);
        sql = sql.replace("*",fieldCondition);
        System.out.println("执行的sql 为---："+sql);
        return this.getList(sql,map);
    }

    /**
     * 查询页面字段
     * @return
     */
    @Override
    public List listMyColumnField(String page,int uid) {
        Map map = new HashMap();
//        String sql = "select * from show_column where is_del = 0 and page=:page";
        String sql = "SELECT a.page,a.field_name,a.database_name,a.entity_name,a.field_order,b.field_open,b.user_id from show_column a LEFT JOIN user_column b \n" +
                "ON a.id = b.column_id  WHERE a.is_del = '0' AND b.is_del = '0'  AND  a.page = :page and b.user_id=:user_id  AND b.field_open = '0'";
        map.put("page",page);
        map.put("user_id",uid);
        return this.getList(sql,map);
    }
}
