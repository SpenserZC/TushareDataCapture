package com.zcforit.service;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: mysql 本地库操作
 * @date : 2021-12-30 21:49
 */
public interface MysqlService {
    /**
     * 获取本地库最后一天
     * @return
     */
    public String getLastDate();

}
