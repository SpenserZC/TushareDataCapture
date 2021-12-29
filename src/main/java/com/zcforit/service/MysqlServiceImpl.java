package com.zcforit.service;

import com.zcforit.config.ApplicationContextHelper;
import com.zcforit.entity.quotation.CapitalFlowsEntity;
import com.zcforit.repository.quotation.CapitalFlowsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: mysql相关操作
 * @date : 2021-12-29 23:03
 */
public class MysqlServiceImpl {
    @Autowired
    CapitalFlowsDao capitalFlowsDao;


    public String getLastDate(String beanName){
        try{
            JpaRepository repository =(JpaRepository)  ApplicationContextHelper.getBean(beanName);
            CapitalFlowsEntity lastDate = capitalFlowsDao.findLastDate();
            return lastDate.getTradeDate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }



}
