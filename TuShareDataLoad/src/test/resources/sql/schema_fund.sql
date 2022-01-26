--基金数据
--基金基础数据
CREATE TABLE IF NOT EXISTS fund_basic(
    ts_code varchar(20) primary key comment "基金代码",
    `name`    varchar(200) comment "简称",
    management  varchar(100) comment "管理人",
    custodian   varchar(100) comment "托管人",
    fund_type   varchar(50) comment "投资类型",
    found_date  date comment "成立日期",
    due_date    date comment "到期日期",
    list_date   date comment "上市时间",
    issue_date  date comment "发行日期",
    delist_date date comment "退市日期",
    issue_amount    float   comment "发行份额(亿)",
    m_fee   float   comment "管理费",
    c_fee   float   comment "托管费",
    duration_year   float   comment "存续期",
    p_value float   comment "面值",
    min_amount  float   comment "起点金额(万元)",
    exp_return  float   comment "预期收益率",
    benchmark   varchar(200) comment "业绩比较基准",
    `status`  varchar(20) comment "存续状态D摘牌 I发行 L已上市",
    invest_type varchar(50) comment "投资风格",
    `type`   varchar(50) comment "基金类型",
    trustee varchar(100) comment "受托人",
    purc_startdate  date comment "日常申购起始日",
    redm_startdate  date comment "日常赎回起始日",
    market  varchar(50) comment "E场内O场外"
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "基金基础信息表";

CREATE TABLE IF NOT EXISTS fund_company(
    `name` varchar(200) primary key comment "基金公司名称",
    shortname varchar(50) comment "简称",
    short_enname varchar(50) comment "英文缩写",
    province varchar(50) comment "省份",
    city varchar(50) comment "城市",
    address varchar(500) comment "注册地址",
    phone varchar(100) comment "电话",
    office varchar(500) comment "办公地址",
    website varchar(500) comment "公司网址",
    chairman varchar(50) comment "法人代表",
    manager varchar(50) comment "总经理",
    reg_capital float comment "注册资本",
    setup_date date comment "成立日期",
    end_date date comment "公司终止日期",
    employees float comment "员工总数",
    main_business varchar(500) comment "主要产品及业务",
    org_code varchar(20) comment "组织机构代码",
    credit_code varchar(20) comment "统一社会信用代码"
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "基金公司表";

CREATE TABLE IF NOT EXISTS fund_manager(
    ts_code varchar(20) comment "基金代码",
    ann_date date comment "公告日期",
    `name` varchar(20) comment "基金经理姓名",
    gender varchar(20) comment "性别",
    birth_year varchar(20) comment "出生年份",
    edu varchar(20) comment "学历",
    nationality varchar(20) comment "国籍",
    begin_date date comment "任职日期",
    end_date date comment "离任日期",
    resume text comment "简历",
    primary key (ts_code,ann_date)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "基金经理表";

CREATE TABLE IF NOT EXISTS fund_share(
    ts_code varchar(20) comment "基金代码，支持多只基金同时提取，用逗号分隔",
    trade_date  date comment "交易（变动）日期，格式YYYYMMDD",
    fd_share  float comment "基金份额（万）",
    primary key (ts_code,trade_date)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "基金规模表";

CREATE TABLE IF NOT EXISTS fund_nav(
    ts_code varchar(20)  comment "TS代码",
    ann_date    date  comment "公告日期",
    nav_date    date  comment "净值日期",
    unit_nav    float    comment "单位净值",
    accum_nav   float    comment "累计净值",
    accum_div   float    comment "累计分红",
    net_asset   float    comment "资产净值",
    total_netasset  float    comment "合计资产净值",
    adj_nav float    comment "复权单位净值",
    primary key (ts_code,ann_date)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "基金净值";

CREATE TABLE IF NOT EXISTS fund_div(
    ts_code  varchar(20) comment "TS代码",
    ann_date    date comment "公告日期",
    imp_anndate date comment "分红实施公告日",
    base_date   date comment "分配收益基准日",
    div_proc     varchar(50) comment "方案进度",
    record_date date comment "权益登记日",
    ex_date date comment "除息日",
    pay_date    date comment "派息日",
    earpay_date date comment "收益支付日",
    net_ex_date date comment "净值除权日",
    div_cash    float   comment "每股派息(元)",
    base_unit   float   comment "基准基金份额(万份)",
    ear_distr   float   comment "可分配收益(元)",
    ear_amount  float   comment "收益分配金额(元)",
    account_date    date comment "红利再投资到账日",
    base_year    varchar(20) comment "份额基准年度",
    primary key (ts_code,ann_date)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "基金分红";

CREATE TABLE IF NOT EXISTS fund_portfolio(
    ts_code varchar(20) comment "TS基金代码",
    ann_date    date comment "公告日期",
    end_date    date comment "截止日期",
    symbol  varchar(20) comment "股票代码",
    mkv float   comment "持有股票市值(元)",
    amount  float   comment "持有股票数量（股）",
    stk_mkv_ratio   float   comment "占股票市值比",
    stk_float_ratio float   comment "占流通股本比例",
    primary key (ts_code,ann_date)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "基金持仓";

CREATE TABLE IF NOT EXISTS fund_daily(
    ts_code varchar(20) comment "TS代码",
    trade_date  date comment "交易日期",
    `open`    float   comment "开盘价(元)",
    `high`    float   comment "最高价(元)",
    `low` float   comment "最低价(元)",
    `close`   float   comment "收盘价(元)",
    pre_close   float   comment "昨收盘价(元)",
    `change`  float   comment "涨跌额(元)",
    pct_chg float   comment "涨跌幅(%)",
    `vol` float   comment "成交量(手)",
    amount  float   comment "成交额(千元)",
    primary key (ts_code,trade_date)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "基金日线行情";

CREATE TABLE IF NOT EXISTS fund_adj(
    ts_code varchar(20) comment "TS代码",
    trade_date  date comment "交易日期",
    adj_factor float comment "复权因子",
    primary key (ts_code,trade_date)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "基金复权因子";