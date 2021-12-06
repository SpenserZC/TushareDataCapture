package com.zcforit.controller.base;

import com.zcforit.config.TuShareConfig;
import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.base.StockBasicDTO;

import com.zcforit.entity.base.StockBasicEntity;
import com.zcforit.service.base.BasicService;
import com.zcforit.utils.TuShareUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.List;


/**
 * @author zhang cheng
 * @version 1.0
 * @description: 基本数据行情
 * @date : 2021-12-05 11:01
 */
@Controller
public class BasicController implements ApplicationRunner {
    @Autowired
    BasicService basicService;

    @Autowired
    TuShareConfig config;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        StockBasicDTO dto = StockBasicDTO.builder()
                .apiName("stock_basic")
                .build();
        BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new StockBasicEntity(), config.getToken());
        List<StockBasicEntity> baseStock = basicService.getBaseStock(baseRequest);
        System.out.println(basicService.saveBaseStock(baseStock));
        System.exit(0);
    }
}
