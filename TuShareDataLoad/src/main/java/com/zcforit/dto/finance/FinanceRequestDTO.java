package com.zcforit.dto.finance;

import lombok.Data;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 财务数据请求
 * @date 2022/1/5 20:05
 */
@Data
public class FinanceRequestDTO {
    private String apiName;
    private String tsCode; //str	Y	股票代码
    private String annDate; //str	N	公告日期(YYYYMMDD格式，下同)
    private String startDate; //str	N	公告开始日期
    private String endDate; //str	N	公告结束日期
    private String period; //str	N	报告期(每个季度最后一天的日期，比如20171231表示年报)
    private String reportType; //str	N	报告类型：见下方详细说明
    private String compType; //str	N	公司类型：1一般工商业 2银行 3保险 4证券
    private String endType; //str	N	报告期编号 （1~4表示季度，e.g. 4表示年报）
}
