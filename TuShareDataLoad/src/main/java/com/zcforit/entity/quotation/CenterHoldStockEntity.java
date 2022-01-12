package com.zcforit.entity.quotation;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 中央结算系统持股明细
 * @date : 2021-12-26 16:27
 */
@Data
@Entity
@IdClass(QuotationKeys.class)
@Table(name="stock_quotation_center_hold")
public class CenterHoldStockEntity {
    @Id
    private String tradeDate; //str	Y	交易日期
    @Id
    private String tsCode; //str	Y	股票代号
    private String name; //str	Y	股票名称
    private String colParticipantId; //str	Y	参与者编号
    private String colParticipantName; //str	Y	机构名称
    private String colShareholding; //str	Y	持股量(股)
    private String colShareholdingPercent; //str	Y	占已发行股份/权证/单位百分比(%)
}
