package com.zcforit.repository.base;

import com.zcforit.entity.base.StockBasicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 操作数据库
 * @date 2021/12/6 16:51
 */
@Repository
public interface StockBasicRepository extends JpaRepository<StockBasicEntity,String> {
}
