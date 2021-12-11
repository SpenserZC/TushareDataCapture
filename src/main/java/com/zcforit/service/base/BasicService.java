package com.zcforit.service.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zcforit.config.ApplicationContextHelper;
import com.zcforit.config.HttpComponent;
import com.zcforit.config.TuShareConfig;
import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.BaseResult;
import com.zcforit.entity.base.StockBasicEntity;
import com.zcforit.repository.base.StockBasicRepository;
import com.zcforit.utils.CommenUtils;
import com.zcforit.utils.TuShareUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 基础股票信息
 * @date : 2021-12-05 10:37
 */
@Slf4j
@Service
public class BasicService {
    @Autowired
    HttpComponent component;
    @Autowired
    TuShareConfig tuShare;

    @Autowired
    StockBasicRepository stockBasicRepository;

    private String url="http://api.waditu.com";

    public List<StockBasicEntity> getBaseStock(BaseRequest dto){
        JSONObject result = component.post(url, tuShare.headerMap(), CommenUtils.objectToStr(dto));
        List<StockBasicEntity> stockBasicEntities = null;
        try {
            stockBasicEntities= TuShareUtils.analyzeTSResult(result, new StockBasicEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockBasicEntities;
    }

    public boolean saveBaseStock(List<StockBasicEntity> lists){
        try{
            List<StockBasicEntity> stockBasicEntities = stockBasicRepository.saveAll(lists);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public <T> boolean saveToMySql(List<T> lists,String beanName){
        try{
            JpaRepository repository =(JpaRepository)  ApplicationContextHelper.getBean(beanName);
            if(repository!=null)
                repository.saveAll(lists);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public <T> List<T> getTuShareData(BaseRequest dto,T t){
        JSONObject result = component.post(url, tuShare.headerMap(), CommenUtils.objectToStr(dto));
        List<T> tList = null;
        try {
            tList= TuShareUtils.analyzeTSResult(result, t);
        } catch (Exception e) {
            log.info(result.toJSONString());
            e.printStackTrace();
        }
        return tList;
    }


}
