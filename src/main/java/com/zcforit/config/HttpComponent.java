package com.zcforit.config;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 发送http消息
 * @date 2021/12/3 17:31
 */
@Slf4j
@Component
public class HttpComponent {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * get请求
     *
     * @param url       请求地址
     * @param headerMap 头部信息
     * @param resp      响应结果类型
     * @return
     */
    public Object get(String url, Map<String, String> headerMap, Class<?> resp) {
        log.info("send request: " + url);
        HttpHeaders httpHeaders = new HttpHeaders();
        for (Map.Entry<String, String> stringStringEntry : headerMap.entrySet()) {
            httpHeaders.add(stringStringEntry.getKey(), stringStringEntry.getValue());
        }
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<?> result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, resp);
        return result.getBody();
    }

    /**
     * post 请求
     *
     * @param url        请求地址
     * @param headerMap  头信息
     * @param jsonObject 请求参数 JSON
     * @return JSONObject
     */
    public JSONObject post(String url, Map<String, String> headerMap, String jsonObject) {
        log.info("send request: " + url);
        log.info("send request body: " + jsonObject);
        HttpHeaders httpHeaders = new HttpHeaders();
        for (Map.Entry<String, String> stringStringEntry : headerMap.entrySet()) {
            httpHeaders.add(stringStringEntry.getKey(), stringStringEntry.getValue());
        }
        HttpEntity httpEntity = new HttpEntity(jsonObject, httpHeaders);
        log.info("response: " + httpEntity);
        JSONObject result = restTemplate.postForObject(url, httpEntity, JSONObject.class);
        return result;
    }


    /**
     * get 请求
     * @param requestUrl
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getEntity(String requestUrl,Class<T> clazz) {
        try {
            log.info("send request: " + requestUrl);
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(requestUrl,String.class);
            if (responseEntity!=null && responseEntity.getStatusCodeValue()==200){
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                return (T)objectMapper.readValue(responseEntity.getBody(), clazz);
            } else {
                return null;
            }
        } catch (Exception e) {
            log.error("获取第三方 API error {} ", e);
            return null;
        }
    }
}
