package com.zcforit.controller;

import com.zcforit.dto.quotation.QuotationInfoDTO;
import com.zcforit.entity.quotation.*;
import com.zcforit.service.BasicService;
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
    BasicService basicService;

//    @GetMapping(path = "/init")
//    public String getS(String dto) {
//       return "OK";
//    }

    @GetMapping(path = "/update/today")
    public String updateAll() {
        String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
        try{
            loadDaily(today);
            loadWeekly(today);
            loadMonthly(today);
            loadDailyIndicator(today);
            loadCashFlows(today);
        }catch (Exception e){
            e.printStackTrace();
        }
        return today +" 更新完成";
    }

    @GetMapping(path = "/update/daily")
    public void loadDaily(String date) throws InterruptedException {
        basicService.loadByDay(new QuotationInfoDTO(),new DailyInfoEntity(),date);
    }
    @GetMapping(path = "/update/weekly")
    public void loadWeekly(String date) throws InterruptedException {
        QuotationInfoDTO quotationInfoDTO = new QuotationInfoDTO();
        quotationInfoDTO.setApiName("weekly");
        basicService.loadByDay(quotationInfoDTO, new WeeklyInfoEntity(),date);
    }
    @GetMapping(path = "/update/monthly")
    public void loadMonthly(String date) throws InterruptedException {
        QuotationInfoDTO quotationInfoDTO = new QuotationInfoDTO();
        quotationInfoDTO.setApiName("monthly");
        basicService.loadByDay(quotationInfoDTO, new MonthlyInfoEntity(),date);
    }
    @GetMapping(path = "/update/indicator")
    public void loadDailyIndicator(String date) throws InterruptedException {
        QuotationInfoDTO dto = new QuotationInfoDTO();
        dto.setApiName("daily_basic");
        basicService.loadByDay(dto, new DailyIndicatorEntity(),date);
    }
    @GetMapping(path = "/update/cashflow")
    public void loadCashFlows(String date) throws InterruptedException {
        QuotationInfoDTO dto = new QuotationInfoDTO();
        dto.setApiName("moneyflow");
        basicService.loadByDay(dto, new CapitalFlowsEntity(),date);
    }




}
