package com.zcforit.entity.quotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 联合主键
 * @date 2022/1/12 14:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class QuotationKeys implements Serializable {
    protected String tsCode;
    protected String tradeDate;
}
