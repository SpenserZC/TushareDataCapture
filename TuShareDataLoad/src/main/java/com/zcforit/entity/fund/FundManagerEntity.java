package com.zcforit.entity.fund;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 基金代码
 * @date 2022/1/13 14:30
 */
@Data
@Entity
@Table(name = "fund_manager")
public class FundManagerEntity {
    @Id
    private String tsCode; //基金代码
    private String annDate; //公告日期
    private String name; //基金经理姓名
    private String gender; //性别
    private String birthYear; //出生年份
    private String edu; //学历
    private String nationality; //国籍
    private String beginDate; //任职日期
    private String endDate; //离任日期
    private String resume; //简历
}
