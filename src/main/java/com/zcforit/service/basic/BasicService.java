package com.zcforit.service.basic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zcforit.config.HttpComponent;
import com.zcforit.config.TuShareConfig;
import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.basic.StockBasicDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 基础股票信息
 * @date : 2021-12-05 10:37
 */
@Service
public class BasicService {
    @Autowired
    HttpComponent component;
    @Autowired
    TuShareConfig tuShare;

    private String url="http://api.waditu.com";

    public String getBaseStock(BaseRequest dto){
        JSONObject post = component.post(url, tuShare.headerMap(), (JSONObject) JSONObject.toJSON(dto));
        return post.toJSONString();
    }

}
