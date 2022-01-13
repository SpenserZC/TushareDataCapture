package com.zcforit.entity.keys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

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
public class EndDateKeys implements Serializable {
    protected String tsCode;
    protected String endDate;
}
