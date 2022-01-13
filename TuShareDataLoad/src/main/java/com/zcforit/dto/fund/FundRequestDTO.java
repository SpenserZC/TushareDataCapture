package com.zcforit.dto.fund;

import lombok.Data;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 基金请求参数
 * @date : 2022-01-13 21:47
 */
@Data
public class FundRequestDTO {
    private String apiName;
    private String market; //	str	N	交易市场: E场内 O场外（默认E）
    private String status;	//str	N	存续状态 D摘牌 I发行 L上市中
    private Integer offset; //	intint	N	开始行数
    private Integer limit; //	int	N	每页行数
}
