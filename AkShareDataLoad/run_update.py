from service.ths import ThsIndustryCapture
from service.em_zdt import EmZdtCapture
from service.a_stock_mark import StockMarket
ths = ThsIndustryCapture()
# ThsIndustryCapture.all_industry(ths)
# ThsIndustryCapture.all_index_to_sql(ths)

em = EmZdtCapture()
# EmZdtCapture.all_em_zt(em)
EmZdtCapture.em_dt(em,"20220223")
EmZdtCapture.em_zt(em,"20220223")
sm = StockMarket()
# StockMarket.sh_market_daily(sm,"20220223")
# StockMarket.sz_market_daily(sm,"20220223")