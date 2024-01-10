# from . import db
import akshare as ak
import datetime

from sqlalchemy import create_engine
from sqlalchemy.exc import IntegrityError

conn = create_engine('mysql+pymysql://akshare:akshare@114.115.167.87:10080/akshare')


# 载入数据
class DataLoad:
    # dataframe 存储sql，需要对表进行校验
    def df_to_sql(self, df, table):
        try:
            df.to_sql(con=conn, name=table, if_exists='replace', index=False)
        except IntegrityError as e:
            print(e)
            # Ignore duplicates
            pass
    def get_cal(self, begin, end):
        data = ak.tool_trade_date_hist_sina();
        begin_date = datetime.datetime.strptime(begin, "%Y-%m-%d").date()
        end_date = datetime.datetime.strptime(end, "%Y-%m-%d").date()
        return data[(data['trade_date'] > begin_date) & (data['trade_date'] <= end_date) ]
