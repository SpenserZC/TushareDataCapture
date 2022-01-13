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
 * @description: 分红
 * @date 2022/1/13 14:43
 */
@Data
@Entity
@IdClass(AnnDateKeys.class)
@Table(name="fund_div")
public class FundDiv {
    @Id
    private String tsCode;  //TS代码
    @Id
    private String annDate;  //公告日期
    private String impAnndate;  //分红实施公告日
    private String baseDate;  //分配收益基准日
    private String divProc;  //方案进度
    private String recordDate;  //权益登记日
    private String exDate;  //除息日
    private String payDate;  //派息日
    private String earpayDate;  //收益支付日
    private String netExDate;  //净值除权日
    private String divCash;  //每股派息(元)
    private String baseUnit;  //基准基金份额(万份)
    private String earDistr;  //可分配收益(元)
    private String earAmount;  //收益分配金额(元)
    private String accountDate;  //红利再投资到账日
    private String baseYear;  //份额基准年度
}
