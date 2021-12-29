package com.zcforit.service.impl;

import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.quotation.QuotationInfoDTO;
import com.zcforit.entity.base.StockBasicEntity;
import com.zcforit.entity.base.StockCompanyEntity;
import com.zcforit.entity.base.TradeCalEntity;
import com.zcforit.entity.quotation.*;
import com.zcforit.repository.base.TradeCalDao;
import com.zcforit.service.BasicService;
import com.zcforit.service.LoadDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 拉取数据并存储
 * @date : 2021-12-29 22:23
 */
@Slf4j
@Service
public class LoadDataServiceImpl implements LoadDataService {

    @Autowired
    BasicService basicService;
    @Autowired
    TradeCalDao tradeCalDao;


    public void loadStockBasic(BaseRequest baseRequest){
        try{
            List<StockBasicEntity> res = basicService.getTuShareData(baseRequest,new StockBasicEntity());
            basicService.saveToMySql(res,"StockBasicDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void loadStockCompany(BaseRequest baseRequest){
        try{
            List<StockCompanyEntity> res = basicService.getTuShareData(baseRequest,new StockCompanyEntity());
            basicService.saveToMySql(res,"StockCompanyDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void loadStockCal(BaseRequest baseRequest){
        try{
            List<TradeCalEntity> res = basicService.getTuShareData(baseRequest,new TradeCalEntity());
            basicService.saveToMySql(res,"TradeCalDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadDaily() {
        try {
            basicService.loadByCal(new QuotationInfoDTO(), new DailyInfoEntity(), tradeCalDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void loadWeekly(){
        try {
            QuotationInfoDTO quotationInfoDTO = new QuotationInfoDTO();
            quotationInfoDTO.setApiName("weekly");
            basicService.loadByCal(quotationInfoDTO, new WeeklyInfoEntity(),tradeCalDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void loadMonthly(){
        try {
            QuotationInfoDTO quotationInfoDTO = new QuotationInfoDTO();
            quotationInfoDTO.setApiName("monthly");
            basicService.loadByCal(quotationInfoDTO, new MonthlyInfoEntity(),tradeCalDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadDailyIndicator()  {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("daily_basic");
            basicService.loadByCal(dto, new DailyIndicatorEntity(),tradeCalDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadCashFlows() {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("moneyflow");
            basicService.loadByCal(dto, new CapitalFlowsEntity(),tradeCalDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadLimitList(){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("limit_list");
            basicService.loadByCal(dto, new LimitListEntity(),tradeCalDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadHSGTCapitalFlows(){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("moneyflow_hsgt");
            basicService.loadByCal(dto, new HSGTCapitalFlowsEntity(),tradeCalDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadHSTCapitalFlowsTop10(){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("hsgt_top10");
            basicService.loadByCal(dto, new HSTCapitalFlowsTop10Entity(),tradeCalDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadGGTCapitalFlowsTop10(){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("ggt_top10");
            basicService.loadByCal(dto, new GGTCapitalFlowsTop10Entity(),tradeCalDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadHSGTHoldStock(){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("hk_hold");
            basicService.loadByCal(dto, new HSGTHoldStockEntity(),tradeCalDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadGGTDailyBuyStock(){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("ggt_top10");
            basicService.loadByCal(dto, new GGTDailyBuyStockEntity(),tradeCalDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void loadGGTMonthlyBuyStock(){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("ggt_daily");
            basicService.loadByCal(dto, new GGTMonthlyBuyStockEntity(),tradeCalDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void loadCenterHoldStock(){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("ccass_hold_detail");
            basicService.loadByCal(dto, new CenterHoldStockEntity(),tradeCalDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
