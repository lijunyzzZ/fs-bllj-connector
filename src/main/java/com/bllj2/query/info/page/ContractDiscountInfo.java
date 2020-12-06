package com.bllj2.query.info.page;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * 折扣分页查询的结果
 *
 * @author lijuny
 * @date 2020/11/9
 */
@Setter
@Getter
public class ContractDiscountInfo {
	@JsonIgnore
	private long contractDiscountId;
	@JsonAlias
	private String contractNumber;
	private String paymentRequestNo;
	private String wholesalerName;
	private BigDecimal paymentAmount;
	private boolean confirm;
	private long confirmTime;
	private long createTime;
	private long lastModifiedTime;
}
