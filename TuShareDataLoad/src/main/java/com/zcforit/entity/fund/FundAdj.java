package com.zcforit.entity.fund;

import com.zcforit.entity.keys.EndDateKeys;
import com.zcforit.entity.keys.TradeDateKeys;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 基金复权因子
 * @date 2022/1/13 14:50
 */
@Data
@Entity
@IdClass(TradeDateKeys.class)
@Table(name="fund_adj")
public class FundAdj {
    @Id
    private String tsCode; //ts基金代码
    @Id
    private String tradeDate; //交易日期
    private String adjFactor; //复权因子
}
