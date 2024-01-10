import time

import akshare as ak
import socket
import numpy as np
from AkShareDataLoad.connutil.df_mysql import DataLoad

socket.setdefaulttimeout(5)
dl = DataLoad()


# 获取通话行业数据
class ThsMoneyFlow:
    # 同花顺-个股资金流向 ，及时接口，每天更新
    def stock_money_flow(self, date):
        # try:
            stock_fund_flow_individual_df = ak.stock_fund_flow_individual(symbol="即时")
            df_tosql = stock_fund_flow_individual_df.drop(labels="序号", axis=1)
            df_tosql.columns = ["stock_code", "stock_name", "price", "change_quote", "turnover_rate", "in_flows",
                                "out_flows", "net_amount", "trade_amount"]
            df_tosql.insert(df_tosql.shape[1], 'trade_date', date)
            df_tosql['stock_code'] = df_tosql['stock_code'].apply(lambda x: str(x).rjust(6, '0'))
            df_tosql['in_flows'] = df_tosql['in_flows'].apply(lambda x: float(x[:-1]) * 100000000 if x.find('亿') else (float(x[:-1]) * 10000) if x.find('万') else float(x[:-1]))
            df_tosql['out_flows'] = df_tosql['out_flows'].apply(lambda x: float(x[:-1]) * 100000000 if x.find('亿') else (float(x[:-1]) * 10000) if x.find('万') else float(x[:-1]))
            df_tosql['net_amount'] = df_tosql['net_amount'].apply(lambda x: float(x[:-1]) * 100000000 if x.find('亿') else (float(x[:-1]) * 10000) if x.find('万') else float(x[:-1]))
            df_tosql['trade_amount'] = df_tosql['trade_amount'].apply(lambda x: float(x[:-1]) * 100000000 if x.find('亿') else (float(x[:-1]) * 10000) if x.find('万') else float(x[:-1]))
            DataLoad.df_to_sql(dl, df_tosql, "ak_stock_money_flow_stock_ths")
            print(date + "个股流向存入数据")
        # except BaseException:
        #     print("存入数据异常")

    # 同花顺-行业资金流向 ，及时接口，每天更新
    def industry_money_flow(self, date):
        try:
            stock_fund_flow_industry_df = ak.stock_fund_flow_industry(symbol="即时")
            df_tosql = stock_fund_flow_industry_df.drop(labels="序号", axis=1)
            df_tosql.columns = ["industry_name", "industry_price", "change_quote", "in_flows", "out_flows", "net_amount",
                                "stock_cnt", "stock_top", "stock_change", "stock_price"]
            df_tosql.insert(df_tosql.shape[1], 'trade_date', date)
            DataLoad.df_to_sql(dl, df_tosql, "ak_stock_money_flow_industry_ths")
            print(date + "行业资金流向存入数据")
        except BaseException:
            print("存入数据异常")


