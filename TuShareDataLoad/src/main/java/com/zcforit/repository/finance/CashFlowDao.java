package com.zcforit.repository.finance;

import com.zcforit.entity.finance.CashFlowEntity;
import com.zcforit.entity.finance.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 日线
 * @date : 2021-12-10 22:53
 */
@Repository("CashFlowDao")
public interface CashFlowDao extends JpaRepository<CashFlowEntity,String> {
}
