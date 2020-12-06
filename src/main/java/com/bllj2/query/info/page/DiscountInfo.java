package com.bllj2.query.info.page;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * 折扣结果，在{@link com.bllj2.query.info.PageResult}的泛型中使用
 * @author lijuny
 */
@Getter
@Setter
public class DiscountInfo {
	private boolean auditState;
	private boolean confirm;
	private String contractNumber;
	private float discount;
	private String discountId;
	private String confirmTime;
	private String signerId;
	private String signerName;
}

