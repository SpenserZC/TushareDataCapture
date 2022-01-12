package com.zcforit.controller;

import com.zcforit.config.TuShareConfig;
import com.zcforit.service.FinanceService;
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
//@Controller
public class FinanceController implements ApplicationRunner {
    @Autowired
    FinanceService financeService;
    @Autowired
    TuShareConfig config;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        financeService.loadFinanceIncome();
        financeService.loadFinanceBalance();
        financeService.loadFinanceCashFlow();
        financeService.loadFinanceForecast();
        financeService.loadFinanceExpress();
        financeService.loadFinanceDivided();
        financeService.loadFinanceIndicator();
        financeService.loadFinanceAudit();
        financeService.loadFinanceMainbz();
        financeService.loadFinanceDisclosureDate();
        System.exit(0);
    }
}
