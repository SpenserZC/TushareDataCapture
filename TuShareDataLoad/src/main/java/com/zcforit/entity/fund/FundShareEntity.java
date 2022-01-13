package com.zcforit.entity.fund;

import com.zcforit.entity.keys.AnnDateKeys;
import com.zcforit.entity.keys.TradeDateKeys;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 基金分红
 * @date 2022/1/13 14:32
 */
@Data
@Entity
@IdClass(TradeDateKeys.class)
@Table(name = "fund_share")
public class FundShareEntity {
    @Id
    private String tsCode; //基金代码，支持多只基金同时提取，用逗号分隔
    @Id
    private String tradeDate; //交易（变动）日期，格式YYYYMMDD
    private String fdShare; //基金份额（万）
}
