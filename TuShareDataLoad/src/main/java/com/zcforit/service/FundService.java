package com.zcforit.service;

import com.zcforit.dto.fund.FundRequestDTO;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 基金数据接口
 * @date : 2022-01-13 21:32
 */
public interface FundService {
    /**
     * 基金基础数据
     * @param dto
     */
    public void loadFundBasic(FundRequestDTO dto);

    /**
     * 基金公司
     */
    public void loadCompany();

    /**
     * 基金经理
     */
    public void loadManager();

    /**
     * 拉去基金规模
     */
    public void loadShare(FundRequestDTO dto);

    /**
     * 拉去基金净值
     */
    public void loadNav(FundRequestDTO dto);

    /**
     * 拉去基金分红
     */
    public void loadDiv(FundRequestDTO dto);

    /**
     * 拉取基金持仓
     */
    public void loadPortfolio(FundRequestDTO dto);

    /**
     * 拉去基金行情
     */
    public void loadDaily(FundRequestDTO dto);

    /**
     *拉去基金复权因子
     */
    public void loadAdj();
}
