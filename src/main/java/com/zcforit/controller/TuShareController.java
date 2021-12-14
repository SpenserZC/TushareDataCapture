package com.zcforit.controller;

import com.zcforit.service.base.BasicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 实时服务，接受请求参数
 * @date 2021/12/14 20:16
 */
@Slf4j
@RestController
@RequestMapping("/dc/company/detail/v1")
public class TuShareController {
    @Autowired
    BasicService basicService;

    @GetMapping(path = "/init")
    public String getS(String dto) {
       return "OK";
    }

//    @GetMapping(path = "/")
//    public String getS(String date) {
//        CompanyBaseInfoEntity companyBaseInfoEntity = service.getCompanyBaseInfoByCompanyId(dto.getId());
//        return BaseResultEntity.success(companyBaseInfoEntity);
//    }

}
