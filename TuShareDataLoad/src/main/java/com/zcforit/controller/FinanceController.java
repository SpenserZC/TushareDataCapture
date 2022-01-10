package com.zcforit.controller;

import com.zcforit.config.TuShareConfig;
import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.FinanceRequest;
import com.zcforit.dto.base.StockBasicDTO;
import com.zcforit.entity.base.StockBasicEntity;
import com.zcforit.entity.finance.IncomeEntity;
import com.zcforit.service.FinanceService;
import com.zcforit.utils.TuShareUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 拉取财务数据
 * @date 2022/1/10 21:03
 */
@Controller
public class FinanceController implements ApplicationRunner {
    @Autowired
    FinanceService service;
    @Autowired
    TuShareConfig config;



    @Override
    public void run(ApplicationArguments args) throws Exception {
        FinanceRequest dto = new FinanceRequest();
        dto.setTsCode("000001.SZ");
        dto.setApiName("income");
        BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new IncomeEntity(), config.getToken());
        service.loadFinanceIncome(baseRequest);
    }
}
