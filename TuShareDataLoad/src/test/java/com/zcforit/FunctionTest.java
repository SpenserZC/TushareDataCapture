package com.zcforit;

import com.zcforit.service.BasicQuotaService;
import com.zcforit.service.MysqlService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 方法测试
 * @date 2022/1/24 19:13
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class FunctionTest {
    @Autowired
    BasicQuotaService basicQuotaService;
    @Autowired
    MysqlService mysqlService;

    @Test
    public void test(){
        String dailyInfoLastDay = mysqlService.getDailyInfoLastDay();
        if(dailyInfoLastDay.contains("-")){
            dailyInfoLastDay=dailyInfoLastDay.replaceAll("-","");
        }
        System.out.println(dailyInfoLastDay);
//        basicQuotaService.getDatesList("20220117","20220124");
    }

}
