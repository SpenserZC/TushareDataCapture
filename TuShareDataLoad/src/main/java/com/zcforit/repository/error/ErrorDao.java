package com.zcforit.repository.error;

import com.zcforit.entity.error.ErrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 收集错误信息
 * @date 2021/12/14 17:52
 */
@Repository("ErrorDao")
public interface ErrorDao extends JpaRepository<ErrorEntity,String> {
}
