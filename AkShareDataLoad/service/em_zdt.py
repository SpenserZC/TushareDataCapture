import time

import akshare as ak
import socket
from AkShareDataLoad.connutil.df_mysql import DataLoad

socket.setdefaulttimeout(5)
dl = DataLoad()


# 获取东财涨跌停数据
class EmZdtCapture:

    # 根据日期获取当日涨停股
    def em_zt(self, date, fail_cnt):
        try:
            stock_em_zt_pool_df = ak.stock_zt_pool_em(date=date)
            if stock_em_zt_pool_df.empty:
                print(date + "数据返回为空")
            else:
                stock_em_zt_pool_df_tosql = stock_em_zt_pool_df.drop(labels="序号", axis=1)
                stock_em_zt_pool_df_tosql.insert(stock_em_zt_pool_df_tosql.shape[1], 'date', date)
                stock_em_zt_pool_df_tosql.columns = ["stock_code", "stock_name", "change_quote", "latest_price", "turnover",
                                                     "circulation_market_value", "total_market_value", "turnover_rate",
                                                     "limit_up_amount", "first_limit_up_time", "last_limit_up_time",
                                                     "limit_up_fail_cnt", "limit_up_cnt", "limit_up_continuous_cnt",
                                                     "industry",
                                                     "date"]
                DataLoad.df_to_sql(dl, stock_em_zt_pool_df_tosql, "ak_stock_zdt_zt_pool_em")

                print(date + " 数据已插入")
        except BaseException:
            fail_cnt_b = fail_cnt+1
            if fail_cnt_b < 5:
                print(date + " 插入数据异常")
                time.sleep(1)
                EmZdtCapture.em_zt(self, date, fail_cnt_b)

    # 获取所有涨停数据
    def em_zt_pull(self,start,end):
        cal = DataLoad.get_cal(dl, start,end)
        for idx, data in cal.iterrows():
            EmZdtCapture.em_zt(self, data[0], 0)
            time.sleep(0.5)

    # 获取跌停数据
    def em_dt(self, date, fail_cnt):
        try:
            stock_em_dt_pool_df = ak.stock_zt_pool_dtgc_em(date=date)
            if stock_em_dt_pool_df.empty:
                print(date + "数据返回为空")
            else:
                stock_em_dt_pool_df_tosql = stock_em_dt_pool_df.drop(labels="序号", axis=1)
                stock_em_dt_pool_df_tosql.insert(stock_em_dt_pool_df_tosql.shape[1], 'date', date)
                stock_em_dt_pool_df_tosql.columns = ["stock_code", "stock_name", "change_quote", "latest_price", "turnover",
                                                     "circulation_market_value", "total_market_value", "leading_pe",
                                                     "turnover_rate",
                                                     "limit_down_amount", "last_limit_down_time", "limit_down_mount",
                                                     "limit_down_continuous_cnt", "limit_down_fail_cnt", "industry", "date"]
                DataLoad.df_to_sql(dl, stock_em_dt_pool_df_tosql, "ak_stock_zdt_dt_pool_em")
                print(date + " 数据已插入")
        except BaseException:
            fail_cnt_b = fail_cnt+1
            if fail_cnt_b < 5:
                print(date + " 插入数据异常")
                time.sleep(1)
                EmZdtCapture.em_dt(self, date, fail_cnt_b)

    # 获取所有跌停数据
    def em_dt_pull(self,start,end):
        cal = DataLoad.get_cal(dl, start, end)
        for idx, data in cal.iterrows():
            EmZdtCapture.em_dt(self, data[0],0)
            time.sleep(0.5)
