import time

import akshare as ak
import socket
from models.df_mysql import DataLoad

socket.setdefaulttimeout(5)
dl = DataLoad()


class StockMarket:
    # 根据日期获取上证股市总貌
    def sh_market_daily(self, date):
        fail_cnt = 0;
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
                fail_cnt = 0
                print(date + " 数据已插入")
        except BaseException:
            if fail_cnt > 5:
                pass
            fail_cnt += 1
            print(date + " 插入数据异常")
            time.sleep(1)
            StockMarket.sh_market_daily(self, date)

    def sh_market_init(self, start, end):
        cal = DataLoad.get_cal(dl, start, end)
        for idx, data in cal.iterrows():
            StockMarket.sh_market_daily(self, data[0])
            time.sleep(0.5)

    # 根据日期获取上证股市总貌
    def sz_market_daily(self, date):
        fail_cnt = 0;
        try:
            stock_szse_summary_df = ak.stock_szse_summary(date=date)
            if stock_szse_summary_df.empty:
                print(date + "数据返回为空")
            else:
                stock_szse_summary_df.columns = ["market","listed_cnt","amount","vol","total_share","total_mv","float_share","circ_mv"]
                stock_szse_summary_df.insert(stock_szse_summary_df.shape[1], 'trade_date',date)
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
            if fail_cnt > 5:
                pass
            fail_cnt += 1
            print(date + " 插入数据异常")
            time.sleep(1)
            StockMarket.sh_market_daily(self, date)

    def sz_market_init(self, start, end):
        cal = DataLoad.get_cal(dl, start, end)
        for idx, data in cal.iterrows():
            StockMarket.sz_market_daily(self, data[0])
            time.sleep(0.5)




