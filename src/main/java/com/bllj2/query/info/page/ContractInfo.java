package com.bllj2.query.info.page;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * 合同结果，在{@link com.bllj2.query.info.PageResult}的泛型中使用
 *
 * @author lijuny
 */
@Getter
@Setter
public class ContractInfo {
	//id不返回到前端，忽略掉
	@JsonIgnore
	private String contractId;
	private String contractNumber;
	private String contractType;
	private String accountNo;
	private String store;
	private String storeType;
	private boolean prcContract;
	private long startDate;
	private long endDate;
	private String signerId;
	private String signerName;
	private long signerDate;
	private BigDecimal completeDisCount;
	private BigDecimal discountTargetRate;
	private BigDecimal extraDiscount;
	private String contractVersion;
	private long activitySession;
	private String contractState;
	private String poNo;
	private String targetBase;
	private long createTime;
	private long lastModifiedTime;


}
