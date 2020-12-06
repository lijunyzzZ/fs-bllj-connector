package com.bllj2.query.service;

import java.util.List;

import com.bllj2.query.info.QueryPageArgs;
import com.bllj2.query.info.page.ContractDiscountInfo;
import com.bllj2.query.info.page.ContractResultInfo;

/**
 *
 *
 * @author lijuny
 * @date 2020/11/8
 */
public interface QueryService {

	List<ContractResultInfo> queryContracts(QueryPageArgs args);

	List<ContractDiscountInfo> queryContractDiscount(QueryPageArgs args);

	int queryContractCount(QueryPageArgs args);

	int queryDisCount(QueryPageArgs args);

}
