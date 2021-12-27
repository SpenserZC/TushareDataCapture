package com.zcforit.entity.quotation;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 沪深股通持股明细
 * @date : 2021-12-26 16:27
 */
@Data
@Entity
@Table(name="stock_quotation_hsgt_monthly_buy")
public class HSGTMonthlyBuyStockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //自增id
    private String month; //str	Y	交易日期
    private String dayBuyAmt; //float	Y	当月日均买入成交金额（亿元）
    private String dayBuyVol; //float	Y	当月日均买入成交笔数（万笔）
    private String daySellAmt; //float	Y	当月日均卖出成交金额（亿元）
    private String daySellVol; //float	Y	当月日均卖出成交笔数（万笔）
    private String totalBuyAmt; //float	Y	总买入成交金额（亿元）
    private String totalBuyVol; //float	Y	总买入成交笔数（万笔）
    private String totalSellAmt; //float	Y	总卖出成交金额（亿元）
    private String totalSellVol; //float	Y	总卖出成交笔数（万笔）

}
