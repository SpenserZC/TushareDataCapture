package com.zcforit.entity.quotation;

import com.zcforit.entity.finance.IdKeys;
import lombok.Data;

import javax.persistence.*;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: TODO
 * @date 2021/12/11 15:06
 */
@Data
@Entity
@IdClass(QuotationKeys.class)
@Table(name="stock_quotation_monthly")
public class MonthlyInfoEntity {
    @Id
    private String tsCode; //str	股票代码
    @Id
    private String tradeDate; //str	交易日期
    @Column(name="`open`")
    private String open; //float	开盘价
    private String high; //float	最高价
    private String low; //float	最低价
    @Column(name="`close`")
    private String close; //float	收盘价
    private String preClose; //float	昨收价
    @Column(name="`change`")
    private String change; //float	涨跌额
    private String pctChg; //float	涨跌幅 （未复权，如果是复权请用 通用行情接口 ）
    private String vol; //float	成交量 （手）
    private String amount; //float	成交额 （千元）
}
