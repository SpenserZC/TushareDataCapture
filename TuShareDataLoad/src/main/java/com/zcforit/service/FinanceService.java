package com.zcforit.service;

import com.zcforit.dto.BaseRequest;
import org.springframework.stereotype.Service;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 财务数据
 * @date 2022/1/10 20:54
 */

public interface FinanceService {
    /**
     *利润表
     * @param
     */
    public void loadFinanceIncome(String stock);
    public void loadFinanceIncome();

    /**
     * 资产负债表
     * @param stock
     */
    public void loadFinanceBalance(String stock);
    public void loadFinanceBalance();

    /**
     * 现金流量表
     * @param stock
     */
    public void loadFinanceCashFlow(String stock);
    public void loadFinanceCashFlow();

    /**
     * 业绩预报
     * @param stock
     */
    public void loadFinanceForecast(String stock);
    public void loadFinanceForecast();

    /**
     * 业绩快报
     * @param stock
     */
    public void loadFinanceExpress(String stock);
    public void loadFinanceExpress();

    /**
     * 分股分红
     * @param stock
     */
    public void loadFinanceDivided(String stock);
    public void loadFinanceDivided();

    /**
     * 财务指标
     * @param stock
     */
    public void loadFinanceIndicator(String stock);
    public void loadFinanceIndicator();

    /**
     * 财务审计
     * @param stock
     */
    public void loadFinanceAudit(String stock);
    public void loadFinanceAudit();

    /**
     * 主营业务构成
     * @param stock
     */
    public void loadFinanceMainbz(String stock);
    public void loadFinanceMainbz();

    /**
     * 财报披露计划
     * @param stock
     */
    public void loadFinanceDisclosureDate(String stock);
    public void loadFinanceDisclosureDate();




}
