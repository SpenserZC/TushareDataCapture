package com.zcforit.service.impl;

import com.zcforit.entity.base.TradeCalEntity;
import com.zcforit.repository.base.TradeCalDao;
import com.zcforit.service.MysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String getLastDate(){
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



}
