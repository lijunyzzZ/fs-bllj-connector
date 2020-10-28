package com.bllj2.query.info.page;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>succez</p>
 * 合同结果，在{@link com.bllj2.query.info.PageResult}的泛型中使用
 *
 * @author lijuny
 */
@Getter
@Setter
public class ContractInfo {
	private String name;
	private String contractNumber;
	private String storeName;
	private String accountNo;
	private String startDate;
	private String endDate;
	private String storeType;
	private boolean trueContract;
	private String discount;
	private String contractVersion;
	private String activitySession;
	private String contractState;
	private boolean standardContract;
	private List<TransferContractDetailVo> transferContractDetailVos;
	private List<TransferContractStoreVo> transferContractStoreVos;

}
