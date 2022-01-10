package com.zcforit.entity.finance;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 财务审计
 * @date 2022/1/5 20:33
 */
@Data
//@Entity
//@Table(name="stock_finance_audit")
public class FinanceAuditEntity {
    @Id
    private String tsCode; //str	TS股票代码
    @Id
    private String endDate; //str	报告期
    private String annDate; //str	公告日期
    private String auditResult; //str	审计结果
    private String auditFees; //float	审计总费用（元）
    private String auditAgency; //str	会计事务所
    private String auditSign; //str	签字会计师
}
