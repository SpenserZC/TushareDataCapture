package com.zcforit.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: tushare 配置
 * @date 2021/12/3 18:04
 */

@Data
@Component
public class TuShareConfig {
    @Value("${tushare.url}")
    private String url;
    @Value("${tushare.token1}")
    private String token;

    public Map<String,String> headerMap(){
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept-Encoding","gzip,deflate");
        headers.put("Content-Type","application/json");
        return headers;
    }
}
