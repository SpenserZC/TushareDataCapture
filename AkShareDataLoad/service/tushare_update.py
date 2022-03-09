import time
import tushare as ts
from models.df_mysql import DataLoad

ts.set_token("325114407edee775609e7b370eac76e9ad9558798958fbd92ea0eead")
dl = DataLoad()


class TushareDailyUpdate:

    # 根据日期获取上证股市总貌 2021-12-27以后
    def stock_daily(self, date):
        try:
            pro = ts.pro_api()
            df = pro.daily(trade_date=date)
            if df.empty:
                print(date + "数据返回为空")
            else:
                DataLoad.df_to_sql(dl, df, "stock_quotation_daily")
                print(date + " 数据已插入")
        except BaseException:
            print(date + " 插入数据异常")

    def stock_daily_time(self, start, end):
        cal = DataLoad.get_cal(dl, start, end)
        for idx, data in cal.iterrows():
            TushareDailyUpdate.stock_daily(self, data[0])
            time.sleep(0.5)

    def stock_daily_ind(self, date):
        try:
            pro = ts.pro_api()
            df = pro.daily_basic(trade_date=date)
            if df.empty:
                print(date + "数据返回为空")
            else:
                DataLoad.df_to_sql(dl, df, "stock_quotation_daily_indicator")
                print(date + " 数据已插入")
        except BaseException:
            print(date + " 插入数据异常")

    def stock_daily_ind_time(self, start, end):
        cal = DataLoad.get_cal(dl, start, end)
        for idx, data in cal.iterrows():
            TushareDailyUpdate.stock_daily_ind(self, data[0])
            time.sleep(0.5)

    def money_flow_hsgt(self, date):
        try:
            pro = ts.pro_api()
            df = pro.query('moneyflow_hsgt', trade_date=date)
            if df.empty:
                print(date + "数据返回为空")
            else:
                DataLoad.df_to_sql(dl, df, "stock_quotation_hsgt_capital_flows")
                print(date + " 数据已插入")
        except BaseException:
            print(date + " 插入数据异常")

    def money_flow_hsgt(self, date):
        try:
            pro = ts.pro_api()
            df = pro.query('moneyflow_hsgt', trade_date=date)
            if df.empty:
                print(date + "数据返回为空")
            else:
                DataLoad.df_to_sql(dl, df, "stock_quotation_hsgt_capital_flows")
                print(date + " 数据已插入")
        except BaseException:
            print(date + " 插入数据异常")

    def money_flow_hsgt_top(self, date):
        try:
            pro = ts.pro_api()
            df = pro.query('hsgt_top10', trade_date=date)
            if df.empty:
                print(date + "数据返回为空")
            else:
                DataLoad.df_to_sql(dl, df, "stock_quotation_hsgt_capital_flows_top10")
                print(date + " 数据已插入")
        except BaseException:
            print(date + " 插入数据异常")

    def money_flow_hsgt_hold(self, date):
        try:
            pro = ts.pro_api()
            df = pro.query('hk_hold', trade_date=date)
            if df.empty:
                print(date + "数据返回为空")
            else:
                DataLoad.df_to_sql(dl, df, "stock_quotation_hsgt_hold_stock")
                print(date + " 数据已插入")
        except BaseException:
            print(date + " 插入数据异常")

    def money_flow_stock(self, date):
        try:
            pro = ts.pro_api()
            df = pro.moneyflow(trade_date=date)
            if df.empty:
                print(date + "数据返回为空")
            else:
                DataLoad.df_to_sql(dl, df, "stock_quotation_capital_flows")
                print(date + " 数据已插入")
        except BaseException:
            print(date + " 插入数据异常")

    def money_flow_stock_all(self, start,end):
        cal = DataLoad.get_cal(dl, start, end)
        for idx, data in cal.iterrows():
            TushareDailyUpdate.money_flow_stock(self, data[0])
            time.sleep(0.5)
