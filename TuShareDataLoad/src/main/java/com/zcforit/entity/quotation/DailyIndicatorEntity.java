package com.zcforit.entity.quotation;

import com.zcforit.entity.keys.TradeDateKeys;
import lombok.Data;

import javax.persistence.*;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 每日指标
 * @date 2021/12/11 15:27
 */
@Data
@Entity
@IdClass(TradeDateKeys.class)
@Table(name="stock_quotation_daily_indicator")
public class DailyIndicatorEntity {
    @Id
    private String tsCode; //str	TS股票代码
    @Id
    private String tradeDate; //str	交易日期
    private String close; //float	当日收盘价
    private String turnoverRate; //float	换手率（%）
    private String turnoverRateF; //float	换手率（自由流通股）
    private String volumeRatio; //float	量比
    private String pe; //float	市盈率（总市值/净利润， 亏损的PE为空）
    private String peTtm; //float	市盈率（TTM，亏损的PE为空）
    private String pb; //float	市净率（总市值/净资产）
    private String ps; //float	市销率
    private String psTtm; //float	市销率（TTM）
    private String dvRatio; //float	股息率 （%）
    private String dvTtm; //float	股息率（TTM）（%）
    private String totalShare; //float	总股本 （万股）
    private String floatShare; //float	流通股本 （万股）
    private String freeShare; //float	自由流通股本 （万）
    private String totalMv; //float	总市值 （万元）
    private String circMv; //float	流通市值（万元）
}
