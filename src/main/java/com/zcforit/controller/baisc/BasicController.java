package com.zcforit.controller.baisc;

import com.alibaba.fastjson.JSONObject;
import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.basic.StockBasicDTO;

import com.zcforit.service.basic.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 基本数据行情
 * @date : 2021-12-05 11:01
 */
//@Controller
public class BasicController implements ApplicationRunner {
    @Autowired
    BasicService basicService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        StockBasicDTO dto = StockBasicDTO.builder()
                .apiName("stock_basic")
                .exchange("SSE")
                .build();
        dto.setRequest();
        String baseStock = basicService.getBaseStock(dto.getRequest());
        System.out.println(baseStock);
    }
}
