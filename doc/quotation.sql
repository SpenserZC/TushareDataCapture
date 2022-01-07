--行情数据
-- 创建日线行情
CREATE TABLE IF NOT EXISTS stock_quotation_daily(
 	id int primary key auto_increment,
    ts_code  varchar(10) comment "股票代码",
	trade_date date comment "交易日期",
	`open`  float comment "开盘价",
	high  float comment "最高价",
	low  float comment "最低价",
	`close`  float comment "收盘价",
	pre_close  float comment "昨收价",
	`change` float comment "涨跌额",
	pct_chg  float comment "涨跌幅 （未复权，如果是复权请用 通用行情接口 ）",
	vol  float comment "成交量 （手）",
	amount  float comment "成交额 （千元）"
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "K线日线表";

-- 创建周线行情
CREATE TABLE IF NOT EXISTS stock_quotation_weekly(
    id int primary key auto_increment,
    ts_code  varchar(10) comment "股票代码",
    trade_date date comment "交易日期",
    `open`  float comment "开盘价",
    high  float comment "最高价",
    low  float comment "最低价",
    `close`  float comment "收盘价",
    pre_close  float comment "昨收价",
    `change` float comment "涨跌额",
    pct_chg  float comment "涨跌幅 （未复权，如果是复权请用 通用行情接口 ）",
    vol  float comment "成交量 （手）",
    amount  float comment "成交额 （千元）"
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "K线日线表";

-- 创建月线行情
CREATE TABLE IF NOT EXISTS stock_quotation_monthly(
    id int primary key auto_increment,
    ts_code  varchar(10) comment "股票代码",
    trade_date date comment "交易日期",
    `open`  float comment "开盘价",
    `high`  float comment "最高价",
    `low`  float comment "最低价",
    `close`  float comment "收盘价",
    pre_close  float comment "昨收价",
    `change` float comment "涨跌额",
    pct_chg  float comment "涨跌幅 （未复权，如果是复权请用 通用行情接口 ）",
    vol  float comment "成交量 （手）",
    amount  float comment "成交额 （千元）"
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "K线日线表";

-- 创建每日指标
CREATE TABLE IF NOT EXISTS stock_quotation_daily_indicator(
    id int primary key auto_increment,
    ts_code  varchar(10) comment "股票代码",
    trade_date date comment "交易日期",
    `close` float comment"当日收盘价",
    turnover_rate float comment"换手率（%）",
    turnover_rate_f float comment"换手率（自由流通股）",
    volume_ratio float comment"量比",
    pe float comment"市盈率（总市值/净利润， 亏损的PE为空）",
    pe_ttm float comment"市盈率（TTM，亏损的PE为空）",
    pb float comment"市净率（总市值/净资产）",
    ps float comment"市销率",
    ps_ttm float comment"市销率（TTM）",
    dv_ratio float comment"股息率 （%）",
    dv_ttm float comment"股息率（TTM）（%）",
    total_share float comment"总股本 （万股）",
    float_share float comment"流通股本 （万股）",
    free_share float comment"自由流通股本 （万）",
    total_mv float comment"总市值 （万元）",
    circ_mv float comment"流通市值（万元）"
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "每日指标";

-- 个股资金流
CREATE TABLE IF NOT EXISTS stock_quotation_capital_flows(
    id int primary key auto_increment,
    ts_code  varchar(10) comment "股票代码",
    trade_date date comment "交易日期",
    buy_sm_vol  int comment "小单买入量（手）",
    buy_sm_amount   float comment "小单买入金额（万元）",
    sell_sm_vol int comment "小单卖出量（手）",
    sell_sm_amount  float comment "小单卖出金额（万元）",
    buy_md_vol  int comment "中单买入量（手）",
    buy_md_amount   float comment "中单买入金额（万元）",
    sell_md_vol int comment "中单卖出量（手）",
    sell_md_amount  float comment "中单卖出金额（万元）",
    buy_lg_vol  int comment "大单买入量（手）",
    buy_lg_amount   float comment "大单买入金额（万元）",
    sell_lg_vol int comment "大单卖出量（手）",
    sell_lg_amount  float comment "大单卖出金额（万元）",
    buy_elg_vol int comment "特大单买入量（手）",
    buy_elg_amount  float comment "特大单买入金额（万元）",
    sell_elg_vol    int comment "特大单卖出量（手）",
    sell_elg_amount float comment "特大单卖出金额（万元）",
    net_mf_vol  int comment "净流入量（手）",
    net_mf_amount   float comment "净流入额（万元）"
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "个股资金流向";



--个股涨跌停统计
CREATE TABLE IF NOT EXISTS stock_quotation_limit_list(
    id int primary key auto_increment,
    trade_date date  comment "交易日期",
	ts_code  varchar(10)  comment "股票代码",
	`name`  varchar(100)  comment "股票名称",
	`close` float comment "收盘价",
	pct_chg float comment "涨跌幅",
	amp float comment "振幅",
	fc_ratio float comment "封单金额/日成交金额",
	fl_ratio float comment "封单手数/流通股本",
	fd_amount float comment "封单金额",
	first_time	TIME comment "首次涨停时间",
	last_time TIME comment "最后封板时间",
	open_times	int comment "打开次数",
	strth float comment "涨跌停强度",
	`limit`  varchar(10)  comment "D跌停U涨停"
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "涨跌停统计";

--沪深港通资金流向
CREATE TABLE IF NOT EXISTS stock_quotation_hsgt_capital_flows(
    id int primary key auto_increment,
    trade_date	date  COMMENT "交易日期",
	ggt_ss float  COMMENT "港股通（上海）",
	ggt_sz float  COMMENT "港股通（深圳）",
	hgt float  COMMENT "沪股通（百万元）",
	sgt float  COMMENT "深股通（百万元）",
	north_money float  COMMENT "北向资金（百万元）",
	south_money float  COMMENT "南向资金（百万元）"
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "沪深港通资金流向";


--沪深通资金流向十大成交
CREATE TABLE IF NOT EXISTS stock_quotation_hsgt_capital_flows_top10(
    id int primary key auto_increment,
   	trade_date	date  COMMENT "交易日期",
	ts_code  varchar(20)  COMMENT "股票代码",
	`name` varchar(30)  COMMENT "股票名称",
	`close` float  COMMENT "收盘价",
	`change` float  COMMENT "涨跌额",
	`rank`	int  COMMENT "资金排名",
	market_type  varchar(20)  COMMENT "市场类型（1：沪市 3：深市）",
	amount float  COMMENT "成交金额（元）",
	net_amount float  COMMENT "净成交金额（元）",
	buy float  COMMENT "买入金额（元）",
	sell float  COMMENT "卖出金额（元）"
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "沪深港通资金流向十大成交";

--港股通通资金流向十大成交
CREATE TABLE IF NOT EXISTS stock_quotation_ggt_capital_flows_top10(
    id int primary key auto_increment,
   	trade_date date COMMENT "交易日期",
	ts_code  varchar(20) COMMENT "股票代码",
	`name` varchar(30) COMMENT "股票名称",
	`close` float COMMENT "收盘价",
	p_change float COMMENT "涨跌幅",
	`rank` varchar(10)  COMMENT "资金排名",
	market_type  varchar(10) COMMENT "市场类型 2：港股通（沪） 4：港股通（深）",
	amount float  COMMENT "累计成交金额（元）",
	net_amount float  COMMENT "净买入金额（元）",
	sh_amount float  COMMENT "沪市成交金额（元）",
	sh_net_amount float  COMMENT "沪市净买入金额（元）",
	sh_buy float  COMMENT "沪市买入金额（元）",
	sh_sell float  COMMENT "沪市卖出金额",
	sz_amount float  COMMENT "深市成交金额（元）",
	sz_net_amount float  COMMENT "深市净买入金额（元）",
	sz_buy float  COMMENT "深市买入金额（元）",
	sz_sell float  COMMENT "深市卖出金额（元）"
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "港股通资金流向十大成交";

--沪深港股通持股明细
CREATE TABLE IF NOT EXISTS stock_quotation_hsgt_hold_stock(
    id int primary key auto_increment,
   	`code` varchar(20)  COMMENT "原始代码",
	trade_date date  COMMENT "交易日期",
	ts_code varchar(20)  COMMENT "TS代码",
	`name` varchar(100)  COMMENT "股票名称",
	vol BIGINT  COMMENT "持股数量(股)",
	ratio float  COMMENT "持股占比（%），占已发行股份百分比",
	exchange varchar(10)  COMMENT "类型：SH沪股通SZ深股通HK港股通"
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "沪深港股通持股明细";

--港股通每日成交统计
CREATE TABLE IF NOT EXISTS stock_quotation_hsgt_daily_buy(
    id int primary key auto_increment,
   	trade_date	date  COMMENT "交易日期",
	buy_amount float  COMMENT "买入成交金额（亿元）",
	buy_volume float  COMMENT "买入成交笔数（万笔）",
	sell_amount float  COMMENT "卖出成交金额（亿元）",
	sell_volume float  COMMENT "卖出成交笔数（万笔）"
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "港股通每日成交统计";


--港股通每月成交统计
CREATE TABLE IF NOT EXISTS stock_quotation_hsgt_monthly_buy(
    id int primary key auto_increment,
   	`month`	date COMMENT "交易日期",
	day_buy_amt float COMMENT "当月日均买入成交金额（亿元）",
	day_buy_vol float COMMENT "当月日均买入成交笔数（万笔）",
	day_sell_amt float COMMENT "当月日均卖出成交金额（亿元）",
	day_sell_vol float COMMENT "当月日均卖出成交笔数（万笔）",
	total_buy_amt float COMMENT "总买入成交金额（亿元）",
	total_buy_vol float COMMENT "总买入成交笔数（万笔）",
	total_sell_amt float COMMENT "总卖出成交金额（亿元）",
	total_sell_vol float COMMENT "总卖出成交笔数（万笔）"
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "港股通每月成交统计";

--中央结算系统持股明细
CREATE TABLE IF NOT EXISTS stock_quotation_center_hold(
    id int primary key auto_increment,
    trade_date	date COMMENT "交易日期",
	ts_code  varchar(20) COMMENT "股票代号",
	`name`  varchar(100) COMMENT "股票名称",
	col_participant_id  varchar(100) COMMENT "参与者编号",
	col_participant_name  varchar(100) COMMENT "机构名称",
	col_shareholding  varchar(20) COMMENT "持股量(股)",
	col_shareholding_percent varchar(20) COMMENT "占已发行股份/权证/单位百分比(%)"
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "中央结算系统持股明细";





