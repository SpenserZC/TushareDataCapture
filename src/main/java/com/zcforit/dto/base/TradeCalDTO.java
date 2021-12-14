package com.zcforit.dto.base;

import lombok.Data;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 交易日历
 * @date 2021/12/13 19:00
 */
@Data
public class TradeCalDTO {
    private String apiName = "trade_cal";
    private String exchange;//str	N	交易所 SSE上交所,SZSE深交所,CFFEX 中金所,SHFE 上期所,CZCE 郑商所,DCE 大商所,INE 上能源
    private String startDate;//str	N	开始日期 （格式：YYYYMMDD 下同）
    private String endDate;//str	N	结束日期
    private String isOpen;//str	N	是否交易 '0'休市 '1'交易
}
