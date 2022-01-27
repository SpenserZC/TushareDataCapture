package com.zcforit;

import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.fund.FundRequestDTO;
import com.zcforit.entity.base.TradeCalEntity;
import com.zcforit.entity.fund.FundBasicEntity;
import com.zcforit.entity.fund.FundDivEntity;
import com.zcforit.service.BasicQuotaService;
import com.zcforit.service.FundService;
import com.zcforit.service.MysqlService;
import com.zcforit.utils.TuShareUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: TODO
 * @date 2022/1/26 14:37
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class FundTest {
    @Autowired
    FundService fundService;
    @Autowired
    MysqlService mysqlService;
    @Autowired
    BasicQuotaService basicQuotaService;
    @Autowired
    BasicQuotaService quotaService;

    @Test
    public void FundBasic(){
        FundRequestDTO dto = new FundRequestDTO();
        //L E 1081,L O 13533,I E 6, I O 573
        dto.setApiName("fund_basic");
        dto.setStatus("I");
        dto.setMarket("O");
        fundService.loadFundBasic(dto);
    }

    @Test
    public void FundCompany(){
        fundService.loadCompany();
    }

    @Test
    public void FundManager(){
        fundService.loadManager();
    }

    @Test
    public void FundShare(){
        List<FundBasicEntity> allFund = mysqlService.getAllFund();
        for (FundBasicEntity fund:allFund){
            FundRequestDTO dto = new FundRequestDTO();
            dto.setApiName("fund_share");
            dto.setTsCode(fund.getTsCode());
            fundService.loadShare(dto);
        }
    }


    @Test
    public void FundNav(){
        List<FundBasicEntity> allFund = mysqlService.getAllFund();
        for (FundBasicEntity fund:allFund){
            FundRequestDTO dto = new FundRequestDTO();
            dto.setApiName("fund_nav");
            dto.setTsCode(fund.getTsCode());
            fundService.loadNav(dto);
        }
    }
    @Test
    public void loadDiv(){
        List<FundBasicEntity> allFund = mysqlService.getAllFund();
        FundRequestDTO dto = new FundRequestDTO();
        dto.setApiName("fund_div");
        for (FundBasicEntity fund:allFund) {
            dto.setTsCode(fund.getTsCode());
            fundService.loadDiv(dto);
            break;
        }
    }
    @Test
    public void loadPortfolio(){
        List<FundBasicEntity> allFund = mysqlService.getAllFund();
        FundRequestDTO dto = new FundRequestDTO();
        dto.setApiName("fund_portfolio");
        for (FundBasicEntity fund:allFund) {
            dto.setTsCode(fund.getTsCode());
            fundService.loadDiv(dto);
            break;
        }
    }
    @Test
    public void loadDaily(){
        List<TradeCalEntity> datesList = basicQuotaService.getDatesList("20220101", "20220127");

        List<FundBasicEntity> allFund = mysqlService.getAllFund();
        List<FundBasicEntity> collect = allFund.stream().sorted(Comparator.comparing(FundBasicEntity::getTsCode)
                .reversed()).collect(Collectors.toList());
        FundRequestDTO dto = new FundRequestDTO();

//        mysqlService.getDailyInfoLastDay()
        for (TradeCalEntity fund:datesList) {
            dto.setApiName("fund_daily");
            dto.setTradeDate(fund.getCalDate());
//            dto.setTsCode(fund.getTsCode());
//            dto.setStartDate("20220127");
//            dto.setEndDate("20200101");
            fundService.loadDaily(dto);
        }
    }

    @Test
    public void loadAdj(){
        List<TradeCalEntity> datesList = basicQuotaService.getDatesList("20220101", "20220127");
        FundRequestDTO dto = new FundRequestDTO();
        dto.setApiName("fund_adj");
        for (TradeCalEntity fund:datesList) {

            dto.setTradeDate(fund.getCalDate());
//            dto.setTsCode(fund.getTsCode());
//            dto.setStartDate("20220127");
//            dto.setEndDate("20200101");
            fundService.loadDaily(dto);
        }
    }

}
