package com.zcforit.controller;

import com.zcforit.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 基金接口
 * @date : 2022-01-13 21:54
 */
@Controller
public class FundController implements ApplicationRunner {
    @Autowired
    FundService fundService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
            fundService.loadFundBasic();

    }
}
