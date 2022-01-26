package com.zcforit.service.impl;

import com.zcforit.entity.base.StockBasicEntity;
import com.zcforit.entity.base.TradeCalEntity;
import com.zcforit.entity.fund.FundBasicEntity;
import com.zcforit.repository.base.StockBasicDao;
import com.zcforit.repository.base.TradeCalDao;
import com.zcforit.repository.fund.FundBasicDao;
import com.zcforit.repository.quotation.*;
import com.zcforit.service.MysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: mysql相关操作
 * @date : 2021-12-29 23:03
 */
@Service
public class MysqlServiceImpl implements MysqlService {
    @Autowired
    TradeCalDao tradeCalDao;

    @Autowired
    StockBasicDao stockBasicDao;
    @Autowired
    CapitalFlowsDao capitalFlowsDao;
    @Autowired
    CenterHoldStockDao centerHoldStockDao;
    @Autowired
    DailyIndicatorDao dailyIndicatorDao;
    @Autowired
    DailyInfoDao dailyInfoDao;
    @Autowired
    LimitListDao limitListDao;
    @Autowired
    MonthlyInfoDao monthlyInfoDao;
    @Autowired
    WeeklyInfoDao weeklyInfoDao;
    @Qualifier("GGTCapitalFlowsTop10Dao")
    @Autowired
    GGTCapitalFlowsTop10Dao ggtCapitalFlowsTop10Dao;
    @Qualifier("GGTDailyBuyStockDao")
    @Autowired
    GGTDailyBuyStockDao ggtDailyBuyStockDao;
    @Qualifier("GGTMonthlyBuyStockDao")
    @Autowired
    GGTMonthlyBuyStockDao ggtMonthlyBuyStockDao;
    @Qualifier("HSGTCapitalFlowsDao")
    @Autowired
    HSGTCapitalFlowsDao hsgtCapitalFlowsDao;
    @Qualifier("HSGTHoldStockDao")
    @Autowired
    HSGTHoldStockDao hsgtHoldStockDao;
    @Qualifier("HSTCapitalFlowsTop10Dao")
    @Autowired
    HSTCapitalFlowsTop10Dao hstCapitalFlowsTop10Dao;

    @Autowired
    FundBasicDao fundBasicDao;



    public String getCalLastDate(){
        String res="";
        try{
            TradeCalEntity lastDate = tradeCalDao.findLastDate();
            if(lastDate!=null) res= lastDate.getCalDate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }



    public List<StockBasicEntity> getAllStock(){
        return  stockBasicDao.findAll();
    }
    public List<FundBasicEntity> getAllFund(){
        return  fundBasicDao.findAll();
    }
    public String getCapitalFlowsLastDay(){return capitalFlowsDao.findLastDate();}
    public String getCenterHoldStockLastDay(){return centerHoldStockDao.findLastDate();}
    public String getDailyIndicatorLastDay(){return dailyIndicatorDao.findLastDate();}
    public String getDailyInfoLastDay(){return dailyInfoDao.findLastDate();}
    public String getLimitListLastDay(){return limitListDao.findLastDate();}
    public String getMonthlyInfoLastDay(){return monthlyInfoDao.findLastDate();}
    public String getWeeklyInfoLastDay(){return weeklyInfoDao.findLastDate();}
    public String getGGTCapitalFlowsTop10LastDay(){return ggtCapitalFlowsTop10Dao.findLastDate();}
    public String getGGTDailyBuyStockLastDay(){return ggtDailyBuyStockDao.findLastDate();}
    public String getGGTMonthlyBuyStockLastDay(){return ggtMonthlyBuyStockDao.findLastDate();}
    public String getHSGTCapitalFlowsLastDay(){return hsgtCapitalFlowsDao.findLastDate();}
    public String getHSGTHoldStockLastDay(){return hsgtHoldStockDao.findLastDate();}
    public String getHSTCapitalFlowsTop10LastDay(){return hstCapitalFlowsTop10Dao.findLastDate();}






}
