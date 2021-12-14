--基础数据
-- 创建基础信息表
CREATE TABLE IF NOT EXISTS stock_base_basic(
    ts_code char(10)  not null primary key  comment "股票代码",
    symbol char(10) comment "股票代码",
    name char(50)	comment "股票名称",
    area char(20)	comment "地域",
    industry char(30)	comment "所属行业",
    fullname char(100)	comment "股票全称",
    enname char(100)	comment "英文全称",
    cnspell char(20)	comment "拼音缩写",
    market char(10)	comment "市场类型（主板/创业板/科创板/CDR）",
    exchange char(10)	comment "交易所代码",
    curr_type char(10)	comment "交易货币",
    list_status char(2)	comment "上市状态 L上市 D退市 P暂停上市",
    list_date char(10)	comment "上市日期",
    delist_date char(10)	comment "退市日期",
    is_hs char(2)	comment "是否沪深港通标的，N否 H沪股通 S深股通"
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "股票信息表";

-- 创建交易日历
CREATE TABLE IF NOT EXISTS stock_base_trade_cal(
    id int primary key auto_increment,
    exchange char(10) comment "交易所 SSE上交所 SZSE深交所",
    cal_date char(10) comment "日历日期",
    is_open char(10)	comment "是否交易 0休市 1交易",
    pretrade_date char(10)	comment "上一个交易日"
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "交易日历";


-- 创建上市公司
CREATE TABLE IF NOT EXISTS stock_base_company(
    ts_code char(10) comment "股票代码",
    exchange char(10) comment "交易所代码 ，SSE上交所 SZSE深交所",
    chairman char(50) comment "法人代表",
    manager char(50) comment "总经理",
    secretary char(50) comment "董秘",
    reg_capital char(20) comment "注册资本",
    setup_date char(20) comment "注册日期",
    province char(30) comment "所在省份",
    city char(30) comment "所在城市",
    introduction TEXT comment "公司介绍",
    website char(50) comment "公司主页",
    email TEXT comment "电子邮件",
    office char(200) comment "办公室",
    employees int comment "员工人数",
    main_business TEXT comment "主要业务及产品",
    business_scope TEXT comment "经营范围"
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "上市公司基本信息表";




--行情数据
-- 创建日线行情
CREATE TABLE IF NOT EXISTS stock_quotation_daily(
 	id int primary key auto_increment,
    ts_code  varchar(10) comment "股票代码",
	trade_date datetime comment "交易日期",
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
    trade_date datetime comment "交易日期",
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
    trade_date datetime comment "交易日期",
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

-- 创建每日指标
CREATE TABLE IF NOT EXISTS stock_quotation_daily_indicator(
    id int primary key auto_increment,
    ts_code  varchar(10) comment "股票代码",
    trade_date datetime comment "交易日期",
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


CREATE TABLE IF NOT EXISTS stock_quotation_capital_flows(
    id int primary key auto_increment,
    ts_code  varchar(10) comment "股票代码",
    trade_date datetime comment "交易日期",
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




CREATE TABLE IF NOT EXISTS tushare_error_log(
    id int primary key auto_increment,
    api_name varchar(50),
    `key` varchar(50),
    exception_info TEXT
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "tushare异常表";




