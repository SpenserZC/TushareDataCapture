package com.zcforit.entity.fund;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 基金基础信息
 * @date 2022/1/13 14:24
 */
@Data
@Entity
@Table(name = "fund_basic")
public class FundBasicEntity {
    @Id
    private String tsCode; //基金代码
    private String name; //简称
    private String management; //管理人
    private String custodian; //托管人
    private String fundType; //投资类型
    private String foundDate; //成立日期
    private String dueDate; //到期日期
    private String listDate; //上市时间
    private String issueDate; //发行日期
    private String delistDate; //退市日期
    private String issueAmount; //发行份额(亿)
    private String mFee; //管理费
    private String cFee; //托管费
    private String durationYear; //存续期
    private String pValue; //面值
    private String minAmount; //起点金额(万元)
    private String expReturn; //预期收益率
    private String benchmark; //业绩比较基准
    private String status; //存续状态D摘牌 I发行 L已上市
    private String investType; //投资风格
    private String type; //基金类型
    private String trustee; //受托人
    private String purcStartdate; //日常申购起始日
    private String redmStartdate; //日常赎回起始日
    private String market; //E场内O场外
}
