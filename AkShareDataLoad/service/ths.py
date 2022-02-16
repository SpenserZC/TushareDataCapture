import akshare as ak
from models.df_mysql import DataLoad


# 获取通话行业数据
class ThsIndustryCapture:
    # 同花顺-成份股-行业名称 ak.stock_board_industry_name_ths()
    # 获取所有行业名称
    def all_industry(self):
        try:
            stock_board_name_ths_df = ak.stock_board_industry_name_ths()
            print(stock_board_name_ths_df)
            # DataLoad.df_to_sql(stock_board_name_ths_df, "ak_stock_board_industry_name_ths")
        except BaseException:
            print("获取数据异常")

    # 同花顺-成份股-行业名称 stock_board_industry_cons_ths
    # 根据行业代码，行业名称获取行业成分股
    def board_to_sql(self,code, name):
        try:
            stock_board_cons_ths_df = ak.stock_board_cons_ths(symbol=code)
            df_tosql = stock_board_cons_ths_df.drop(labels="序号", axis=1)
            df_tosql.insert(df_tosql.shape[1], 'industry_code', code)
            df_tosql.insert(df_tosql.shape[1], 'industry_name', name)
            df_tosql.columns = ["code", "name", "price", "pct_chg", "pct", "pct_rate", "turnover", "volume_ratio",
                                "amp", "amount", "float_share", "circ_mv", "pe", "industry_code", "industry_name"]
            DataLoad.df_to_sql(stock_board_cons_ths_df, "ak_stock_board_industry_cons_ths")
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

    