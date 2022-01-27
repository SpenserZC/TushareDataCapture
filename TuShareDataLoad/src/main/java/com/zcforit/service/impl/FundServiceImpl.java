package com.zcforit.service.impl;

import com.zcforit.config.TuShareConfig;
import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.finance.FinanceRequestDTO;
import com.zcforit.dto.fund.FundRequestDTO;
import com.zcforit.entity.finance.IncomeEntity;
import com.zcforit.entity.fund.*;
import com.zcforit.service.BasicService;
import com.zcforit.service.FundService;
import com.zcforit.service.MysqlService;
import com.zcforit.utils.TuShareUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 基金数据
 * @date : 2022-01-13 21:32
 */
@Service
public class FundServiceImpl  implements FundService {

    @Autowired
    BasicService basicService;

    @Autowired
    MysqlService mysqlService;

    @Autowired
    TuShareConfig config;

    public void loadFundBasic(FundRequestDTO dto){
        try{
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new FundBasicEntity(), config.getToken());
            Map<Integer, List<FundBasicEntity>> map = basicService.getTuShareData(baseRequest, new FundBasicEntity());
            if(map.containsKey(0)){
                basicService.saveToMySql(map.get(0),"FundBasicDao");
            }else if(map.containsKey(2)){
                Thread.sleep(10000l);
                if(map.containsKey(0))
                    basicService.saveToMySql(basicService.getTuShareData(baseRequest, new FundBasicEntity()).get(0),"FundBasicDao");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadCompany(){
        try{
            FundRequestDTO dto = new FundRequestDTO();
            dto.setApiName("fund_company");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new FundCompanyEntity(), config.getToken());
            Map<Integer, List<FundCompanyEntity>> map = basicService.getTuShareData(baseRequest, new FundCompanyEntity());
            if(map.containsKey(0)){
                basicService.saveToMySql(map.get(0),"FundCompanyDao");
            }else if(map.containsKey(2)){
                Thread.sleep(10000l);
                if(map.containsKey(0))
                    basicService.saveToMySql(basicService.getTuShareData(baseRequest, new FundCompanyEntity()).get(0),"FundCompanyDao");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadManager(){
        try{
            FundRequestDTO dto = new FundRequestDTO();
            dto.setApiName("fund_manager");
            List<FundManagerEntity> list=new ArrayList<>();
            for (int i=0;;i++){
                dto.setLimit(5000);
                dto.setOffset(i*5000+1);
                BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new FundManagerEntity(), config.getToken());
                Map<Integer, List<FundManagerEntity>> map = basicService.getTuShareData(baseRequest, new FundManagerEntity());
                if(map.containsKey(0)){
                    list.addAll(map.get(0));
                    if(map.get(0).size()<5000)break;
                }else if(map.containsKey(2)) {
                    Thread.sleep(10000l);
                    map = basicService.getTuShareData(baseRequest, new FundManagerEntity());
                    if (map.containsKey(0))
                        list.addAll(map.get(0));
                    if(map.get(0).size()<5000)break;
                }
            }
            basicService.saveToMySql(list,"FundManagerDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadShare(FundRequestDTO dto){
        try{
                BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new FundShareEntity(), config.getToken());
                Map<Integer, List<FundShareEntity>> map = basicService.getTuShareData(baseRequest, new FundShareEntity());
                if(map.containsKey(0)){
                    List<FundShareEntity> list = map.get(0);
                    if(list.size()==2000){
                        dto.setStartDate(list.stream().map(FundShareEntity::getTradeDate).max(Comparator.
                                comparing(String::valueOf)).get());
                        list.addAll(basicService.getTuShareData(baseRequest, new FundShareEntity()).get(0));
                    }
                }else if(map.containsKey(2)) {
                    Thread.sleep(10000l);
                    map = basicService.getTuShareData(baseRequest, new FundShareEntity());
                    if(map.containsKey(0)){
                        List<FundShareEntity> list = map.get(0);
                        if(list.size()==2000){
                            dto.setStartDate(list.stream().map(FundShareEntity::getTradeDate).max(Comparator.
                                    comparing(String::valueOf)).get());
                            list.addAll(basicService.getTuShareData(baseRequest, new FundShareEntity()).get(0));
                        }
                    }
                }
                basicService.saveToMySql(map.get(0),"FundShareDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadNav(FundRequestDTO dto){
        try{
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new FundNavEntity(), config.getToken());
            Map<Integer, List<FundNavEntity>> map = basicService.getTuShareData(baseRequest, new FundNavEntity());
            if(map.containsKey(0)){
                basicService.saveToMySql(map.get(0),"FundNavDao");
            }else if(map.containsKey(2)){
                Thread.sleep(10000l);
                if(map.containsKey(0))
                    basicService.saveToMySql(basicService.getTuShareData(baseRequest, new FundNavEntity()).get(0),"FundNavDao");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadDiv( FundRequestDTO dto){
        try{
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new FundDivEntity(), config.getToken());
              Map<Integer, List<FundDivEntity>> map = basicService.getTuShareData(baseRequest, new FundDivEntity());
            if(map.containsKey(0)){
                basicService.saveToMySql(map.get(0),"FundDivDao");
            }else if(map.containsKey(2)){
                Thread.sleep(10000l);
                if(map.containsKey(0))
                    basicService.saveToMySql(basicService.getTuShareData(baseRequest, new FundDivEntity()).get(0),"FundDivDao");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadPortfolio( FundRequestDTO dto){
        try{
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new FundPortfolioEntity(), config.getToken());
            Map<Integer, List<FundPortfolioEntity>> map = basicService.getTuShareData(baseRequest, new FundPortfolioEntity());
            if(map.containsKey(0)){
                basicService.saveToMySql(map.get(0),"FundPortfolioDao");
            }else if(map.containsKey(2)){
                Thread.sleep(10000l);
                if(map.containsKey(0))
                    basicService.saveToMySql(basicService.getTuShareData(baseRequest, new FundPortfolioEntity()).get(0),"FundPortfolioDao");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadDaily(FundRequestDTO dto){
        try{
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new FundDailyEntity(), config.getToken());
            Map<Integer, List<FundDailyEntity>> map = basicService.getTuShareData(baseRequest, new FundDailyEntity());
            if(map.containsKey(0)){
                basicService.saveToMySql(map.get(0),"FundDailyDao");
            }else if(map.containsKey(2)){
                Thread.sleep(10000l);
                if(map.containsKey(0))
                    basicService.saveToMySql(basicService.getTuShareData(baseRequest, new FundPortfolioEntity()).get(0),"FundDailyDao");
            }


//            if(map.containsKey(0)){
//                List<FundDailyEntity> list = map.get(0);
//                int size=list.size();
//                while (size>=800){
//                    dto.setStartDate(list.stream().map(FundDailyEntity::getTradeDate).max(Comparator.
//                            comparing(String::valueOf)).get());
//                    Thread.sleep(300);
//                    List<FundDailyEntity> list1 = basicService.getTuShareData(baseRequest, new FundDailyEntity()).get(0);
//                    list.addAll(list1);
//                    size=list1.size();
//                }
//                basicService.saveToMySql(list,"FundDailyDao");
//            }else if(map.containsKey(2)){
//                Thread.sleep(10000l);
//                if(map.containsKey(0)) {
//                    List<FundDailyEntity> list = map.get(0);
//                    int size=list.size();
//                    while (size>=800){
//                        dto.setStartDate(list.stream().map(FundDailyEntity::getTradeDate).max(Comparator.
//                                comparing(String::valueOf)).get());
//                        Thread.sleep(300);
//                        List<FundDailyEntity> list1 = basicService.getTuShareData(baseRequest, new FundDailyEntity()).get(0);
//                        list.addAll(list1);
//                        size=list1.size();
//                    }
//                    basicService.saveToMySql(list,"FundDailyDao");
//                }
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadAdj(){
        try{
            FundRequestDTO dto = new FundRequestDTO();
            dto.setApiName("fund_adj");
            BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new FundAdjEntity(), config.getToken());
            Map<Integer, List<FundAdjEntity>> map = basicService.getTuShareData(baseRequest, new FundAdjEntity());
            if(map.containsKey(0)){
                basicService.saveToMySql(map.get(0),"FundAdjDao");
            }else if(map.containsKey(2)){
                Thread.sleep(10000l);
                if(map.containsKey(0))
                    basicService.saveToMySql(basicService.getTuShareData(baseRequest, new FundAdjEntity()).get(0),"FundAdjDao");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
