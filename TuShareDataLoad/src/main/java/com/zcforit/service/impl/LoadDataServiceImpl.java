package com.zcforit.service.impl;

import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.quotation.QuotationInfoDTO;
import com.zcforit.entity.base.StockBasicEntity;
import com.zcforit.entity.base.StockCompanyEntity;
import com.zcforit.entity.base.StockNewShareEntity;
import com.zcforit.entity.base.TradeCalEntity;
import com.zcforit.entity.quotation.*;
import com.zcforit.repository.base.TradeCalDao;
import com.zcforit.service.BasicService;
import com.zcforit.service.LoadDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
            List<StockBasicEntity> res = basicService.getTuShareData(baseRequest,new StockBasicEntity()).get(0);
            basicService.saveToMySql(res,"StockBasicDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  List<StockNewShareEntity> loadNewStockCompany(BaseRequest baseRequest){
        try{
            List<StockNewShareEntity> res = basicService.getTuShareData(baseRequest,new StockNewShareEntity()).get(0);
            basicService.saveToMySql(res,"StockNewShareDao");
            return res;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void loadStockCompany(BaseRequest baseRequest){
        try{
            List<StockCompanyEntity> res = basicService.getTuShareData(baseRequest,new StockCompanyEntity()).get(0);
            basicService.saveToMySql(res,"StockCompanyDao");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void loadStockCal(BaseRequest baseRequest){
        try{
            List<TradeCalEntity> res = basicService.getTuShareData(baseRequest,new TradeCalEntity()).get(0);
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

    @Override
    public void loadDaily(String date) {
        try {
            basicService.loadByDay(new QuotationInfoDTO(), new DailyInfoEntity(),date);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadDaily(String start, String end) {
        try {
            basicService.loadByDays(new QuotationInfoDTO(), new DailyInfoEntity(),start,end);
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

    @Override
    public void loadWeekly(String date) {
        try {
            QuotationInfoDTO quotationInfoDTO = new QuotationInfoDTO();
            quotationInfoDTO.setApiName("weekly");
            basicService.loadByDay(quotationInfoDTO, new WeeklyInfoEntity(),date);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadWeekly(String start, String end) {
        try {
            QuotationInfoDTO quotationInfoDTO = new QuotationInfoDTO();
            quotationInfoDTO.setApiName("weekly");
            basicService.loadByDays(quotationInfoDTO, new WeeklyInfoEntity(),start,end);
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

    @Override
    public void loadMonthly(String date) {
        try {
            QuotationInfoDTO quotationInfoDTO = new QuotationInfoDTO();
            quotationInfoDTO.setApiName("monthly");
            basicService.loadByDay(quotationInfoDTO, new MonthlyInfoEntity(),date);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadMonthly(String start, String end) {
        try {
            QuotationInfoDTO quotationInfoDTO = new QuotationInfoDTO();
            quotationInfoDTO.setApiName("monthly");
            basicService.loadByDays(quotationInfoDTO, new MonthlyInfoEntity(),start,end);
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

    @Override
    public void loadDailyIndicator(String date) {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("daily_basic");
            basicService.loadByDay(dto, new DailyIndicatorEntity(),date);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadDailyIndicator(String start, String end) {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("daily_basic");
            basicService.loadByDays(dto, new DailyIndicatorEntity(),start,end);
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

    @Override
    public void loadCashFlows(String date) {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("moneyflow");
            basicService.loadByDay(dto, new CapitalFlowsEntity(),date);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadCashFlows(String start, String end) {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("moneyflow");
            basicService.loadByDays(dto, new CapitalFlowsEntity(),start,end);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadLimitList(){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("limit_list");
            List<TradeCalEntity> collect = tradeCalDao.findAll().stream().filter(e -> (e.getCalDate().compareTo("20200101") > 0)).collect(Collectors.toList());
            basicService.loadByCal(dto, new LimitListEntity(),collect);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadLimitList(String date){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("limit_list");
            basicService.loadByDay(dto, new LimitListEntity(),date);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadLimitList(String start, String end) {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("limit_list");
            basicService.loadByDays(dto, new LimitListEntity(),start,end);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void loadHSGTCapitalFlows(){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("moneyflow_hsgt");
            List<TradeCalEntity> collect = tradeCalDao.findAll().stream().filter(e -> (e.getCalDate().compareTo("20100101") > 0)).collect(Collectors.toList());
            basicService.loadByCal(dto, new HSGTCapitalFlowsEntity(),collect);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadHSGTCapitalFlows(String date){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("moneyflow_hsgt");
            basicService.loadByDay(dto, new HSGTCapitalFlowsEntity(),date);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadHSGTCapitalFlows(String start, String end) {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("moneyflow_hsgt");
            basicService.loadByDays(dto, new HSGTCapitalFlowsEntity(),start,end);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void loadHSTCapitalFlowsTop10(){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("hsgt_top10");
            List<TradeCalEntity> collect = tradeCalDao.findAll().stream().filter(e -> (e.getCalDate().compareTo("20100101") > 0)).collect(Collectors.toList());
            basicService.loadByCal(dto, new HSTCapitalFlowsTop10Entity(),collect);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadHSTCapitalFlowsTop10(String date) {
        QuotationInfoDTO dto = new QuotationInfoDTO();
        dto.setApiName("hsgt_top10");
        try {
            basicService.loadByDay(dto, new HSTCapitalFlowsTop10Entity(),date);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadHSTCapitalFlowsTop10(String start, String end) {
        QuotationInfoDTO dto = new QuotationInfoDTO();
        dto.setApiName("hsgt_top10");
        try {
            basicService.loadByDays(dto, new HSTCapitalFlowsTop10Entity(),start,end);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void loadGGTCapitalFlowsTop10(){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("ggt_top10");
            List<TradeCalEntity> collect = tradeCalDao.findAll().stream().filter(e -> (e.getCalDate().compareTo("20100101") > 0)).collect(Collectors.toList());
            basicService.loadByCal(dto, new GGTCapitalFlowsTop10Entity(),collect);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadGGTCapitalFlowsTop10(String date) {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("ggt_top10");
            basicService.loadByDay(dto, new GGTCapitalFlowsTop10Entity(),date);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadGGTCapitalFlowsTop10(String start, String end) {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("ggt_top10");
            basicService.loadByDays(dto, new GGTCapitalFlowsTop10Entity(),start,end);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadHSGTHoldStock(){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("hk_hold");
            List<TradeCalEntity> collect = tradeCalDao.findAll().stream().filter(e -> (e.getCalDate().compareTo("20100101") > 0)).collect(Collectors.toList());
            basicService.loadByCal(dto, new HSGTHoldStockEntity(),collect);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadHSGTHoldStock(String date) {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("hk_hold");
            basicService.loadByDay(dto, new HSGTHoldStockEntity(),date);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadHSGTHoldStock(String start, String end) {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("hk_hold");
            basicService.loadByDays(dto, new HSGTHoldStockEntity(),start,end);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadGGTDailyBuyStock(){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("ggt_daily");
            List<TradeCalEntity> collect = tradeCalDao.findAll().stream().filter(e -> (e.getCalDate().compareTo("20100101") > 0)).collect(Collectors.toList());
            basicService.loadByCal(dto, new GGTDailyBuyStockEntity(),collect);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadGGTDailyBuyStock(String date) {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("ggt_daily");
            basicService.loadByDay(dto, new GGTDailyBuyStockEntity(),date);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadGGTDailyBuyStock(String start, String end) {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("ggt_daily");
            basicService.loadByDays(dto, new GGTDailyBuyStockEntity(),start,end);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void loadGGTMonthlyBuyStock(){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("ggt_monthly");
            List<TradeCalEntity> collect = tradeCalDao.findAll().stream().filter(e -> (e.getCalDate().compareTo("20100101") > 0)).collect(Collectors.toList());
            basicService.loadByCal(dto, new GGTMonthlyBuyStockEntity(),collect);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadGGTMonthlyBuyStock(String date) {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("ggt_monthly");
            basicService.loadByDay(dto, new GGTMonthlyBuyStockEntity(),date);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadGGTMonthlyBuyStock(String start, String end) {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("ggt_monthly");
            basicService.loadByDays(dto, new GGTMonthlyBuyStockEntity(),start,end);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void loadCenterHoldStock(){
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("ccass_hold_detail");
            List<TradeCalEntity> collect = tradeCalDao.findAll().stream().filter(e -> (e.getCalDate().compareTo("20100101") > 0)).collect(Collectors.toList());
            basicService.loadByCal(dto, new CenterHoldStockEntity(),collect);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadCenterHoldStock(String date) {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("ccass_hold_detail");
            basicService.loadByDay(dto, new CenterHoldStockEntity(),date);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadCenterHoldStock(String start, String end) {
        try {
            QuotationInfoDTO dto = new QuotationInfoDTO();
            dto.setApiName("ccass_hold_detail");
            basicService.loadByDays(dto, new CenterHoldStockEntity(),start,end);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
