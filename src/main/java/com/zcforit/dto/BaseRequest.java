package com.zcforit.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class BaseRequest {
    private String apiName;
    private String token;
    private Map<String,String> params;
    private String fields;
}
