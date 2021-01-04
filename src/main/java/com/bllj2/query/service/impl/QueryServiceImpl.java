package com.bllj2.query.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bllj2.query.info.QueryPageArgs;
import com.bllj2.query.info.page.ContractDetailInfo;
import com.bllj2.query.info.page.ContractDiscountInfo;
import com.bllj2.query.info.page.ContractResultInfo;
import com.bllj2.query.info.page.ContractStoreInfo;
import com.bllj2.query.info.page.PageDBResult;
import com.bllj2.query.mapper.QueryServiceMapper;
import com.bllj2.query.service.QueryService;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @author lijuny
 * @date 2020/11/8
 */
@Component
public class QueryServiceImpl implements QueryService {
	private final QueryServiceMapper mapper;

	public QueryServiceImpl(QueryServiceMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<ContractResultInfo> queryContracts(QueryPageArgs args) {
		List<PageDBResult> pageDBResults = mapper.queryContract(args);
		pageDBResults.sort(PageDBResult.pageDBResultComparator);
		return groupContract(pageDBResults).stream().filter(list -> !list.isEmpty()).map(this::convertResult).collect(Collectors.toList());
	}

	@Override
	public List<ContractDiscountInfo> queryContractDiscount(QueryPageArgs args) {
		return mapper.queryDiscount(args);
	}

	@Override
	public int queryContractCount(QueryPageArgs args) {
		return mapper.countContract(args);
	}

	@Override
	public int queryDisCount(QueryPageArgs args) {
		return mapper.countDiscount(args);
	}

	@Override
	public Map<String, Object> queryContract(String contractNumber) {
		return mapper.queryContractOne(contractNumber);
	}


	/**
	 * 将查询出来的笛卡尔积分组。
	 *
	 * @param results
	 * @return
	 */
	private List<List<PageDBResult>> groupContract(List<PageDBResult> results) {
		if (CollectionUtils.isEmpty(results)) {
			return Collections.emptyList();
		}
		List<List<PageDBResult>> res = new ArrayList<>();
		List<PageDBResult> current = new ArrayList<>();
		String currentId = results.get(0).getContractId();
		for (PageDBResult result : results) {
			if (result.getContractId() == currentId) {
				current.add(result);
				continue;
			}
			currentId = result.getContractId();
			res.add(new ArrayList<>(current));
			current.clear();
			current.add(result);
		}
		if (!current.isEmpty()) {
			res.add(current);
		}
		return res;
	}

	/**
	 * 将查询出来的每一个合同结果转化成{@link ContractResultInfo}
	 *
	 * @param pageDBResults 一个合同的结果
	 * @return
	 */
	private ContractResultInfo convertResult(List<PageDBResult> pageDBResults) {
		ContractResultInfo contractResultInfo = ContractResultInfo.create(pageDBResults.get(0));

		LinkedHashSet<ContractStoreInfo> storeInfos = new LinkedHashSet<>();
		LinkedHashSet<ContractDetailInfo> detailInfos = new LinkedHashSet<>();

		for (PageDBResult pageDBResult : pageDBResults) {
			ContractStoreInfo contractStoreInfo = ContractStoreInfo.create(pageDBResult);
			if (contractStoreInfo != null) {
				storeInfos.add(contractStoreInfo);
			}
			ContractDetailInfo contractDetailInfo = ContractDetailInfo.create(pageDBResult);
			if (contractDetailInfo != null) {
				detailInfos.add(contractDetailInfo);
			}
		}
		/*
		 * 保证每次返回的数据都是有序的，这里用list sort 排序，依据是id（这个id是不会返回到前端的）
		 */
		List<ContractStoreInfo> contractStoreInfos = new ArrayList<>(storeInfos);
//		contractStoreInfos.sort((o1, o2) -> {
//			return String.CASE_INSENSITIVE_ORDER.compare(o1.getContractStoreId(), o2.getContractStoreId());
//		});
		List<ContractDetailInfo> contractDetailInfos = new ArrayList<>(detailInfos);
//		contractDetailInfos.sort((o1, o2) -> {
//			return String.CASE_INSENSITIVE_ORDER.compare(o1.getContractDetailId(), o2.getContractDetailId());
//		});
		contractResultInfo.getContractStores().addAll(contractStoreInfos);
		contractResultInfo.getContractDetails().addAll(contractDetailInfos);
		return contractResultInfo;
	}
}
