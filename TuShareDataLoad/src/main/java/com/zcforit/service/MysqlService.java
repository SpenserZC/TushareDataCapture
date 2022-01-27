package com.zcforit.service;

import com.zcforit.entity.base.StockBasicEntity;
import com.zcforit.entity.fund.FundBasicEntity;

import java.util.List;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: mysql 本地库操作
 * @date : 2021-12-30 21:49
 */
public interface MysqlService {
    /**
     * 获取本地库最后一天
     * @return
     */
    public String getCalLastDate();

    /**
     * 获取所有的股票信息
     * @return
     */
    public List<StockBasicEntity> getAllStock();

    /**
     * 获取所有的fund
     * @return
     */
    public List<FundBasicEntity> getAllFund();

    public String getCapitalFlowsLastDay();
    public String getCenterHoldStockLastDay();
    public String getDailyIndicatorLastDay();
    public String getDailyInfoLastDay();
    public String getLimitListLastDay();
    public String getMonthlyInfoLastDay();
    public String getWeeklyInfoLastDay();
    public String getGGTCapitalFlowsTop10LastDay();
    public String getGGTDailyBuyStockLastDay();
    public String getGGTMonthlyBuyStockLastDay();
    public String getHSGTCapitalFlowsLastDay();
    public String getHSGTHoldStockLastDay();
    public String getHSTCapitalFlowsTop10LastDay();
}
