package com.zcforit.entity.quotation;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 资金流数据
 * @date 2021/12/11 15:44
 */
@Data
@Entity
@Table(name="stock_quotation_capital_flows")
public class CapitalFlowsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //自增id
    private String tsCode; //str Y   TS代码
    private String tradeDate; //str Y   交易日期
    private String buySmVol; //int Y   小单买入量（手）
    private String buySmAmount; //float   Y   小单买入金额（万元）
    private String sellSmVol; //int Y   小单卖出量（手）
    private String sellSmAmount; //float   Y   小单卖出金额（万元）
    private String buyMdVol; //int Y   中单买入量（手）
    private String buyMdAmount; //float   Y   中单买入金额（万元）
    private String sellMdVol; //int Y   中单卖出量（手）
    private String sellMdAmount; //float   Y   中单卖出金额（万元）
    private String buyLgVol; //int Y   大单买入量（手）
    private String buyLgAmount; //float   Y   大单买入金额（万元）
    private String sellLgVol; //int Y   大单卖出量（手）
    private String sellLgAmount; //float   Y   大单卖出金额（万元）
    private String buyElgVol; //int Y   特大单买入量（手）
    private String buyElgAmount; //float   Y   特大单买入金额（万元）
    private String sellElgVol; //int Y   特大单卖出量（手）
    private String sellElgAmount; //float   Y   特大单卖出金额（万元）
    private String netMfVol; //int Y   净流入量（手）
    private String netMfAmount; //float   Y   净流入额（万元）
}
