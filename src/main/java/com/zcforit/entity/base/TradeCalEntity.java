package com.zcforit.entity.base;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 交易日历
 * @date 2021/12/13 19:02
 */
@Data
@Entity
@Table(name="stock_base_trade_cal")
public class TradeCalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //自增id
    private String exchange;	 //str	Y	交易所 SSE上交所 SZSE深交所
    private String calDate;	 //str	Y	日历日期
    private String isOpen;	 //str	Y	是否交易 0休市 1交易
    private String pretradeDate;	 //str	Y	上一个交易日
}
