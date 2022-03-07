from service.tushare_update import TushareDailyUpdate

tu = TushareDailyUpdate()

date = "20220225"
# TushareDailyUpdate.stock_daily(tu,date)
# TushareDailyUpdate.stock_daily_ind(tu,date)
# TushareDailyUpdate.money_flow_hsgt(tu,date)
# TushareDailyUpdate.money_flow_hsgt_top(tu,date)
# TushareDailyUpdate.money_flow_hsgt_hold(tu,date)


def index_to_sql(fail_cnt):
        if fail_cnt < 5:
            print(fail_cnt)
            fail_cnt += 1

index_to_sql(1)