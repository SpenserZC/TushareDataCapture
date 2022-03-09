from service.ths_industry import ThsIndustryCapture
from service.em_zdt import EmZdtCapture
from service.a_stock_mark import StockMarket
ths = ThsIndustryCapture()
# ThsIndustryCapture.all_industry(ths)
# ThsIndustryCapture.all_index_to_sql(ths,"20220218","20220305")
ThsIndustryCapture.all_board_to_sql(ths)

# em = EmZdtCapture()
# EmZdtCapture.all_em_zt(em)
# EmZdtCapture.all_em_dt(em,"20220221","20220222")
# EmZdtCapture.all_em_zt(em,"20220221","20220222")
# sm = StockMarket()
# StockMarket.sh_market_init(sm,"20211227","20220223")
# StockMarket.sz_market_init(sm,"20211227","20220223")
# StockMarket.sh_market_init_before(sm,"20201227","20211227")
# StockMarket.sz_market_init(sm,"20201227","20220223")

