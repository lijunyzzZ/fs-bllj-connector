package com.bllj2.query.info.page;

import java.math.BigDecimal;
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
public class ContractDetailInfo {
	@JsonIgnore
	private long contractDetailId;
	private String subBrandNo;
	private String subBrandName;
	private BigDecimal targetVolume;
	private BigDecimal targetValue;
	private boolean keySubbranch;
	private long createTime;
	private long lastModifiedTime;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ContractDetailInfo that = (ContractDetailInfo) o;
		return contractDetailId == that.contractDetailId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contractDetailId);
	}

	public static ContractDetailInfo create(PageDBResult result) {
		if (result.getContractDetailId() < 0) {
			return null;
		}
		ContractDetailInfo contractDetailInfo = new ContractDetailInfo();
		contractDetailInfo.setContractDetailId(result.getContractDetailId());
		contractDetailInfo.setCreateTime(result.getDetailCreateTime());
		contractDetailInfo.setLastModifiedTime(result.getDetailLastModifiedTime());
		contractDetailInfo.setKeySubbranch(result.isKeySubbranch());
		contractDetailInfo.setTargetValue(result.getTargetValue());
		contractDetailInfo.setTargetVolume(result.getTargetVolume());
		contractDetailInfo.setSubBrandNo(result.getSubBrandNo());
		contractDetailInfo.setSubBrandName(result.getSubBrandName());
		return contractDetailInfo;
	}
}
