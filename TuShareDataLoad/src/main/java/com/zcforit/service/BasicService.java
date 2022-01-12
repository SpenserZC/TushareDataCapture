package com.zcforit.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zcforit.config.ApplicationContextHelper;
import com.zcforit.config.HttpComponent;
import com.zcforit.config.TuShareConfig;
import com.zcforit.dto.BaseRequest;
import com.zcforit.entity.base.TradeCalEntity;
import com.zcforit.entity.error.ErrorEntity;
import com.zcforit.utils.CommenUtils;
import com.zcforit.utils.TuShareUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private String url="http://api.waditu.com";


    public <T> boolean saveToMySql(List<T> lists,String beanName){
        try{
            JpaRepository repository =(JpaRepository)  ApplicationContextHelper.getBean(beanName);
            if(repository!=null)
                repository.saveAll(lists);
            else log.info("找不到对应的bean");
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 返回resMap,0 有数据且返回数据,1 没数据没有返回数据, 2 有数据但没有返回数据,触发访问限制
     * @param dto
     * @param t
     * @param <T>
     * @return
     */
    public <T> Map<Integer, List<T>> getTuShareData(BaseRequest dto, T t){
        Map<Integer, List<T>> resMap = new HashMap<>();
        try{
            JSONObject result = component.post(url, tuShare.headerMap(), CommenUtils.objectToStr(dto));
            String code = result.get("code").toString();
            if("0".equals(code)){
                JSONArray jsonArray = result.getJSONObject("data").getJSONArray("items");
                log.info("拉取了"+jsonArray.size()+"条数据");
                if(jsonArray.size()>0)
                    resMap.put(0,TuShareUtils.analyzeTSResult(result, t));
                else resMap.put(1,null);
            }else{
                resMap.put(2,null);
            }
            return resMap;
        }catch (Exception e){
            log.info("拉取数据失败");
        }
       return resMap;
    }

    /**
     * 通过日历拉取数据
     * @param t
     * @param e
     * @param all
     * @param <T>
     * @param <E>
     * @throws InterruptedException
     */
    public <T,E>void loadByCal(T t,E e,List<TradeCalEntity> all) throws InterruptedException {
        int failCnt = 0;
        for (int i = 0; i < all.size(); i++) {
            BaseRequest baseRequest = null;
            try {
                Field tradeDate = t.getClass().getDeclaredField("tradeDate");
                tradeDate.setAccessible(true);
                tradeDate.set(t,all.get(i).getCalDate());
                baseRequest = TuShareUtils.transBaseRequest(t, e, tuShare.getToken());
                Map<Integer, List<E>> res = getTuShareData(baseRequest,e);
                if(res.containsKey(0)){
                    saveToMySql(res.get(0),e.getClass().getSimpleName().replace("Entity","Dao"));
                    log.info(all.get(i).getCalDate()+" 股市数据拉取存储完成");
                    Thread.sleep(200l);
                    if(failCnt!=0){failCnt=0;}
                }else if(res.containsKey(2)){
                    if(failCnt<3){
                        failCnt++;
                        i=i-1;
                        Thread.sleep(10000l);
                    }else{
                        ErrorEntity errorEntity = new ErrorEntity();
                        errorEntity.setApiName(baseRequest.getApiName());
                        errorEntity.setKey(all.get(i).getCalDate());
                        errorEntity.setExceptionInfo("get file");
                        List<ErrorEntity> errorEntities = new ArrayList<>();
                        errorEntities.add(errorEntity);
                        saveToMySql(errorEntities,"ErrorDao");
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        log.info("数据拉取完成");
    }

    public <T,E>void loadByDay(T t,E e,String date) throws InterruptedException {
            BaseRequest baseRequest = null;
            try {
                Field tradeDate = t.getClass().getDeclaredField("tradeDate");
                tradeDate.setAccessible(true);
                tradeDate.set(t,date);
                baseRequest = TuShareUtils.transBaseRequest(t, e, tuShare.getToken());
                Map<Integer, List<E>> res = getTuShareData(baseRequest,e);
                if(res.containsKey(0)){
                    saveToMySql(res.get(0),e.getClass().getSimpleName().replace("Entity","Dao"));
                    log.info(date+" 股市数据拉取存储完成");
                }else if(res.containsKey(2)){
                    Thread.sleep(30000l);
                    Map<Integer, List<E>> res2 = getTuShareData(baseRequest,e);
                    if(res2.containsKey(0))
                        saveToMySql(res.get(0),e.getClass().getSimpleName().replace("Entity","Dao"));
                    log.info(date+" 股市数据拉取存储完成");
                }else{
                    ErrorEntity errorEntity = new ErrorEntity();
                    errorEntity.setApiName(baseRequest.getApiName());
                    errorEntity.setKey(date);
                    errorEntity.setExceptionInfo("数据拉取失败");
                    List<ErrorEntity> errorEntities = new ArrayList<>();
                    errorEntities.add(errorEntity);
                    saveToMySql(errorEntities,"ErrorDao");
                }
                Thread.sleep(200l);
            } catch (Exception exception) {
                exception.printStackTrace();
                    ErrorEntity errorEntity = new ErrorEntity();
                    errorEntity.setApiName(baseRequest.getApiName());
                    errorEntity.setKey(date);
                    errorEntity.setExceptionInfo(exception.getMessage());
                    List<ErrorEntity> errorEntities = new ArrayList<>();
                    errorEntities.add(errorEntity);
                    saveToMySql(errorEntities,"ErrorDao");
            }
        log.info("数据拉取完成");
    }
    public <T,E>void loadByDays(T t,E e,String start,String end) throws InterruptedException {
        BaseRequest baseRequest = null;
        try {
            Field startDate = t.getClass().getDeclaredField("startDate");
            startDate.setAccessible(true);
            startDate.set(t,start);
            Field endDate = t.getClass().getDeclaredField("endDate");
            endDate.setAccessible(true);
            endDate.set(t,end);
            baseRequest = TuShareUtils.transBaseRequest(t, e, tuShare.getToken());
            Map<Integer, List<E>> res = getTuShareData(baseRequest,e);
            if(res.containsKey(0)){
                saveToMySql(res.get(0),e.getClass().getSimpleName().replace("Entity","Dao"));
                log.info(start+"-"+end+" 股市数据拉取存储完成");
            }else if(res.containsKey(2)){
                Thread.sleep(30000l);
                Map<Integer, List<E>> res2 = getTuShareData(baseRequest,e);
                if(res2.containsKey(0))
                    saveToMySql(res.get(0),e.getClass().getSimpleName().replace("Entity","Dao"));
                log.info(start+"-"+end+" 股市数据拉取存储完成");
            }else{
                ErrorEntity errorEntity = new ErrorEntity();
                errorEntity.setApiName(baseRequest.getApiName());
                errorEntity.setKey(start+"-"+end);
                errorEntity.setExceptionInfo("数据拉取失败");
                List<ErrorEntity> errorEntities = new ArrayList<>();
                errorEntities.add(errorEntity);
                saveToMySql(errorEntities,"ErrorDao");
            }
            Thread.sleep(200l);
        } catch (Exception exception) {
            exception.printStackTrace();
            ErrorEntity errorEntity = new ErrorEntity();
            errorEntity.setApiName(baseRequest.getApiName());
            errorEntity.setKey(start+"-"+end);
            errorEntity.setExceptionInfo(exception.getMessage());
            List<ErrorEntity> errorEntities = new ArrayList<>();
            errorEntities.add(errorEntity);
            saveToMySql(errorEntities,"ErrorDao");
        }
        log.info("数据拉取完成");
    }



}
