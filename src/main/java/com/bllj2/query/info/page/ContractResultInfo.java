package com.bllj2.query.info.page;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 合同分页查询返回的结构
 *
 * @author lijuny
 * @date 2020/11/8
 */

public class ContractResultInfo  extends  ContractInfo {
	private List<ContractDetailInfo> contractDetails;
	private List<ContractStoreInfo> contractStores;

	public List<ContractDetailInfo> getContractDetails() {
		if (contractDetails == null) {
			contractDetails = new ArrayList<>();
		}
		return contractDetails;
	}
	public void addContractDetail(ContractDetailInfo detail) {
		getContractDetails().add(detail);
	}

	public List<ContractStoreInfo> getContractStores() {
		if (contractStores == null) {
			contractStores = new ArrayList<>();
		}
		return contractStores;
	}

	public void addContractStore(ContractStoreInfo contractStoreInfo) {
		getContractStores().add(contractStoreInfo);
	}

	public static ContractResultInfo create(PageDBResult result) {
		ContractResultInfo contractResultInfo = new ContractResultInfo();
		contractResultInfo.setContractId(result.getContractId());
		contractResultInfo.setContractNumber(result.getContractNumber());
		contractResultInfo.setAccountNo(result.getOutletNo());
		contractResultInfo.setContractType(result.getContractType());
		contractResultInfo.setStore(result.getOutletName());
		contractResultInfo.setStoreType(result.getOutletType());
		contractResultInfo.setPrcContract(result.isPrcContract());
		contractResultInfo.setStartDate(result.getStartDate());
		contractResultInfo.setEndDate(result.getEndDate());
		contractResultInfo.setSignerDate(result.getSignDate());
		contractResultInfo.setSignerId(result.getSignerId());
		contractResultInfo.setSignerName(result.getSignerName());
		contractResultInfo.setCompleteDisCount(result.getCompleteDisCount());
		contractResultInfo.setDiscountTargetRate(result.getDiscountTargetRate());
		contractResultInfo.setExtraDiscount(result.getExtraDiscount());
		contractResultInfo.setActivitySession(result.getActivitySession());
		contractResultInfo.setContractVersion(result.getContractVersion());
		contractResultInfo.setContractState(result.getContractState());
		contractResultInfo.setPoNo(result.getPoNo());
		contractResultInfo.setTargetBase(result.getTargetBase());
		contractResultInfo.setCreateTime(result.getCreateTime());
		contractResultInfo.setLastModifiedTime(result.getLastModifiedTime());
		return contractResultInfo;
	}
}
