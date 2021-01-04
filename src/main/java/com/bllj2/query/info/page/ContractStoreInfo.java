package com.bllj2.query.info.page;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 *
 *
 * @author lijuny
 * @date 2020/11/6
 */
@Getter
@Setter
public class ContractStoreInfo {
	//id不返回到前端，忽略掉
	@JsonIgnore
	private String contractStoreId;
	private String branchStore;
	private String storeNumber;
	private long createTime;
	private long lastModifiedTime;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ContractStoreInfo that = (ContractStoreInfo) o;
		return contractStoreId == that.contractStoreId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contractStoreId);
	}

	public static ContractStoreInfo create(PageDBResult result) {
		if (result.getContractStoreId() == null ) {
			return null;
		}
		ContractStoreInfo contractStoreInfo = new ContractStoreInfo();
		contractStoreInfo.setContractStoreId(result.getContractStoreId());
		contractStoreInfo.setBranchStore(result.getStoreOutletName());
		contractStoreInfo.setStoreNumber(result.getStoreOutletNo());
		contractStoreInfo.setCreateTime(result.getStoreCreateTime());
		contractStoreInfo.setLastModifiedTime(result.getStoreLastModifiedTime());
		return contractStoreInfo;
	}
}
