from service.ths_industry import ThsIndustryCapture
from service.em_zdt import EmZdtCapture
from service.a_stock_mark import StockMarket
from service.tushare_update import TushareDailyUpdate

tu = TushareDailyUpdate()
ths = ThsIndustryCapture()
em = EmZdtCapture()
sm = StockMarket()


date = "20220307"

#每日更新，总市场
StockMarket.sh_market_pull(sm,date,date)
StockMarket.sz_market_pull(sm,date,date)

#同花顺行业指数
# ThsIndustryCapture.index_to_sql(ths,date,date)
#
#涨跌停 东财
EmZdtCapture.em_dt_pull(em,date,date)
EmZdtCapture.em_zt_pull(em,date,date)

#港股通和每日指标
TushareDailyUpdate.money_flow_hsgt(tu,date)
TushareDailyUpdate.money_flow_hsgt_top(tu,date)
TushareDailyUpdate.money_flow_hsgt_hold(tu,date)
TushareDailyUpdate.stock_daily(tu,date)
TushareDailyUpdate.stock_daily_ind(tu,date)
