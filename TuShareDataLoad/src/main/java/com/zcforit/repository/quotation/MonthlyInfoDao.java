package com.zcforit.repository.quotation;

import com.zcforit.entity.quotation.MonthlyInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zhang cheng
 * @version 1.0
 * @description:
 * @date 2021/12/11 15:10
 */
@Repository("MonthlyInfoDao")
public interface MonthlyInfoDao extends JpaRepository<MonthlyInfoEntity,String> {
    @Query(nativeQuery = true,value = "select max(trade_date) from stock_quotation_monthly")
    String findLastDate();
}
