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


CREATE TABLE `ak_stock_zdt_zt_pool_em` (
    `date` date  NOT NULL COMMENT '时间',
    `stock_code` varchar(10) NOT NULL  COMMENT '代码',
    `stock_name` varchar(30) DEFAULT NULL COMMENT '名称',
    `change_quote` double DEFAULT NULL COMMENT '涨跌幅',
    `latest_price` float DEFAULT NULL COMMENT '最新价',
    `turnover` double DEFAULT NULL COMMENT '成交额',
    `circulation_market_value` double DEFAULT NULL COMMENT '流通市值',
    `total_market_value` double DEFAULT NULL COMMENT '总市值',
    `turnover_rate` float DEFAULT NULL COMMENT '换手率',
    `limit_up_amount` float DEFAULT NULL COMMENT '封板资金',
    `first_limit_up_time` time DEFAULT NULL COMMENT '首次封板时间',
    `last_limit_up_time` time DEFAULT NULL COMMENT '最后封板时间',
    `limit_up_fail_cnt` int DEFAULT NULL COMMENT '炸板次数',
    `limit_up_cnt` varchar(10) DEFAULT NULL COMMENT '涨停统计',
    `limit_up_continuous_cnt` int DEFAULT NULL COMMENT '连板数',
    `industry` varchar(30) DEFAULT NULL COMMENT '所属行业',
    PRIMARY KEY (`date`,`stock_code`)
) ENGINE=InnoDB AUTO_INCREMENT=30071 DEFAULT CHARSET=utf8


CREATE TABLE `ak_stock_zdt_dt_pool_em` (
    `date` date  NOT NULL COMMENT '时间',
    `stock_code` varchar(10) NOT NULL COMMENT '代码',
    `stock_name` varchar(30) DEFAULT NULL COMMENT '名称',
    `change_quote` double DEFAULT NULL COMMENT '涨跌幅',
    `latest_price` float DEFAULT NULL COMMENT '最新价',
    `turnover` double DEFAULT NULL COMMENT '成交额',
    `circulation_market_value` double DEFAULT NULL COMMENT '流通市值',
    `total_market_value` double DEFAULT NULL COMMENT '总市值',
    `leading_pe` float DEFAULT NULL COMMENT '动态市盈率',
    `turnover_rate` float DEFAULT NULL COMMENT '换手率',
    `limit_down_amount` float DEFAULT NULL COMMENT '封板资金',
    `last_limit_down_time` time DEFAULT NULL COMMENT '最后封板时间',
    `limit_down_mount` float DEFAULT NULL COMMENT '板上成交额',
    `limit_down_continuous_cnt` int DEFAULT NULL COMMENT '连续跌停数',
    `limit_down_fail_cnt` int  DEFAULT NULL COMMENT '开板次数',
    `industry` varchar(30) DEFAULT NULL COMMENT '所属行业',
    PRIMARY KEY (`date`,`stock_code`)
) ENGINE=InnoDB AUTO_INCREMENT=30071 DEFAULT CHARSET=utf8



CREATE TABLE `ak_stock_ansysis_zdt_em` (
   `date` date  NOT NULL COMMENT '时间',
   zt_cnt int COMMENT '涨停数量',
   dt_cnt int COMMENT '跌停数量',
   PRIMARY KEY (`date`)
) ENGINE=InnoDB AUTO_INCREMENT=30071 DEFAULT CHARSET=utf8

INSERT into ak_stock_ansysis_zdt_em 
select s.`date`,COUNT(DISTINCT(codea)) as zt,COUNT(DISTINCT(codeb)) as dt 
	from (
		select 
			a.`date`,
			a.stock_code codea,
			b.stock_code codeb
		from ak_stock_zdt_zt_pool_em a left join 
			ak_stock_zdt_dt_pool_em b on a.`date` =b.`date` 
				UNION 
		select 
			a.`date`,
			a.stock_code codea,
			b.stock_code codeb
		from ak_stock_zdt_zt_pool_em a right join 
			ak_stock_zdt_dt_pool_em b on a.`date` =b.`date` 
	)s GROUP BY s.`date` HAVING `date` = '2022-02-23'





CREATE TABLE `ak_stock_ansysis_market_zd_em` (
   `date` date  NOT NULL COMMENT '时间',
   `stock_code` varchar(10) NOT NULL COMMENT '代码',
   `pct_chg_mode` int COMMENT '涨跌幅',
   PRIMARY KEY (`date`,`stock_code`)
) ENGINE=InnoDB AUTO_INCREMENT=30071 DEFAULT CHARSET=utf8


INSERT into 
	ak_stock_ansysis_market_zd_em 
select 
	trade_date as `date`,
	SUBSTRING(ts_code,1,6) as stock_code,
	 CASE
	WHEN pct_chg BETWEEN 0 AND 2 THEN 1
	WHEN pct_chg BETWEEN 2 AND 4 THEN 3
	WHEN pct_chg BETWEEN 4 AND 6 THEN 5
	WHEN pct_chg BETWEEN 6 AND 8 THEN 7
	WHEN pct_chg > 8 THEN 9
	WHEN pct_chg BETWEEN -2 AND 0 THEN -1
	WHEN pct_chg BETWEEN -4 AND -2 THEN -3
	WHEN pct_chg BETWEEN -6 AND -4 THEN -5
	WHEN pct_chg BETWEEN -8 AND -6 THEN -7
	WHEN pct_chg < -8 THEN -9
	END AS pct_chg_mode
	from stock_quotation_daily sqd where trade_date >'20200218'
	

CREATE TABLE `ak_stock_ansysis_zd_sum_em` (
   `date` date  NOT NULL COMMENT '时间',
   `z_0`  int COMMENT '0-2%',
   `z_1`  int COMMENT '2-4',
   `z_2`  int COMMENT '4-6',
   `z_3`  int COMMENT '6-8',
   `z_4`  int COMMENT '8-涨停',
   `d_0`  int COMMENT '-2~0',
   `d_1`  int COMMENT '-4~-2',
   `d_2`  int COMMENT '-6~-4',
   `d_3`  int COMMENT '-8~-6',
   `d_4`  int COMMENT '跌停~-8',
   PRIMARY KEY (`date`)
) ENGINE=InnoDB AUTO_INCREMENT=30071 DEFAULT CHARSET=utf8

insert into `ak_stock_ansysis_zd_sum_em`
select
	trade_date as `date`,
	COUNT(case WHEN pct_chg BETWEEN 0 AND 2 THEN pct_chg END) as z_0,
	COUNT(case WHEN pct_chg BETWEEN 2 AND 4 THEN pct_chg END) as z_1,
	COUNT(case WHEN pct_chg BETWEEN 4 AND 6 THEN pct_chg END) as z_2,
	COUNT(case WHEN pct_chg BETWEEN 6 AND 8 THEN pct_chg END) as z_3,
	COUNT(case WHEN pct_chg > 8 THEN pct_chg END) as z_4,
	COUNT(case WHEN pct_chg BETWEEN -2 AND 0 THEN pct_chg END) as d_0,
	COUNT(case WHEN pct_chg BETWEEN -4 AND -2 THEN pct_chg END) as d_1,
	COUNT(case WHEN pct_chg BETWEEN -6 AND -4 THEN pct_chg END) as d_2,
	COUNT(case WHEN pct_chg BETWEEN -8 AND -6 THEN pct_chg END) as d_3,
	COUNT(case WHEN pct_chg < -8 THEN pct_chg END) as d_4
	from stock_quotation_daily where trade_date="20220223" group by trade_date 

	
