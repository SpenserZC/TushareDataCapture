package com.zcforit.entity.fund;

import com.zcforit.entity.keys.AnnDateKeys;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 公募基金持仓
 * @date 2022/1/13 14:45
 */
@Data
@Entity
@IdClass(AnnDateKeys.class)
@Table(name = "fund_portfolio")
public class FundPortfolio {
    @Id
    private String tsCode; //TS基金代码
    @Id
    private String annDate; //公告日期
    private String endDate; //截止日期
    private String symbol; //股票代码
    private String mkv; //持有股票市值(元)
    private String amount; //持有股票数量（股）
    private String stkMkvRatio; //占股票市值比
    private String stkFloatRatio; //占流通股本比例
}
