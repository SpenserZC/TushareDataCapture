package com.zcforit.repository.quotation;

import com.zcforit.entity.quotation.DailyIndicatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 日线
 * @date : 2021-12-10 22:53
 */
@Repository("DailyIndicatorDao")
public interface DailyIndicatorDao extends JpaRepository<DailyIndicatorEntity,String> {
    @Query(nativeQuery = true,value = "select max(trade_date) from stock_quotation_daily_indicator")
    String findLastDate();
}
