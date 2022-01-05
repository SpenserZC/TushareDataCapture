package com.zcforit.controller;

import com.zcforit.config.TuShareConfig;
import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.base.StockBasicDTO;
import com.zcforit.dto.base.TradeCalDTO;
import com.zcforit.dto.quotation.QuotationInfoDTO;
import com.zcforit.entity.base.StockBasicEntity;
import com.zcforit.entity.base.StockCompanyEntity;
import com.zcforit.entity.base.TradeCalEntity;
import com.zcforit.entity.quotation.*;
import com.zcforit.repository.base.TradeCalDao;
import com.zcforit.service.BasicService;
import com.zcforit.service.LoadDataService;
import com.zcforit.service.MysqlService;
import com.zcforit.utils.TuShareUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @author zhang cheng
 * @version 1.0
 * @description: 初始化，第一次拉取所有信息
 * @date : 2021-12-05 11:01
 */
@Slf4j
@Controller
public class InitController implements ApplicationRunner {
    @Autowired
    BasicService basicService;
    @Autowired
    TradeCalDao tradeCalDao;

    @Autowired
    LoadDataService service;

    @Autowired
    MysqlService mysqlService;

    @Autowired
    TuShareConfig config;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("load start");
        loadStockBasic();
        loadStockCompany();
        loadStockCal();
        service.loadDaily();
        service.loadWeekly();
        service.loadMonthly();
        service.loadDailyIndicator();
        service.loadCashFlows();
        service.loadLimitList();
        service.loadHSGTCapitalFlows();
        service.loadHSTCapitalFlowsTop10();
        service.loadGGTCapitalFlowsTop10();
        service.loadHSGTHoldStock();
        service.loadGGTDailyBuyStock();
        service.loadGGTMonthlyBuyStock();
        service.loadCenterHoldStock();
        System.exit(0);
    }

    /**
     * 以stock code为主键，可以重复
     */
    public void loadStockBasic(){
        StockBasicDTO dto = new StockBasicDTO();
        BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new StockBasicEntity(), config.getToken());
        service.loadStockBasic(baseRequest);
    }

    /**
     * 以stock code为主键，可以重复
     */
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

    /**
     * 以日期为主键，可以重复拉取
     * 返回本次需要更新的最开始的一天
     */
    public String loadStockCal(){
        String lastDate = mysqlService.getLastDate();
        if(lastDate==null) lastDate="20100101";
        TradeCalDTO dto = new TradeCalDTO();
        dto.setStartDate(lastDate);
        String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
        dto.setEndDate(today);
        dto.setIsOpen("1");
        BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new TradeCalEntity(), config.getToken());
        try{
            List<TradeCalEntity> res = basicService.getTuShareData(baseRequest,new TradeCalEntity());
            basicService.saveToMySql(res,"TradeCalDao");
        }catch (Exception e){
            e.printStackTrace();
        }
        return lastDate;
    }
}
