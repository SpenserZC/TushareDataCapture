package com.zcforit.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.zcforit.entity.quotation.DailyInfoEntity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
    public  static <T> T strToObject(String str,Class<T> clazz){
        config.propertyNamingStrategy= PropertyNamingStrategy.CamelCase;
        return JSON.parseObject(str, clazz);
    }

    /**
     * 驼峰转下划线
     * @param o
     * @return
     */
    public static String objectToStr(Object o){
        config.propertyNamingStrategy= PropertyNamingStrategy.SnakeCase;
        return JSON.toJSONString(o,config);
    }


    /**
     * 下划线转驼峰
     * user_name  ---->  userName
     * userName   --->  userName
     *
     * @param underlineStr 带有下划线的字符串
     * @return 驼峰字符串
     */
    public static String toCamelCase(String underlineStr) {
        if (underlineStr == null) {
            return null;
        }
        // 分成数组
        char[] charArray = underlineStr.toCharArray();
        // 判断上次循环的字符是否是"_"
        boolean underlineBefore = false;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0, l = charArray.length; i < l; i++) {
            // 判断当前字符是否是"_",如果跳出本次循环
            if (charArray[i] == 95) {
                underlineBefore = true;
            } else if (underlineBefore) {
                // 如果为true，代表上次的字符是"_",当前字符需要转成大写
                buffer.append(charArray[i] -= 32);
                underlineBefore = false;
            } else {
                // 不是"_"后的字符就直接追加
                buffer.append(charArray[i]);
            }
        }
        return buffer.toString();
    }

    /**
     * 驼峰转 下划线
     * userName  ---->  user_name
     * user_name  ---->  user_name
     *
     * @param camelCaseStr 驼峰字符串
     * @return 带下滑线的String
     */
    public static String toUnderlineCase(String camelCaseStr) {
        if (camelCaseStr == null) {
            return null;
        }
        // 将驼峰字符串转换成数组
        char[] charArray = camelCaseStr.toCharArray();
        StringBuffer buffer = new StringBuffer();
        //处理字符串
        for (int i = 0, l = charArray.length; i < l; i++) {
            if (charArray[i] >= 65 && charArray[i] <= 90) {
                buffer.append("_").append(charArray[i] += 32);
            } else {
                buffer.append(charArray[i]);
            }
        }
        return buffer.toString();
    }

    /**
     * list 驼峰转换
     * @param list
     * @return
     */
    public static List<String> transList2CamelCase(List<String> list){
        return list.stream().map(CommenUtils::toCamelCase).collect(Collectors.toList());
    }
}
