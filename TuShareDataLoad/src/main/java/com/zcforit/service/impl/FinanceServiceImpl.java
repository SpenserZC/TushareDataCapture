package com.zcforit.service.impl;

import com.zcforit.config.TuShareConfig;
import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.FinanceRequest;
import com.zcforit.entity.base.StockBasicEntity;
import com.zcforit.entity.finance.*;
import com.zcforit.service.BasicService;
import com.zcforit.service.FinanceService;
import com.zcforit.service.MysqlService;
import com.zcforit.utils.TuShareUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 财务数据
 * @date 2022/1/10 20:54
 */
@Service
public class FinanceServiceImpl implements FinanceService {
    @Autowired
    BasicService basicService;

    @Autowired
    MysqlService mysqlService;

    @Autowired
    TuShareConfig config;

   public void loadFinanceIncome(String stock){
        try{
            FinanceRequest dto = new FinanceRequest();
            dto.setTsCode(stock);
            dto.setApiName("income");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new IncomeEntity(), config.getToken());
            List<IncomeEntity> res = basicService.getTuShareData(baseRequest,new IncomeEntity());
            basicService.saveToMySql(res,"IncomeDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void loadFinanceIncome(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceIncome(basicEntity.getTsCode());
                Thread.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceBalance(String stock){
        try{
            FinanceRequest dto = new FinanceRequest();
            dto.setTsCode(stock);
            dto.setApiName("balancesheet");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new BalanceEntity(), config.getToken());
            List<BalanceEntity> res = basicService.getTuShareData(baseRequest,new BalanceEntity());
            basicService.saveToMySql(res,"BalanceDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceBalance(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceBalance(basicEntity.getTsCode());
                Thread.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceCashFlow(String stock){
        try{
            FinanceRequest dto = new FinanceRequest();
            dto.setTsCode(stock);
            dto.setApiName("cashflow");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new CashFlowEntity(), config.getToken());
            List<CashFlowEntity> res = basicService.getTuShareData(baseRequest,new CashFlowEntity());
            basicService.saveToMySql(res,"CashFlowDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceCashFlow(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceCashFlow(basicEntity.getTsCode());
                Thread.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceForecast(String stock){
        try{
            FinanceRequest dto = new FinanceRequest();
            dto.setTsCode(stock);
            dto.setApiName("forecast");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new ForecastEntity(), config.getToken());
            List<ForecastEntity> res = basicService.getTuShareData(baseRequest,new ForecastEntity());
            basicService.saveToMySql(res,"ForecastDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceForecast(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceForecast(basicEntity.getTsCode());
                Thread.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void loadFinanceExpress(String stock){
        try{
            FinanceRequest dto = new FinanceRequest();
            dto.setTsCode(stock);
            dto.setApiName("express");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new ExpressEntity(), config.getToken());
            List<ExpressEntity> res = basicService.getTuShareData(baseRequest,new ExpressEntity());
            basicService.saveToMySql(res,"ExpressDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceExpress(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceExpress(basicEntity.getTsCode());
                Thread.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceDivided(String stock){
        try{
            FinanceRequest dto = new FinanceRequest();
            dto.setTsCode(stock);
            dto.setApiName("dividend");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new DividedEntity(), config.getToken());
            List<DividedEntity> res = basicService.getTuShareData(baseRequest,new DividedEntity());
            basicService.saveToMySql(res,"DividedDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceDivided(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceDivided(basicEntity.getTsCode());
                Thread.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceIndicator(String stock){
        try{
            FinanceRequest dto = new FinanceRequest();
            dto.setTsCode(stock);
            dto.setApiName("fina_indicator");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new FinanceIndicatorEntity(), config.getToken());
            List<FinanceIndicatorEntity> res = basicService.getTuShareData(baseRequest,new FinanceIndicatorEntity());
            basicService.saveToMySql(res,"FinanceIndicatorDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceIndicator(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceIndicator(basicEntity.getTsCode());
                Thread.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceAudit(String stock){
        try{
            FinanceRequest dto = new FinanceRequest();
            dto.setTsCode(stock);
            dto.setApiName("fina_audit");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new FinanceAuditEntity(), config.getToken());
            List<FinanceAuditEntity> res = basicService.getTuShareData(baseRequest,new FinanceAuditEntity());
            basicService.saveToMySql(res,"FinanceAuditDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceAudit(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceAudit(basicEntity.getTsCode());
                Thread.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceMainbz(String stock){
        try{
            FinanceRequest dto = new FinanceRequest();
            dto.setTsCode(stock);
            dto.setApiName("fina_mainbz");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new FinanceMainbzEntity(), config.getToken());
            List<FinanceMainbzEntity> res = basicService.getTuShareData(baseRequest,new FinanceMainbzEntity());
            basicService.saveToMySql(res,"FinanceMainbzDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceMainbz(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceMainbz(basicEntity.getTsCode());
                Thread.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceDisclosureDate(String stock){
        try{
            FinanceRequest dto = new FinanceRequest();
            dto.setTsCode(stock);
            dto.setApiName("disclosure_date");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new DisclosureDateEntity(), config.getToken());
            List<DisclosureDateEntity> res = basicService.getTuShareData(baseRequest,new DisclosureDateEntity());
            basicService.saveToMySql(res,"DisclosureDateDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceDisclosureDate(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceDisclosureDate(basicEntity.getTsCode());
                Thread.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
