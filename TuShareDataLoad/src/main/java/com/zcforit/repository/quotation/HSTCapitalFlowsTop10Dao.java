package com.zcforit.repository.quotation;

import com.zcforit.entity.quotation.HSTCapitalFlowsTop10Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 日线
 * @date : 2021-12-10 22:53
 */
@Repository("HSTCapitalFlowsTop10Dao")
public interface HSTCapitalFlowsTop10Dao extends JpaRepository<HSTCapitalFlowsTop10Entity,String> {
    @Query(nativeQuery = true,value = "select max(trade_date) from stock_quotation_hsgt_capital_flows_top10")
    String findLastDate();
}
