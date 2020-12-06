package com.bllj2.query.info;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

/**
 *
 * 封装分页查询的参数
 * @author lijuny
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
public class QueryPageArgs {
	/**
	 * 分页页码
	 */
	private int pageNum = 1;
	/**
	 * 每页条数
	 */
	private int pageSize = 10;
	/**
	 * 开始时间 给定一个默认值，就不用在查找的时候去判断空了
	 */
	private long startTime = 0L;
	/**
	 * 结束时间 给定一个默认值，就不用在查找的时候去判断空了
	 */
	private long endTime = Long.MAX_VALUE;
	/**
	 * 门店id
	 */
	private String accountNo;

	private String poNo;

	private String contractNumber;

}
