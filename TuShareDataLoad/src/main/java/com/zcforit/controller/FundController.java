package com.zcforit.controller;

import com.zcforit.dto.fund.FundRequestDTO;
import com.zcforit.entity.base.TradeCalEntity;
import com.zcforit.entity.fund.FundBasicEntity;
import com.zcforit.service.BasicQuotaService;
import com.zcforit.service.FundService;
import com.zcforit.service.MysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 基金接口
 * @date : 2022-01-13 21:54
 */
//@Controller
public class FundController implements ApplicationRunner {
    @Autowired
    FundService fundService;
    @Autowired
    MysqlService mysqlService;
    @Autowired
    BasicQuotaService basicQuotaService;
    @Autowired
    BasicQuotaService quotaService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadShare();
        loadNav();
        loadDiv();
        loadPortfolio();
        loadDaily();
        loadAdj();
        System.exit(0);
    }

    public void loadFundBasic(){
        FundRequestDTO dto = new FundRequestDTO();
        dto.setApiName("fund_basic");
        dto.setStatus("L");
        dto.setMarket("E");
        fundService.loadFundBasic(dto);
    }


    public void loadCompany(){
        fundService.loadCompany();
    }

    public void loadManager(){
        fundService.loadManager();
    }

    public void loadShare(){
        List<FundBasicEntity> allFund = mysqlService.getAllFund();
        for (FundBasicEntity fund:allFund){
            FundRequestDTO dto = new FundRequestDTO();
            dto.setApiName("fund_share");
            dto.setTsCode(fund.getTsCode());
            fundService.loadShare(dto);
        }
    }


    public void loadNav(){
        List<FundBasicEntity> allFund = mysqlService.getAllFund();
        for (FundBasicEntity fund:allFund){
            FundRequestDTO dto = new FundRequestDTO();
            dto.setApiName("fund_nav");
            dto.setTsCode(fund.getTsCode());
            fundService.loadNav(dto);
        }
    }
    public void loadDiv(){
        List<FundBasicEntity> allFund = mysqlService.getAllFund();
        FundRequestDTO dto = new FundRequestDTO();
        dto.setApiName("fund_div");
        for (FundBasicEntity fund:allFund) {
            dto.setTsCode(fund.getTsCode());
            fundService.loadDiv(dto);
            break;
        }
    }
    public void loadPortfolio(){
        List<FundBasicEntity> allFund = mysqlService.getAllFund();
        FundRequestDTO dto = new FundRequestDTO();
        dto.setApiName("fund_portfolio");
        for (FundBasicEntity fund:allFund) {
            dto.setTsCode(fund.getTsCode());
            fundService.loadDiv(dto);
            break;
        }
    }
    public void loadDaily(){
        List<TradeCalEntity> datesList = basicQuotaService.getDatesList("20150101", "20220127");
        FundRequestDTO dto = new FundRequestDTO();
        for (TradeCalEntity fund:datesList) {
            dto.setApiName("fund_daily");
            dto.setTradeDate(fund.getCalDate());
            fundService.loadDaily(dto);
        }
    }

    public void loadAdj(){
        List<TradeCalEntity> datesList = basicQuotaService.getDatesList("20150101", "20220127");
        FundRequestDTO dto = new FundRequestDTO();
        dto.setApiName("fund_adj");
        for (TradeCalEntity fund:datesList) {
            dto.setTradeDate(fund.getCalDate());
            fundService.loadDaily(dto);
        }
    }

}
