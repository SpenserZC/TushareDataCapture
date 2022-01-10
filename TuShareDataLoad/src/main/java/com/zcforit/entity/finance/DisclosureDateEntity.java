package com.zcforit.entity.finance;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 财报披露计划
 * @date 2022/1/5 20:42
 */
@Data
//@Entity
//@Table(name="stock_finance_disclosure_date")
public class DisclosureDateEntity {
    @Id
    private String tsCode; //str	Y	TS代码
    @Id
    private String endDate; //str	Y	报告期
    private String annDate; //str	Y	最新披露公告日
    private String preDate; //str	Y	预计披露日期
    private String actualDate; //str	Y	实际披露日期
    private String modifyDate; //str	N	披露日期修正记录
}
