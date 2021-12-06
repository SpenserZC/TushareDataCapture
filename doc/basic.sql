DROP TABLE IF EXISTS basic_stock;
CREATE TABLE IF NOT EXISTS basic_stock(
    symbol char(10) not null primary key comment "股票代码",
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




