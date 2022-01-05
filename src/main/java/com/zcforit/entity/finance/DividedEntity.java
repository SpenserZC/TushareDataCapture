package com.zcforit.entity.finance;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 分红送股
 * @date 2022/1/5 20:30
 */
@Data
@Entity
@Table(name="stock_finance_divided")
public class DividedEntity {
    @Id
    private String tsCode; //str	Y	TS代码
    @Id
    private String endDate; //str	Y	分红年度
    private String annDate; //str	Y	预案公告日
    private String divProc; //str	Y	实施进度
    private String stkDiv; //float	Y	每股送转
    private String stkBoRate; //float	Y	每股送股比例
    private String stkCoRate; //float	Y	每股转增比例
    private String cashDiv; //float	Y	每股分红（税后）
    private String cashDivTax; //float	Y	每股分红（税前）
    private String recordDate; //str	Y	股权登记日
    private String exDate; //str	Y	除权除息日
    private String payDate; //str	Y	派息日
    private String divListdate; //str	Y	红股上市日
    private String impAnnDate; //str	Y	实施公告日
    private String baseDate; //str	N	基准日
    private String baseShare; //float	N	基准股本（万）
}
