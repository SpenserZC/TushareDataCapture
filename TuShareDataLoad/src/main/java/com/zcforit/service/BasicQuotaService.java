package com.zcforit.service;

import com.zcforit.dto.BaseRequest;
import com.zcforit.entity.base.StockNewShareEntity;
import com.zcforit.entity.base.TradeCalEntity;

import java.util.List;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 拉取数据接口
 * @date : 2021-12-29 22:33
 */
public interface BasicQuotaService {
    //基本数据
    /**
     * 获取基本数据
     * @param baseRequest
     */
    public void loadStockBasic(BaseRequest baseRequest);

    /**
     * 获取股市数据公司信息
     * @param baseRequest
     */
    public void loadStockCompany(BaseRequest baseRequest);

    /**
     * 获取新上市企业信息
     * @param baseRequest
     */
    public List<StockNewShareEntity> loadNewStockCompany(BaseRequest baseRequest);

    /**
     * 获取股市交易日历
     * @param baseRequest
     */
    public void loadStockCal(BaseRequest baseRequest);

    /**
     * 获取两天之间的交易日期
     * @param start
     * @param end
     * @return
     */
    public List<TradeCalEntity> getDatesList(String start, String end);

    //行情数据
    /**
     * 获取日线全量数据
     */
    public void loadDaily();
    public void loadDaily(String date);
    public void loadDaily(String start,String end);
    /**
     * 获取周线线全量数据
     */
    public void loadWeekly();
    public void loadWeekly(String date);
    public void loadWeekly(String start,String end);
    /**
     * 获取月线线全量数据
     */
    public void loadMonthly();
    public void loadMonthly(String date);
    public void loadMonthly(String start,String end);
    /**
     * 获取每日指标
     */
    public void loadDailyIndicator();
    public void loadDailyIndicator(String date);
    public void loadDailyIndicator(String start,String end);
    /**
     * 获取每日现金流
     */
    public void loadCashFlows();
    public void loadCashFlows(String date);
    public void loadCashFlows(String start,String end);
    /**
     * 每日涨跌停
     */
    public void loadLimitList();
    public void loadLimitList(String date);
    public void loadLimitList(String start,String end);
    /**
     * 沪深股通资金流
     */
    public void loadHSGTCapitalFlows();
    public void loadHSGTCapitalFlows(String date);
    public void loadHSGTCapitalFlows(String start,String end);
    /**
     * 沪深通十大成交股
     */
    public void loadHSTCapitalFlowsTop10();
    public void loadHSTCapitalFlowsTop10(String date);
    public void loadHSTCapitalFlowsTop10(String start,String end);
    /**
     * 港股通十大成交股
     */
    public void loadGGTCapitalFlowsTop10();
    public void loadGGTCapitalFlowsTop10(String date);
    public void loadGGTCapitalFlowsTop10(String start,String end);
    /**
     * 沪深港股通持股明细
     */
    public void loadHSGTHoldStock();
    public void loadHSGTHoldStock(String date);
    public void loadHSGTHoldStock(String start,String end);

    /**
     * 港股通每日成交统计
     */
    public void loadGGTDailyBuyStock();
    public void loadGGTDailyBuyStock(String date);
    public void loadGGTDailyBuyStock(String start,String end);
    /**
     * 港股通每月成交统计
     */
    public void loadGGTMonthlyBuyStock();
    public void loadGGTMonthlyBuyStock(String date);
    public void loadGGTMonthlyBuyStock(String start,String end);

    /**
     * 港股通每月成交统计
     */
    public void loadCenterHoldStock();
    public void loadCenterHoldStock(String date);
    public void loadCenterHoldStock(String start,String end);

}
