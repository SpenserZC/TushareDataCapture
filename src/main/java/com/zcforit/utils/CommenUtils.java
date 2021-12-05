package com.zcforit.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 转换工具
 * @date : 2021-12-05 14:15
 */
public class CommenUtils {
    public static  SerializeConfig config = new SerializeConfig();

    /**
     * 下划线转驼峰
     * @param <T>
     * @return
     */
    public <T> T strToObject(String str,Class<T> clazz){
        config.propertyNamingStrategy= PropertyNamingStrategy.CamelCase;
        return JSON.parseObject(str, clazz);
    }

    /**
     * 驼峰转下划线
     * @param o
     * @return
     */
    public String objectToStr(Object o){
        config.propertyNamingStrategy= PropertyNamingStrategy.SnakeCase;
        return JSON.toJSONString(o);
    }

}
