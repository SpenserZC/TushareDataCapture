package com.zcforit.utils;

import com.zcforit.dto.BaseRequest;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: tuShare 实体请求转换
 * @date : 2021-12-05 20:39
 */
public class TuShareUtils {

    /**
     * 实体转换为请求信息
     * @param param,field
     * @return
     */
    public BaseRequest transBaseRequest(Object param,Object field,String token){
        Map<String, String> request = collectFiledValue(param);
        BaseRequest apiName = BaseRequest.builder()
                .apiName(request.get("apiName"))
                .params(request)
                .fields(collectFiledParam(field))
                .token(token)
                .build();
        return apiName;
    }

    /**
     * 获取实体的值和
     * @param o
     * @return
     */
    public Map<String,String> collectFiledValue(Object o){
        Map<String, String> map = new HashMap<>();
        Class<?> clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field :fields) {
            field.setAccessible(true);
            try {
                if(field.get(o)!=null)
                    map.put(field.getName(),field.get(o).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * 组织需要查找的字段
     * @param o
     * @return
     */
    public String collectFiledParam(Object o){
        StringBuilder sb = new StringBuilder();
        Class<?> clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i <fields.length; i++) {
            if(i==0) sb.append(fields[i].getName());
            else sb.append(",").append(fields[i].getName());
        }
        return sb.toString();
    }

}
