

class Config(object):
    """项目配置核心类"""
    # 调试模式
    DEBUG = True

    # todo 配置日志
    LOG_LEVEL = "DEBUG"

    # mysql数据库的配置信息
    'SQLALCHEMY_DATABASE_URI ="数据库类型://用户名:密码@ip:port:库名?指定字符集编码"'
    SQLALCHEMY_DATABASE_URI = " jdbc:mysql://152.136.98.160:3306/tushare?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC"
    # 动态追踪修改设置，如未设置只会提示警告
    SQLALCHEMY_TRACK_MODIFICATIONS = False
    # 查询时会显示原始SQL语句
    SQLALCHEMY_ECHO= False

    # 设置密钥，可以通过 base64.b64encode(os.urandom(48)) 来生成一个指定长度的随机字符串
    SECRET_KEY = "ghhBljAa0uzw2afLqJOXrukORE4BlkTY/1vaMuDh6opQ3uwGYtsDUyxcH62Aw3ju"

