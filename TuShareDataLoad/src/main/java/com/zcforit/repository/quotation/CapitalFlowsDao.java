package com.zcforit.repository.quotation;

import com.zcforit.entity.quotation.CapitalFlowsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 日线
 * @date : 2021-12-10 22:53
 */
@Repository("CapitalFlowsDao")
public interface CapitalFlowsDao extends JpaRepository<CapitalFlowsEntity,String> {
    @Query(nativeQuery = true,value = "select max(trade_date) from stock_quotation_capital_flows")
    String findLastDate();
}
