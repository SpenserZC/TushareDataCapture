package com.zcforit.entity.fund;

import com.zcforit.entity.keys.TradeDateKeys;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 场内基金
 * @date 2022/1/13 14:48
 */
@Data
@Entity
@IdClass(TradeDateKeys.class)
@Table(name="fund_daily")
public class FundDailyEntity {
    @Id
    private String tsCode; //TS代码
    @Id
    private String tradeDate; //交易日期
    private String open; //开盘价(元)
    private String high; //最高价(元)
    private String low; //最低价(元)
    private String close; //收盘价(元)
    private String preClose; //昨收盘价(元)
    private String change; //涨跌额(元)
    private String pctChg; //涨跌幅(%)
    private String vol; //成交量(手)
    private String amount; //成交额(千元)
}
