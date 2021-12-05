package com.zcforit.dto.basic;

import com.zcforit.dto.BaseRequest;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 股票信息请求数据
 * @date : 2021-12-05 10:29
 */
@Data
@Builder
public class StockBasicDTO{
    private  String apiName;
    private String isHs; //str	N	是否沪深港通标的，N否 H沪股通 S深股通
    private String listStatus; //str	N	上市状态 L上市 D退市 P暂停上市，默认是L
    private String exchange; //str	N	交易所 SSE上交所 SZSE深交所 BSE北交所
    private String tsCode; //str	N	TS股票代码
    private String market; //str	N	市场类别 （主板/创业板/科创板/CDR/北交所）
    private String limit; //int	N
    private String offset; //int	N
    private String name; //str	N	名称
    private BaseRequest request;

    public void setRequest(){
        BaseRequest request = BaseRequest.builder()
                                .apiName(apiName)
                                .token("325114407edee775609e7b370eac76e9ad9558798958fbd92ea0eead")
                                .fields("")
                                .build();
        Map<String,String> map = new HashMap<>();
        map.put("exchange","SSE");
        request.setParams(map);
        this.request=request;
    }

    public BaseRequest getRequest(){
        return this.request;
    }

}
