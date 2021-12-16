package com.zcforit.controller;

import com.zcforit.config.TuShareConfig;
import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.base.StockBasicDTO;

import com.zcforit.dto.base.TradeCalDTO;
import com.zcforit.dto.quotation.DailyInfoDTO;
import com.zcforit.entity.base.StockBasicEntity;
import com.zcforit.entity.base.StockCompanyEntity;
import com.zcforit.entity.base.TradeCalEntity;
import com.zcforit.entity.error.ErrorEntity;
import com.zcforit.entity.quotation.*;
import com.zcforit.repository.base.StockBasicDao;
import com.zcforit.repository.base.TradeCalDao;
import com.zcforit.service.base.BasicService;
import com.zcforit.utils.TuShareUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * @author zhang cheng
 * @version 1.0
 * @description: 基本数据行情
 * @date : 2021-12-05 11:01
 */
@Slf4j
//@Controller
public class BasicController implements ApplicationRunner {
    @Autowired
    BasicService basicService;
    @Autowired
    TradeCalDao tradeCalDao;


    @Autowired
    TuShareConfig config;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadStockBasic();
        loadStockCompany();
        loadStockCal();
        loadDaily();
        loadWeekly();
        loadMonthly();
        loadDailyIndicator();
        loadCashFlows();
        System.exit(0);
    }

    public void loadStockBasic(){
        StockBasicDTO dto = new StockBasicDTO();
        BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new StockBasicEntity(), config.getToken());
        try{
            List<StockBasicEntity> res = basicService.getTuShareData(baseRequest,new StockBasicEntity());
            basicService.saveToMySql(res,"StockBasicDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void loadStockCompany(){
        StockBasicDTO dto = new StockBasicDTO();
        dto.setApiName("stock_company");
        BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new StockCompanyEntity(), config.getToken());
        try{
            List<StockCompanyEntity> res = basicService.getTuShareData(baseRequest,new StockCompanyEntity());
            basicService.saveToMySql(res,"StockCompanyDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void loadStockCal(){
        TradeCalDTO dto = new TradeCalDTO();
        dto.setStartDate("20111211");
        dto.setEndDate("20211214");
        dto.setIsOpen("1");
        BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new TradeCalEntity(), config.getToken());
        try{
            List<TradeCalEntity> res = basicService.getTuShareData(baseRequest,new TradeCalEntity());
            basicService.saveToMySql(res,"TradeCalDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadDaily() throws InterruptedException {
        basicService.loadByCal(new DailyInfoDTO(),new DailyInfoEntity(),tradeCalDao.findAll());
        log.info("日K 近10年数据拉取完成");
    }
    public void loadWeekly() throws InterruptedException {
        DailyInfoDTO dailyInfoDTO = new DailyInfoDTO();
        dailyInfoDTO.setApiName("weekly");
        basicService.loadByCal(dailyInfoDTO, new WeeklyInfoEntity(),tradeCalDao.findAll());
        log.info("周K 近10年数据拉取完成");
    }
    public void loadMonthly() throws InterruptedException {
        DailyInfoDTO dailyInfoDTO = new DailyInfoDTO();
        dailyInfoDTO.setApiName("monthly");
        basicService.loadByCal(dailyInfoDTO, new MonthlyInfoEntity(),tradeCalDao.findAll());
        log.info("周K 近10年数据拉取完成");
    }

    public void loadDailyIndicator() throws InterruptedException {
        DailyInfoDTO dto = new DailyInfoDTO();
        dto.setApiName("daily_basic");
        basicService.loadByCal(dto, new DailyIndicatorEntity(),tradeCalDao.findAll());
    }

    public void loadCashFlows() throws InterruptedException {
        DailyInfoDTO dto = new DailyInfoDTO();
        dto.setApiName("moneyflow");
        basicService.loadByCal(dto, new CapitalFlowsEntity(),tradeCalDao.findAll());
    }

}
