import time

import akshare as ak
import socket
from AkShareDataLoad.connutil.df_mysql import DataLoad

socket.setdefaulttimeout(5)
dl = DataLoad()


class StockMarket:
    # 根据日期获取上证股市总貌 2021-12-27以后
    def sh_market_daily(self, date,fail_cnt):
        try:
            stock_sse_deal_daily_df = ak.stock_sse_deal_daily(date=date)
            if stock_sse_deal_daily_df.empty:
                print(date + "数据返回为空")
            else:
                stock_sse_summary_to_sql = stock_sse_deal_daily_df.transpose()
                stock_sse_summary_to_sql.columns = ["total_mv", "average_pe", "vol", "amount", "trade_date",
                                                    "listed_cnt", "turnover_rate", "circ_mv", "circ_turnover_rate"]
                stock_sse_summary_to_sql['market'] = stock_sse_summary_to_sql.index
                stock_sse_summary_to_sql = stock_sse_summary_to_sql.drop(index='单日情况')
                DataLoad.df_to_sql(dl, stock_sse_summary_to_sql, "ak_stock_a_sh_summary")
                print(date + " 数据已插入")
        except BaseException:
            fail_cnt_b = fail_cnt+1
            if fail_cnt_b < 5:
                print("上证股市总貌"+date + " 插入数据异常")
                time.sleep(1)
                StockMarket.sh_market_daily(self, date,fail_cnt_b)

    def sh_market_pull(self, start, end):
        cal = DataLoad.get_cal(dl, start, end)
        for idx, data in cal.iterrows():
            StockMarket.sh_market_daily(self, data[0],0)
            time.sleep(0.5)

    # 根据日期获取上证股市总貌 2021-12-27以前
    def sh_market_daily_before(self, date, fail_cnt):
        try:
            stock_sse_deal_daily_df = ak.stock_sse_deal_daily(date=date)
            if stock_sse_deal_daily_df.empty:
                print(date + "数据返回为空")
            else:
                stock_sse_summary_tosql = stock_sse_deal_daily_df.drop(index=[3, 7])
                stock_sse_summary_tosql = stock_sse_summary_tosql.transpose()
                stock_sse_summary_tosql.columns = ["total_mv", "average_pe", "vol", "amount", "listed_cnt",
                                                   "turnover_rate",
                                                   "circ_mv", "circ_turnover_rate"]
                stock_sse_summary_tosql['market'] = stock_sse_summary_tosql.index
                stock_sse_summary_tosql = stock_sse_summary_tosql.drop(index='单日情况')
                stock_sse_summary_tosql.insert(stock_sse_summary_tosql.shape[1], 'trade_date', date)
                DataLoad.df_to_sql(dl, stock_sse_summary_tosql, "ak_stock_a_sh_summary")
                fail_cnt = 0
                print(date + " 数据已插入")
        except BaseException:
            fail_cnt_b = fail_cnt+1
            if fail_cnt_b < 5:
                print(date + " 插入数据异常")
                time.sleep(1)
                StockMarket.sh_market_daily_before(self, date,fail_cnt_b)

    def sh_market_init_before(self, start, end):
        cal = DataLoad.get_cal(dl, start, end)
        for idx, data in cal.iterrows():
            StockMarket.sh_market_daily_before(self, data[0],0)
            time.sleep(0.5)

    # 根据日期获取深证股市总貌
    def sz_market_daily(self, date, fail_cnt):
        try:
            stock_szse_summary_df = ak.stock_szse_summary(date=date)
            if stock_szse_summary_df.empty:
                print(date + "数据返回为空")
            else:
                stock_szse_summary_df.columns = ["market", "listed_cnt", "amount", "vol", "total_share", "total_mv",
                                                 "float_share", "circ_mv"]
                stock_szse_summary_df.insert(stock_szse_summary_df.shape[1], 'trade_date', date)
                stock_szse_summary_df["amount"] = stock_szse_summary_df["amount"] / 100000000
                stock_szse_summary_df["vol"] = stock_szse_summary_df["vol"] / 100000000
                stock_szse_summary_df["total_share"] = stock_szse_summary_df["total_share"] / 100000000
                stock_szse_summary_df["total_mv"] = stock_szse_summary_df["total_mv"] / 100000000
                stock_szse_summary_df["float_share"] = stock_szse_summary_df["float_share"] / 100000000
                stock_szse_summary_df["circ_mv"] = stock_szse_summary_df["circ_mv"] / 100000000
                DataLoad.df_to_sql(dl, stock_szse_summary_df, "ak_stock_a_sz_summary")
                fail_cnt = 0
                print(date + " 数据已插入")
        except BaseException:
            fail_cnt_b = fail_cnt + 1
            if fail_cnt_b < 5:
                print("深证股市总貌"+date + " 插入数据异常")
                time.sleep(1)
                StockMarket.sz_market_daily(self, date, fail_cnt_b)

    def sz_market_pull(self, start, end):
        cal = DataLoad.get_cal(dl, start, end)
        for idx, data in cal.iterrows():
            StockMarket.sz_market_daily(self, data[0],0)
            time.sleep(0.5)
