package com.zcforit.controller.base;

import com.zcforit.config.TuShareConfig;
import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.base.StockBasicDTO;

import com.zcforit.dto.quotation.DailyInfoDTO;
import com.zcforit.entity.base.StockBasicEntity;
import com.zcforit.entity.quotation.*;
import com.zcforit.repository.base.StockBasicRepository;
import com.zcforit.service.base.BasicService;
import com.zcforit.utils.TuShareUtils;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Controller
public class BasicController implements ApplicationRunner {
    @Autowired
    BasicService basicService;
    @Autowired
    StockBasicRepository basicRepository;

    @Autowired
    TuShareConfig config;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        loadStockBasic();
//        loadDaily();
//        loadWeekly();
//        loadMonthly();
        loadDailyIndicator();
        loadCashFlows();
        System.exit(0);
    }

    public void loadStockBasic(){
        StockBasicDTO dto = new StockBasicDTO();
        BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new StockBasicEntity(), config.getToken());
        List<StockBasicEntity> baseStock = basicService.getTuShareData(baseRequest,new StockBasicEntity());
        basicService.saveBaseStock(baseStock);
    }

    public void loadDaily() throws InterruptedException {
        List<StockBasicEntity> all = basicRepository.findAll();
        for (StockBasicEntity val:all) {
            DailyInfoDTO dto = new DailyInfoDTO();
            dto.setTsCode(val.getTsCode());
            dto.setStartDate("20111211");
            dto.setEndDate("20211211");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new DailyInfoEntity(), config.getToken());
            List<DailyInfoEntity> baseStock = basicService.getTuShareData(baseRequest,new DailyInfoEntity() );
            basicService.saveToMySql(baseStock,"DailyInfoDao");
            log.info(val.getTsCode()+" 近10年数据拉取完成");
            Thread.sleep(200l);
        }
        log.info("日K 近10年数据拉取完成");
    }

    public void loadWeekly() throws InterruptedException {
        List<StockBasicEntity> all = basicRepository.findAll();
        for (StockBasicEntity val:all) {
            DailyInfoDTO dto = new DailyInfoDTO();
            dto.setApiName("weekly");
            dto.setTsCode(val.getTsCode());
            dto.setStartDate("20111211");
            dto.setEndDate("20211211");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new WeeklyInfoEntity(), config.getToken());
            List<WeeklyInfoEntity> baseStock = basicService.getTuShareData(baseRequest,new WeeklyInfoEntity() );
            basicService.saveToMySql(baseStock,"WeeklyInfoDao");
            log.info(val.getTsCode()+" 近10年数据拉取完成");
            Thread.sleep(200l);
        }
        log.info("周K 近10年数据拉取完成");
    }

    public void loadMonthly() throws InterruptedException {
        List<StockBasicEntity> all = basicRepository.findAll();
        for (StockBasicEntity val:all) {
            DailyInfoDTO dto = new DailyInfoDTO();
            dto.setApiName("monthly");
            dto.setTsCode(val.getTsCode());
            dto.setStartDate("20111211");
            dto.setEndDate("20211211");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new MonthlyInfoEntity(), config.getToken());
            List<MonthlyInfoEntity> baseStock = basicService.getTuShareData(baseRequest,new MonthlyInfoEntity() );
            basicService.saveToMySql(baseStock,"MonthlyInfoDao");
            log.info(val.getTsCode()+" 近10年数据拉取完成");
            Thread.sleep(200l);
        }
        log.info("月K 近10年数据拉取完成");
    }

    public void loadDailyIndicator() throws InterruptedException {
        List<StockBasicEntity> all = basicRepository.findAll();
        for (StockBasicEntity val:all) {
            DailyInfoDTO dto = new DailyInfoDTO();
            dto.setApiName("daily_basic");
            dto.setTsCode(val.getTsCode());
            dto.setStartDate("20111211");
            dto.setEndDate("20211211");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new DailyIndicatorEntity(), config.getToken());
            List<DailyIndicatorEntity> baseStock = basicService.getTuShareData(baseRequest,new DailyIndicatorEntity() );
            if(baseStock.isEmpty()){
                log.info("拉取数据为空");
                break;
            }
            basicService.saveToMySql(baseStock,"DailyIndicatorDao");
            log.info(val.getTsCode()+" 近10年数据拉取完成");
            Thread.sleep(200l);
        }
        log.info("每日指标 近10年数据拉取完成");
    }

    public void loadCashFlows() throws InterruptedException {
        List<StockBasicEntity> all = basicRepository.findAll();
        for (StockBasicEntity val:all) {
            DailyInfoDTO dto = new DailyInfoDTO();
            dto.setApiName("moneyflow");
            dto.setTsCode(val.getTsCode());
            dto.setStartDate("20111211");
            dto.setEndDate("20211211");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new CapitalFlowsEntity(), config.getToken());
            List<CapitalFlowsEntity> baseStock = basicService.getTuShareData(baseRequest,new CapitalFlowsEntity() );
            if(baseStock.isEmpty()){
                log.info("拉取数据为空");
                break;
            }
            basicService.saveToMySql(baseStock,"CapitalFlowsDao");
            log.info(val.getTsCode()+" 近10年数据拉取完成");
            Thread.sleep(200l);
        }
    }

}
