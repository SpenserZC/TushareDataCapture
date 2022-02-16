import os

basedir = os.path.abspath(os.path.dirname(__file__))


class Config:
    SECRET_KEY = os.environ.get('SECRET_KEY') or 'hard to guess string'
    SQLALCHEMY_COMMIT_ON_TEARDOWN = True

    @staticmethod
    def init_app(app):
        pass


class DevelopmentConfig(Config):
    DEBUG = True
    SQLALCHEMY_DATABASE_URI = 'tushare:tushare@152.136.98.160:3306/tushare'


class TestingConfig(Config):
    TESTING = True
    SQLALCHEMY_DATABASE_URI = 'tushare:tushare@152.136.98.160:3306/tushare'


class ProductionConfig(Config):
    SQLALCHEMY_DATABASE_URI = 'tushare:tushare@152.136.98.160:3306/tushare'


config = {
    'development': DevelopmentConfig,
    'testing': TestingConfig,
    'production': ProductionConfig,
    'default': DevelopmentConfig
}
