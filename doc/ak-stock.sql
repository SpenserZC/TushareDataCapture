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

 CREATE TABLE IF NOT EXISTS ak_stock_money_flow_industry_ths(
     trade_date date  COMMENT "报告时间",
     industry_name varchar(20) COMMENT "行业",
     industry_price float  COMMENT "行业指数",
     change_quote varchar(20) COMMENT "行业-涨跌幅注意单位: %",
     in_flows float  COMMENT "流入资金 注意单位: 亿",
     out_flows float  COMMENT "流出资金 注意单位: 亿",
     net_amount float  COMMENT "净额	注意单位: 亿",
     stock_cnt float  COMMENT "公司家数",
     stock_top varchar(20) COMMENT "领涨股",
     stock_change varchar(20) COMMENT "领涨股-涨跌幅 注意单位: %",
     stock_price float  COMMENT "当前价",
     primary key (trade_date,industry_name)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "行业资金流向";



 CREATE TABLE IF NOT EXISTS ak_stock_money_flow_stock_ths(
     trade_date date  COMMENT "报告时间",
     stock_code  varchar(20) COMMENT "股票代码",
     stock_name  varchar(20) COMMENT "股票简称",
     price float  COMMENT "最新价",
     change_quote  varchar(20) COMMENT "涨跌幅 注意单位: %",
     turnover_rate  varchar(20) COMMENT "换手率",
     in_flows float  COMMENT "流入资金 注意单位: 元",
     out_flows float  COMMENT "流出资金 注意单位: 元",
     net_amount float  COMMENT "净额 注意单位: 元",
     trade_amount float  COMMENT "成交额 注意单位: 元",
     primary key (trade_date,stock_code)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "个股资金流向";

