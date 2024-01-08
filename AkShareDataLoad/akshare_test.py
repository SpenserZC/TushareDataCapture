import akshare as ak
import datetime
#stock_sse_deal_daily_df = ak.stock_sse_deal_daily(date="20220309")
#print(stock_sse_deal_daily_df)
# data = ak.tool_trade_date_hist_sina()
# begin_date = datetime.datetime.strptime('2010-01-01', "%Y-%m-%d").date()
# print(data[(data['trade_date']>begin_date)])




stock_lhb_hyyyb_em_df = ak.stock_lhb_hyyyb_em(start_date="20220324", end_date="20220324")
print(stock_lhb_hyyyb_em_df)



