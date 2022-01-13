package com.zcforit.entity.fund;

import com.zcforit.entity.keys.AnnDateKeys;
import com.zcforit.entity.keys.TradeDateKeys;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 基金净值
 * @date 2022/1/13 14:36
 */
@Data
@Entity
@IdClass(AnnDateKeys.class)
@Table(name="fund_nav")
public class FundNavEntity {
    @Id
    private String tsCode; //TS代码
    @Id
    private String annDate; //公告日期
    private String navDate; //净值日期
    private String unitNav; //单位净值
    private String accumNav; //累计净值
    private String accumDiv; //累计分红
    private String netAsset; //资产净值
    private String totalNetasset; //合计资产净值
    private String adjNav; //复权单位净值
}
