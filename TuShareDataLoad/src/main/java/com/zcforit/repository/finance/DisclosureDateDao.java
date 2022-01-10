package com.zcforit.repository.finance;

import com.zcforit.entity.finance.DisclosureDateEntity;
import com.zcforit.entity.finance.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 日线
 * @date : 2021-12-10 22:53
 */
@Repository("DisclosureDateDao")
public interface DisclosureDateDao extends JpaRepository<DisclosureDateEntity,String> {
}
