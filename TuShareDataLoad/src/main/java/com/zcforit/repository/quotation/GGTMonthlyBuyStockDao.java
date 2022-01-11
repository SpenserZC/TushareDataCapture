package com.zcforit.repository.quotation;

import com.zcforit.entity.quotation.GGTMonthlyBuyStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 日线
 * @date : 2021-12-10 22:53
 */
@Repository("GGTMonthlyBuyStockDao")
public interface GGTMonthlyBuyStockDao extends JpaRepository<GGTMonthlyBuyStockEntity,String> {
    @Query(nativeQuery = true,value = "select max(trade_date) from stock_quotation_hsgt_monthly_buy")
    String findLastDate();
}
