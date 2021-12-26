package com.zcforit.entity.quotation;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 港通十大成交
 * @date 2021/12/11 15:44
 */
@Data
@Entity
@Table(name="")
public class CapitalFlowsGTTop10Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //自增id
    private String tradeDate; //str	交易日期
    private String tsCode; //str	股票代码
    private String name; //str	股票名称
    private String close; //float	收盘价
    private String pChange; //float	涨跌幅
    private String rank; //str	资金排名
    private String marketType; //str	市场类型 2：港股通（沪） 4：港股通（深）
    private String amount; //float	累计成交金额（元）
    private String netAmount; //float	净买入金额（元）
    private String shAmount; //float	沪市成交金额（元）
    private String shNetAmount; //float	沪市净买入金额（元）
    private String shBuy; //float	沪市买入金额（元）
    private String shSell; //float	沪市卖出金额
    private String szAmount; //float	深市成交金额（元）
    private String szNetAmount; //float	深市净买入金额（元）
    private String szBuy; //float	深市买入金额（元）
    private String szSell; //float	深市卖出金额（元）
}
