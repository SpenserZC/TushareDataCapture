# from . import db
import tushare as ts

from sqlalchemy import create_engine
from sqlalchemy.exc import IntegrityError

conn = create_engine('mysql+pymysql://tushare:tushare@152.136.98.160:3306/tushare', encoding='utf8')
ts.set_token("325114407edee775609e7b370eac76e9ad9558798958fbd92ea0eead")


# 载入数据
class DataLoad:
    # dataframe 存储sql，需要对表进行校验
    def df_to_sql(self, df, table):
        try:
            df.to_sql(con=conn, name=table, if_exists='append', index=False)
        except IntegrityError:
            # Ignore duplicates
            pass
    def get_cal(self, start, end):
        pro = ts.pro_api()
        return pro.trade_cal(start_date=start, end_date=end, fields='cal_date', is_open='1')
