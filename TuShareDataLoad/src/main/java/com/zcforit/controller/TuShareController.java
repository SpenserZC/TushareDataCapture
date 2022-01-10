package com.zcforit.controller;

import com.zcforit.config.TuShareConfig;
import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.base.StockBasicDTO;
import com.zcforit.dto.base.TradeCalDTO;
import com.zcforit.entity.base.StockBasicEntity;
import com.zcforit.entity.base.StockCompanyEntity;
import com.zcforit.entity.base.StockNewShareEntity;
import com.zcforit.entity.base.TradeCalEntity;
import com.zcforit.service.LoadDataService;
import com.zcforit.service.MysqlService;
import com.zcforit.utils.TuShareUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    MysqlService mysqlService;

    @Autowired
    TuShareConfig config;
    @Autowired
    LoadDataService service;

    @GetMapping(path = "/update")
    public String updateAll(String date) {
        if(date==null||"".equals(date))
         date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        try{
            String lastDate = loadStockCal(date);
            List<StockNewShareEntity> news = loadNewStockCompany(lastDate, date);
            loadStockBasic(news);
            loadStockCompany(news);
            service.loadDaily(date);
            service.loadWeekly(date);
            service.loadMonthly(date);
            service.loadDailyIndicator(date);
            service.loadCashFlows(date);
            service.loadLimitList(date);
            service.loadHSGTCapitalFlows(date);
            service.loadHSTCapitalFlowsTop10(date);
            service.loadGGTCapitalFlowsTop10(date);
            service.loadHSGTHoldStock(date);
            service.loadGGTDailyBuyStock(date);
//            service.loadGGTMonthlyBuyStock(date); 木有权限
            service.loadCenterHoldStock(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return date +" 更新完成";
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

    /**
     * 获取新上市公司,返回新上市公司代码
     */
    public List<StockNewShareEntity> loadNewStockCompany(String start, String end){
        TradeCalDTO dto = new TradeCalDTO();
        dto.setApiName("new_share");
        dto.setStartDate(start);
        dto.setEndDate(end);
        BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new StockNewShareEntity(), config.getToken());
        return service.loadNewStockCompany(baseRequest);
    }

    /**
     * 以stock code为主键，可以重复
     */
    public void loadStockBasic( List<StockNewShareEntity> list){
        if(list==null || list.isEmpty()) return;
        for (StockNewShareEntity val: list) {
            StockBasicDTO dto = new StockBasicDTO();
            dto.setTsCode(val.getTsCode());
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new StockBasicEntity(), config.getToken());
            service.loadStockBasic(baseRequest);
        }
    }

    /**
     * 以stock code为主键，可以重复
     */
    public void loadStockCompany(List<StockNewShareEntity> list){
        if(list==null || list.isEmpty()) return;
        for (StockNewShareEntity val: list) {
            StockBasicDTO dto = new StockBasicDTO();
            dto.setApiName("stock_company");
            dto.setTsCode(val.getTsCode());
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new StockCompanyEntity(), config.getToken());
            service.loadStockCompany(baseRequest);
        }
    }

    /**
     * 以日期为主键，可以重复拉取
     * 返回本次需要更新的最开始的一天
     */
    public String loadStockCal(String date){
        String lastDate = mysqlService.getLastDate();
        if(lastDate==null) lastDate="20100101";
        TradeCalDTO dto = new TradeCalDTO();
        dto.setStartDate(lastDate);
        dto.setEndDate(date);
        dto.setIsOpen("1");
        BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new TradeCalEntity(), config.getToken());
        service.loadStockCal(baseRequest);
        return lastDate;
    }

}
