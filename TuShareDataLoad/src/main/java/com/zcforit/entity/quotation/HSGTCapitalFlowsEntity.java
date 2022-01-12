package com.zcforit.entity.quotation;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 沪深港通资金流向
 * @date 2021/12/11 15:44
 */
@Data
@Entity
@Table(name="stock_quotation_hsgt_capital_flows")
public class HSGTCapitalFlowsEntity {
    @Id
    private String tradeDate; //str	交易日期
    private String ggtSs; //float	港股通（上海）
    private String ggtSz; //float	港股通（深圳）
    private String hgt; //float	沪股通（百万元）
    private String sgt; //float	深股通（百万元）
    private String northMoney; //float	北向资金（百万元）
    private String southMoney; //float	南向资金（百万元）
}
