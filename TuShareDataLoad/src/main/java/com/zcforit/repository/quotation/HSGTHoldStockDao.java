package com.zcforit.repository.quotation;

import com.zcforit.entity.quotation.HSGTHoldStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 日线
 * @date : 2021-12-10 22:53
 */
@Repository("HSGTHoldStockDao")
public interface HSGTHoldStockDao extends JpaRepository<HSGTHoldStockEntity,String> {
    @Query(nativeQuery = true,value = "select max(trade_date) from stock_quotation_hsgt_hold_stock")
    String findLastDate();
}
