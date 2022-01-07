package com.zcforit.entity.base;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 新股上市
 * @date 2022/1/7 19:33
 */
@Data
@Entity
@Table(name="stock_base_ipo_new")
public class StockNewShareEntity {
    @Id
    private String tsCode;  //str Y   TS股票代码
    private String subCode;     //str Y   申购代码
    private String name;     //str Y   名称
    private String ipoDate;     //str Y   上网发行日期
    private String issueDate;   //str Y   上市日期
    private String amount;   //float   Y   发行总量（万股）
    private String marketAmount;    //float   Y   上网发行总量（万股）
    private String price;    //float   Y   发行价格
    private String pe;   //float   Y   市盈率
    private String limitAmount;     //float   Y   个人申购上限（万股）
    private String funds;    //float   Y   募集资金（亿元）
    private String ballot;   //float   Y   中签率
}
