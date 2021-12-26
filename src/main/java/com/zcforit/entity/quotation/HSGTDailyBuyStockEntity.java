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
@Table(name="")
public class HSGTDailyBuyStockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //自增id
    private String tradeDate; //str	Y	交易日期
    private String buyAmount; //float	Y	买入成交金额（亿元）
    private String buyVolume; //float	Y	买入成交笔数（万笔）
    private String sellAmount; //float	Y	卖出成交金额（亿元）
    private String sellVolume; //float	Y	卖出成交笔数（万笔）
}
