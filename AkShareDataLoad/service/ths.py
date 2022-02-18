import time

import akshare as ak
import socket

from models.df_mysql import DataLoad

socket.setdefaulttimeout(5)
dl = DataLoad()


# 获取通话行业数据
class ThsIndustryCapture:
    # 同花顺-成份股-行业名称 ak.stock_board_industry_name_ths()
    # 获取所有行业名称
    def all_industry(self):
        try:
            stock_board_name_ths_df = ak.stock_board_industry_name_ths()
            stock_board_name_ths_df['name'] = stock_board_name_ths_df['name'].map(lambda x: x.replace("Ⅲ", ""))
            print(stock_board_name_ths_df)
            DataLoad.df_to_sql(dl, stock_board_name_ths_df, "ak_stock_board_industry_name_ths")
        except BaseException:
            print("存入数据异常")

    # 同花顺-成份股-行业名称 stock_board_industry_cons_ths
    # 根据行业代码，行业名称获取行业成分股
    def board_to_sql(self, code, name):
        try:
            stock_board_cons_ths_df = ak.stock_board_cons_ths(symbol=code)
            df_tosql = stock_board_cons_ths_df.drop(labels="序号", axis=1)
            df_tosql.insert(df_tosql.shape[1], 'industry_code', code)
            df_tosql.insert(df_tosql.shape[1], 'industry_name', name)
            df_tosql.columns = ["code", "name", "price", "pct_chg", "pct", "pct_rate", "turnover", "volume_ratio",
                                "amp", "amount", "float_share", "circ_mv", "pe", "industry_code", "industry_name"]
            DataLoad.df_to_sql(dl, stock_board_cons_ths_df, "ak_stock_board_industry_cons_ths")
            print(name + "行业 成分股数据已导入")
        except TypeError:
            print(code + "获取行业代码异常")
        except BaseException:
            print(name + "插入数据异常")

    # 获取所有成分股
    def all_board_to_sql(self):
        stock_board_industry_name_ths = ak.stock_board_industry_name_ths()
        for idx, data in stock_board_industry_name_ths.iterrows():
            ThsIndustryCapture.board_tosql(data[1], data[0])

    # 根据行业code，name获取行业指数
    def index_to_sql(self, code, name, start, end):
        fail_cnt = 0;
        try:
            stock_board_industry_index_ths_df = ak.stock_board_industry_index_ths(symbol=name, start_date=start,
                                                                                  end_date=end)
            stock_board_industry_index_ths_df.insert(stock_board_industry_index_ths_df.shape[1], 'industry_code', code)
            stock_board_industry_index_ths_df.insert(stock_board_industry_index_ths_df.shape[1], 'industry_name', name)
            stock_board_industry_index_ths_df.columns = ["date", "open", "high", "low", "close", "vol", "amount",
                                                         "industry_code", "industry_name"]
            DataLoad.df_to_sql(dl, stock_board_industry_index_ths_df, "ak_stock_board_industry_index_ths")
            print(name + "插入数据已导入")
            fail_cnt = 0
        except BaseException:
            if fail_cnt > 5:
                pass
            fail_cnt += 1
            print(code + ":" + name + "插入数据异常")
            time.sleep(10)
            ThsIndustryCapture.index_to_sql(self, code, name, start, end)

    # 获取所有行业指数
    def all_index_to_sql(self):
        stock_board_industry_name_ths = ak.stock_board_industry_name_ths()
        for idx, data in stock_board_industry_name_ths.iterrows():
            ThsIndustryCapture.index_to_sql(self, data[1], data[0], "20120217", "20220217")
            time.sleep(0.5)
