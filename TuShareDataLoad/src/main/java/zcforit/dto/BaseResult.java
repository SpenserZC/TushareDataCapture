package com.zcforit.dto;

import lombok.Data;

import java.util.List;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 返回值接受
 * @date 2021/12/6 11:45
 */
@Data
public class BaseResult<T> {

    private String msg;
    private String code;
    private DataRes<T> data;
    @Data
    static class DataRes<T>{
        List<String> fields;
        List<T> items;
    }
}
