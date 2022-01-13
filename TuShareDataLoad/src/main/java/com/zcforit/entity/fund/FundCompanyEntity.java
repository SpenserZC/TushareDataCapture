package com.zcforit.entity.fund;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 基金公司
 * @date 2022/1/13 14:28
 */
@Data
@Entity
@Table(name = "fund_company")
public class FundCompanyEntity {
    @Id
    private String name; //基金公司名称
    private String shortname; //简称
    private String shortEnname; //英文缩写
    private String province; //省份
    private String city; //城市
    private String address; //注册地址
    private String phone; //电话
    private String office; //办公地址
    private String website; //公司网址
    private String chairman; //法人代表
    private String manager; //总经理
    private String regCapital; //注册资本
    private String setupDate; //成立日期
    private String endDate; //公司终止日期
    private String employees; //员工总数
    private String mainBusiness; //主要产品及业务
    private String orgCode; //组织机构代码
    private String creditCode; //统一社会信用代码
}
