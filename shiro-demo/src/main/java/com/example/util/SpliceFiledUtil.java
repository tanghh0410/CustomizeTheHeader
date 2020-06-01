package com.example.util;

import java.util.List;
import java.util.Map;

/**
 * @Author tanghh
 * @Date 2020/5/29 15:37
 */
public class SpliceFiledUtil {
    /**
     * 拼接查询条件
     * @param fieldList
     */
    public static String spliceInputCondition(List fieldList){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < fieldList.size(); i++) {
             Map map = (Map) fieldList.get(i);
             if(i == 0){
                 stringBuffer.append(" and ( ");
             }
             if(map.get("database_name")!=null){
                 String databaseName = (String) map.get("database_name");
                 if(i >= 0 && i != fieldList.size() -1){
                     stringBuffer.append(" a."+ databaseName +" like :input or");
                 }else{
                     stringBuffer.append(" a."+ databaseName +" like :input ");
                 }
             }
             if(i == fieldList.size() -1){
                 stringBuffer.append(" ) ");
             }
        }
        return stringBuffer.toString();
    }

    /**
     * 拼接查询的字段
     * @param fieldList
     * @return
     */
    public static String spliceFiledCondition(List fieldList){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < fieldList.size(); i++) {
            Map map = (Map) fieldList.get(i);
            if(map.get("database_name")!=null){
                String databaseName = (String) map.get("database_name");
                if(i != fieldList.size() - 1){
                    stringBuffer.append(" a."+ databaseName +",");
                }else{
                    stringBuffer.append(" a."+ databaseName);
                }
            }
        }
        return  stringBuffer.toString();
    }
}
