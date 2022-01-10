package com.zcforit.entity.finance;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 主营业务构成
 * @date 2022/1/5 20:37
 */
@Data
//@Entity
//@Table(name="stock_finance_mainbz")
public class FinanceMainbzEntity {
    @Id
    private String tsCode; //str	TS代码
    @Id
    private String endDate; //str	报告期
    private String bzItem; //str	主营业务来源
    private String bzSales; //float	主营业务收入(元)
    private String bzProfit; //float	主营业务利润(元)
    private String bzCost; //float	主营业务成本(元)
    private String currType; //str	货币代码
    private String updateFlag; //str	是否更新
}
