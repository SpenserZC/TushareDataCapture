import akshare as ak
import datetime
#stock_sse_deal_daily_df = ak.stock_sse_deal_daily(date="20220309")
#print(stock_sse_deal_daily_df)
# data = ak.tool_trade_date_hist_sina()
# begin_date = datetime.datetime.strptime('2010-01-01', "%Y-%m-%d").date()
# print(data[(data['trade_date']>begin_date)])

# stock_lhb_detail_em_df = ak.stock_lhb_detail_em(start_date="20230403", end_date="20230417")
# print(stock_lhb_detail_em_df)

from service.ak_lhb_em import EmLHBCapture

lhb = EmLHBCapture()

lhb.em_lhb_single("20240110",4)












