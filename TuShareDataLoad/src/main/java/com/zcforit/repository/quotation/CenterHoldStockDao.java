package com.zcforit.repository.quotation;

import com.zcforit.entity.quotation.CenterHoldStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 日线
 * @date : 2021-12-10 22:53
 */
@Repository("CenterHoldStockDao")
public interface CenterHoldStockDao extends JpaRepository<CenterHoldStockEntity,String> {
}
