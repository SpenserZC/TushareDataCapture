package com.zcforit.dto.quotation;

import lombok.Data;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 日线行情请求信息
 * @date 2021/12/9 16:54
 */
@Data
public class DailyInfoDTO {
    private  String apiName="daily";
    private String tsCode; //str	N	股票代码（支持多个股票同时提取，逗号分隔）
    private String tradeDate; //str	N	交易日期（YYYYMMDD）
    private String startDate; //str	N	开始日期(YYYYMMDD)
    private String endDate; //str	N	结束日期(YYYYMMDD)
}
