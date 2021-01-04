package com.bllj2.query.mapper;

import java.util.List;
import java.util.Map;

import com.bllj2.query.info.QueryPageArgs;
import com.bllj2.query.info.page.ContractDiscountInfo;
import com.bllj2.query.info.page.PageDBResult;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 *
 * @author lijuny
 * @date 2020/11/8
 */
@Repository
@Mapper
public interface QueryServiceMapper {

	List<PageDBResult> queryContract(QueryPageArgs args);

	int countContract(QueryPageArgs args);

	List<ContractDiscountInfo> queryDiscount(QueryPageArgs args);

	int countDiscount(QueryPageArgs args);

	Map<String, Object> queryContractOne(String contractNumber);
}
