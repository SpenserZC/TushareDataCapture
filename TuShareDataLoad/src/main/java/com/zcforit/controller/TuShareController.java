package com.zcforit.controller;

import com.zcforit.config.TuShareConfig;
import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.base.StockBasicDTO;
import com.zcforit.dto.base.TradeCalDTO;
import com.zcforit.entity.base.StockBasicEntity;
import com.zcforit.entity.base.StockCompanyEntity;
import com.zcforit.entity.base.StockNewShareEntity;
import com.zcforit.entity.base.TradeCalEntity;
import com.zcforit.service.BasicQuotaService;
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
    BasicQuotaService basicQuotaService;


    @GetMapping(path = "/update")
    public String updateAll(String date) {
        if(date==null||"".equals(date))
         date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        try{
            String lastDate = loadStockCal(date);
            System.out.println(lastDate);
            List<StockNewShareEntity> news = loadNewStockCompany(lastDate, date);
            loadStockBasic(news);
            loadStockCompany(news);
            if(mysqlService.getDailyInfoLastDay().compareTo(date)<0){
                List<TradeCalEntity> datesList = basicQuotaService.getDatesList(mysqlService.getDailyInfoLastDay(), date);
                for (TradeCalEntity val:datesList){
                    basicQuotaService.loadDaily(val.getCalDate());
                }
            }
            if(mysqlService.getWeeklyInfoLastDay().compareTo(date)<0){
                List<TradeCalEntity> datesList = basicQuotaService.getDatesList(mysqlService.getWeeklyInfoLastDay(), date);
                for (TradeCalEntity val:datesList){
                    basicQuotaService.loadWeekly(val.getCalDate());
                }
            }
            if(mysqlService.getMonthlyInfoLastDay().compareTo(date)<0){
                List<TradeCalEntity> datesList = basicQuotaService.getDatesList(mysqlService.getMonthlyInfoLastDay(), date);
                for (TradeCalEntity val:datesList){
                    basicQuotaService.loadMonthly(val.getCalDate());
                }
            }
            if(mysqlService.getDailyIndicatorLastDay().compareTo(date)<0){
                List<TradeCalEntity> datesList = basicQuotaService.getDatesList(mysqlService.getDailyIndicatorLastDay(), date);
                for (TradeCalEntity val:datesList){
                    basicQuotaService.loadDailyIndicator(val.getCalDate());
                }
            }
            if(mysqlService.getCapitalFlowsLastDay().compareTo(date)<0){
                List<TradeCalEntity> datesList = basicQuotaService.getDatesList(mysqlService.getCapitalFlowsLastDay(), date);
                for (TradeCalEntity val:datesList){
                    basicQuotaService.loadCashFlows(val.getCalDate());
                }
            }
            if(mysqlService.getLimitListLastDay().compareTo(date)<0){
                List<TradeCalEntity> datesList = basicQuotaService.getDatesList(mysqlService.getLimitListLastDay(), date);
                for (TradeCalEntity val:datesList){
                    basicQuotaService.loadLimitList(val.getCalDate());
                }
            }
            if(mysqlService.getHSGTCapitalFlowsLastDay().compareTo(date)<0){
                List<TradeCalEntity> datesList = basicQuotaService.getDatesList(mysqlService.getHSGTCapitalFlowsLastDay(), date);
                for (TradeCalEntity val:datesList){
                    basicQuotaService.loadHSGTCapitalFlows(val.getCalDate());
                }
            }
            if(mysqlService.getHSTCapitalFlowsTop10LastDay().compareTo(date)<0){
                List<TradeCalEntity> datesList = basicQuotaService.getDatesList(mysqlService.getHSTCapitalFlowsTop10LastDay(), date);
                for (TradeCalEntity val:datesList){
                    basicQuotaService.loadHSTCapitalFlowsTop10(val.getCalDate());
                }
            }
            if(mysqlService.getGGTCapitalFlowsTop10LastDay().compareTo(date)<0){
                List<TradeCalEntity> datesList = basicQuotaService.getDatesList(mysqlService.getGGTCapitalFlowsTop10LastDay(), date);
                for (TradeCalEntity val:datesList){
                    basicQuotaService.loadGGTCapitalFlowsTop10(val.getCalDate());
                }
            }
            if(mysqlService.getHSGTHoldStockLastDay().compareTo(date)<0){
                List<TradeCalEntity> datesList = basicQuotaService.getDatesList(mysqlService.getHSGTHoldStockLastDay(), date);
                for (TradeCalEntity val:datesList){
                    basicQuotaService.loadHSGTHoldStock(val.getCalDate());
                }
            }
            if(mysqlService.getGGTDailyBuyStockLastDay().compareTo(date)<0){
                List<TradeCalEntity> datesList = basicQuotaService.getDatesList(mysqlService.getGGTDailyBuyStockLastDay(), date);
                for (TradeCalEntity val:datesList){
                    basicQuotaService.loadGGTDailyBuyStock(val.getCalDate());
                }
            }
            if(mysqlService.getCenterHoldStockLastDay().compareTo(date)<0){
                List<TradeCalEntity> datesList = basicQuotaService.getDatesList(mysqlService.getCenterHoldStockLastDay(), date);
                for (TradeCalEntity val:datesList){
                    basicQuotaService.loadCenterHoldStock(val.getCalDate());
                }
            }
//            service.loadGGTMonthlyBuyStock(date); 木有权限
        }catch (Exception e){
            e.printStackTrace();
        }
        return date +" 更新完成";
    }

    @GetMapping(path = "/update/daily")
    public void loadDaily(String date) throws InterruptedException {
        basicQuotaService.loadDaily(date);
    }
    @GetMapping(path = "/update/weekly")
    public void loadWeekly(String date) throws InterruptedException {
        basicQuotaService.loadWeekly(date);
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
        return basicQuotaService.loadNewStockCompany(baseRequest);
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
            basicQuotaService.loadStockBasic(baseRequest);
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
            basicQuotaService.loadStockCompany(baseRequest);
        }
    }

    /**
     * 以日期为主键，可以重复拉取
     * 返回本次需要更新的最开始的一天
     */
    public String loadStockCal(String date){
        String lastDate = mysqlService.getCalLastDate();
        if(lastDate==null) lastDate="20100101";
        TradeCalDTO dto = new TradeCalDTO();
        dto.setStartDate(lastDate);
        dto.setEndDate(date);
        dto.setIsOpen("1");
        BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new TradeCalEntity(), config.getToken());
        basicQuotaService.loadStockCal(baseRequest);
        return lastDate;
    }

}
