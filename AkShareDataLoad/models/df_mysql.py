from . import db


# 载入数据
class DataLoad:
    # dataframe 存储sql，需要对表进行校验
    def df_to_sql(self, df, table):
        try:
            df.to_sql(con=db.engine, name=table, if_exists='append', index=False)
            print("数据已导入")
        except TypeError:
            print("插入数据异常")
        except BaseException:
            pass  # or any other action
