package com.zcforit.repository.finance;

import com.zcforit.entity.finance.FinanceIndicatorEntity;
import com.zcforit.entity.finance.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 日线
 * @date : 2021-12-10 22:53
 */
@Repository("FinanceIndicatorDao")
public interface FinanceIndicatorDao extends JpaRepository<FinanceIndicatorEntity,String> {
}
