package com.zcforit.service;

import com.zcforit.dto.BaseRequest;
import org.springframework.stereotype.Service;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 财务数据
 * @date 2022/1/10 20:54
 */

public interface FinanceService {
    /**
     * 财务数据
     * @param baseRequest
     */
    public void loadFinanceIncome(BaseRequest baseRequest);
}
