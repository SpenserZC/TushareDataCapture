package com.zcforit.controller.base;

import com.zcforit.config.TuShareConfig;
import com.zcforit.dto.BaseRequest;
import com.zcforit.dto.base.StockBasicDTO;

import com.zcforit.dto.quotation.DailyInfoDTO;
import com.zcforit.entity.base.StockBasicEntity;
import com.zcforit.entity.quotation.DailyInfoEntity;
import com.zcforit.service.base.BasicService;
import com.zcforit.utils.TuShareUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.List;


/**
 * @author zhang cheng
 * @version 1.0
 * @description: 基本数据行情
 * @date : 2021-12-05 11:01
 */
@Controller
public class BasicController implements ApplicationRunner {
    @Autowired
    BasicService basicService;

    @Autowired
    TuShareConfig config;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        loadStockBasic();
        loadDaily();
        System.exit(0);
    }

    public void loadStockBasic(){
        StockBasicDTO dto = new StockBasicDTO();
        BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new StockBasicEntity(), config.getToken());
        List<StockBasicEntity> baseStock = basicService.getTuShareData(baseRequest,new StockBasicEntity());
        System.out.println(baseStock);
//        basicService.saveBaseStock(baseStock);
    }

    public void loadDaily(){
        DailyInfoDTO dto = new DailyInfoDTO();
        dto.setTsCode("000001.SZ");
        dto.setStartDate("20211201");
        dto.setEndDate("20211209");
        BaseRequest baseRequest = TuShareUtils.transBaseRequest(dto, new DailyInfoEntity(), config.getToken());
        List<DailyInfoEntity> baseStock = basicService.getTuShareData(baseRequest,new DailyInfoEntity() );
        System.out.println(baseStock);
    }


}
