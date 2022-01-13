package com.zcforit.service.impl;

import com.zcforit.config.TuShareConfig;
import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.finance.FinanceRequestDTO;
import com.zcforit.entity.base.StockBasicEntity;
import com.zcforit.entity.finance.*;
import com.zcforit.service.BasicService;
import com.zcforit.service.FinanceService;
import com.zcforit.service.MysqlService;
import com.zcforit.utils.TuShareUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
            FinanceRequestDTO dto = new FinanceRequestDTO();
            dto.setTsCode(stock);
            dto.setApiName("income");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new IncomeEntity(), config.getToken());
            Map<Integer, List<IncomeEntity>> map = basicService.getTuShareData(baseRequest, new IncomeEntity());
            if(map.containsKey(0)){
                basicService.saveToMySql(map.get(0),"IncomeDao");
            }else if(map.containsKey(2)){
                Thread.sleep(10000l);
                if(map.containsKey(0))
                    basicService.saveToMySql(basicService.getTuShareData(baseRequest, new IncomeEntity()).get(0),"IncomeDao");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void loadFinanceIncome(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceIncome(basicEntity.getTsCode());
                Thread.sleep(300l);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceBalance(String stock){
        try{
            FinanceRequestDTO dto = new FinanceRequestDTO();
            dto.setTsCode(stock);
            dto.setApiName("balancesheet");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new BalanceEntity(), config.getToken());
            Map<Integer, List<BalanceEntity>> map = basicService.getTuShareData(baseRequest, new BalanceEntity());
            if(map.containsKey(0)){
                basicService.saveToMySql(map.get(0),"BalanceDao");
            }else if(map.containsKey(2)){
                Thread.sleep(10000l);
                if(map.containsKey(0))
                    basicService.saveToMySql(basicService.getTuShareData(baseRequest, new BalanceEntity()).get(0),"BalanceDao");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceBalance(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceBalance(basicEntity.getTsCode());
                Thread.sleep(300l);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceCashFlow(String stock){
        try{
            FinanceRequestDTO dto = new FinanceRequestDTO();
            dto.setTsCode(stock);
            dto.setApiName("cashflow");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new CashFlowEntity(), config.getToken());
            Map<Integer, List<CashFlowEntity>> map = basicService.getTuShareData(baseRequest, new CashFlowEntity());
            if(map.containsKey(0)){
                basicService.saveToMySql(map.get(0),"CashFlowDao");
            }else if(map.containsKey(2)){
                Thread.sleep(10000l);
                if(map.containsKey(0))
                    basicService.saveToMySql(basicService.getTuShareData(baseRequest, new CashFlowEntity()).get(0),"CashFlowDao");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceCashFlow(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceCashFlow(basicEntity.getTsCode());
                Thread.sleep(300l);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceForecast(String stock){
        try{
            FinanceRequestDTO dto = new FinanceRequestDTO();
            dto.setTsCode(stock);
            dto.setApiName("forecast");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new ForecastEntity(), config.getToken());
            Map<Integer, List<ForecastEntity>> map = basicService.getTuShareData(baseRequest, new ForecastEntity());
            if(map.containsKey(0)){
                basicService.saveToMySql(map.get(0),"ForecastDao");
            }else if(map.containsKey(2)){
                Thread.sleep(10000l);
                if(map.containsKey(0))
                    basicService.saveToMySql(basicService.getTuShareData(baseRequest, new ForecastEntity()).get(0),"ForecastDao");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceForecast(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceForecast(basicEntity.getTsCode());
                Thread.sleep(300l);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void loadFinanceExpress(String stock){
        try{
            FinanceRequestDTO dto = new FinanceRequestDTO();
            dto.setTsCode(stock);
            dto.setApiName("express");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new ExpressEntity(), config.getToken());
            Map<Integer, List<ExpressEntity>> map = basicService.getTuShareData(baseRequest, new ExpressEntity());
            if(map.containsKey(0)){
                basicService.saveToMySql(map.get(0),"ExpressDao");
            }else if(map.containsKey(2)){
                Thread.sleep(10000l);
                if(map.containsKey(0))
                    basicService.saveToMySql(basicService.getTuShareData(baseRequest, new ExpressEntity()).get(0),"ExpressDao");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceExpress(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceExpress(basicEntity.getTsCode());
                Thread.sleep(300l);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceDivided(String stock){
        try{
            FinanceRequestDTO dto = new FinanceRequestDTO();
            dto.setTsCode(stock);
            dto.setApiName("dividend");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new DividedEntity(), config.getToken());
            Map<Integer, List<DividedEntity>> map = basicService.getTuShareData(baseRequest, new DividedEntity());
            if(map.containsKey(0)){
                basicService.saveToMySql(map.get(0),"DividedDao");
            }else if(map.containsKey(2)){
                Thread.sleep(10000l);
                if(map.containsKey(0))
                    basicService.saveToMySql(basicService.getTuShareData(baseRequest, new DividedEntity()).get(0),"DividedDao");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceDivided(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceDivided(basicEntity.getTsCode());
                Thread.sleep(300l);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceIndicator(String stock){
        try{
            FinanceRequestDTO dto = new FinanceRequestDTO();
            dto.setTsCode(stock);
            dto.setApiName("fina_indicator");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new FinanceIndicatorEntity(), config.getToken());
            Map<Integer, List<FinanceIndicatorEntity>> map = basicService.getTuShareData(baseRequest, new FinanceIndicatorEntity());
            if(map.containsKey(0)){
                basicService.saveToMySql(map.get(0),"FinanceIndicatorDao");
            }else if(map.containsKey(2)){
                Thread.sleep(10000l);
                if(map.containsKey(0))
                    basicService.saveToMySql(basicService.getTuShareData(baseRequest, new FinanceIndicatorEntity()).get(0),"FinanceIndicatorDao");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceIndicator(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceIndicator(basicEntity.getTsCode());
                Thread.sleep(300l);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceAudit(String stock){
        try{
            FinanceRequestDTO dto = new FinanceRequestDTO();
            dto.setTsCode(stock);
            dto.setApiName("fina_audit");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new FinanceAuditEntity(), config.getToken());
            Map<Integer, List<FinanceAuditEntity>> map = basicService.getTuShareData(baseRequest, new FinanceAuditEntity());
            if(map.containsKey(0)){
                basicService.saveToMySql(map.get(0),"FinanceAuditDao");
            }else if(map.containsKey(2)){
                Thread.sleep(10000l);
                if(map.containsKey(0))
                    basicService.saveToMySql(basicService.getTuShareData(baseRequest, new FinanceAuditEntity()).get(0),"FinanceAuditDao");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceAudit(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceAudit(basicEntity.getTsCode());
                Thread.sleep(300l);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceMainbz(String stock){
        try{
            FinanceRequestDTO dto = new FinanceRequestDTO();
            dto.setTsCode(stock);
            dto.setApiName("fina_mainbz");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new FinanceMainbzEntity(), config.getToken());
            Map<Integer, List<FinanceMainbzEntity>> map = basicService.getTuShareData(baseRequest, new FinanceMainbzEntity());
            if(map.containsKey(0)){
                basicService.saveToMySql(map.get(0),"FinanceMainbzDao");
            }else if(map.containsKey(2)){
                Thread.sleep(10000l);
                if(map.containsKey(0))
                    basicService.saveToMySql(basicService.getTuShareData(baseRequest, new FinanceMainbzEntity()).get(0),"FinanceMainbzDao");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceMainbz(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceMainbz(basicEntity.getTsCode());
                Thread.sleep(300l);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceDisclosureDate(String stock){
        try{
            FinanceRequestDTO dto = new FinanceRequestDTO();
            dto.setTsCode(stock);
            dto.setApiName("disclosure_date");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new DisclosureDateEntity(), config.getToken());
            Map<Integer, List<DisclosureDateEntity>> map = basicService.getTuShareData(baseRequest, new DisclosureDateEntity());
            if(map.containsKey(0)){
                basicService.saveToMySql(map.get(0),"DisclosureDateDao");
            }else if(map.containsKey(2)){
                Thread.sleep(10000l);
                if(map.containsKey(0))
                    basicService.saveToMySql(basicService.getTuShareData(baseRequest, new DisclosureDateEntity()).get(0),"DisclosureDateDao");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFinanceDisclosureDate(){
        try{
            List<StockBasicEntity> allStock = mysqlService.getAllStock();
            for (StockBasicEntity basicEntity: allStock) {
                loadFinanceDisclosureDate(basicEntity.getTsCode());
                Thread.sleep(300l);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
