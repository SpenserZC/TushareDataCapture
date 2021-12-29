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
    list_date date	comment "上市日期",
    delist_date date	comment "退市日期",
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
    ts_code char(10) not null primary key comment "股票代码",
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



CREATE TABLE IF NOT EXISTS tushare_error_log(
    id int primary key auto_increment,
    api_name varchar(50),
    `key` varchar(50),
    exception_info TEXT
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "tushare异常表";




