package com.zcforit.repository.fund;

import com.zcforit.entity.finance.BalanceEntity;
import com.zcforit.entity.fund.FundAdjEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 日线
 * @date : 2021-12-10 22:53
 */
@Repository("FundAdjDao")
public interface FundAdjDao extends JpaRepository<FundAdjEntity,String> {
}
