package com.zcforit.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 网络参数
 * @date 2021/12/3 17:11
 */

@Component
@ConfigurationProperties(prefix = "http.pool")
@Data
public class HttpPoolProperties {
    private Integer maxTotal;
    private Integer defaultMaxPerRoute;
    private Integer connectTimeout;
    private Integer connectionRequestTimeout;
    private Integer socketTimeout;
    private Integer validateAfterInactivity;
}
