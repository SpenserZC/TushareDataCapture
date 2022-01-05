package com.zcforit.controller;

import com.zcforit.dto.quotation.QuotationInfoDTO;
import com.zcforit.entity.quotation.*;
import com.zcforit.service.BasicService;
import com.zcforit.service.LoadDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 实时服务，接受请求参数
 * @date 2021/12/14 20:16
 */
@Slf4j
@RestController
@RequestMapping("/tushare")
public class TuShareController {

    @Autowired
    LoadDataService service;
//    @GetMapping(path = "/init")
//    public String getS(String dto) {
//       return "OK";
//    }

    @GetMapping(path = "/update/today")
    public String updateAll() {
        String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
        try{
            service.loadDaily(today);
            service.loadWeekly(today);
            service.loadMonthly(today);
            service.loadDailyIndicator(today);
            service.loadCashFlows(today);
            service.loadLimitList(today);
            service.loadHSGTCapitalFlows(today);
            service.loadHSTCapitalFlowsTop10(today);
            service.loadGGTCapitalFlowsTop10(today);
            service.loadHSGTHoldStock(today);
            service.loadGGTDailyBuyStock(today);
            service.loadGGTMonthlyBuyStock(today);
            service.loadCenterHoldStock(today);
        }catch (Exception e){
            e.printStackTrace();
        }
        return today +" 更新完成";
    }

    @GetMapping(path = "/update/daily")
    public void loadDaily(String date) throws InterruptedException {
        service.loadDaily(date);
    }
    @GetMapping(path = "/update/weekly")
    public void loadWeekly(String date) throws InterruptedException {
        service.loadWeekly(date);
    }
    @GetMapping(path = "/update/monthly")
    public void loadMonthly(String date) throws InterruptedException {

    }
    @GetMapping(path = "/update/indicator")
    public void loadDailyIndicator(String date) throws InterruptedException {

    }
    @GetMapping(path = "/update/cashflow")
    public void loadCashFlows(String date) throws InterruptedException {

    }




}
