package com.zcforit.entity.quotation;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 沪深通十大成交
 * @date 2021/12/11 15:44
 */
@Data
@Entity
@IdClass(QuotationKeys.class)
@Table(name="stock_quotation_hsgt_capital_flows_top10")
public class HSTCapitalFlowsTop10Entity {
    @Id
    private String tradeDate; //str	交易日期
    @Id
    private String tsCode; //str	股票代码
    private String name; //str	股票名称
    @Column(name="`close`")
    private String close; //float	收盘价
    @Column(name="`change`")
    private String change; //float	涨跌额
    @Column(name="`rank`")
    private String rank; //int	资金排名
    private String marketType; //str	市场类型（1：沪市 3：深市）
    private String amount; //float	成交金额（元）
    private String netAmount; //float	净成交金额（元）
    @Column(name="`buy`")
    private String buy; //float	买入金额（元）
    @Column(name="`sell`")
    private String sell; //float	卖出金额（元）
}
