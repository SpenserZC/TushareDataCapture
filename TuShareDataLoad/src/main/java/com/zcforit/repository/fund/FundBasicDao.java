package com.zcforit.repository.fund;

import com.zcforit.entity.finance.BalanceEntity;
import com.zcforit.entity.fund.FundBasicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 日线
 * @date : 2021-12-10 22:53
 */
@Repository("FundBasicDao")
public interface FundBasicDao extends JpaRepository<FundBasicEntity,String> {
}
