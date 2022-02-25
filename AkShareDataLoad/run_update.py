from service.ths_industry import ThsIndustryCapture
from service.em_zdt import EmZdtCapture
from service.a_stock_mark import StockMarket
ths = ThsIndustryCapture()
# ThsIndustryCapture.all_industry(ths)
# ThsIndustryCapture.all_index_to_sql(ths)

date = "20220224"
em = EmZdtCapture()
# EmZdtCapture.all_em_zt(em)
EmZdtCapture.em_dt(em,date)
EmZdtCapture.em_zt(em,date)
sm = StockMarket()
StockMarket.sh_market_daily(sm,date)
StockMarket.sz_market_daily(sm,date)