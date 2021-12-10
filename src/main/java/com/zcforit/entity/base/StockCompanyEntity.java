package com.zcforit.entity.base;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: TODO
 * @date 2021/12/7 11:25
 */
@Data
@Entity
@Table(name="stock_company")
public class StockCompanyEntity {
    @Id
    private String tsCode; //股票代码
    private String exchange; //交易所代码 ，SSE上交所 SZSE深交所
    private String chairman; //法人代表
    private String manager; //总经理
    private String secretary; //董秘
    private String regCapital; //注册资本
    private String setupDate; //注册日期
    private String province; //所在省份
    private String city; //所在城市
    private String introduction; //公司介绍
    private String website; //公司主页
    private String email; //电子邮件
    private String office; //办公室
    private Integer employees; //员工人数
    private String mainBusiness; //主要业务及产品
    private String businessScope; //经营范围
}
