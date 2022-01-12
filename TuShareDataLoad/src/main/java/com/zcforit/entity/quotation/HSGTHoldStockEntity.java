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
@IdClass(QuotationKeys.class)
@Table(name="stock_quotation_hsgt_hold_stock")
public class HSGTHoldStockEntity {
    @Id
    private String tradeDate; //str	Y	交易日期
    @Id
    private String tsCode; //str	Y	TS代码
    private String code; //str	Y	原始代码
    private String name; //str	Y	股票名称
    private String vol; //int	Y	持股数量(股)
    private String ratio; //float	Y	持股占比（%），占已发行股份百分比
    private String exchange; //str	Y	类型：SH沪股通SZ深股通HK港股通
}
