import time

import akshare as ak
import socket
from AkShareDataLoad.connutil.df_mysql import DataLoad

socket.setdefaulttimeout(5)
dl = DataLoad()


# 获取东财涨跌停数据
class EmLHBCapture:
    def em_lhb(self, start,end, fail_cnt):
        try:
            stock_lhb_detail_em_df = ak.stock_lhb_detail_em(start_date=start, end_date=end)
            if stock_lhb_detail_em_df.empty:
                print(start+" - "+end + " 数据返回为空")
            else:
                stock_lhb_detail_em_df = stock_lhb_detail_em_df.drop(labels="序号", axis=1)
                stock_lhb_detail_em_df.columns = ["code","name","act_date","unscramble","price","pct_chg","lhb_net_buy_amount","lhb_buy_amount","lhb_sale_amount","lhb_all_amount","stock_all_amount","net_buy_rate","buy_all_rate","turnover","circ_mv","reason","after_1d","after_2d","after_5d","after_10d"]
                stock_lhb_detail_em_df.drop_duplicates(subset=['code','act_date'])
                DataLoad.df_to_sql(dl, stock_lhb_detail_em_df, "ak_stock_lhb_daily_detail")
                print(start+" - "+end + " 数据已插入")
        except BaseException as e:
            print(e)
            fail_cnt_b = fail_cnt + 1
            if fail_cnt_b < 5:
                print(start + " - " + end + " 数据插入异常")
                time.sleep(1)
                EmLHBCapture.em_lhb(self, start,end, fail_cnt_b)

    def em_lhb_single(self, date, fail_cnt):
        EmLHBCapture.em_lhb(self , date, date, fail_cnt)

