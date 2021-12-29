package com.zcforit.service;

import com.zcforit.dto.BaseRequest;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 拉取数据接口
 * @date : 2021-12-29 22:33
 */
public interface LoadDataService {
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
     * 获取股市交易日历
     * @param baseRequest
     */
    public void loadStockCal(BaseRequest baseRequest);

    //行情数据
    /**
     * 获取日线全量数据
     */
    public void loadDaily();
    /**
     * 获取周线线全量数据
     */
    public void loadWeekly();
    /**
     * 获取月线线全量数据
     */
    public void loadMonthly();
    /**
     * 获取每日指标
     */
    public void loadDailyIndicator();
    /**
     * 获取每日现金流
     */
    public void loadCashFlows();

    /**
     * 每日涨跌停
     */
    public void loadLimitList();
    /**
     * 沪深股通资金流
     */
    public void loadHSGTCapitalFlows();
    /**
     * 沪深通十大成交股
     */
    public void loadHSTCapitalFlowsTop10();
    /**
     * 港股通十大成交股
     */
    public void loadGGTCapitalFlowsTop10();
    /**
     * 沪深港股通持股明细
     */
    public void loadHSGTHoldStock();

    /**
     * 港股通每日成交统计
     */
    public void loadGGTDailyBuyStock();
    /**
     * 港股通每月成交统计
     */
    public void loadGGTMonthlyBuyStock();

    /**
     * 港股通每月成交统计
     */
    public void loadCenterHoldStock();

}
