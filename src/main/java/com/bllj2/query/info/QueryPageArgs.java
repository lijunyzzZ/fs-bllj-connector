package com.bllj2.query.info;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>succez</p>
 * 封装分页查询的参数
 * @author lijuny
 */
@Setter
@Getter
public class QueryPageArgs {
	/**
	 * 分页页码
	 */
	private Integer pageNum;
	/**
	 * 每页条数
	 */
	private Integer pageSize;
	/**
	 * 开始时间
	 */
	private Long startTime;
	/**
	 * 结束时间
	 */
	private Long endTime;
	/**
	 * 门店id
	 */
	private String accountNo;
	/**
	 * 签字人id
	 */
	private String signId;
}
