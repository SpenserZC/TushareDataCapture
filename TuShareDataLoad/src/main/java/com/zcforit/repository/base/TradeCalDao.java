package com.zcforit.repository.base;

import com.zcforit.entity.base.TradeCalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 交易日历
 * @date 2021/12/13 19:08
 */
@Repository("TradeCalDao")
public interface TradeCalDao extends JpaRepository<TradeCalEntity,String> {
    @Query(nativeQuery = true,value = "select * from stock_base_trade_cal t order by t.cal_date desc limit 1")
    TradeCalEntity findLastDate();
}
