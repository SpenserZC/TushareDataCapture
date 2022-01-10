CREATE TABLE IF NOT EXISTS stock_analysis_hsgt_capital_flows(
    trade_date	date  COMMENT "交易日期",
	ggt_ss float  COMMENT "港股通（上海）",
	ggt_sz float  COMMENT "港股通（深圳）",
	hgt float  COMMENT "沪股通（百万元）",
	sgt float  COMMENT "深股通（百万元）",
	north_money float  COMMENT "北向资金（百万元）",
	south_money float  COMMENT "南向资金（百万元）"
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "沪深港通资金流向";