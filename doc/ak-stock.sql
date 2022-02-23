 CREATE TABLE IF NOT EXISTS ak_stock_a_summary(
	trade_date date  COMMENT "报告时间",
	market varchar(20) COMMENT "市场",
	listed_cnt int  COMMENT "挂牌数",
	total_mv float  COMMENT "总市值",
	circ_mv float  COMMENT "流通市值",
	average_pe float  COMMENT "平均市盈率",
	vol float  COMMENT "成交量",
	amount float  COMMENT "成交金额",
	turnover_rate float  COMMENT "换手率",
	circ_turnover_rate float  COMMENT "流通换手率",
	primary key (trade_date,market)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "A股总览";