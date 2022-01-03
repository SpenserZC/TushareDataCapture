package com.zcforit.entity.quotation;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 涨跌停
 * @date 2021/12/11 16:49
 */
@Data
@Entity
@Table(name="stock_quotation_limit_list")
public class LimitListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //自增id
    private String tradeDate; 	//str	Y	交易日期
    private String tsCode; 	//str	Y	股票代码
    private String name; 	//str	Y	股票名称
    private String close; 	//float	Y	收盘价
    private String pctChg; 	//float	Y	涨跌幅
    private String amp; 	//float	Y	振幅
    private String fcRatio; 	//float	Y	封单金额/日成交金额
    private String flRatio; 	//float	Y	封单手数/流通股本
    private String fdAmount; 	//float	Y	封单金额
    private String firstTime; 	//str	Y	首次涨停时间
    private String lastTime; 	//str	Y	最后封板时间
    private String openTimes; 	//int	Y	打开次数
    private String strth; 	//float	Y	涨跌停强度
    @Column(name="`limit`")
    private String limit; 	//str	Y	D跌停U涨停
}
