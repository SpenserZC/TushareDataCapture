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
@Table(name="")
public class CapitalFlowsHSTTop10Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //自增id
    private String tradeDate; //str	交易日期
    private String tsCode; //str	股票代码
    private String name; //str	股票名称
    private String close; //float	收盘价
    private String change; //float	涨跌额
    private String rank; //int	资金排名
    private String marketType; //str	市场类型（1：沪市 3：深市）
    private String amount; //float	成交金额（元）
    private String netAmount; //float	净成交金额（元）
    private String buy; //float	买入金额（元）
    private String sell; //float	卖出金额（元）
}
