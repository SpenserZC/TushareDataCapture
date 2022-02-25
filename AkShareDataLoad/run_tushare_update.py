from service.tushare_update import TushareDailyUpdate

tu = TushareDailyUpdate()

date = "20220224"
# TushareDailyUpdate.stock_daily(tu,date)
# TushareDailyUpdate.stock_daily_ind(tu,date)
TushareDailyUpdate.money_flow_hsgt(tu,date)
TushareDailyUpdate.money_flow_hsgt_top(tu,date)
TushareDailyUpdate.money_flow_hsgt_hold(tu,date)




