package com.zcforit.service.impl;

import com.zcforit.dto.BaseRequest;
import com.zcforit.entity.base.StockBasicEntity;
import com.zcforit.entity.finance.IncomeEntity;
import com.zcforit.service.BasicService;
import com.zcforit.service.FinanceService;
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
            System.out.println(res);
            //            basicService.saveToMySql(res,"StockBasicDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
