package com.bllj2.query.info;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 *
 * 封装分页查询的参数
 * @author lijuny
 */


@ToString
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

	public QueryPageArgs(int pageNum, int pageSize, long startTime, long endTime, String accountNo, String poNo, String contractNumber) {
		this.pageNum = Math.max(1, pageNum);
		this.pageSize = Math.max(1, pageSize);
		this.startTime = startTime;
		this.endTime = endTime;
		this.accountNo = accountNo;
		this.poNo = poNo;
		this.contractNumber = contractNumber;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = Math.max(1,pageNum);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = Math.max(1, pageSize);
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
}
