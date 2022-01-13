package com.zcforit.entity.finance;

import com.zcforit.entity.keys.EndDateKeys;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 业绩预告
 * @date 2022/1/5 20:20
 */
@Data
@Entity
@IdClass(EndDateKeys.class)
@Table(name="stock_finance_forecast")
public class ForecastEntity {
    @Id
    private String tsCode; //str	TS股票代码
    @Id
    private String endDate; //str	报告期
    private String annDate; //str	公告日期
    private String type; //str	业绩预告类型(预增/预减/扭亏/首亏/续亏/续盈/略增/略减)
    private String pChangeMin; //float	预告净利润变动幅度下限（%）
    private String pChangeMax; //float	预告净利润变动幅度上限（%）
    private String netProfitMin; //float	预告净利润下限（万元）
    private String netProfitMax; //float	预告净利润上限（万元）
    private String lastParentNet; //float	上年同期归属母公司净利润
    private String firstAnnDate; //str	首次公告日
    private String summary; //str	业绩预告摘要
    private String changeReason; //str	业绩变动原因
}
