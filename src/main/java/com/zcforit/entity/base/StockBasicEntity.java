package com.zcforit.entity.base;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 股票列表
 * @date : 2021-12-05 10:21
 */
@Data
@Entity
@Table(name="basic_stock")
public class StockBasicEntity implements Serializable {
    @Id
    private String symbol;	//str	Y	股票代码
    private String name;	//str	Y	股票名称
    private String area;	//str	Y	地域
    private String industry;	//str	Y	所属行业
    private String fullname;	//str	N	股票全称
    private String enname;	//str	N	英文全称
    private String cnspell;	//str	N	拼音缩写
    private String market;	//str	Y	市场类型（主板/创业板/科创板/CDR）
    private String exchange;	//str	N	交易所代码
    private String currType;	//str	N	交易货币
    private String listStatus;	//str	N	上市状态 L上市 D退市 P暂停上市
    private String listDate;	//str	Y	上市日期
    private String delistDate;	//str	N	退市日期
    private String isHs;	//str	N	是否沪深港通标的，N否 H沪股通 S深股通
}
