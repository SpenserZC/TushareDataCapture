CREATE TABLE IF NOT EXISTS ak_stock_board_industry_name_ths(
    name varchar(100)  COMMENT "名称",
    code varchar(20)  COMMENT "代码",
    primary key (code)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "同花顺行业分类";

CREATE TABLE IF NOT EXISTS ak_stock_board_industry_cons_ths(
    industry_code varchar(20) COMMENT "所属行业代码",
    industry_name varchar(50) COMMENT "所属行业名称",
    code varchar(20) COMMENT "代码",
    name varchar(50) COMMENT "名称",
    price float COMMENT "现价",
    pct_chg float COMMENT "涨跌幅",
    pct float COMMENT "涨跌",
    pct_rate float COMMENT "涨速",
    turnover float COMMENT "换手",
    volume_ratio float COMMENT "量比",
    amp float COMMENT "振幅",
    amount varchar(20) COMMENT "成交额",
    float_share varchar(20) COMMENT "流通股",
    circ_mv varchar(20) COMMENT "流通市值",
    pe varchar(20) COMMENT "市盈率",
    primary key (industry_code,code)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "同花顺行业成份股";

CREATE TABLE IF NOT EXISTS ak_stock_board_industry_index_ths(
    industry_code varchar(20) COMMENT "行业代码",
    `date` varchar(20) COMMENT "日期",
    industry_name varchar(50) COMMENT "行业名称",
    `open`  float comment "开盘价",
    high  float comment "最高价",
    low  float comment "最低价",
    `close`  float comment "收盘价",
    vol  float comment "成交量 （手）",
    amount  float comment "成交额 （千元）",
    primary key (industry_code,`date`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "同花顺行业指数";


