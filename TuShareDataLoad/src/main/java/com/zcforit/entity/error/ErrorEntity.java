package com.zcforit.entity.error;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: TODO
 * @date 2021/12/14 17:36
 */
@Data
@Entity
@Table(name="tushare_error_log")
public class ErrorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //自增id
    private String apiName;
    @Column(name="`key`")
    private String key;
    private String exceptionInfo;
}
