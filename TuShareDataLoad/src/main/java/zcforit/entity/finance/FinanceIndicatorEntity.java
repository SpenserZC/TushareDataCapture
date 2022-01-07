package com.zcforit.entity.finance;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 财务指标
 * @date 2022/1/5 20:30
 */
@Data
@Entity
@Table(name="stock_finance_indicator")
public class FinanceIndicatorEntity {
    @Id
    private String tsCode;  //str	Y	TS代码
    @Id
    private String endDate;  //str	Y	报告期
    private String annDate;  //str	Y	公告日期
    private String eps;  //float	Y	基本每股收益
    private String dtEps;  //float	Y	稀释每股收益
    private String totalRevenuePs;  //float	Y	每股营业总收入
    private String revenuePs;  //float	Y	每股营业收入
    private String capitalResePs;  //float	Y	每股资本公积
    private String surplusResePs;  //float	Y	每股盈余公积
    private String undistProfitPs;  //float	Y	每股未分配利润
    private String extraItem;  //float	Y	非经常性损益
    private String profitDedt;  //float	Y	扣除非经常性损益后的净利润（扣非净利润）
    private String grossMargin;  //float	Y	毛利
    private String currentRatio;  //float	Y	流动比率
    private String quickRatio;  //float	Y	速动比率
    private String cashRatio;  //float	Y	保守速动比率
    private String invturnDays;  //float	N	存货周转天数
    private String arturnDays;  //float	N	应收账款周转天数
    private String invTurn;  //float	N	存货周转率
    private String arTurn;  //float	Y	应收账款周转率
    private String caTurn;  //float	Y	流动资产周转率
    private String faTurn;  //float	Y	固定资产周转率
    private String assetsTurn;  //float	Y	总资产周转率
    private String opIncome;  //float	Y	经营活动净收益
    private String valuechangeIncome;  //float	N	价值变动净收益
    private String interstIncome;  //float	N	利息费用
    private String daa;  //float	N	折旧与摊销
    private String ebit;  //float	Y	息税前利润
    private String ebitda;  //float	Y	息税折旧摊销前利润
    private String fcff;  //float	Y	企业自由现金流量
    private String fcfe;  //float	Y	股权自由现金流量
    private String currentExint;  //float	Y	无息流动负债
    private String noncurrentExint;  //float	Y	无息非流动负债
    private String interestdebt;  //float	Y	带息债务
    private String netdebt;  //float	Y	净债务
    private String tangibleAsset;  //float	Y	有形资产
    private String workingCapital;  //float	Y	营运资金
    private String networkingCapital;  //float	Y	营运流动资本
    private String investCapital;  //float	Y	全部投入资本
    private String retainedEarnings;  //float	Y	留存收益
    private String diluted2Eps;  //float	Y	期末摊薄每股收益
    private String bps;  //float	Y	每股净资产
    private String ocfps;  //float	Y	每股经营活动产生的现金流量净额
    private String retainedps;  //float	Y	每股留存收益
    private String cfps;  //float	Y	每股现金流量净额
    private String ebitPs;  //float	Y	每股息税前利润
    private String fcffPs;  //float	Y	每股企业自由现金流量
    private String fcfePs;  //float	Y	每股股东自由现金流量
    private String netprofitMargin;  //float	Y	销售净利率
    private String grossprofitMargin;  //float	Y	销售毛利率
    private String cogsOfSales;  //float	Y	销售成本率
    private String expenseOfSales;  //float	Y	销售期间费用率
    private String profitToGr;  //float	Y	净利润/营业总收入
    private String saleexpToGr;  //float	Y	销售费用/营业总收入
    private String adminexpOfGr;  //float	Y	管理费用/营业总收入
    private String finaexpOfGr;  //float	Y	财务费用/营业总收入
    private String impaiTtm;  //float	Y	资产减值损失/营业总收入
    private String gcOfGr;  //float	Y	营业总成本/营业总收入
    private String opOfGr;  //float	Y	营业利润/营业总收入
    private String ebitOfGr;  //float	Y	息税前利润/营业总收入
    private String roe;  //float	Y	净资产收益率
    private String roeWaa;  //float	Y	加权平均净资产收益率
    private String roeDt;  //float	Y	净资产收益率(扣除非经常损益)
    private String roa;  //float	Y	总资产报酬率
    private String npta;  //float	Y	总资产净利润
    private String roic;  //float	Y	投入资本回报率
    private String roeYearly;  //float	Y	年化净资产收益率
    private String roa2Yearly;  //float	Y	年化总资产报酬率
    private String roeAvg;  //float	N	平均净资产收益率(增发条件)
    private String opincomeOfEbt;  //float	N	经营活动净收益/利润总额
    private String investincomeOfEbt;  //float	N	价值变动净收益/利润总额
    private String nOpProfitOfEbt;  //float	N	营业外收支净额/利润总额
    private String taxToEbt;  //float	N	所得税/利润总额
    private String dtprofitToProfit;  //float	N	扣除非经常损益后的净利润/净利润
    private String salescashToOr;  //float	N	销售商品提供劳务收到的现金/营业收入
    private String ocfToOr;  //float	N	经营活动产生的现金流量净额/营业收入
    private String ocfToOpincome;  //float	N	经营活动产生的现金流量净额/经营活动净收益
    private String capitalizedToDa;  //float	N	资本支出/折旧和摊销
    private String debtToAssets;  //float	Y	资产负债率
    private String assetsToEqt;  //float	Y	权益乘数
    private String dpAssetsToEqt;  //float	Y	权益乘数(杜邦分析)
    private String caToAssets;  //float	Y	流动资产/总资产
    private String ncaToAssets;  //float	Y	非流动资产/总资产
    private String tbassetsToTotalassets;  //float	Y	有形资产/总资产
    private String intToTalcap;  //float	Y	带息债务/全部投入资本
    private String eqtToTalcapital;  //float	Y	归属于母公司的股东权益/全部投入资本
    private String currentdebtToDebt;  //float	Y	流动负债/负债合计
    private String longdebToDebt;  //float	Y	非流动负债/负债合计
    private String ocfToShortdebt;  //float	Y	经营活动产生的现金流量净额/流动负债
    private String debtToEqt;  //float	Y	产权比率
    private String eqtToDebt;  //float	Y	归属于母公司的股东权益/负债合计
    private String eqtToInterestdebt;  //float	Y	归属于母公司的股东权益/带息债务
    private String tangibleassetToDebt;  //float	Y	有形资产/负债合计
    private String tangassetToIntdebt;  //float	Y	有形资产/带息债务
    private String tangibleassetToNetdebt;  //float	Y	有形资产/净债务
    private String ocfToDebt;  //float	Y	经营活动产生的现金流量净额/负债合计
    private String ocfToInterestdebt;  //float	N	经营活动产生的现金流量净额/带息债务
    private String ocfToNetdebt;  //float	N	经营活动产生的现金流量净额/净债务
    private String ebitToInterest;  //float	N	已获利息倍数(EBIT/利息费用)
    private String longdebtToWorkingcapital;  //float	N	长期债务与营运资金比率
    private String ebitdaToDebt;  //float	N	息税折旧摊销前利润/负债合计
    private String turnDays;  //float	Y	营业周期
    private String roaYearly;  //float	Y	年化总资产净利率
    private String roaDp;  //float	Y	总资产净利率(杜邦分析)
    private String fixedAssets;  //float	Y	固定资产合计
    private String profitPrefinExp;  //float	N	扣除财务费用前营业利润
    private String nonOpProfit;  //float	N	非营业利润
    private String opToEbt;  //float	N	营业利润／利润总额
    private String nopToEbt;  //float	N	非营业利润／利润总额
    private String ocfToProfit;  //float	N	经营活动产生的现金流量净额／营业利润
    private String cashToLiqdebt;  //float	N	货币资金／流动负债
    private String cashToLiqdebtWithinterest;  //float	N	货币资金／带息流动负债
    private String opToLiqdebt;  //float	N	营业利润／流动负债
    private String opToDebt;  //float	N	营业利润／负债合计
    private String roicYearly;  //float	N	年化投入资本回报率
    private String totalFaTrun;  //float	N	固定资产合计周转率
    private String profitToOp;  //float	Y	利润总额／营业收入
    private String qOpincome;  //float	N	经营活动单季度净收益
    private String qInvestincome;  //float	N	价值变动单季度净收益
    private String qDtprofit;  //float	N	扣除非经常损益后的单季度净利润
    private String qEps;  //float	N	每股收益(单季度)
    private String qNetprofitMargin;  //float	N	销售净利率(单季度)
    private String qGsprofitMargin;  //float	N	销售毛利率(单季度)
    private String qExpToSales;  //float	N	销售期间费用率(单季度)
    private String qProfitToGr;  //float	N	净利润／营业总收入(单季度)
    private String qSaleexpToGr;  //float	Y	销售费用／营业总收入 (单季度)
    private String qAdminexpToGr;  //float	N	管理费用／营业总收入 (单季度)
    private String qFinaexpToGr;  //float	N	财务费用／营业总收入 (单季度)
    private String qImpairToGrTtm;  //float	N	资产减值损失／营业总收入(单季度)
    private String qGcToGr;  //float	Y	营业总成本／营业总收入 (单季度)
    private String qOpToGr;  //float	N	营业利润／营业总收入(单季度)
    private String qRoe;  //float	Y	净资产收益率(单季度)
    private String qDtRoe;  //float	Y	净资产单季度收益率(扣除非经常损益)
    private String qNpta;  //float	Y	总资产净利润(单季度)
    private String qOpincomeToEbt;  //float	N	经营活动净收益／利润总额(单季度)
    private String qInvestincomeToEbt;  //float	N	价值变动净收益／利润总额(单季度)
    private String qDtprofitToProfit;  //float	N	扣除非经常损益后的净利润／净利润(单季度)
    private String qSalescashToOr;  //float	N	销售商品提供劳务收到的现金／营业收入(单季度)
    private String qOcfToSales;  //float	Y	经营活动产生的现金流量净额／营业收入(单季度)
    private String qOcfToOr;  //float	N	经营活动产生的现金流量净额／经营活动净收益(单季度)
    private String basicEpsYoy;  //float	Y	基本每股收益同比增长率(%)
    private String dtEpsYoy;  //float	Y	稀释每股收益同比增长率(%)
    private String cfpsYoy;  //float	Y	每股经营活动产生的现金流量净额同比增长率(%)
    private String opYoy;  //float	Y	营业利润同比增长率(%)
    private String ebtYoy;  //float	Y	利润总额同比增长率(%)
    private String netprofitYoy;  //float	Y	归属母公司股东的净利润同比增长率(%)
    private String dtNetprofitYoy;  //float	Y	归属母公司股东的净利润-扣除非经常损益同比增长率(%)
    private String ocfYoy;  //float	Y	经营活动产生的现金流量净额同比增长率(%)
    private String roeYoy;  //float	Y	净资产收益率(摊薄)同比增长率(%)
    private String bpsYoy;  //float	Y	每股净资产相对年初增长率(%)
    private String assetsYoy;  //float	Y	资产总计相对年初增长率(%)
    private String eqtYoy;  //float	Y	归属母公司的股东权益相对年初增长率(%)
    private String trYoy;  //float	Y	营业总收入同比增长率(%)
    private String orYoy;  //float	Y	营业收入同比增长率(%)
    private String qGrYoy;  //float	N	营业总收入同比增长率(%)(单季度)
    private String qGrQoq;  //float	N	营业总收入环比增长率(%)(单季度)
    private String qSalesYoy;  //float	Y	营业收入同比增长率(%)(单季度)
    private String qSalesQoq;  //float	N	营业收入环比增长率(%)(单季度)
    private String qOpYoy;  //float	N	营业利润同比增长率(%)(单季度)
    private String qOpQoq;  //float	Y	营业利润环比增长率(%)(单季度)
    private String qProfitYoy;  //float	N	净利润同比增长率(%)(单季度)
    private String qProfitQoq;  //float	N	净利润环比增长率(%)(单季度)
    private String qNetprofitYoy;  //float	N	归属母公司股东的净利润同比增长率(%)(单季度)
    private String qNetprofitQoq;  //float	N	归属母公司股东的净利润环比增长率(%)(单季度)
    private String equityYoy;  //float	Y	净资产同比增长率
    private String rdExp;  //float	N	研发费用
    private String updateFlag;  //str	N	更新标识
}
