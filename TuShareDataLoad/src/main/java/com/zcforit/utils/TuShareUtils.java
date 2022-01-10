package com.zcforit.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zcforit.dto.BaseRequest;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
    public static BaseRequest transBaseRequest(Object param,Object field,String token){
        Map<String, String> request = collectFiledValue(param);
        BaseRequest apiName = BaseRequest.builder()
                .apiName(request.get("api_name"))
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
    public static Map<String,String> collectFiledValue(Object o){
        Map<String, String> map = new HashMap<>();
        Class<?> clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field :fields) {
            field.setAccessible(true);
            try {
                if(field.get(o)!=null)
                    map.put(CommenUtils.toUnderlineCase(field.getName()),field.get(o).toString());
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
    public static String collectFiledParam(Object o){
        StringBuilder sb = new StringBuilder();
        Class<?> clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i <fields.length; i++) {
            if("id".equals(fields[i].getName()))continue;
            if(sb.length()==0) sb.append(CommenUtils.toUnderlineCase(fields[i].getName()));
            else sb.append(",").append(CommenUtils.toUnderlineCase(fields[i].getName()));
        }
        return sb.toString();
    }

    /**
     * set 结果，准备存库
     * @param o
     * @param t
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     * @throws InstantiationException
     */
    public static <T> List<T> analyzeTSResult(JSONObject o, T t) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        LinkedList<T> res = new LinkedList<>();
        List<String> fields = CommenUtils.transList2CamelCase(
                    o.getJSONObject("data").getJSONArray("fields").toJavaList(String.class));
        JSONArray items = o.getJSONObject("data").getJSONArray("items");
        for (Object obj : items) {
            List<String> values = JSONArray.parseArray(obj.toString()).toJavaList(String.class);
            res.add((T)assembleResult(t.getClass(), fields, values));
        }
        return res;
    }

    /**
     * set 结果，准备存库
     * @param clazz
     * @param fieldNames
     * @param fieldValues
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchFieldException
     */
    public static <T> T assembleResult(Class<T> clazz,List<String> fieldNames,List<String> fieldValues) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        T t = clazz.newInstance();
        for (int i = 0; i < fieldNames.size(); i++) {
            Field field = clazz.getDeclaredField(fieldNames.get(i));
            field.setAccessible(true);
            if(fieldValues.get(i)!=null)
                field.set(t,fieldValues.get(i));
        }
        return t;
    }




}
