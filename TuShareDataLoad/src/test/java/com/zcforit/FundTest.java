package com.zcforit;

import com.zcforit.dto.fund.FundRequestDTO;
import com.zcforit.service.FundService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        fundService.loadShare();
    }


}
