package com.zcforit.service.impl;

import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.FinanceRequest;
import com.zcforit.entity.base.StockBasicEntity;
import com.zcforit.entity.finance.IncomeEntity;
import com.zcforit.service.BasicService;
import com.zcforit.service.FinanceService;
import com.zcforit.utils.TuShareUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 财务数据
 * @date 2022/1/10 20:54
 */
@Service
public class FinanceServiceImpl implements FinanceService {
    @Autowired
    BasicService basicService;



   public void loadFinanceIncome(BaseRequest baseRequest){
        try{
            List<IncomeEntity> res = basicService.getTuShareData(baseRequest,new IncomeEntity());
            basicService.saveToMySql(res,"StockBasicDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void loadFinanceIncome(){
        try{
            FinanceRequest dto = new FinanceRequest();
            dto.setTsCode("000001.SZ");
            dto.setApiName("income");
//            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new IncomeEntity(), config.getToken());
//            List<IncomeEntity> res = basicService.getTuShareData(baseRequest,new IncomeEntity());
//            basicService.saveToMySql(res,"StockBasicDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }








}
