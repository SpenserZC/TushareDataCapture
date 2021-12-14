package com.zcforit.repository.base;

import com.zcforit.entity.base.StockCompanyEntity;
import com.zcforit.entity.base.TradeCalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 上市公司信息
 * @date 2021/12/13 19:09
 */
@Repository("StockCompanyDao")
public interface StockCompanyDao  extends JpaRepository<StockCompanyEntity,String> {
}
