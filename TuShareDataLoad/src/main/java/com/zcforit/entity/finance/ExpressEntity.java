package com.zcforit.entity.finance;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 业绩快报
 * @date 2022/1/5 20:24
 */
@Data
//@Entity
//@Table(name="stock_finance_express")
public class ExpressEntity {
    @Id
    private String tsCode;//	str	TS股票代码
    @Id
    private String endDate;//	str	报告期
    private String annDate;//	str	公告日期
    private String revenue;//	float	营业收入(元)
    private String operateProfit;//	float	营业利润(元)
    private String totalProfit;//	float	利润总额(元)
    private String nIncome;//	float	净利润(元)
    private String totalAssets;//	float	总资产(元)
    private String totalHldrEqyExcMinInt;//	float	股东权益合计(不含少数股东权益)(元)
    private String dilutedEps;//	float	每股收益(摊薄)(元)
    private String dilutedRoe;//	float	净资产收益率(摊薄)(%)
    private String yoyNetProfit;//	float	去年同期修正后净利润
    private String bps;//	float	每股净资产
    private String yoySales;//	float	同比增长率:营业收入
    private String yoyOp;//	float	同比增长率:营业利润
    private String yoyTp;//	float	同比增长率:利润总额
    private String yoyDeduNp;//	float	同比增长率:归属母公司股东的净利润
    private String yoyEps;//	float	同比增长率:基本每股收益
    private String yoyRoe;//	float	同比增减:加权平均净资产收益率
    private String growthAssets;//	float	比年初增长率:总资产
    private String yoyEquity;//	float	比年初增长率:归属母公司的股东权益
    private String growthBps;//	float	比年初增长率:归属于母公司股东的每股净资产
    private String orLastYear;//	float	去年同期营业收入
    private String opLastYear;//	float	去年同期营业利润
    private String tpLastYear;//	float	去年同期利润总额
    private String npLastYear;//	float	去年同期净利润
    private String epsLastYear;//	float	去年同期每股收益
    private String openNetAssets;//	float	期初净资产
    private String openBps;//	float	期初每股净资产
    private String perfSummary;//	str	业绩简要说明
    private String isAudit;//	int	是否审计： 1是 0否
    private String remark;//	str	备注
}
